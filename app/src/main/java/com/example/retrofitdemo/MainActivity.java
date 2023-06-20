package com.example.retrofitdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void  openRegisterActivity(View view)
    {
        startActivity(new Intent(MainActivity.this, Register.class));
    }

    public  void openLoginActivity(View view)
    {
        startActivity(new Intent(MainActivity.this,Login.class));
    }
}