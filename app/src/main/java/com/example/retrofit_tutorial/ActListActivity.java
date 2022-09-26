package com.example.retrofit_tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActListActivity extends AppCompatActivity {

    ListView I3A,S3IA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_list);

        I3A = findViewById(R.id.I3ALV);
        S3IA = findViewById(R.id.SALV);

        get3IActList();
        getSActList();
    }

    public void get3IActList(){
        Call actListCall = ApiClient.getUserService().get3IAList();
        actListCall.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                if(response.isSuccessful()){
                    ActListResponse LR = (ActListResponse) response.body();
                    if(LR.getError() == "false"){
                        Toast.makeText(ActListActivity.this,"List successfully retrieved",Toast.LENGTH_LONG).show();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                ListManager.getInstance(getApplicationContext()).I3ActList(
                                        LR.getList()
                                );
                                String[] list = ListManager.getInstance(getApplicationContext()).getKey3ia();
                                ArrayList<String> listItems = new ArrayList<String>();
                                ArrayAdapter<String> adapter;

                                adapter = new ArrayAdapter<String>(ActListActivity.this,
                                        android.R.layout.simple_list_item_1,
                                        listItems);
                                I3A.setAdapter(adapter);
                                for(int i = 0; i < list.length;i++){
                                    addItems(adapter,listItems,I3A,list[i]);
                                }
                            }
                        },700);

                    }else if(LR.getError() == "true"){
                        Toast.makeText(ActListActivity.this,LR.getMessage(),Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(ActListActivity.this,"Failed to get activity list",Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(ActListActivity.this,"Throwable"+t.getLocalizedMessage(),Toast.LENGTH_LONG).show();
            }
        });

    }

    public void getSActList(){
        Call actListCall = ApiClient.getUserService().getSActList();
        actListCall.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                if(response.isSuccessful()){
                    ActListResponse LR = (ActListResponse) response.body();
                    if(LR.getError() == "false"){
                        Toast.makeText(ActListActivity.this,"List successfully retrieved",Toast.LENGTH_LONG).show();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                ListManager.getInstance(getApplicationContext()).smartActList(
                                        LR.getList()
                                );
                                String[] list = ListManager.getInstance(getApplicationContext()).getKeyS3ia();
                                ArrayList<String> listItems = new ArrayList<String>();
                                ArrayAdapter<String> adapter;

                                adapter = new ArrayAdapter<String>(ActListActivity.this,
                                        android.R.layout.simple_list_item_1,
                                        listItems);
                                S3IA.setAdapter(adapter);
                                for(int i = 0; i < list.length;i++){
                                    addItems(adapter,listItems,S3IA,list[i]);
                                }
                            }
                        },700);

                    }else if(LR.getError() == "true"){
                        Toast.makeText(ActListActivity.this,LR.getMessage(),Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(ActListActivity.this,"Failed to get activity list",Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(ActListActivity.this,"Throwable"+t.getLocalizedMessage(),Toast.LENGTH_LONG).show();
            }
        });

    }

    public void addItems(ArrayAdapter<String> adapter, ArrayList<String> listItems, View v, String item){
        listItems.add(item);
        adapter.notifyDataSetChanged();
    }
}