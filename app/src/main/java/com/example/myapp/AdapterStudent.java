package com.example.myapp;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.List;

public class AdapterStudent  extends BaseAdapter {
    StudentProfile listViewMain1;
    String[] personalInformation;
    Animation animation;
  public   AdapterStudent(StudentProfile listViewMain1, String [] personalInformation){

      this.listViewMain1=listViewMain1;
      this.personalInformation=personalInformation;
  }
    public static int getRandom(int max) {
        return (int) (Math.random() * max);
    }


    @Override
    public int getCount() {
        return personalInformation.length;
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
        convertView = LayoutInflater.from(listViewMain1).inflate(R.layout.student_profile, parent, false);
        animation = AnimationUtils.loadAnimation(listViewMain1, R.anim.animation1);
        TextView textView = convertView.findViewById(R.id.personalInformation);
       /* LinearLayout ll_bg;
        ll_bg = convertView.findViewById(R.id.ll_bg);*/

        textView.setText(personalInformation[position]);
        return convertView;

    }
}