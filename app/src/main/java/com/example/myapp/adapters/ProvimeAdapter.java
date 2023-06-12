package com.example.myapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.example.myapp.R;
import com.example.myapp.activities.ProvimetActivity;
import com.example.myapp.entities.Provimi;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.Date;

public class ProvimeAdapter extends BaseAdapter {
    ProvimetActivity provimetActivity;
    ArrayList<Provimi> periodExams;
    Animation animation1;

    public ProvimeAdapter(ProvimetActivity provimetActivity, ArrayList<Provimi> periodExams) {
        this.provimetActivity = provimetActivity;
        this.periodExams = periodExams;

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
        convertView = LayoutInflater.from(provimetActivity).inflate(R.layout.exam_periods, parent, false);
        animation1 = AnimationUtils.loadAnimation(provimetActivity, R.anim.animation1);
        TextView textView = convertView.findViewById(R.id.list_view);
        LinearLayout ll_bg;
        ll_bg = convertView.findViewById(R.id.ll_bg);
        int number = getRandom(5);
        if (number == 1) {
            ll_bg.setBackground(ContextCompat.getDrawable(provimetActivity, R.drawable.gradient_1));
        }
        if (number == 2) {
            ll_bg.setBackground(ContextCompat.getDrawable(provimetActivity, R.drawable.gradient_2));
        }
        if (number == 3) {
            ll_bg.setBackground(ContextCompat.getDrawable(provimetActivity, R.drawable.gradient_3));
        }
        if (number == 4) {
            ll_bg.setBackground(ContextCompat.getDrawable(provimetActivity, R.drawable.gradient_4));
        }
        if (number == 5) {
            ll_bg.setBackground(ContextCompat.getDrawable(provimetActivity, R.drawable.gradient_4));
        }
        Provimi provimi = periodExams.get(position);
        String itemText = provimi.getExamName();
        DateTime dateTime = new DateTime(provimi.getExamTime());
        String datePattern = "dd.MM.yyyy HH:mm";
        String dateString = dateTime.toString(datePattern);

        textView.setText(itemText + "   " +dateString);
        return convertView;
    }

    private String getItem(Provimi provimi) {
        return provimi.getExamName();
    }

    private Date getData(Provimi provimi) {
        return provimi.getExamTime();
    }

}

