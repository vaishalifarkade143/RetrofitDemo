package com.example.retrofitdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.retrofitdemo.responces.LoginResponce;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Login extends AppCompatActivity
{
    EditText log_email,log_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        log_email = (EditText) findViewById(R.id.log_email);
        log_pass =  (EditText) findViewById(R.id.log_pass);

    }
    public  void  login(View view)
    {
        //here we get the email n pass from the user
        String email1 = log_email.getText().toString();
        String pass1 = log_pass.getText().toString();

        Retrofit retrofit  = new Retrofit.Builder()
                .baseUrl("http://192.168.1.17/RetroApi.php/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitApi retrofitApi = retrofit.create(RetrofitApi.class);
        Call<LoginResponce> call =retrofitApi.login(email1,pass1);

        call.enqueue(new Callback<LoginResponce>() {
            @Override
            public void onResponse(Call<LoginResponce> call, Response<LoginResponce> response)
            {
                 if(response.isSuccessful())
                 {
                     LoginResponce loginResponce = response.body();
                     String name2 = loginResponce.getName();
                     if(name2 != null)
                     {
//                         String email2 = loginResponce.getEmail();
//                         String gender2 = loginResponce.getGender();
//                         Toast.makeText(Login.this, "Name  : "+name2+ "\nEmail : "+email2+ "\nGender : "+gender2, Toast.LENGTH_SHORT).show();
                     startActivity(new Intent(Login.this, Profile.class
                     ));
                     }
                     else {
                         Toast.makeText(Login.this, "Email Id and Password didn't match", Toast.LENGTH_SHORT).show();
                     }

                 }
                 else {
                     Toast.makeText(Login.this, "Error Occurd try again", Toast.LENGTH_SHORT).show();
                 }

            }

            @Override
            public void onFailure(Call<LoginResponce> call, Throwable t) {

            }
        });
    }
}