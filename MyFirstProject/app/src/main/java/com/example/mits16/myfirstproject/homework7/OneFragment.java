package com.example.mits16.myfirstproject.homework7;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.mits16.myfirstproject.R;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Created by mizz8 on 02.03.2018.
 */

public class OneFragment extends Fragment {
    TextView textView;
    private PublishContract publishContract;
    private Disposable disposable;




    public static OneFragment getInstance(){
        return new OneFragment();

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return getLayoutInflater().inflate(R.layout.fragment_one,container,false);



    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView = view.findViewById(R.id.textFragment);

        view.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                subsribe();
            }
        }));

    }

    @Override
    public void onResume() {
        super.onResume();
                    subsribe();
    }

    private void subsribe(){
        disposable = publishContract.getObserable()
                .map(new Function<Integer, String>() {
                    @Override
                    public String apply(Integer integer) throws Exception {
                        return String.valueOf(integer);

                    }
                }).subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String text) throws Exception {
                        textView.setText(text);

                    }
                });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = getActivity();
        if(activity!=null){
            publishContract = (PublishContract) activity;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        publishContract = null;
    }
}




