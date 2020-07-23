package com.example.myapplication.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Adapters.MyAdapter;
import com.example.myapplication.Models.Product;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Product> products;
    private List<Product> allProducts;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private MyAdapter mAdapter;

    private int counter = 0;

    private static final String SHARED_PREFS = "sharedPrefs";
    private static final String TOTAL = "total";
    private static final String ISFIRST = "isFirst";
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);

        if(sharedPreferences.getString(ISFIRST, "").equals(""))
            cleanSP();

        isNotFirstTime();
        products = getAllProducts();

        mRecyclerView = findViewById(R.id.rvProducts);
        mLayoutManager = new LinearLayoutManager(this);

        mAdapter = new MyAdapter(products, R.layout.recycler_view_item, new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Product product, int position) {
                Intent i = new Intent(MainActivity.this, SaleActivity.class);
                i.putExtra("productname", product.getName());
                i.putExtra("productprice", product.getPrice());
                i.putExtra("productimage", product.getImg());
                i.putExtra("productlinkimg", product.getLinkImg());
                startActivity(i);
            }
        });

        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(mLayoutManager);
    }

    //Menú para barra de búsqueda
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mAdapter.getFilter().filter(newText);
                return false;
            }

        });
        return super.onCreateOptionsMenu(menu);
    }

    private List<Product> getAllProducts() {
        //int p = R.drawable.pan;
        products = new ArrayList<Product>();
        products.add(new Product("Pan", 1.75, R.mipmap.pan_icon, "https://harinas.monisa.com/wp-content/uploads/2018/07/Pan-casero-600x400.jpeg"));
        products.add(new Product("Leche", 2.50, R.mipmap.leche_icon, "https://harinas.monisa.com/wp-content/uploads/2018/07/Pan-casero-600x400.jpeg"));
        products.add(new Product("Chifon", 4.50, R.mipmap.chifon_icon, "https://harinas.monisa.com/wp-content/uploads/2018/07/Pan-casero-600x400.jpeg"));
        return products;
    }

    private void cleanSP(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(TOTAL, "");
        editor.apply();
    }

    private void isNotFirstTime() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(ISFIRST, "1");
        editor.apply();
    }
}