package com.example.khaled.staytuned.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by khaled on 6/13/18.
 */

public class ParentResponse {
    private MainResponse response;

    public ParentResponse(MainResponse response) {
        this.response = response;
    }

    public MainResponse getResponse() {
        return response;
    }

    public void setResponse(MainResponse response) {
        this.response = response;
    }

}
