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

public class CustomBaseAdapter extends BaseAdapter {

        ExamPeriodList listViewMain;
        Animation animation1;
        public String afatiIProvimeve[]={"Janar","Prill","Qershor","Shtator"};

        public CustomBaseAdapter(ExamPeriodList listViewMain, String[] afatiIProvimeve) {
            this.afatiIProvimeve=afatiIProvimeve;
            this.listViewMain=listViewMain;



        }
        public static int getRandom(int max){
            return (int)(Math.random()*max);
        }

        @Override
        public int getCount() {

            return afatiIProvimeve.length;}





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
            convertView= LayoutInflater.from(listViewMain).inflate(R.layout.exam_periods,parent,false);
            animation1= AnimationUtils.loadAnimation(listViewMain,R.anim.animation1);
            TextView textView=(TextView)convertView.findViewById(R.id.subjects);
            LinearLayout ll_bg;
            ll_bg=convertView.findViewById(R.id.ll_bg);
            int number=getRandom(4);
            if (number==1){
                ll_bg.setBackground(ContextCompat.getDrawable(listViewMain,R.drawable.gradient_1));
            }
            if (number==2){
                ll_bg.setBackground(ContextCompat.getDrawable(listViewMain,R.drawable.gradient_2));
            }
            if (number==3){
                ll_bg.setBackground(ContextCompat.getDrawable(listViewMain,R.drawable.gradient_3));
            }if (number==4){
                ll_bg.setBackground(ContextCompat.getDrawable(listViewMain,R.drawable.gradient_4));
            }
            textView.setText(afatiIProvimeve[position]);
            textView.setAnimation(animation1);
            return convertView;

        }}


      /*  public View getView(int i, View view, ViewGroup viewGroup) {


            view=LayoutInflater.from(listViewMain).inflate(R.layout.exam_periods,viewGroup,false);
            animation1= AnimationUtils.loadAnimation(listViewMain,R.anim.animation1);
            TextView textView=(TextView)view.findViewById(R.id.subjects);

            LinearLayout ll_bg;
            ll_bg=view.findViewById(R.id.ll_bg);
            int number=getRandom(4);
            if (number==1){
                ll_bg.setBackground(ContextCompat.getDrawable(listViewMain,R.drawable.gradient_1));
            }
            if (number==2){
                ll_bg.setBackground(ContextCompat.getDrawable(listViewMain,R.drawable.gradient_2));
            }
            if (number==3){
                ll_bg.setBackground(ContextCompat.getDrawable(listViewMain,R.drawable.gradient_3));
            }if (number==4){
                ll_bg.setBackground(ContextCompat.getDrawable(listViewMain,R.drawable.gradient_4));
            }
            textView.setText(afatiIProvimeve[i]);
            textView.setAnimation(animation1);


            return view;

        }
*/


