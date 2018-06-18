package com.example.khaled.staytuned.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by khaled on 6/18/18.
 */

public class Field {

    @SerializedName("thumbnail")
    private String thumbnail;

    public Field(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
