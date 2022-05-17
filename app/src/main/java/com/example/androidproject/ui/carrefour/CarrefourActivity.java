package com.example.androidproject.ui.carrefour;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.androidproject.AddActivity;
import com.example.androidproject.R;
import com.example.androidproject.SQLiteProductsDBHelper;
import com.example.androidproject.ui.list.ProductListActivity;
import com.example.androidproject.ui.megaimage.CustomAdapterMegaImage;
import com.example.androidproject.ui.megaimage.MegaImageActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class CarrefourActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton add_button, list_button;
    SQLiteProductsDBHelper db;
    ArrayList<String> product_id, product_name, product_type, product_price;
    CustomAdapterCarrefour customAdapterCarrefour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrefour);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        list_button = (FloatingActionButton) findViewById(R.id.displaylist);
        list_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CarrefourActivity.this, ProductListActivity.class);
                startActivity(intent);
            }
        });

        add_button = (FloatingActionButton) findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CarrefourActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });

        db = new SQLiteProductsDBHelper(CarrefourActivity.this);
        product_id = new ArrayList<>();
        product_name = new ArrayList<>();
        product_type = new ArrayList<>();
        product_price = new ArrayList<>();

        storeData();

        customAdapterCarrefour = new CustomAdapterCarrefour(CarrefourActivity.this, product_id, product_name, product_type, product_price);
        recyclerView.setAdapter(customAdapterCarrefour);
        recyclerView.setLayoutManager(new LinearLayoutManager(CarrefourActivity.this));

    }

    public void storeData() {
        Cursor cursor = db.readAllDataMegaImage();
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                product_id.add(cursor.getString(0));
                product_name.add(cursor.getString(1));
                product_type.add(cursor.getString(2));
                product_price.add(cursor.getString(3));
            }
        }
    }
}