package com.example.Useless.site.model;

public class CoordinateModel {
    
    String url;

    double latitude;

    double longitude;

    public CoordinateModel(String url, Double latitude, Double longitude) {
        this.url = url;
        this.latitude = latitude;
        this.longitude = longitude;
    }


    public String getUrl() {
        return url;
    }


    public void setUrl(String url) {
        this.url = url;
    }

    public double getLatitude() {
        return latitude;
    }


    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }


    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

}

