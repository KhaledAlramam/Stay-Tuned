package com.example.khaled.staytuned.network;

import com.example.khaled.staytuned.model.ParentResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by khaled on 6/12/18.
 */

public interface GetDataService {

    @GET
    Call<ParentResponse> getResponse(@Url String url);
}
