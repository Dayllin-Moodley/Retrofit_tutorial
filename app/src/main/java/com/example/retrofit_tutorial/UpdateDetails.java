package com.example.retrofit_tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UpdateDetails extends AppCompatActivity {

    Button btn_update;
    EditText Address,CellNum,Password,ConfPassword,Email;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Address = findViewById(R.id.Address);
        CellNum = findViewById(R.id.CellNum);
        Password = findViewById(R.id.Origin_Password);
        ConfPassword = findViewById(R.id.Conf_Password);
        Email = findViewById(R.id.Email);
        btn_update = findViewById(R.id.btn_update);

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDetails();
            }
        });

    }

    public void updateDetails(){

    }

}