package com.example.mits16.domain.interactors;


import com.example.mits16.domain.entity.UserEntity;
import com.example.mits16.domain.executor.PostExecutionThread;
import com.example.mits16.domain.executor.ThreadExecutor;
import com.example.mits16.domain.repository.UserRepository;

import javax.inject.Inject;

import io.reactivex.Observable;


/**
 * Created by user on 16.03.2018.
 */


public class GetUserUseCase extends BaseUseCase{


    private UserRepository userRepository;


    public GetUserUseCase(PostExecutionThread postExecutionThread, ThreadExecutor threadExecutor){
        super(postExecutionThread,threadExecutor);
    }


    @Inject
    public GetUserUseCase(PostExecutionThread postExecutionThread, UserRepository userRepository){
        super(postExecutionThread);
        this.userRepository = userRepository;
    }

    public Observable<UserEntity> get(String id){

         return userRepository.getId(id)
                .subscribeOn(threadExecution)
                .observeOn(postExecutionThread);


    }

}
