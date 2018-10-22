package com.example.luigitercero.appcolonia.ApiServer;

import com.example.luigitercero.appcolonia.Models.PokeRequest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PokeApiService {
    @GET("pokemon")
    Call<PokeRequest> obtenerListaPokemon(@Query("limit") int limit, @Query("offset") int offset);
}
