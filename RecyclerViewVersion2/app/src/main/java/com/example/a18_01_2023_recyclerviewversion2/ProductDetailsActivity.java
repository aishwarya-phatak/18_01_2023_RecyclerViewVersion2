package com.example.a18_01_2023_recyclerviewversion2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class ProductDetailsActivity extends Activity {
    TextView txtTitle, txtPrice;
    ImageView productImageView;
    int id, imageId, price;
    String title;
    Product product;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_details_activity);
        initViews();
        extractionOfData();
    }

    private void initViews(){
        productImageView = findViewById(R.id.productImageView);
        txtTitle = findViewById(R.id.txtTitle);
        txtPrice = findViewById(R.id.txtPrice);
    }

    private void extractionOfData(){
        Intent intent = getIntent();
        /*id = intent.getIntExtra("id",0);
        title = intent.getStringExtra("title");
        price = intent.getIntExtra("price",10);
        imageId = intent.getIntExtra("imageId",0);

        productImageView.setImageResource(imageId);
        txtTitle.setText(title);
        txtPrice.setText(price + "");*/

        product = (Product) intent.getSerializableExtra("product");
        productImageView.setImageResource(product.getImageId());
        txtTitle.setText(product.getTitle());
        txtPrice.setText(product.getPrice() + "");
    }
}
