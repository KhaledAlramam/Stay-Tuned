package com.example.khaled.staytuned.network;

import com.example.khaled.staytuned.model.ParentResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by khaled on 6/12/18.
 */

public interface GetDataService {


    @GET("/search?q=world-cup&section=football&api-key=test")
    Call<ParentResponse> getResponse();
}
