package com.example.projectproposal;

import android.graphics.Bitmap;

import java.io.Serializable;
import java.util.Date;

public class ItemModel implements Serializable {

    String name;
    String gre;
    String rate;
    String tofle;
    String url;
    String type;
    String location;
    String locationString;

    public ItemModel(String name, String gre, String rate, String tofle, String url, String type, String location, String locationString) {
        this.name = name;
        this.gre = gre;
        this.rate = rate;
        this.tofle = tofle;
        this.url = url;
        this.type = type;
        this.location = location;
        this.locationString = locationString;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public String getLocationString() {
        return locationString;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setLocationString(String locationString) {
        this.locationString = locationString;
    }

    public String getGre() {
        return gre;
    }

    public void setGre(String gre) {
        this.gre = gre;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getTofle() {
        return tofle;
    }

    public void setTofle(String tofle) {
        this.tofle = tofle;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}

