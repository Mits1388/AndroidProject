package com.example.mits16.presentation.homework9;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.example.mits16.presentation.R;
import com.example.mits16.presentation.databinding.ActivityHomework9Binding;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;



/**
 * Created by mizz8 on 08.03.2018.
 */

public class HomeWork9Activity extends AppCompatActivity{
    private User userWoman;
    private User userMan;
    private ActivityHomework9Binding binding;
    private Disposable disposable;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_homework9);

    }

   public void onWomanClick(View view){
       userWoman = new User("Elizabeth", "Brown",25,"female","https://cdn.pixabay.com/photo/2015/08/19/03/09/girl-895456_960_720.jpg");
       subscribeNow(userWoman);
    }

    public void onManClick(View view){
        userMan = new User("Jack", "Smith",18,"male","http://www.zastavki.com/pictures/originals/2013/Men__039174_.jpg");
        subscribeNow(userMan);
    }

    private void subscribeNow(User user) {


        Observable<User> userObservable = Observable.just(user);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        userObservable.subscribe(new Observer<User>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(User user) {
                binding.setUser(user);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

    }
}



