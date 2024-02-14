package com.example.backend_android.service;

import com.example.backend_android.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Product createProduct(Product product);

    List<Product> getAllProducts();

    Optional<Product> getProductById(Integer id);
}
