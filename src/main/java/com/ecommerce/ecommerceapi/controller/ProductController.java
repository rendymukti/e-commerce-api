package com.ecommerce.ecommerceapi.controller;

import com.ecommerce.ecommerceapi.entity.Product;
import com.ecommerce.ecommerceapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {


    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public List<Product> findAll() {
        return productService.findAll();
    }

    @PostMapping("/product")
    public Product createNewProduct(@RequestBody Product product) {
        return productService.createNewProduct(product);
    }

    @GetMapping("/product/{id}")
    public Product findProductById(@PathVariable("id") Long productId) {
        return productService.findProductById(productId);
    }

    @PutMapping("/product")
    public Product editProductById(@RequestBody Product product) {
        return productService.editProductById(product);
    }

    @DeleteMapping("/product/{id}")
    public void deleteProductById(@PathVariable("id") Long productId) {
        productService.deleteProductById(productId);
    }

}
