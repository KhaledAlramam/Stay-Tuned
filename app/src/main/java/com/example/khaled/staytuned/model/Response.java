package com.example.khaled.staytuned.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by khaled on 6/12/18.
 */

public class Response {

    @SerializedName("currentPage")
    private int currentPage;

    @SerializedName("pages")
    private int pages;

    @SerializedName("results")
    private List<News> results;

    public int getCurrentPage() {
        return currentPage;
    }

    public Response(int currentPage, int pages, List<News> results) {
        this.currentPage = currentPage;
        this.pages = pages;
        this.results = results;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public List<News> getResults() {
        return results;
    }

    public void setResults(List<News> results) {
        this.results = results;
    }

    public class News{
        @SerializedName("webTitle")
        private String webTitle;

        @SerializedName("webUrl")
        private String webUrl;


        public News(String webTitle, String webUrl) {
            this.webTitle = webTitle;
            this.webUrl = webUrl;
        }

        public void setWebTitle(String webTitle) {this.webTitle = webTitle;}

        public void setWebUrl(String webUrl) {
            this.webUrl = webUrl;
        }

        public String getWebTitle() {
            return webTitle;
        }

        public String getWebUrl() {
            return webUrl;
        }
    }
}
