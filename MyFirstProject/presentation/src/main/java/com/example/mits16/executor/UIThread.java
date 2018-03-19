package com.example.mits16.executor;

import com.example.mits16.domain.executor.PostExecutionThread;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * Created by mizz8 on 19.03.2018.
 */

    public class UIThread implements PostExecutionThread {
        @Override
        public Scheduler getScheduler() {
            return AndroidSchedulers.mainThread();
        }
    }

