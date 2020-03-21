package com.dataentropia.room_viewmodel;


import androidx.annotation.NonNull;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "person")
public class Person {

    private String name;
    @PrimaryKey
    @NonNull
    private String mobile;

    private String email;
    @Embedded
    private Address id_mobile;
    @Ignore
    private String middleName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getId_mobile() {
        return id_mobile;
    }

    public void setId_mobile(Address id_mobile) {
        this.id_mobile = id_mobile;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
}

