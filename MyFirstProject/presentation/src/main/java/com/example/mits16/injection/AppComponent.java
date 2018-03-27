package com.example.mits16.injection;



import android.util.Log;

import com.example.mits16.presentation.screens.user.UserViewModel;

import javax.inject.Singleton;
import dagger.Component;

/**
 * Created by user on 19.03.2018.
 */


@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(UserViewModel userViewModel);
}
