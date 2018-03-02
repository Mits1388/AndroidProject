package com.example.mits16.myfirstproject.homework7;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mits16.myfirstproject.R;
import com.jakewharton.rxbinding2.view.RxView;
import com.jakewharton.rxbinding2.widget.RxTextView;

import org.reactivestreams.Subscription;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by mizz8 on 02.03.2018.
 */

public class HomeWork7Activity extends AppCompatActivity {
    private boolean isOnevisible = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework7);



        findViewById(R.id.buttonFragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment();
            }
        });

        //проверка
        if(savedInstanceState == null) {
            showFragment(OneFragment.getInstance());
        }
    }


    private void changeFragment(){
        if(isOnevisible){
            showFragment(TwoFragment.getInstance());
            isOnevisible = false;
        }else {
            showFragment(OneFragment.getInstance());
            isOnevisible = true;
        }
    }

    private void showFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        // замена одного фрагмента на другой
        fragmentTransaction.replace(R.id.container,fragment);
        // fragmentTransaction.replace(R.id.container,fragment.getClass().getSimpleName());
        //кнопка назад
        fragmentTransaction.addToBackStack(fragment.getTag());
        // fragmentTransaction.addToBackStack(fragment.getClass().getSimpleName());
        //выполнить транзакцию
        fragmentTransaction.commit();

    }
}

