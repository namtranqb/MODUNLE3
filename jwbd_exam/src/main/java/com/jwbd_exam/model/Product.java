package com.jwbd_exam.model;

public class Product{

    private int id;
    private String product_name;
    private Double price;
    private int quantity;
    private String color;
    private String description;
    private int category_id;


    public Product(int id, String productName, Double price, int quantity, String color, String categoryName) {
    }

    public Product(int id, String product_name, Double price, int quantity, String color, String description, int category_id) {

        this.id = id;
        this.product_name = product_name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.description = description;
        this.category_id = category_id;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

}
