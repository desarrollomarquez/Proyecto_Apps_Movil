package com.dataentropia.room_viewmodel;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "address")
public class Address {

    @PrimaryKey
    @NonNull
    private String id;
    @NonNull
    private String id_mobile;
    private String city;
    private String country;
    private String zip;

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    @NonNull
    public String getId_mobile() {
        return id_mobile;
    }

    public void setId_mobile(@NonNull String id_mobile) {
        this.id_mobile = id_mobile;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
