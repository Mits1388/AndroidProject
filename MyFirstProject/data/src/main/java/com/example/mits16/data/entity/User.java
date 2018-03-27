package com.example.mits16.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by user on 19.03.2018.
 */


public class User {


    @SerializedName("objectId")
    private String objectId;
    @SerializedName("username")
    private String username;
    @SerializedName("age")
    private String age;
    @SerializedName("lastname")
    private String lastname;

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
