package com.example.myapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

public class CustomBaseAdapter extends BaseAdapter {
    ListViewMain listViewMain;
    public String afatiIProvimeve[];
    Animation animation1;


    LayoutInflater inflater;
    public CustomBaseAdapter(ListViewMain listViewMain, String[] afatiIProvimeve) {
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
    public View getView(int i, View view, ViewGroup viewGroup) {

        view=LayoutInflater.from(listViewMain).inflate(R.layout.activity_item_list,viewGroup,false);
        animation1= AnimationUtils.loadAnimation(listViewMain,R.anim.animation1);
       /* TextView txtView=(TextView)view.findViewById(R.id.textView);*/
        Button button=(Button)view.findViewById(R.id.button) ;
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
        button.setText(afatiIProvimeve[i]);
        button.setAnimation(animation1);
        return view;

    }

}
