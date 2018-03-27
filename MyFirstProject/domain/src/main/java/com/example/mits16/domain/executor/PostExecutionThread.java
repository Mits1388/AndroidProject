package com.example.mits16.domain.executor;

import io.reactivex.Scheduler;

/**
 * Created by user on 16.03.2018.
 */


public interface PostExecutionThread {
    Scheduler getScheduler();
}
