package com.example.myapplication.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Filter;
import android.widget.TextView;

import com.example.myapplication.Models.Product;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class FinalActivity extends AppCompatActivity {

    private ArrayList<? extends Product> ticketList = new ArrayList<Product>();

    private TextView txtTotal;
    private Button btnAnotherProduct, btnFinalize, btnPrint;
    private double totalsale, previoustotal;

    private static final String SHARED_PREFS = "sharedPrefs";
    private static final String TOTAL = "total";

    private String total;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);

        txtTotal = findViewById(R.id.txtTotalSalePrice);
        btnAnotherProduct = findViewById(R.id.btnAnotherProduct);
        btnFinalize = findViewById(R.id.btnFinalize);
        btnPrint = findViewById(R.id.btnPrint);

        loadData();

    //    Bundle bundle = new Bundle();
    //    ticketList =  bundle.getParcelableArrayList("ticketList");
        totalsale = getIntent().getExtras().getDouble("saleprice");

        if(total.equals("")) {
            txtTotal.setText("" + totalsale);
        } else {
            previoustotal = Double.parseDouble(total);
            totalsale = previoustotal + totalsale;
            txtTotal.setText("" + totalsale);
        }
        btnAnotherProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
                Intent i = new Intent(FinalActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        btnFinalize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(TOTAL);
                editor.apply();
                Intent i = new Intent(FinalActivity.this, ClosingActivity.class);
                i.putExtra("saleprice", Double.parseDouble(txtTotal.getText().toString()));
                startActivity(i);

            }
        });
    }

    private void saveData() {
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(TOTAL, txtTotal.getText().toString());
        editor.apply();
    }

    private void loadData() {
        //SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        total = sharedPreferences.getString(TOTAL, "");
    }
}