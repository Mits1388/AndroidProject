package com.example.mits16.myfirstproject.homework6;

/**
 * Created by mizz8 on 26.02.2018.
 */

public class User {

    private String imageUrl;
    private String name;
    private String surname;

    public User(String s, String s1, String s2, String s3, String s4) {
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
}
