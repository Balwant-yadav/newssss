package com.example.newssss;

import java.util.ArrayList;

public class api {
    ArrayList<modem> articles;

    public api(ArrayList<modem> articles) {
        this.articles = articles;
    }

    public ArrayList<modem> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<modem> articles) {
        this.articles = articles;
    }
}
