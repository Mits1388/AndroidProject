package com.example.mits16.injection;

import android.content.Context;
import android.util.Log;

import com.example.mits16.data.repository.UserRepositoryImpl;
import com.example.mits16.data.rest.RestApi;
import com.example.mits16.data.rest.RestService;
import com.example.mits16.domain.executor.PostExecutionThread;
import com.example.mits16.domain.repository.UserRepository;
import com.example.mits16.executor.UIThread;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by user on 19.03.2018.
 */


//передостовление зависимостей
@Module
public class AppModule {

    Context context;

    public AppModule(Context context) {
        this.context = context;
    }


    @Provides
    @Singleton
    public Context getContext(){
        return context;
    }



    @Provides
    @Singleton
    public PostExecutionThread getUiThread(){
        return new UIThread();
    }

    @Provides
    @Singleton
    public UserRepository getRepository(Context context, RestService restService){
        return new UserRepositoryImpl(context, restService);
    }


    @Provides
    @Singleton
    public Retrofit getRetrofit(Gson gson){
        Log.e("Retrofit", "success");
        return  new Retrofit.Builder()
                .baseUrl("https://api.backendless.com/E4814525-FD80-3266-FFEA-B4A3C10BED00/6CBFD035-ABFF-6B90-FFBD-4BFA2D2EA700/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

@Provides
@Singleton
    public RestApi getRestApi(Retrofit retrofit){
        return retrofit.create(RestApi.class);
    }



    @Provides
    @Singleton
    public Gson getGson(){
        return new GsonBuilder().create();
    }
}
