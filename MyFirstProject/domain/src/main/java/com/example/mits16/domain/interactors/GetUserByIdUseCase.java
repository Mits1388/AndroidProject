package com.example.mits16.domain.interactors;


import com.example.mits16.domain.entity.UserEntity;
import com.example.mits16.domain.executor.PostExecutionThread;
import com.example.mits16.domain.executor.ThreadExecutor;
import com.example.mits16.domain.repository.UserRepository;
import io.reactivex.Observable;


/**
 * Created by mizz8 on 19.03.2018.
 */

public class GetUserByIdUseCase extends BaseUseCase {

    private UserRepository userRepository;

    public GetUserByIdUseCase(PostExecutionThread postExecutionThread, ThreadExecutor threadExecutor){
        super(postExecutionThread,threadExecutor);
    }

    public GetUserByIdUseCase(PostExecutionThread postExecutionThread, UserRepository userRepository){
        super(postExecutionThread);
        this.userRepository = userRepository;
    }

    public Observable<UserEntity> get(String id){

        return userRepository.getId(id)
                .subscribeOn(threadExecution)
                .observeOn(postExecutionThread);


    }


}
