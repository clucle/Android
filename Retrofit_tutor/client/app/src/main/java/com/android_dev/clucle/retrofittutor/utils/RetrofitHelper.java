package com.android_dev.clucle.retrofittutor.utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {

    // server address, port
    private final static String url = "http://192.168.0.22";
    private final static int port = 3000;

    private static Retrofit retrofit;

    public static RetrofitAPI getInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(url + ":" + port)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(RetrofitAPI.class);
    }
}
