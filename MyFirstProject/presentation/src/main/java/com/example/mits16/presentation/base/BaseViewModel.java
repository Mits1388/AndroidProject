package com.example.mits16.presentation.base;

import android.arch.lifecycle.ViewModel;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by mizz8 on 18.03.2018.
 */

public class BaseViewModel extends ViewModel {

    protected CompositeDisposable compositeDisposable = new CompositeDisposable();


    public void onStart(){

    }
    public void onResume(){

    }

    public void onPause(){

    }
    public void onStop(){

    }

    @Override
    protected void onCleared() {
        super.onCleared();
        //от писываемся
        if(!compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }

    }
}

