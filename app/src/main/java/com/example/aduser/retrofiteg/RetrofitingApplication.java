package com.example.aduser.retrofiteg;

import android.app.Application;

import com.example.aduser.retrofiteg.networking.OkHTTPFactory;

import okhttp3.OkHttpClient;

/**
 * Created by aduser on 2/12/2018.
 */

public class RetrofitingApplication extends Application {
    private static RetrofitingApplication mSretrofitInstance;
    private OkHttpClient okHttpClient;

    @Override
    public void onCreate() {
        super.onCreate();
        mSretrofitInstance = this;
        okHttpClient = OkHTTPFactory.provideOkHttpClient(this);
    }

    public static RetrofitingApplication getInstance(){
        return mSretrofitInstance;
    }
    public OkHttpClient getOkHttpClient(){
        return okHttpClient;
    }
}
