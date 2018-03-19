package com.example.mits16.presentation.homework9;

import android.databinding.BindingAdapter;
import android.widget.ImageView;
import com.bumptech.glide.Glide;

/**
 * Created by mizz8 on 10.03.2018.
 */

public class User {
    private String name;
    private String surname;
    private int age;
    private String gender;
    private String imageUrl;


    //private String imageUrl = "https://cdn.pixabay.com/photo/2015/08/19/03/09/girl-895456_960_720.jpg";
   // private String imageUrl = "http://www.zastavki.com/pictures/originals/2013/Men__039174_.jpg";


    public User(String name, String surname,int age,String gender, String imageUrl) {
    this.name = name;
    this.surname = surname;
    this.age = age;
    this.gender = gender;
    this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean genderType(){
        if (gender.equals("male")) {
            return true;
        }else {
            return false;
        }
    }

    @BindingAdapter({"app:src"})
    public static void setImageUrl(ImageView view,String imageUrl){
        Glide.with(view.getContext()).load(imageUrl).into(view);
    }
}
