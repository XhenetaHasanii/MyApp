package com.example.myapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class CustomBaseAdapter extends BaseAdapter {
    String examPeriods [];
    ExamPeriodsList listViewMain;
    Animation animation1;


    public CustomBaseAdapter(ExamPeriodsList listViewMain, String examPeriods[]) {

        this.listViewMain = listViewMain;
        this.examPeriods = examPeriods;


    }


    public static int getRandom(int max) {
        return (int) (Math.random() * max);
    }

    @Override
    public int getCount() {

        return examPeriods.length;
    }


    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(listViewMain).inflate(R.layout.exam_periods, parent, false);
        animation1 = AnimationUtils.loadAnimation(listViewMain, R.anim.animation1);
        TextView textView = convertView.findViewById(R.id.periods);
        LinearLayout ll_bg;
        ll_bg = convertView.findViewById(R.id.ll_bg);
        int number = getRandom(5);
        if (number == 1) {
            ll_bg.setBackground(ContextCompat.getDrawable(listViewMain, R.drawable.gradient_1));
        }
        if (number == 2) {
            ll_bg.setBackground(ContextCompat.getDrawable(listViewMain, R.drawable.gradient_2));
        }
        if (number == 3) {
            ll_bg.setBackground(ContextCompat.getDrawable(listViewMain, R.drawable.gradient_3));
        }
        if (number == 4) {
            ll_bg.setBackground(ContextCompat.getDrawable(listViewMain, R.drawable.gradient_4));
        }
        if (number == 5) {
            ll_bg.setBackground(ContextCompat.getDrawable(listViewMain, R.drawable.gradient_4));
        }
        textView.setText(examPeriods[position]);
        return convertView;
    }


}




