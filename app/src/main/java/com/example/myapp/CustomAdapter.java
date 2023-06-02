package com.example.myapp;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;

 class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    String examPeriods[];
    ExamPeriodsList listViewMain;
    Animation animation1;
    private OnItemClickListener mListener;
    public interface OnItemClickListener {
        void onItemClick(int position);
    }


    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;

        public ViewHolder(View view,final OnItemClickListener listener) {
            super(view);
            // Define click listener for the ViewHolder's View

            textView = (TextView) view.findViewById(R.id.textView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener!= null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
    public CustomAdapter(ExamPeriodsList listViewMain, String examPeriods[]) {
        super();
        this.listViewMain = listViewMain;
        this.examPeriods = examPeriods;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View  v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item, parent, false);
        CustomAdapter.ViewHolder evh = new ViewHolder(v, mListener);
        return evh;
    }

    /*public static int getRandom(int max) {
            return (int) (Math.random() * max);
        }*/
    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.ViewHolder holder, int position) {
        Object[] examPeriodsList= Arrays.stream(examPeriods).toArray();
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getItemCount() {
        return examPeriods.length;
    }



    /*@Override
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
*/
}



