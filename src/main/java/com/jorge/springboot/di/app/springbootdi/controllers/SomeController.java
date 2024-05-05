package com.jorge.springboot.di.app.springbootdi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jorge.springboot.di.app.springbootdi.services.ProductServiceImpl;

@RestController
@RequestMapping("/api")
public class SomeController {

  private ProductServiceImpl service = new ProductServiceImpl();

  @GetMapping
  public List<Product> findAll() {
    return service.findAll();
  }

  @GetMapping("/{id}")
  public Product show(@PathVariable Long id) {
    return service.findById(id);
  }
}
