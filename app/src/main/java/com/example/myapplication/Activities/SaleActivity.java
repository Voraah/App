package com.example.myapplication.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class SaleActivity extends AppCompatActivity {

    private EditText txtQuantity;
    private Button btnNumber, btnDelete, btnCheck;
    int digit;
    long quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_sale);

        txtQuantity = findViewById(R.id.txtProductQuantity);
        btnDelete = findViewById(R.id.btnDelete);
        btnCheck = findViewById(R.id.btnCheck);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtQuantity.setText("");
            }
        });
    }

    public void numberPressed(View v) {
        btnNumber = (Button) v;

        digit = Integer.parseInt(btnNumber.getText().toString());

        if (txtQuantity.getText().toString().equals("")) {
            quantity = 0;
        }
        quantity = Long.parseLong(txtQuantity.getText().toString());
        quantity = quantity * 10 + digit;

        txtQuantity.setText(String.valueOf(quantity));
    }
}
