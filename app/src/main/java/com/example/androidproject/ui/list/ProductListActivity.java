package com.example.androidproject.ui.list;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.androidproject.AddActivity;
import com.example.androidproject.R;
import com.example.androidproject.ui.megaimage.MegaImageActivity;
import com.example.androidproject.ui.shops.ShopsActivity;

public class ProductListActivity extends AppCompatActivity {

    Button exit_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        exit_button = (Button) findViewById(R.id.exit_button);
        exit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductListActivity.this, ShopsActivity.class);
                startActivity(intent);
            }
        });
    }
}