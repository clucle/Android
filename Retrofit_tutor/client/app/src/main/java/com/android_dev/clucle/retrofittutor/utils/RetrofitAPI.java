package com.android_dev.clucle.retrofittutor.utils;

import com.android_dev.clucle.retrofittutor.model.User;
import com.android_dev.clucle.retrofittutor.model.Users;

import retrofit2.Call;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RetrofitAPI {

    @POST("user/one")
    @FormUrlEncoded
    Call<User> getUser(
            @Field("name") String name
    );

    @POST("user/list")
    Call<Users> getUserList();
}
