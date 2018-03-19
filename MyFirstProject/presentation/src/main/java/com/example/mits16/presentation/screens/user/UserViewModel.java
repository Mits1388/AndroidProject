package com.example.mits16.presentation.screens.user;

import android.databinding.BindingAdapter;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.util.Log;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.example.mits16.data.repository.UserRepositoryImpl;
import com.example.mits16.domain.entity.UserEntity;
import com.example.mits16.domain.interactors.GetUserByIdUseCase;
import com.example.mits16.executor.UIThread;
import com.example.mits16.presentation.base.BaseViewModel;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


/**
 * Created by mizz8 on 18.03.2018.
 */

public class UserViewModel extends BaseViewModel {
    public ObservableField<String> username = new ObservableField<>("");
    public ObservableField<String> profileUrl = new ObservableField<>("");
    public ObservableField<String> surname = new ObservableField<>("");
    public ObservableField<String> gender = new ObservableField<>("");
    public ObservableInt age = new ObservableInt();
    public ObservableBoolean progressVisible = new ObservableBoolean(false);

    private GetUserByIdUseCase getUserByIdUseCase = new GetUserByIdUseCase(new UIThread(),new UserRepositoryImpl());


    public UserViewModel() {

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

                        username.set(userEntity.getUsername());
                        surname.set(userEntity.getSurname());
                        gender.set(userEntity.getGender());
                        profileUrl.set(userEntity.getProfileUrl());
                        age.set(userEntity.getAge());

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

/*
    @Override
    public void onResume() {

        progressVisible.set(true);

        Observable.create(new ObservableOnSubscribe<UserEntity>() {

            @Override
            public void subscribe(ObservableEmitter<UserEntity> emitter) throws Exception {
                Thread.sleep(5000);

                UserEntity userEntity = new UserEntity("Jack", 20, "https://cdn.pixabay.com/photo/2015/08/19/03/09/girl-895456_960_720.jpg");
                emitter.onNext(userEntity);
                emitter.onComplete();
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("Subscribe","onSubscribe");
                    }

                    @Override
                    public void onNext(UserEntity userEntity) {
                        Log.e("Subscribe","onNext");
                        username.set(userEntity.getUsername());
                        profileUrl.set(userEntity.getProfileUrl());
                        age.set(userEntity.getAge());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("Subscribe","onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.e("Subscribe","onComplete");
                        progressVisible.set(false);
                    }
                });
    }
*/
    @BindingAdapter({"app:srcimage"})
    public static void setProfileUrl(ImageView view, String  profileUrl){
        Glide.with(view.getContext()).load(profileUrl).into(view);
    }
}
