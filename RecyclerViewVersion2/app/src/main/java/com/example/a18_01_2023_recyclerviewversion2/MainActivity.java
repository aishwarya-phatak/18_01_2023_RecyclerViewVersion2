package com.example.a18_01_2023_recyclerviewversion2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.ViewGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView productsRecyclerView;
    ArrayList<Product> products;
    ProductsAdapter productsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initProducts();
        initViews();
    }
    private void initViews(){
        productsRecyclerView = findViewById(R.id.productsRecyclerView);
        productsRecyclerView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL,
                false
        ));
        productsAdapter = new ProductsAdapter(products);
        productsRecyclerView.setAdapter(productsAdapter);
    }

    private void initProducts(){
        products = new ArrayList<Product>();
        for(int i = 0; i<10;i++) {
            products.add(
                    new Product(
                            i,
                            R.drawable.ic_launcher_background,
                            i *500 + 103,
                            "Product" + i
                    )
            );
        }
    }
}