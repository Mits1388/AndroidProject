package com.example.mits16.presentation.homework8;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.mits16.presentation.R;
import java.util.concurrent.TimeUnit;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;


/**
 * Created by mizz8 on 07.03.2018.
 */

public class HomeWork8Activity extends AppCompatActivity {
    TextView textView;
    Button buttonStart;
    Button buttonStop;
    Disposable disposable;
    Observable<Long> values;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework8);
        buttonStart = findViewById(R.id.buttonHome1);
        buttonStop = findViewById(R.id.buttonHome2);
        textView = findViewById(R.id.textView3);


      buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                subscribeNow();
                buttonStop.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           if(disposable!=null){
               disposable.dispose();
           }
       }
   });

    }

    private void subscribeNow(){
        values = Observable.interval(1, TimeUnit.SECONDS);
        disposable = values.filter(new Predicate<Long>() {
            @Override
            public boolean test(Long aLong) throws Exception {
                return aLong %2 == 0;
            }
        }).map(new Function<Long, String>() {

            @Override
            public String apply(Long aLong) throws Exception {
                return String.valueOf(aLong);
            }
        })//.subscribe(e -> Log.e("TAG","Received: " + e));
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                textView.setText(s);
                            }
                        });
                    }
                });
            }
        });
    }
}
