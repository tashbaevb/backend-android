package com.example.backend_android.controller;

import com.example.backend_android.entity.Product;
import com.example.backend_android.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("product")
public class ProductController {

    private final ProductService productService;


    @PostMapping("/create")
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @GetMapping("/getAll")
    public List<Product> getAllProduct() {
        return productService.getAllProducts();
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Product> getByProductId(@PathVariable Integer id) {
        Optional<Product> getById = productService.getProductById(id);

        return getById.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
