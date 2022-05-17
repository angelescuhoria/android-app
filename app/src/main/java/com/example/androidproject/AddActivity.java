package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText name_input, type_input, price_input;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        name_input = (EditText) findViewById(R.id.product_name);
        type_input = (EditText) findViewById(R.id.product_type);
        price_input = (EditText) findViewById(R.id.product_price);
        add_button = (Button) findViewById(R.id.add_button);

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteProductsDBHelper db = new SQLiteProductsDBHelper(AddActivity.this);
                db.addProduct(name_input.getText().toString().trim(), type_input.getText().toString().trim(), Integer.valueOf(price_input.getText().toString().trim()));
            }
        });
    }
}