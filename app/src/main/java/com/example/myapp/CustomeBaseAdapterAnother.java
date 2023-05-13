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

public class CustomeBaseAdapterAnother extends BaseAdapter {
    JanuaryPeriod listViewMain1;
    ArrayList<String> exams;
    Animation animation1;

    public CustomeBaseAdapterAnother(JanuaryPeriod listViewMain1, ArrayList<String> exams) {
        this.listViewMain1 = listViewMain1;
        this.exams = exams;
    }

    public static int getRandom(int max) {
        return (int) (Math.random() * max);
    }


    @Override
    public int getCount() {
        return exams.size();
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
    public View getView(int position, View view, ViewGroup parent) {

        view = LayoutInflater.from(listViewMain1).inflate(R.layout.exams_january, parent, false);
        animation1 = AnimationUtils.loadAnimation(listViewMain1, R.anim.animation1);
        TextView textView1 = view.findViewById(R.id.exams);
        LinearLayout ll_bg1;
        ll_bg1 = view.findViewById(R.id.ll_bg1);
        int number1 = getRandom(3);
        if (number1 == 1) {
            ll_bg1.setBackground(ContextCompat.getDrawable(listViewMain1, R.drawable.gradient_1));
        }
        if (number1 == 2) {
            ll_bg1.setBackground(ContextCompat.getDrawable(listViewMain1, R.drawable.gradient_2));
        }
        if (number1 == 3) {
            ll_bg1.setBackground(ContextCompat.getDrawable(listViewMain1, R.drawable.gradient_3));
        }

        textView1.setText(exams.get(position));

        return view;

    }
}

