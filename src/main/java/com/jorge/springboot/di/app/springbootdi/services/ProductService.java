package com.jorge.springboot.di.app.springbootdi.services;

import java.util.List;

import com.jorge.springboot.di.app.springbootdi.controllers.Product;

public interface ProductService {
  List<Product> findAll();

  Product findById(Long id);
}
