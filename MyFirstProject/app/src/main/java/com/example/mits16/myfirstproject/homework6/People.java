package com.example.mits16.myfirstproject.homework6;

/**
 * Created by mizz8 on 01.03.2018.
 */

public class People {
    private String name;
    private String age;
    private String id;
    private String surname;
    private String isDegree;

    People (String id, String name, String surname, String age, String isDegree){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.isDegree = isDegree;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getIsDegree() {
        return isDegree;
    }

    public void setIsDegree(String isDegree) {
        this.isDegree = isDegree;
    }
}
