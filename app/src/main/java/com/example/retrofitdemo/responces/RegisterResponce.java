package com.example.retrofitdemo.responces;


//pojo class
public class RegisterResponce
{
    private String errorcode;
    private  String message;

    public String getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(String errorcode) {
        this.errorcode = errorcode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
