package com.example.myapp.entities;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import java.util.Date;

public class Provimi implements Parcelable {

    private String examName;
    private Date examTime;

    public Provimi(String examName, Date examTime) {
        this.examName = examName;
        this.examTime = examTime;
    }

    public Provimi() {
    }

    public Provimi(Parcel in) {
        this.examName = in.readString();
        this.examTime = new Date(in.readLong());
    }

    @Override
    public String toString() {
        return "Provimi{" +
                "examName='" + examName + '\'' +
                ", examTime=" + examTime +
                '}';
    }

    public String getExamName() {
        return examName;
    }

    public Date getExamTime() {
        return examTime;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public void setExamTime(Date examTime) {
        this.examTime = examTime;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(this.examName);
        parcel.writeLong(this.examTime.getTime());
    }

    public static final Parcelable.Creator<Provimi> CREATOR = new Parcelable.Creator<Provimi>()
    {
        public Provimi createFromParcel(Parcel in)
        {
            return new Provimi(in);
        }
        public Provimi[] newArray(int size)
        {
            return new Provimi[size];
        }
    };
}
