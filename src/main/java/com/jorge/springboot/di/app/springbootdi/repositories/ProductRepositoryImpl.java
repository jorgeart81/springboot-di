package com.jorge.springboot.di.app.springbootdi.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.jorge.springboot.di.app.springbootdi.controllers.Product;

@Primary
@Repository
public class ProductRepositoryImpl implements ProductRepository {
  private List<Product> data;

  public ProductRepositoryImpl() {
    this.data = Arrays.asList(
        new Product(1L, "Memoria corsair 32", 300L),
        new Product(2L, "Intel core i9", 860L),
        new Product(3L, "Teclado Razer Mini 60&", 180L),
        new Product(4L, "Motherboard Gigabyte", 480L));
  }

  @Override
  public List<Product> findAll() {
    return data;
  }

  @Override
  public Product findById(Long id) {
    return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow();
  }
}
