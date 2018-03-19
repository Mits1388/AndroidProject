package com.example.mits16.presentation.homework7;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.example.mits16.presentation.R;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by mizz8 on 02.03.2018.
 */

public class HomeWork7Activity extends AppCompatActivity implements PublishContract {

    public PublishSubject<Integer> publishSubject = PublishSubject.create();
    private int count = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework7);

        findViewById(R.id.buttonFragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                publishSubject.onNext(count);
                count++;
            }
        });

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, OneFragment.getInstance());
        transaction.commit();
    }

    @Override
    public Observable<Integer> getObserable() {
        return publishSubject;
    }
}

