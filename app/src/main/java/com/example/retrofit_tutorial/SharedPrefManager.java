package com.example.retrofit_tutorial;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefManager {

    private static SharedPrefManager mInstance;
    private static Context mCtx;
    private static final String SHARED_PREF_NAME = "mysharedpref12";
    private static final String KEY_ID = "P_ID";
    private static final String KEY_FIRSTNAME = "P_FirstName";
    private static final String KEY_LASTNAME = "P_LastName";
    private static final String KEY_EMAIL = "P_Email";
    private static final String KEY_CELLNUM = "P_CellNum";
    private static final String KEY_ADDRESS = "P_Address";
    private static final String KEY_TYPE = "P_Type";



    private SharedPrefManager(Context context){
        mCtx = context;
    }

    public static synchronized SharedPrefManager getInstance(Context context){
        if(mInstance == null){
            mInstance = new SharedPrefManager(context);
        }
        return mInstance;
    }

    public boolean userLogin(int P_ID, String P_FirstName, String P_LastName, String P_Email,String P_CellNum, String P_Address, String P_Type){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt(KEY_ID, P_ID);
        editor.putString(KEY_FIRSTNAME,P_FirstName);
        editor.putString(KEY_LASTNAME,P_LastName);
        editor.putString(KEY_EMAIL,P_Email);
        editor.putString(KEY_CELLNUM,P_CellNum);
        editor.putString(KEY_ADDRESS,P_Address);
        editor.putString(KEY_TYPE,P_Type);

        editor.apply();
        return true;
    }

    public boolean isLoggedIn(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        if(sharedPreferences.getString(KEY_EMAIL, null) != null){
            return true;
        }
        return false;
    }

    public boolean logout(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        return true;
    }

    public String getFirstname(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_FIRSTNAME,null);
    }

    public String getLastname(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_LASTNAME,null);
    }

    public String getType(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_TYPE,null);
    }



}
