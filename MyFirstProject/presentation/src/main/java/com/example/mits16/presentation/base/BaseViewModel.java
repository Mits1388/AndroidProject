package com.example.mits16.presentation.base;

import android.arch.lifecycle.ViewModel;
import android.util.Log;


import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by user on 12.03.2018.
 */

public abstract class BaseViewModel extends ViewModel{

    protected CompositeDisposable compositeDisposable = new CompositeDisposable();



    public BaseViewModel() {
        super();
        Log.e("BaseViewModel", "success");
      createInject();
    }
   public  abstract void createInject();



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
        if(!compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }

    }
}
