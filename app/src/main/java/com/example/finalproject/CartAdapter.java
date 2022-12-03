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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.MyViewHolder2>{
    private Context context2;
    private Activity activity2;
    private ArrayList quantity_id;
    //private Integer quantity_id;
    private ArrayList grocery_name2, price_num2;
    private Add add;
    private Subtract subtract;
    int quantity_num;

    DBHelper mydb;
    //private Subtract subtract;

    CartAdapter(Activity activity2, Context context2, ArrayList grocery_name2, ArrayList price_num2,ArrayList quantity_id, Add add, Subtract subtract, int quantity_num) {
        this.activity2 = activity2;
        this.context2 = context2;
        this.grocery_name2 = grocery_name2;
        this.price_num2 = price_num2;
        this.quantity_id = quantity_id;
        this.add = add;
        this.subtract = subtract;
        this.quantity_num = quantity_num;
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
        holder.quantity_id.setText(String.valueOf(quantity_num));

        holder.add1.setOnClickListener(new View.OnClickListener() {
            int i = quantity_num;

            @Override
            public void onClick(View v) {
                i++;
                holder.quantity_id.setText(String.valueOf(i));
                quantity_num = i;
                //mydb.updateCartItems("55", 5);
            }
        });

        holder.minus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity_num--;
                holder.quantity_id.setText(String.valueOf(quantity_num));
            }
        });
    }


    @Override
    public int getItemCount() {
        return grocery_name2.size();
    }

    public class MyViewHolder2 extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView name_id2, price_id2, quantity_id;
        LinearLayout mainLayout2;
        Button add1, minus1;
        Add add;
        Subtract subtract;

        public MyViewHolder2(@NonNull View itemView, Add add, Subtract subtract) {
            super(itemView);
            name_id2 = itemView.findViewById(R.id.name_id2);
            price_id2 = itemView.findViewById(R.id.price_id2);
            mainLayout2 = itemView.findViewById(R.id.mainLayout2);
            quantity_id = itemView.findViewById(R.id.quantity_id);
            add1 = itemView.findViewById(R.id.add1);
            minus1 = itemView.findViewById(R.id.minus1);

            this.add = add;
            this.subtract = subtract;

            add1.setOnClickListener(this::onClick);
            minus1.setOnClickListener(this::subtractOnClick);
        }

        @Override
        public void onClick(View view) {
            add.add1(view, getAdapterPosition());
        }

        public void subtractOnClick(View view) {
            subtract.subtract1(view, getAdapterPosition());
        }
    }

    public interface Add{
        void add1(View view, int position);
    }

    public interface Subtract {
        void subtract1 (View view, int position);
    }
}
