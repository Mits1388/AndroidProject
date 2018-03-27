package com.example.mits16.presentation.screens.user;

import android.app.Application;
import android.content.Context;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.util.Log;


import com.example.mits16.app.App;
import com.example.mits16.domain.entity.UserEntity;
import com.example.mits16.domain.interactors.GetUserUseCase;
import com.example.mits16.presentation.base.BaseViewModel;

import javax.inject.Inject;


import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import static com.example.mits16.app.App.getAppComponent;


/**
 * Created by user on 12.03.2018.
 */

public class UserViewModel extends BaseViewModel {


    @Inject
    Context context;


    public ObservableField<String> username = new ObservableField<String>("");
    public ObservableField<String> lastname = new ObservableField<String>("");
    public ObservableField<String> age = new ObservableField<String>("");
    public ObservableField<String> objectId = new ObservableField<String>("");
    public ObservableBoolean progressVisible = new ObservableBoolean(false);


    @Inject
    public GetUserUseCase getUserByIdUseCase;


    @Override
    public void createInject() {

        if( getAppComponent() == null){
            Log.e("createInject", "null");
        }else {
            Log.e("createInject", "success");
        }

        getAppComponent().inject(this);
    }


    public UserViewModel() {
        super();
        Log.e("UserViewModel", "onSubscribe");
     //   App.getAppComponent().inject(this);

        progressVisible.set(true);
        getUserByIdUseCase.get("id")
                .subscribe(new Observer<UserEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("Subscribe", "onSubscribe");
                        compositeDisposable.add(d);

                    }

                    @Override
                    public void onNext(UserEntity userEntity) {
                        Log.e("Subscribe", "onNext");

                        username.set(userEntity.getUser());
                        lastname.set(userEntity.getLast());
                        age.set(userEntity.getAges());
                        objectId.set(userEntity.getOid());

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("Subscribe", "onError");

                    }

                    @Override
                    public void onComplete() {
                        Log.e("Subscribe", "onComplete");
                        progressVisible.set(false);
                    }
                });

    }

}


