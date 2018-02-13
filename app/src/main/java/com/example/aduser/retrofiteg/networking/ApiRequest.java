package com.example.aduser.retrofiteg.networking;

import com.example.aduser.retrofiteg.BuildConfig;
import com.example.aduser.retrofiteg.RetrofitingApplication;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by aduser on 2/12/2018.
 */

public class ApiRequest {
    public ApiRequest() {
    }
    static Retrofit retrofit;
    static Retrofit retrofitGoogle;



    private static Retrofit provideRestAdapter() {
        if (retrofit == null)
            retrofit = new Retrofit.Builder()
                    .baseUrl(BuildConfig.baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(RetrofitingApplication.getInstance().getOkHttpClient())
                    .build();
        return retrofit;
    }

    public static RequestInterface provideInterface() {
        return provideRestAdapter().create(RequestInterface.class);
    }
}
