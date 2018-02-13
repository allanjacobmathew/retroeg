package com.example.aduser.retrofiteg.networking;

import android.app.Application;
import android.support.annotation.NonNull;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by aduser on 2/12/2018.
 */

public class OkHTTPFactory {
    // Cache size for the OkHttpClient

    private static final int DISK_CACHE_SIZE = 50 * 1024 * 1024; // 50MB

    private OkHTTPFactory() {
    }

    @NonNull
    public static OkHttpClient provideOkHttpClient(Application app) {
// Install an HTTP cache in the application cache directory.
        File cacheDir = new File(app.getCacheDir(), "http");
        Cache cache = new Cache(cacheDir, DISK_CACHE_SIZE);

        OkHttpClient.Builder builder = new OkHttpClient.Builder().readTimeout(5, TimeUnit.MINUTES).connectTimeout(5, TimeUnit.MINUTES)
                .cache(cache);

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        builder.interceptors().add(loggingInterceptor);

        return builder.build();
    }
}
