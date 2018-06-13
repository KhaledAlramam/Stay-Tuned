package com.example.khaled.staytuned.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by khaled on 6/13/18.
 */

public class MainResponse {

    @SerializedName("pages")
    private int pages;

    @SerializedName("currentPage")
    private int currentPage;

    @SerializedName("results")
    private List<Results> results;

    public MainResponse(int pages, int currentPage, List<Results> results) {
        this.pages = pages;
        this.currentPage = currentPage;
        this.results = results;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public List<Results> getResults() {
        return results;
    }

    public void setResults(List<Results> results) {
        this.results = results;
    }
}
