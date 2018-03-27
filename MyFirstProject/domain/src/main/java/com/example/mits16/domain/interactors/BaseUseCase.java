package com.example.mits16.domain.interactors;



import com.example.mits16.domain.executor.PostExecutionThread;
import com.example.mits16.domain.executor.ThreadExecutor;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by user on 16.03.2018.
 */

public abstract class BaseUseCase{


    protected Scheduler postExecutionThread;


    protected Scheduler threadExecution;


    public BaseUseCase(PostExecutionThread postExecutionThread){
        this.postExecutionThread = postExecutionThread.getScheduler();
        this.threadExecution = Schedulers.io();
    }


    public BaseUseCase(PostExecutionThread postExecutionThread, ThreadExecutor threadExecution) {
        this.postExecutionThread = postExecutionThread.getScheduler();
        this.threadExecution = Schedulers.from(threadExecution);
    }
}
