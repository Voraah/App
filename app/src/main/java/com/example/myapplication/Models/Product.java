package com.example.myapplication.Models;

public class Product {

    public String name;
    public double price;
    public int img;
    private String linkImg;

    public Product(String name, double price, int img, String linkImg) {
        this.name = name;
        this.price = price;
        this.img = img;
        this.linkImg = linkImg;
    }

    public String getName() {
        return name;
    }

    public String getLinkImg() {
        return linkImg;
    }

    public void setLinkImg(String linkImg) {
        this.linkImg = linkImg;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
