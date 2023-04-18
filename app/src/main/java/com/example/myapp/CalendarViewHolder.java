package com.example.myapp;

import android.os.Build;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.time.LocalDate;

public class CalendarViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
{
    public final View parentView;
    public final TextView dayOfMonth;
    private final CalendarAdapter.OnItemListener onItemListener;
    public CalendarViewHolder( @NonNull View itemView, CalendarAdapter.OnItemListener onItemListener)
    {
        super(itemView);
        parentView=itemView.findViewById(R.id.parentView);
        dayOfMonth = itemView.findViewById(R.id.cellDayText);
        this.onItemListener = onItemListener;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            onItemListener.onItemClick(getAdapterPosition(), LocalDate.parse((String) dayOfMonth.getText()));
        }
    }
}
