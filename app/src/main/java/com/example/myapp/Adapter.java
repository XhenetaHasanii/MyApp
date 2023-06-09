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
import java.util.Date;

public class Adapter extends BaseAdapter {
    JanuaryPeriod listViewMain1;
    ArrayList<Provimi> periodExams;
    Animation animation1;

    public Adapter(JanuaryPeriod januaryPeriod, ArrayList<Provimi> periodExams) {
        this.listViewMain1=januaryPeriod;
        this.periodExams=periodExams;

    }
    public static int getRandom(int max) {
        return (int) (Math.random() * max);
    }

    @Override
    public int getCount() {
        return periodExams.size();
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
        convertView = LayoutInflater.from(listViewMain1).inflate(R.layout.exam_periods, parent, false);
        animation1 = AnimationUtils.loadAnimation(listViewMain1, R.anim.animation1);
        TextView textView = convertView.findViewById(R.id.periods);
        LinearLayout ll_bg;
        ll_bg = convertView.findViewById(R.id.ll_bg);
        int number = getRandom(5);
        if (number == 1) {
            ll_bg.setBackground(ContextCompat.getDrawable(listViewMain1, R.drawable.gradient_1));
        }
        if (number == 2) {
            ll_bg.setBackground(ContextCompat.getDrawable(listViewMain1, R.drawable.gradient_2));
        }
        if (number == 3) {
            ll_bg.setBackground(ContextCompat.getDrawable(listViewMain1, R.drawable.gradient_3));
        }
        if (number == 4) {
            ll_bg.setBackground(ContextCompat.getDrawable(listViewMain1, R.drawable.gradient_4));
        }
        if (number == 5) {
            ll_bg.setBackground(ContextCompat.getDrawable(listViewMain1, R.drawable.gradient_4));
        }
        Provimi provimi = periodExams.get(position);
        String itemText = (String) getItem(provimi);
        String dataText = getData(provimi).toString();
        textView.setText(itemText + " - " + dataText);
        return convertView;
    }

    private CharSequence getItem(Provimi provimi) {

        return provimi.getExamName();
    }
    private Date getData(Provimi provimi){
    return provimi.getExamTime(); }




}

