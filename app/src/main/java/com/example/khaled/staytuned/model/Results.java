package com.example.khaled.staytuned.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by khaled on 6/13/18.
 */

public class Results {

    @SerializedName("webTitle")
    private String webTitle;

    @SerializedName("webUrl")
    private String webUrl;

    @SerializedName("webPublicationDate")
    private String date;

    @SerializedName("fields")
    private Field field;

    public Results(String webTitle, String webUrl, String date, Field field) {
        this.webTitle = webTitle;
        this.webUrl = webUrl;
        this.date = date;
        this.field=field;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public String getWebTitle() {
        return webTitle;
    }

    public void setWebTitle(String webTitle) {
        this.webTitle = webTitle;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
