package com.codegym.blogApplication.service;

import com.codegym.blogApplication.model.Bloger;

import java.util.List;

public interface BlogerService {
    List<Bloger> findAll();

    Bloger findById(long id);

    void save(Bloger bloger);

    void remove(long id);
}
