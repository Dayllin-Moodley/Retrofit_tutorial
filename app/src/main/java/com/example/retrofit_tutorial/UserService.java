package com.example.retrofit_tutorial;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UserService {

    @FormUrlEncoded
    @POST("userLogin.php")
    Call<LoginResponse> userLogin(@Field("P_Email") String P_Email,@Field("PW") String PW);

    @GET("get3IAList.php")
    Call get3IAList();

    @GET("getSActList.php")
    Call getSActList();
}
