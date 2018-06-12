package com.example.khaled.staytuned.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.example.khaled.staytuned.model.MyAppGlideModule;

/**
 * Created by khaled on 6/12/18.
 */

public class RetrofitClientInstance {

    private static Retrofit retrofit;
    private static final String BASE_URL="https://content.guardianapis.com";


    public static Retrofit getRetrofitInstance(){
        retrofit=new retrofit2.Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }
}
