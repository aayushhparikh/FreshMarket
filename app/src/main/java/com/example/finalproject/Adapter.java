package com.example.finalproject;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList grocery_name;

    Adapter(Activity activity, Context context, ArrayList grocery_name) {
        this.activity = activity;
        this.context = context;
        this.grocery_name = grocery_name;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.card_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name_id.setText(String.valueOf(grocery_name.get(position)));

    }

    @Override
    public int getItemCount() {
        return grocery_name.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name_id;
        LinearLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name_id = itemView.findViewById(R.id.name_id);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
