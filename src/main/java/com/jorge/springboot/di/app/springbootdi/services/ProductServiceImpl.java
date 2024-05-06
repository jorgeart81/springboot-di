package com.jorge.springboot.di.app.springbootdi.services;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import com.jorge.springboot.di.app.springbootdi.AddConfig;
import com.jorge.springboot.di.app.springbootdi.controllers.Product;
import com.jorge.springboot.di.app.springbootdi.repositories.ProductRepository;

@Service
@RequestScope
public class ProductServiceImpl implements ProductService {

  private Environment environment;
  private ProductRepository repository;

  // @Value("${config.price.tax}")
  // private Double tax;

  public ProductServiceImpl(ProductRepository repository, Environment environment) {
    this.environment = environment;
    this.repository = repository;
  }

  @Override
  public List<Product> findAll() {
    Double tax = environment.getProperty("config.price.tax", Double.class);

    return repository.findAll().stream().map(p -> {
      Double priceTax = p.getPrice() * tax;
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
