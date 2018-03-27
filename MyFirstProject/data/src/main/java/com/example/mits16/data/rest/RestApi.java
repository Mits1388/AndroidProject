package com.example.mits16.data.rest;


import com.example.mits16.data.entity.User;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by user on 19.03.2018.
 */

public interface RestApi {


    @GET("data/User")
    Observable<List<User>> loadUser();

    @GET("data/User/{id}")
    Observable<User> loadUserById(@Path("id") String id);

}
