package com.example.myapp.entities;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Menza")
public class Menza {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "emri")
    private String emri;
    @ColumnInfo(name = "latitude")
    private String latitude;
    @ColumnInfo(name = "longitude")
    private String longitude;

    public Menza(String emri, String latitude, String longitude) {
        this.emri = emri;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Menza() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
