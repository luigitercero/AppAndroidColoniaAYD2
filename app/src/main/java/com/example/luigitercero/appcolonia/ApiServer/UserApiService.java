package com.example.luigitercero.appcolonia.ApiServer;

import retrofit2.Call;

import com.example.luigitercero.appcolonia.Models.LoginAcces;
import com.example.luigitercero.appcolonia.Models.User;
import com.example.luigitercero.appcolonia.Models.UserRequest;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Body;

public interface UserApiService {
    @GET("pokemon")
    Call<UserRequest> obtenerListaPokemon(@Query("limit") int limit, @Query("offset") int offset);
    @POST("user?type=0")
    Call<LoginAcces> createUser(@Body User user);

}
