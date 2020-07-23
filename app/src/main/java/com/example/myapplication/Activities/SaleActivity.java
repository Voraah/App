package com.example.myapplication.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.FinalActivity;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

public class SaleActivity extends AppCompatActivity {

    private EditText txtQuantity;
    private TextView txtSaleProductName, txtSaleProductPrice;
    private ImageView imgProduct;
    private Button btnNumber, btnDelete, btnCheck;
    private String productname, productLinkImg;
    private double productPrice;
    int digit, productImg;
    long quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_sale);

        imgProduct = findViewById(R.id.imgProductSale);
        txtQuantity = findViewById(R.id.txtProductQuantity);
        txtSaleProductName = findViewById(R.id.txtSaleProductName);
        txtSaleProductPrice = findViewById(R.id.txtSaleProductPrice);
        btnDelete = findViewById(R.id.btnDelete);
        btnCheck = findViewById(R.id.btnCheck);

        productImg = getIntent().getExtras().getInt("productimage");
        productname = getIntent().getExtras().getString("productname");
        productLinkImg = getIntent().getExtras().getString("productlinkimg");
        productPrice = getIntent().getExtras().getDouble("productprice");

        Picasso.get().load(productImg).fit().error(productImg).into(imgProduct);
        txtSaleProductName.setText(productname);
        txtSaleProductPrice.setText("Price:   S/.  " + productPrice);

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SaleActivity.this, FinalActivity.class);
                startActivity(i);
            }
        });

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
