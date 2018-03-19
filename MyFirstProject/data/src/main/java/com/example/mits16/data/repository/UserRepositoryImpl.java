package com.example.mits16.data.repository;

import com.example.mits16.domain.entity.UserEntity;
import com.example.mits16.domain.repository.UserRepository;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

/**
 * Created by mizz8 on 19.03.2018.
 */

public class UserRepositoryImpl implements UserRepository{


    @Override
    public Observable<UserEntity> getId(String id) {
        return  Observable.create(new ObservableOnSubscribe<UserEntity>() {

            @Override
            public void subscribe(ObservableEmitter<UserEntity> emitter) throws Exception {

                Thread.sleep(5000);

                UserEntity userEntity = new UserEntity("Elizabeth", "Brown",25,"female","https://cdn.pixabay.com/photo/2015/08/19/03/09/girl-895456_960_720.jpg");

                emitter.onNext(userEntity);
                emitter.onComplete();
            }
        });
    }

    @Override
    public Observable<List<UserEntity>> getId() {
        return null;
    }

    @Override
    public Completable save() {
        return null
                ;
    }

    @Override
    public Completable remove() {
        return null;
    }
}
