package com.example.mits16.data.repository;

import android.content.Context;


import com.example.mits16.data.entity.User;
import com.example.mits16.data.rest.RestService;
import com.example.mits16.domain.entity.UserEntity;
import com.example.mits16.domain.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;


import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.functions.Function;


/**
 * Created by user on 16.03.2018.
 */

public class UserRepositoryImpl implements UserRepository {

    private Context context;
    private RestService restService;

    public UserRepositoryImpl(Context context, RestService restService) {
        this.context = context;
        this.restService = restService;
    }

    @Override
    public Observable<UserEntity> getId(String id) {


      return restService.loadUserById(id).map(new Function<User, UserEntity>() {
          @Override
          public UserEntity apply(User user) throws Exception {
              return new UserEntity (user.getUsername(), user.getAge(), user.getLastname(), user.getObjectId());
          }
      });
    }

    @Override
    public Observable<List<UserEntity>> getId() {
        return restService.loadUser().map(new Function<List<User>, List<UserEntity>>() {
            @Override
            public List<UserEntity> apply(List<User> users) throws Exception {


                List<UserEntity> list = new ArrayList<>();
                for(User user: users){
                    list.add(new UserEntity(user.getUsername(),user.getAge(), user.getLastname(),user.getObjectId()));
                }

                return list;
            }
        });

    }

    @Override
    public Completable save() {
        return null;
    }

    @Override
    public Completable remove() {
        return null;
    }
}
