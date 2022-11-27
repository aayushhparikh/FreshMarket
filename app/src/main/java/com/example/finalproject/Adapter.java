package com.example.finalproject;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList grocery_name;
    private Listener listener;


    Adapter(Activity activity, Context context, ArrayList grocery_name, Listener listener) {
        this.activity = activity;
        this.context = context;
        this.grocery_name = grocery_name;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.card_item, parent, false);
        return new MyViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name_id.setText(String.valueOf(grocery_name.get(position)));

    }

    @Override
    public int getItemCount() {
        return grocery_name.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name_id;
        LinearLayout mainLayout;
        Button addToCart;
        Listener listener;

        public MyViewHolder(@NonNull View itemView, Listener listener) {
            super(itemView);
            name_id = itemView.findViewById(R.id.name_id);
            mainLayout = itemView.findViewById(R.id.mainLayout);
            addToCart = itemView.findViewById(R.id.addtocart);
            this.listener = listener;

            addToCart.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.addToCartClicked(view, getAdapterPosition());
        }
    }

    public interface Listener{
        void addToCartClicked(View view, int position);
    }
}
