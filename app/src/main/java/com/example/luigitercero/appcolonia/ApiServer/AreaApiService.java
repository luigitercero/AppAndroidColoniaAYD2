package com.example.luigitercero.appcolonia.ApiServer;

import com.example.luigitercero.appcolonia.Models.AreaRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AreaApiService {
    @POST("area?type=1")
    Call<AreaRequest> getArea();
}
