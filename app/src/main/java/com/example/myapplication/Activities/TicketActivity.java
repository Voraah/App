package com.example.myapplication.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
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

    private List<Product> ticketList;

    private RecyclerView tRecyclerView;
    // Puede ser declarado como 'RecyclerView.Adapter' o como nuetra clase adaptador 'MyAdapter'
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private int counter = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);

        ticketList = this.getAllProducts();

        tRecyclerView = findViewById(R.id.rvTicketList);
        mLayoutManager = new LinearLayoutManager(this);

        // 1 linea de dif. acabo de build y error en interfaz xk pojo. esto y luego xml con card, textview image

        // Implementamos nuestro OnItemClickListener propio, sobreescribiendo el método que nosotros
        // definimos en el adaptador, y recibiendo los parámetros que necesitamos
        mAdapter = new tAdapter(ticketList, R.layout.recycler_view_ticket, new tAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Product product, int position) {
                Toast.makeText(TicketActivity.this, "PRUEBA COMPLETA", Toast.LENGTH_SHORT).show();
            }
        });

        // Enlazamos el layout manager y adaptor directamente al recycler view
        tRecyclerView.setLayoutManager(mLayoutManager);
        tRecyclerView.setAdapter(mAdapter);
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