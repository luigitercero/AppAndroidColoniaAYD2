package com.example.luigitercero.appcolonia.Models;

import java.util.ArrayList;

public class NotiRequest {
    private ArrayList<Noticia> response;

    public ArrayList<Noticia> getResults() {
        return response;
    }

    public void setResults(ArrayList<Noticia> results) {
        this.response = results;
    }
}
