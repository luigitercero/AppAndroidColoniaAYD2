package com.example.luigitercero.appcolonia.ApiServer;

import com.example.luigitercero.appcolonia.Models.NotiRequest;
import com.example.luigitercero.appcolonia.Models.Noticia;
import com.example.luigitercero.appcolonia.Models.Noticia2;

import retrofit2.Call;

import retrofit2.http.POST;
import retrofit2.http.Body;

public interface NoticiasApiServer {

    @POST("noticia?type=1")
    Call<NotiRequest> getNoticia();
    @POST("noticia?type=0")
    Call<NotiRequest> crearNoticia();
    @POST("noticia?type=0")
    Call<Noticia> crearNoticia(@Body Noticia noticia);
    @POST("noticia?type=0")
    Call<Noticia> crearNoticia(@Body Noticia2 noticia);
}
