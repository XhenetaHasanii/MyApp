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
NovemberPeriod list;
ArrayList<String> examsNovember;
Animation animation1;
NovemberAdapter(NovemberPeriod list,ArrayList<String> examsNovember){
    this.list=list;
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

        view= LayoutInflater.from(list).inflate(R.layout.exams_november,parent,false);
        animation1 = AnimationUtils.loadAnimation(list, R.anim.animation1);
        TextView textView4= view.findViewById(R.id.examsNovember);
        LinearLayout ll_bg4;
        ll_bg4= view.findViewById(R.id.ll_bg5);
        int number2 = getRandom(4);
        if (number2== 1) {
            ll_bg4.setBackground(ContextCompat.getDrawable(list, R.drawable.gradient_1));
        }
        if (number2 == 2) {
            ll_bg4.setBackground(ContextCompat.getDrawable(list, R.drawable.gradient_2));
        }
        if (number2 == 3) {
            ll_bg4.setBackground(ContextCompat.getDrawable(list, R.drawable.gradient_3));
        }
        textView4.setText(examsNovember.get(position));

        return view;
    }

}
