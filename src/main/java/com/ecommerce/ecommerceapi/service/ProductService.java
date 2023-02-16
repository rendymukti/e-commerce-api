package com.ecommerce.ecommerceapi.service;

import com.ecommerce.ecommerceapi.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product createNewProduct(Product product);

    Product findProductById(Long productId);

    Product editProductById(Product product);

    void deleteProductById(Long productId);
}
