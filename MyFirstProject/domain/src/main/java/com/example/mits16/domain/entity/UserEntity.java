package com.example.mits16.domain.entity;

/**
 * Created by user on 12.03.2018.
 */

public class UserEntity {

    private String oid;
    private String user;
    private String ages;
    private String last;

    public UserEntity(String user, String last, String ages, String oid) {
        this.user = user;
        this.ages = ages;
        this.last = last;
        this.oid = oid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getAges() {
        return ages;
    }

    public void setAges(String ages) {
        this.ages = ages;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }
}
