package com.example.a18_01_2023_recyclerviewversion2;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductViewHolder> {

    Product product;
    TextView txtTitle, txtPrice;
    ImageView productImageView;
    ArrayList<Product> products;

    public ProductsAdapter(ArrayList<Product> products){
        this.products = products;
    }

    class ProductViewHolder extends RecyclerView.ViewHolder{
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            productImageView = itemView.findViewById(R.id.productImageView);
           /* productImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(),ProductDetailsActivity.class);
                    intent.putExtra("id",product.id);
                    intent.putExtra("title",product.title);
                    intent.putExtra("price",product.price);
                    intent.putExtra("imageId",product.imageId);
                    v.getContext().startActivity(intent);
                }
            });*/
        }
    }


    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View productView = layoutInflater.inflate(R.layout.product_view,null);
        productImageView = productView.findViewById(R.id.productImageView);

        productImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Image Clicked"+"--"+""+product.imageId, Toast.LENGTH_LONG).show();
            }
        });
        return new ProductViewHolder(productView);
    }


    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = products.get(position);
            /*holder.itemView.findViewById(R.id.productImageView).setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(v.getContext(), "ImageClicked"+"---"+product.imageId, Toast.LENGTH_SHORT).show();
                        }
                    }
            );*/
        productImageView = holder.itemView.findViewById(R.id.productImageView);
        productImageView.setImageResource(product.imageId);



    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
