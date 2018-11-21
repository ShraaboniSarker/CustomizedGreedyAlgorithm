package com.example.shraboni.algorithmdesignforads.network;

import com.example.shraboni.algorithmdesignforads.model.createUser.CreateUserResponse;
import com.example.shraboni.algorithmdesignforads.model.login.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIService {

    @FormUrlEncoded
    @POST("/testapi/user_information.php")
    Call<LoginResponse> doLogin(
            @Field("email") String email,
            @Field("password") String password);


    @FormUrlEncoded
    @POST("/testapi/create_user.php")
    Call<CreateUserResponse> createUser(
            @Field("name") String name,
            @Field("email") String email,
            @Field("password") String password,
            @Field("dob") String dob);
}
