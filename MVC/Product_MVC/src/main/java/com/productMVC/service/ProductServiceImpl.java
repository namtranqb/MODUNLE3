package com.productMVC.service;

import com.productMVC.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    private static Map<Integer,Product> productList;
    static {
        productList = new HashMap<>();
        productList.put(1,new Product(1,"IP5S","China","Phone",1000));
        productList.put(2,new Product(2,"IP6+","VNA","Phone",3000));
        productList.put(3,new Product(3,"IP8","LLA","Phone",7000));
        productList.put(4,new Product(4,"IP-X","VNA","Phone",10000));
        productList.put(5,new Product(5,"MacM1","China","Laptop",30000));
        productList.put(6,new Product(6,"Ideapad","China","Laptop",12000));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productList.values());
    }

    @Override
    public void save(Product product) {
        productList.put(product.getId(),product);
    }

    @Override
    public Product findById(int id) {

        return productList.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productList.put(id,product);
    }

    @Override
    public void remove(int id) {
        productList.remove(id);
    }
}
