package com.example.retrofitdemo;

import com.example.retrofitdemo.responces.LoginResponce;
import com.example.retrofitdemo.responces.RegisterResponce;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RetrofitApi
{
        @FormUrlEncoded
        @POST("register")
        Call<RegisterResponce> register(
                @Field("k_name")String name,
                @Field("k_email")String email,
                @Field("k_password")String pass,
                @Field("k_gender")String gender
        );
        @FormUrlEncoded
        @POST("login")
        Call<LoginResponce> login(
                @Field("k_email") String email1,
                        @Field("k_password")  String pass1
                );



}
