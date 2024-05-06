package com.jorge.springboot.di.app.springbootdi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.jorge.springboot.di.app.springbootdi.repositories.ProductRepository;
import com.jorge.springboot.di.app.springbootdi.repositories.ProductRepositoryJson;

@Configuration
@PropertySource("classpath:config.properties")
public class AddConfig {

  @Bean
  ProductRepository productRepositoryJson() {
    return new ProductRepositoryJson();
  }
}
