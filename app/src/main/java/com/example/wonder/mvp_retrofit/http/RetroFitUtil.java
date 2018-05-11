package com.example.wonder.mvp_retrofit.http;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroFitUtil {

    private static RetroFitUtil retroFitUtil;
    private final Retrofit retrofit;

    public static RetroFitUtil getInstence(){
        if(retroFitUtil==null){
            retroFitUtil = new RetroFitUtil();
        }
        return retroFitUtil;
    }
    //初始化
    public RetroFitUtil(){
        retrofit = new Retrofit.Builder()
                .baseUrl(HttpConfig.base_url)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
    }
    //指定服务
    public <T> T createRequest(Class<T> clz){
        T t = retrofit.create(clz);
        return t;
    }
}
