package com.jwbd_exam.DAO;

import com.jwbd_exam.model.Product;

import java.util.List;

public interface IProductDAO {

    public List<Product> displayAllProduct();
    public void createProduct(Product product );
}
