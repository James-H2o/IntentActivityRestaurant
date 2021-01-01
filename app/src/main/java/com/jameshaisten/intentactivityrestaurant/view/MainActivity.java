package com.jameshaisten.intentactivityrestaurant.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telecom.Call;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jameshaisten.intentactivityrestaurant.R;
import com.jameshaisten.intentactivityrestaurant.model.FoodItem;

public class MainActivity extends AppCompatActivity {

    private TextView nameTextView;
    private TextView priceTextView;

    private Button addItemButton;
    private final int REQUEST_CODE = 707;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameTextView = findViewById(R.id.textview_new_food);
        priceTextView = findViewById(R.id.textview_price);

        addItemButton = findViewById(R.id.button_goto_add);
        addItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddItemActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });// End setOnClickListener
    }// End onCreate

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE){
            FoodItem foodItem = (FoodItem) data.getSerializableExtra(AddItemActivity.DATA_TAG);
            updateDisp(foodItem);
        }
    }

    private void updateDisp(FoodItem foodItem) {

        nameTextView.setText(foodItem.getName());
        priceTextView.setText(foodItem.getPrice().toString());
    }
}// End MainActivity