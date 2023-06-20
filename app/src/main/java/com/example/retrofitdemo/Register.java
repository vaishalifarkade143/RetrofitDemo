package com.example.retrofitdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.retrofitdemo.responces.RegisterResponce;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Register extends AppCompatActivity
{
    EditText reg_name,reg_email,reg_pass,reg_gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        reg_name =(EditText) findViewById(R.id.reg_name);
        reg_email = (EditText) findViewById(R.id.reg_email);
        reg_pass = (EditText) findViewById(R.id.reg_pass);
        reg_gender = (EditText) findViewById(R.id.reg_gender);
    }

    public void register(View view)
    {
        String name1=reg_name.getText().toString();
        String email1=reg_email.getText().toString();
        String pass1=reg_pass.getText().toString();
        String gender1=reg_gender.getText().toString();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.17/RetroApi.php/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //here we get the referance of Interface{RetrofitApi}
        RetrofitApi retrofitApi = retrofit.create(RetrofitApi.class);
        Call<RegisterResponce> call = retrofitApi.register(name1,email1,pass1,gender1);
        call.enqueue(new Callback<RegisterResponce>() {
            @Override
            public void onResponse(Call<RegisterResponce> call, Response<RegisterResponce> response) {
                //automatic parsing of json
                RegisterResponce reg_response = response.body();
                String errorcode = reg_response.getErrorcode();
                String message = reg_response.getMessage();
                //json parsing done here
                Toast.makeText(Register.this, "ErrorCode :"+errorcode+ "\nMessage"+message, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<RegisterResponce> call, Throwable t) {
                Toast.makeText(Register.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}