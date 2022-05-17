package com.example.androidproject.ui.carrefour;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidproject.R;
import com.example.androidproject.ui.megaimage.CustomAdapterMegaImage;

import java.util.ArrayList;

public class CustomAdapterCarrefour extends RecyclerView.Adapter<CustomAdapterCarrefour.MyViewHolder> {
    public Context context;
    public ArrayList product_id, product_name, product_type, product_price;

    CustomAdapterCarrefour(Context context,
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

    @NonNull
    @Override
    public CustomAdapterCarrefour.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.carrefour_row, parent, false);
        return new CustomAdapterCarrefour.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapterCarrefour.MyViewHolder holder, int position) {
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