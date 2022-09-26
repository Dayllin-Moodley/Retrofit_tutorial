package com.example.retrofit_tutorial;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;

public class ListManager {

    private static ListManager mInstance;
    private static Context mCtx;
    private static final String SHARED_PREF_NAME = "mysharedpref12";
    private static String[] KEY_3IA = null;
    private static String[] KEY_S3IA = null;
    private ListManager(Context context){
        mCtx = context;
    }

    public static synchronized ListManager getInstance(Context context){
        if(mInstance == null){
            mInstance = new ListManager(context);
        }
        return mInstance;
    }

    public boolean smartActList(String[] SActList){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        int SAListsize = SActList.length;
        KEY_S3IA = new String[SAListsize];
        for(int i = 0; i<SAListsize;i++){
            editor.putString(KEY_S3IA[i], SActList[i] );
        }
        editor.apply();
        return true;
    }

    public boolean I3ActList(String[] I3AList){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        int I3Asize =I3AList.length;
        KEY_3IA = new String[I3Asize];
        for(int  i = 0;i < I3Asize;i++){
            editor.putString(KEY_3IA[i],I3AList[i] );
        }
        editor.apply();
        return true;
    }

    public static String[] getKey3ia() {
        return KEY_3IA;
    }

    public static String[] getKeyS3ia() {
        return KEY_S3IA;
    }
}

