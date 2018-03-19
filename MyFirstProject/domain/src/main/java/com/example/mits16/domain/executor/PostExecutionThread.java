package com.example.mits16.domain.executor;

import io.reactivex.Scheduler;

/**
 * Created by mizz8 on 19.03.2018.
 */

public interface PostExecutionThread {
    Scheduler getScheduler();
}
