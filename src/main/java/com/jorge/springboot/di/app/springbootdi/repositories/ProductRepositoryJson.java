package com.jorge.springboot.di.app.springbootdi.repositories;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jorge.springboot.di.app.springbootdi.controllers.Product;

public class ProductRepositoryJson implements ProductRepository {
  private List<Product> list;

  public ProductRepositoryJson() {
    Resource resource = new ClassPathResource("json/product.json");
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      list = Arrays.asList(objectMapper.readValue(resource.getFile(), Product[].class));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public List<Product> findAll() {
    return list;
  }

  @Override
  public Product findById(Long id) {
    return list.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow();
  }

}
