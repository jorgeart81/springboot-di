package com.jorge.springboot.di.app.springbootdi.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jorge.springboot.di.app.springbootdi.controllers.Product;
import com.jorge.springboot.di.app.springbootdi.repositories.ProductRepository;

@Component
public class ProductServiceImpl implements ProductService {

  @Autowired
  private ProductRepository repository;

  @Override
  public List<Product> findAll() {
    return repository.findAll().stream().map(p -> {
      Double priceTax = p.getPrice() * 1.25d;
      // Product newProduct = new Product(p.getId(), p.getName(),
      // priceTax.longValue());
      Product newProduct = (Product) p.clone();
      newProduct.setPrice(priceTax.longValue());
      return newProduct;
    }).collect(Collectors.toList());
  }

  @Override
  public Product findById(Long id) {
    return repository.findById(id);
  }
}
