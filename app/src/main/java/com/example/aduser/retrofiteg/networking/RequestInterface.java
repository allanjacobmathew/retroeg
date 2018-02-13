package com.example.aduser.retrofiteg.networking;

import com.example.aduser.retrofiteg.networking.response.UserResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by aduser on 2/12/2018.
 */

public interface RequestInterface {
    @GET("posts")
    Call<List<UserResponse>> getUserDeatils();
}
