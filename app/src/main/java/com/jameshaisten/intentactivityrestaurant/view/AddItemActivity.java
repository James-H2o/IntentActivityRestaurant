package com.jameshaisten.intentactivityrestaurant.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jameshaisten.intentactivityrestaurant.R;
import com.jameshaisten.intentactivityrestaurant.model.FoodItem;

public class AddItemActivity extends AppCompatActivity {

    private EditText itemName;
    private EditText itemPrice;

    private Button saveItem;

    public static final String DATA_TAG = "data_tag";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        itemName = findViewById(R.id.edittext_food_name);
        itemPrice = findViewById(R.id.editText_price);

        saveItem = findViewById(R.id.button_add_item);
        saveItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name;
                Double price;
                Log.d("onClick------------->", "The value of Name: " + itemName.getText());



                    name = itemName.getText().toString();

                try {
                    price = Double.parseDouble(itemPrice.getText().toString());
                } catch (NumberFormatException e) {
                    price = 0.0;
                }


                FoodItem foodItem = new FoodItem(name, price);

                Intent intent = new Intent();
                intent.putExtra(DATA_TAG, foodItem);
                setResult(RESULT_OK, intent);


                finish();

            }
        });


    }// End onCreate





}// End AddItemActivity