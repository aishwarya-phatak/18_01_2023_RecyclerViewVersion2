package com.example.a18_01_2023_recyclerviewversion2;

public class Product {
    int id;
    int imageId;
    int price;
    String title;

    public Product(int id, int imageId, int price, String title){
        this.id = id;
        this.imageId = imageId;
        this.title = title;
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public int getImageId() {
        return imageId;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
