package com.example.mits16.data.rest;



import com.example.mits16.data.entity.User;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;


/**
 * Created by user on 19.03.2018.
 */

@Singleton
public class RestService {

    private RestApi restApi;

    @Inject
    public RestService(RestApi restApi) {
        this.restApi = restApi;
    }



    public Observable<List<User>> loadUser (){
        return restApi.loadUser();
    }


   public Observable<User> loadUserById(String id){
        return restApi.loadUserById(id);
    }

}
