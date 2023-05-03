package com.example.myapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CustomBaseAdapter extends BaseAdapter {
    Context context;
    String afatiIProvimeve [];
    LayoutInflater inflater;
    public CustomBaseAdapter(Context ctx, String afatiIProvimeve[]) {
        this.context=ctx;
        this.afatiIProvimeve=afatiIProvimeve;
        inflater=LayoutInflater.from(ctx);


    }

    @Override
    public int getCount() {
         return afatiIProvimeve.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        view=inflater.inflate(R.layout.activity_custom_list_view,null);
        TextView txtView=(TextView)view.findViewById(R.id.textView);
        txtView.setText(afatiIProvimeve[position]);
        return view;
    }
}
