package com.example.luigitercero.appcolonia.ApiServer;

import com.example.luigitercero.appcolonia.Models.NotiRequest;
import com.example.luigitercero.appcolonia.Models.Noticia;

import retrofit2.Call;

import retrofit2.http.POST;

public interface NoticiasApiServer {

    @POST("noticia?type=1")
    Call<NotiRequest> getNoticia();
}
