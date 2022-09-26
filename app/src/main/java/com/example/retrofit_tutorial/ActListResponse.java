package com.example.retrofit_tutorial;

public class ActListResponse {

    private String[] List;
    private String error;
    private String message;

    public String[] getList() {
        return List;
    }

    public void setList(String[] list) {
        List = list;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

}
