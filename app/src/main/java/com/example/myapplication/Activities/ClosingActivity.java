package com.example.myapplication.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;

public class ClosingActivity extends AppCompatActivity {

    private double saleprice, change;
    private EditText txtPayment;
    private Button btnCalc;
    private TextView txtFinalPrice, txtChange;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_closing);

        txtFinalPrice = findViewById(R.id.txtFinalPrice);
        txtPayment = findViewById(R.id.txtPayment);
        txtChange = findViewById(R.id.lblFinalResult);
        btnCalc = findViewById(R.id.btnCalc);

        saleprice = getIntent().getExtras().getDouble("saleprice");
        txtFinalPrice.setText(" " + saleprice);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Double.parseDouble(txtPayment.getText().toString())>= saleprice) {
                    change = Double.parseDouble(txtPayment.getText().toString()) - saleprice;
                    txtChange.setText("" + change);
                } else {
                    Toast.makeText(ClosingActivity.this, "El pago establecido no es suficiente", Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}