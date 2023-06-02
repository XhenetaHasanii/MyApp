package com.example.myapp;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Exams extends AppCompatActivity implements Parcelable {
    public List<Exams> periodExams;

    public Exams(List<Exams> periodExams) {
        this.periodExams = periodExams;
    }

    public Exams() {

    }

    public List<Exams> getPeriodExams() {
        return periodExams;
    }

    static List<Afati> readListFrom(final Parcel in) {
        Parcelable[] parcelables = in.readParcelableArray(
                Afati.class.getClassLoader());
        List<Afati> periodExams = new ArrayList<>(parcelables.length);
        for (Parcelable parcelable : parcelables) {
            periodExams.add((Afati) parcelable);
        }
        return periodExams;
    }
    protected Exams(Parcel in) {
        in.readList(periodExams, Exams.class.getClassLoader());

    }

    public static final Creator<Exams> CREATOR = new Creator<Exams>() {
        @Override
        public Exams createFromParcel(Parcel in) {
            return new Exams(in);
        }

        @Override
        public Exams[] newArray(int size) {
            return new Exams[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeList(periodExams);
    }

}
