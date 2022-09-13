package com.example.retrofit_tutorial;

public class LoginResponse {

    private int P_ID;
    private String error;
    private String message;
    private String P_FirstName;
    private String P_Lastname;
    private String P_Email;
    private String P_CellNum;
    private String P_Address;
    private String P_Type;

    public int getP_ID() {
        return P_ID;
    }

    public void setP_ID(int p_ID) {
        P_ID = p_ID;
    }

    public String getP_FirstName() {
        return P_FirstName;
    }

    public void setP_FirstName(String p_FirstName) {
        P_FirstName = p_FirstName;
    }

    public String getP_Lastname() {
        return P_Lastname;
    }

    public void setP_Lastname(String p_Lastname) {
        P_Lastname = p_Lastname;
    }

    public String getP_Email() {
        return P_Email;
    }

    public void setP_Email(String p_Email) {
        P_Email = p_Email;
    }

    public String getP_CellNum() {
        return P_CellNum;
    }

    public void setP_CellNum(String p_CellNum) {
        P_CellNum = p_CellNum;
    }

    public String getP_Address() {
        return P_Address;
    }

    public void setP_Address(String p_Address) {
        P_Address = p_Address;
    }

    public String getP_Type() {
        return P_Type;
    }

    public void setP_Type(String p_Type) {
        P_Type = p_Type;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

}
