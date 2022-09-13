package com.example.retrofit_tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;


import okhttp3.internal.http2.Http2Reader;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextInputEditText Email,Password;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Email = findViewById(R.id.Email);
        Password = findViewById(R.id.UserPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(TextUtils.isEmpty(Email.getText().toString()) /*|| TextUtils.isEmpty(Password.getText().toString())*/){
                    Toast.makeText(MainActivity.this,"Email or Password is empty",Toast.LENGTH_LONG).show();
                }else{
                    //login
                    login();
                }
            }
        });
    }


    public void login(){
        Loginrequest loginrequest = new Loginrequest();
        loginrequest.setEmail(Email.getText().toString());
        //loginrequest.setUserPassword(Password.getText().toString());

        Call<LoginResponse> loginResponseCall = ApiClient.getUserService().userLogin(loginrequest.getEmail());
        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if(response.isSuccessful()){
                    LoginResponse loginResponse = response.body();
                    if(loginResponse.getError() == "false"){
                        Toast.makeText(MainActivity.this,"Login successful",Toast.LENGTH_LONG).show();

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                startActivity(new Intent(MainActivity.this, DashboardActivity.class).putExtra("data",loginResponse.getP_FirstName()));
                            }
                        },700);
                    }else if(loginResponse.getError() == "true"){
                        Toast.makeText(MainActivity.this,loginResponse.getMessage(),Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(MainActivity.this,"Login failed",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Throwable"+t.getLocalizedMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }
}