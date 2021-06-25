package com.productMVC.service;

import com.productMVC.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    void save(Product product);
    Product findById(int Id);
    void update(int id,Product product);
    void remove(int id);
}
