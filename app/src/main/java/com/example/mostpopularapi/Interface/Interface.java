package com.example.mostpopularapi.Interface;
import com.example.mostpopularapi.Model.Model;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;

public interface Interface {
    @Headers("Content-Type: application/json; charset=utf-8")
    @GET("viewed/30.json?api-key=2ofq7hEcNMFyRvMFBOT2NVFG0lLlrnUr")
    Call<Model> getViewed(@Header("api-key") String autchToken);

    @Headers("Content-Type: application/json; charset=utf-8")
    @GET("shared/30/facebook.json?api-key=2ofq7hEcNMFyRvMFBOT2NVFG0lLlrnUr")
    Call<Model> getShared(@Header("api-key") String autchToken);

    @Headers("Content-Type: application/json; charset=utf-8")
    @GET("emailed/30.json?api-key=2ofq7hEcNMFyRvMFBOT2NVFG0lLlrnUr")
    Call<Model> getEmailed(@Header("api-key") String autchToken);
}
