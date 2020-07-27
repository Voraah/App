package com.example.myapplication.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.myapplication.Adapters.MyAdapter;
import com.example.myapplication.Adapters.tAdapter;
import com.example.myapplication.Models.Product;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class TicketActivity extends AppCompatActivity {

    private List<Product> ticketList = new ArrayList<Product>();
    private RecyclerView tRecyclerView;
    private RecyclerView.LayoutManager tLayoutManager;
    private tAdapter tAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);

        ticketList = getAllProducts();

        tRecyclerView = findViewById(R.id.rvTicketList);
        tLayoutManager = new LinearLayoutManager(this);

        tAdapter = new tAdapter(ticketList, R.layout.recycler_view_ticket, new tAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Product product, int position) {
                Toast.makeText(TicketActivity.this, "PRUEBA COMPLETA", Toast.LENGTH_SHORT).show();
            }
        });

        tRecyclerView.setAdapter(tAdapter);
        tRecyclerView.setLayoutManager(tLayoutManager);
    }

    private List<Product> getAllProducts() {
        //int p = R.drawable.pan;
        ticketList = new ArrayList<Product>();
        ticketList.add(new Product("Pan", 2, 1.75));
        ticketList.add(new Product("Leche", 4,2.50));
        ticketList.add(new Product("Chifon", 1, 4.5));
        return ticketList;
    }
}