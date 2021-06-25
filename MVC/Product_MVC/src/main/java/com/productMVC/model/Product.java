package com.productMVC.model;

public class Product {
    private int number;
    private int id;
    private String productName;
    private String origin;
    private String productType;
    private double price;

    public Product() {
    }

    public Product(int id,String productName, String origin, String productType, double price) {
        this.id = id;
        this.productName = productName;
        this.origin = origin;
        this.productType = productType;
        this.price = price;
    }

    public Product(String productName, String origin, String productType, double price) {
        this.id = ++number;
        this.productName = productName;
        this.origin = origin;
        this.productType = productType;
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
