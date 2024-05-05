package com.jorge.springboot.di.app.springbootdi.repositories;

import java.util.List;

import com.jorge.springboot.di.app.springbootdi.controllers.Product;

public interface ProductRepository {
  List<Product> findAll();

  Product findById(Long id);
}
