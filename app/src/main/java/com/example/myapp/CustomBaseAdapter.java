package com.example.myapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CustomBaseAdapter extends BaseAdapter {
    public String afatiIProvimeve[]={"Janar","Prill","Qershor","Shtator"};
   public Context context;

    LayoutInflater inflater;
    public CustomBaseAdapter(Context ctx, String afatiIProvimeve[]) {
        this.context=ctx;
        this.afatiIProvimeve=afatiIProvimeve;
        inflater=LayoutInflater.from(ctx);


    }

    @Override
    public int getCount() {

        for (int i = 0; i < afatiIProvimeve.length; i++) {
            System.out.println(afatiIProvimeve[i]);
            return afatiIProvimeve.length;

    }return afatiIProvimeve.length;
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
    public View getView(int i, View view, ViewGroup viewGroup) {
        view=inflater.inflate(R.layout.activity_custom_list_view,null);
        TextView txtView=(TextView)view.findViewById(R.id.txt1);
        if (txtView!=null){
        txtView.setText(afatiIProvimeve[i]);}
        return view;
    }
}
