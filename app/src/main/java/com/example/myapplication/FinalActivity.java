package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class FinalActivity extends AppCompatActivity {

    private Button btnAnotherProduct, btnFinalize, btnPrint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        btnAnotherProduct = findViewById(R.id.btnAnotherProduct);
        btnFinalize = findViewById(R.id.btnFinalize);
        btnPrint = findViewById(R.id.btnPrint);
    }
}