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

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.MyViewHolder2>{
    private Context context2;
    private Activity activity2;
    private ArrayList grocery_name2, price_num2;

    CartAdapter(Activity activity2, Context context2, ArrayList grocery_name2, ArrayList price_num2) {
        this.activity2 = activity2;
        this.context2 = context2;
        this.grocery_name2 = grocery_name2;
        this.price_num2 = price_num2;
    }

    @NonNull
    @Override
    public MyViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context2);
        View view = inflater.inflate(R.layout.cart_items, parent, false);
        return new MyViewHolder2(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder2 holder, int position) {
        holder.name_id2.setText(String.valueOf(grocery_name2.get(position)));
        holder.price_id2.setText("$" +String.valueOf(price_num2.get(position)));

    }

    @Override
    public int getItemCount() {
        return grocery_name2.size();
    }

    public class MyViewHolder2 extends RecyclerView.ViewHolder{
        TextView name_id2, price_id2;
        LinearLayout mainLayout2;

        public MyViewHolder2(@NonNull View itemView) {
            super(itemView);
            name_id2 = itemView.findViewById(R.id.name_id2);
            price_id2 = itemView.findViewById(R.id.price_id2);
            mainLayout2 = itemView.findViewById(R.id.mainLayout2);
        }
    }
}
