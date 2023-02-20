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


    TextView txtTitle, txtPrice;
    ImageView productImageView;
    ArrayList<Product> products;

    public ProductsAdapter(ArrayList<Product> products){
        this.products = products;
    }

    class ProductViewHolder extends RecyclerView.ViewHolder{
        Product product;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            product = products.get(getAdapterPosition());
            productImageView = itemView.findViewById(R.id.productImageView);
            /*productImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(),ProductDetailsActivity.class);
                      *//*  intent.putExtra("id",product.getId());
                        intent.putExtra("title",product.getTitle());
                        intent.putExtra("price",product.getPrice());
                        intent.putExtra("imageId",product.getImageId());*//*
                        intent.putExtra("product",product);
                    v.getContext().startActivity(intent);
                }
            });*/

            itemView.findViewById(R.id.txtTitle).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(),ProductDetailsActivity.class);
                    v.getContext().startActivity(intent);
                }
            });
        }
    }


    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View productView = layoutInflater.inflate(R.layout.product_view,null);
        productImageView = productView.findViewById(R.id.productImageView);
        txtTitle = productView.findViewById(R.id.txtTitle);
        txtPrice = productView.findViewById(R.id.txtPrice);

       /* productImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Image Clicked"+"--", Toast.LENGTH_LONG).show();
            }
        });

        txtTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"Title Clicked",Toast.LENGTH_LONG).show();
            }
        });

        txtPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"Price Clicked",Toast.LENGTH_LONG).show();
            }
        });*/
        return new ProductViewHolder(productView);
    }


    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = products.get(position);
        productImageView = holder.itemView.findViewById(R.id.productImageView);
        txtTitle = holder.itemView.findViewById(R.id.txtTitle);
        txtPrice = holder.itemView.findViewById(R.id.txtPrice);

        productImageView.setImageResource(product.getImageId());
        txtTitle.setText(product.getTitle());
        txtPrice.setText(product.getPrice()+"");

       /* holder.itemView.findViewById(R.id.productImageView).setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(v.getContext(), "ImageClicked"+"---"+product.getImageId(), Toast.LENGTH_SHORT).show();
                        }
                    });

        txtTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"Title Clicked"+"---"+product.getTitle(),Toast.LENGTH_LONG).show();
            }
        });

        txtPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"Price Clicked" + "---"+product.getPrice(),Toast.LENGTH_LONG).show();
            }
        });*/


    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
