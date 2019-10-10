package com.example.mostpopularapi.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.UUID;


public class Result {


    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("title")
    @Expose
    private String title;

    public Result() {
    }

    public Result(long id, String title, String url) {
        this.id = id;
        this.title = title;
        this.url = url;
    }

    public Result(String title, String url) {
        this.title = title;
        this.url = url;
    }

    @SerializedName("url")
    @Expose


    private String url;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
