package com.abc.mytaskapplication.Network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient   {

    public static  final String BASE_URL = "http://rijalroshan.com.np:8081/";

    static Retrofit instance;

    public static Retrofit getClient(){

        OkHttpClient client  = new OkHttpClient();         ///read string
        Gson gson = new GsonBuilder()  ///convert string to class
                .setLenient()
                .create();

//        return  new Retrofit.Builder()
//                .baseUrl(BASE_URL)
//                .client(client)
//                .addConverterFactory(GsonConverterFactory.create(gson))
//              .build();
//22222


        if (instance == null){
            instance = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }

        return  instance;
    }
}
