package com.example.myapp.entities;

public class Menza {

    private String emri;
    private String latitude;
    private String longitude;

    public Menza(String emri, String latitude, String longitude) {
        this.emri = emri;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Menza() {
    }

    public String getEmri() {
        return emri;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Menza{" +
                "emri='" + emri + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                '}';
    }
}
