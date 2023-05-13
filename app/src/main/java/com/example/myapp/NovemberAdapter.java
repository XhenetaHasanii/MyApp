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

public class NovemberAdapter extends BaseAdapter {
NovemberPeriod array;
ArrayList<String> examsNovember;
Animation animation1;
NovemberAdapter(NovemberPeriod array,ArrayList<String> examsNovember){
    this.array=array;
    this.examsNovember=examsNovember;
}
    public static int getRandom(int max) {
        return (int) (Math.random() * max);}
    @Override
    public int getCount() {
        return examsNovember.size();
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
        view= LayoutInflater.from(array).inflate(R.layout.exams_september,parent,false);
        animation1 = AnimationUtils.loadAnimation(array, R.anim.animation1);
        TextView textView4= view.findViewById(R.id.examsNovember);
        LinearLayout ll_bg4;
        ll_bg4= view.findViewById(R.id.ll_bg4);
        int number1 = getRandom(3);
        if (number1 == 1) {
            ll_bg4.setBackground(ContextCompat.getDrawable(array, R.drawable.gradient_1));
        }
        if (number1 == 2) {
            ll_bg4.setBackground(ContextCompat.getDrawable(array, R.drawable.gradient_2));
        }
        if (number1 == 3) {
            ll_bg4.setBackground(ContextCompat.getDrawable(array, R.drawable.gradient_3));
        }

      textView4.setText(examsNovember.get(position));

        return view;
    }

}
