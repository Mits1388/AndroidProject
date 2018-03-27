package com.example.mits16.domain.repository;




import com.example.mits16.domain.entity.UserEntity;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;


/**
 * Created by user on 16.03.2018.
 */

public interface UserRepository {


    Observable<UserEntity> getId(String id);
    Observable<List<UserEntity>> getId();


    Completable save();
    Completable remove();



}
