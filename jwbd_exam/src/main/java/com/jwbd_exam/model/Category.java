package com.jwbd_exam.model;

public class Category {

    protected int category_id;
    protected String category_name;

    public Category() {
    }

    public Category(int id) {
        this.category_id = id;
    }

    public Category(int id, String category_name) {
        this.category_id = id;
        this.category_name = category_name;
    }

    public int getCategoryId() {
        return category_id;
    }

    public void setCategoryId(int id) {
        this.category_id = id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
}
