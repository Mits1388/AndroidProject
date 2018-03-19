package com.example.mits16.domain.entity;



/**
 * Created by mizz8 on 18.03.2018.
 */

public class UserEntity {

    private String username;
    private int age;
    private String profileUrl;
    private String surname;
    private String gender;


    public UserEntity() {
    }

    public UserEntity(String username,String surname,int age,String gender,String profileUrl) {
        this.username = username;
        this.age = age;
        this.profileUrl = profileUrl;
        this.gender = gender;
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public int getAge() {
        return age;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public String getSurname() {
        return surname;
    }

    public String getGender() {
        return gender;
    }
}
