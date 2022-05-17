package com.example.androidproject.ui.megaimage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidproject.R;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapterMegaImage extends RecyclerView.Adapter<CustomAdapterMegaImage.MyViewHolder> {
    public Context context;
    public ArrayList product_id, product_name, product_type, product_price;

    CustomAdapterMegaImage(Context context,
                           ArrayList product_id,
                           ArrayList product_name,
                           ArrayList product_type,
                           ArrayList product_price) {
        this.context = context;
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_type = product_type;
        this.product_price = product_price;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setFilter(ArrayList<String> lst, ArrayList<String> lst2, ArrayList<String> lst3, ArrayList<String> lst4){
        product_name = lst;
        product_price = lst2;
        product_id = lst3;
        product_type = lst4;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.megaimage_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.product_id.setText(String.valueOf(product_id.get(position)));
        holder.product_name.setText(String.valueOf(product_name.get(position)));
        holder.product_type.setText(String.valueOf(product_type.get(position)));
        holder.product_price.setText(String.valueOf(product_price.get(position)));
    }

    @Override
    public int getItemCount() {
        return product_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView product_id, product_name, product_type, product_price;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            product_id = itemView.findViewById(R.id.product_id);
            product_name = itemView.findViewById(R.id.product_name);
            product_type = itemView.findViewById(R.id.product_type);
            product_price = itemView.findViewById(R.id.product_price);
        }
    }

}
