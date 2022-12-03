package com.example.finalproject;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.MyViewHolder2>{
    private Context context2;
    private Activity activity2;
    private ArrayList<Integer> quantities;
    //private Integer quantity_id;
    private ArrayList grocery_name2, price_num2;
    private Subtract subtract;
    private Add add;

    DBHelper mydb;
    //private Subtract subtract;

    CartAdapter(Activity activity2, Context context2, ArrayList grocery_name2, ArrayList price_num2, ArrayList quantities, Add add, Subtract subtract) {
        this.activity2 = activity2;
        this.context2 = context2;
        this.grocery_name2 = grocery_name2;
        this.price_num2 = price_num2;
        this.quantities = quantities;
        this.subtract = subtract;
        this.add = add;
    }

    @NonNull
    @Override
    public MyViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context2);
        View view = inflater.inflate(R.layout.cart_items, parent, false);
        return new MyViewHolder2(view, add, subtract);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder2 holder, int position) {
        holder.name_id2.setText(String.valueOf(grocery_name2.get(position)));
        holder.price_id2.setText("$" + String.valueOf(price_num2.get(position)));
        holder.quantity_id.setText(String.valueOf(quantities.get(position)));
    }


    @Override
    public int getItemCount() {
        return grocery_name2.size();
    }

    public class MyViewHolder2 extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView name_id2, price_id2, quantity_id;
        LinearLayout mainLayout2;
        Button minus1, add1;
        Subtract subtract;
        Add add;

        public MyViewHolder2(@NonNull View itemView, Add add, Subtract subtract) {
            super(itemView);
            name_id2 = itemView.findViewById(R.id.name_id2);
            price_id2 = itemView.findViewById(R.id.price_id2);
            mainLayout2 = itemView.findViewById(R.id.mainLayout2);
            quantity_id = itemView.findViewById(R.id.quantity_id);
            minus1 = itemView.findViewById(R.id.minus1);
            add1 = itemView.findViewById(R.id.add1);

            this.subtract = subtract;
            this.add = add;

            minus1.setOnClickListener(this::subtractOnClick);
            add1.setOnClickListener(this::onClick);

        }

        
        public void subtractOnClick(View view) {
            int position = getAdapterPosition();
            if(quantities.get(position) > 0) {
                quantities.set(position, quantities.get(position) - 1);
                subtract.subtract1(view, position + 1, quantities.get(position));
                quantity_id.setText(String.valueOf(quantities.get(position)));
            }
        }
        
        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            quantities.set(position, quantities.get(position) + 1);
            add.add1(view, position + 1, quantities.get(position));
            quantity_id.setText(String.valueOf(quantities.get(position)));
        }
    }

    public interface Subtract {
        void subtract1 (View view, int position, int quantity);
    }

    public interface Add{
        void add1(View view, int position, int quantity);
    }
}
