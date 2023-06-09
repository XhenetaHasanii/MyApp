package com.example.myapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AdapterStudent  extends BaseAdapter {
    Profile listViewMain1;

    Animation animation;
   ArrayList<Student> personalInformation;
    public AdapterStudent(Profile listViewMain1, List<Student> personalInformation) {

        this.listViewMain1 = listViewMain1;
       this.personalInformation= (ArrayList<Student>) personalInformation;
    }

    public static int getRandom(int max) {
        return (int) (Math.random() * max);
    }


    @Override
    public int getCount() {
        return personalInformation.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(listViewMain1).inflate(R.layout.activity_profile, parent, false);
        animation = AnimationUtils.loadAnimation(listViewMain1, R.anim.animation1);
        TextView textView = convertView.findViewById(R.id.TV_username);


        Student student= personalInformation.get(position);
        String itemText = getName(student); // First name
        String dataText = getlastName(student); // Last name
        textView.setText(itemText + " - " + dataText);
        return convertView;
    }




    private String getName(Student student) {

        return student.getFirstName();
    }

    private String getlastName(Student student) {
        return student.getLastName();
    }
}