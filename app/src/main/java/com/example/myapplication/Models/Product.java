package com.example.myapplication.Models;

public class Product {

    public String name;
    public double price, cost;
    public int img, quantity;
    private String linkImg;

    public Product(String name, double price, int img, String linkImg) {
        this.name = name;
        this.price = price;
        this.img = img;
        this.linkImg = linkImg;
    }
    // Constructor para el listado de ticket
    // Recibe la cantidad y el precio del producto para calcular el costo
    public Product(String name, int quantity, double price) {
        double cost = price*quantity;
        this.name = name;
        this.quantity = quantity;
        this.cost = cost;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
