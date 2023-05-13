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

public class JuneAdapter extends BaseAdapter {
    JunePeriod list;
    ArrayList<String> examsJune;
    Animation animation1;
    JuneAdapter(JunePeriod list,ArrayList<String> examsJune){
        this.list=list;
        this.examsJune=examsJune;
    }
    public static int getRandom(int max) {
        return (int) (Math.random() * max);}
    @Override
    public int getCount() {
        return examsJune.size();
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
    public View getView(int position, View view, ViewGroup parent) {
        view= LayoutInflater.from(list).inflate(R.layout.exams_june,parent,false);
        animation1 = AnimationUtils.loadAnimation(list, R.anim.animation1);
        TextView textView2= view.findViewById(R.id.examsJune);
        LinearLayout ll_bg1;
        ll_bg1 = view.findViewById(R.id.ll_bg3);
        int number1 = getRandom(3);
        if (number1 == 1) {
            ll_bg1.setBackground(ContextCompat.getDrawable(list, R.drawable.gradient_1));
        }
        if (number1 == 2) {
            ll_bg1.setBackground(ContextCompat.getDrawable(list, R.drawable.gradient_2));
        }
        if (number1 == 3) {
            ll_bg1.setBackground(ContextCompat.getDrawable(list, R.drawable.gradient_3));
        }

        textView2.setText(examsJune.get(position));

        return view;

    }

    }

