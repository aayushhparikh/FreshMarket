package com.example.finalproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ItemAdapter extends ArrayAdapter<itemList> {

    public ItemAdapter(@NonNull Context context, ArrayList<itemList> itemListArrayList) {
        super(context, 0, itemListArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listitemView = convertView;
        if (listitemView == null) {
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.card_item, parent, false);
        }

        itemList itemList = getItem(position);
        TextView itemView = listitemView.findViewById(R.id.item);

        itemView.setText(itemList.getItemname());
        return listitemView;
    }
}
