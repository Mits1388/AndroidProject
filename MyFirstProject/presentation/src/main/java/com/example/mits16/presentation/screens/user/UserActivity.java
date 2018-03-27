package com.example.mits16.presentation.screens.user;



import android.arch.lifecycle.ViewModelProviders;

import com.example.mits16.presentation.R;
import com.example.mits16.presentation.base.BaseMvvmActivity;
import com.example.mits16.presentation.databinding.ActivityUserBinding;


/**
 * Created by user on 05.02.2018.
 */

public class UserActivity extends BaseMvvmActivity<ActivityUserBinding, UserViewModel> {

    @Override
    public int provideLayoutId() {
        return R.layout.activity_user;
    }

    @Override
    public UserViewModel provideViewModel() {

        return ViewModelProviders.of(this).get(UserViewModel.class);


    }

}



