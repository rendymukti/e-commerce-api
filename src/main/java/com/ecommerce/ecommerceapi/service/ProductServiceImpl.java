package com.ecommerce.ecommerceapi.service;

import com.ecommerce.ecommerceapi.entity.Product;
import com.ecommerce.ecommerceapi.exception.BadRequestException;
import com.ecommerce.ecommerceapi.exception.ResourceNotFoundException;
import com.ecommerce.ecommerceapi.repository.CategoryRepository;
import com.ecommerce.ecommerceapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product createNewProduct(Product product) {
        if (!StringUtils.hasText(product.getProductName())) {
            throw new BadRequestException("Product name cannot be empty");
        }

        if (product.getCategory() == null) {
            throw new BadRequestException("Category cannot be empty");
        }

        if (Objects.isNull(product.getCategory().getCategoryId())) {
            throw new BadRequestException("Category id cannot be empty");
        }


        categoryRepository.findById(product.getCategory().getCategoryId())
                .orElseThrow(() -> new BadRequestException(
                        "Category ID " + product.getCategory().getCategoryId() + " not available"));


        return productRepository.save(product);
    }

    @Override
    public Product findProductById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not available"));
    }

    @Override
    public Product editProductById(Product product) {
        if (Objects.isNull(product.getProductId())) {
            throw new BadRequestException("Product id cannot be empty");
        }

        if (!StringUtils.hasText(product.getProductName())) {
            throw new BadRequestException("Product Name cannot be empty");
        }

        if (Objects.isNull(product.getCategory())) {
            throw new BadRequestException("Category cannot be empty");
        }

        if (Objects.isNull(product.getCategory().getCategoryId())) {
            throw new BadRequestException("Category ID cannot be empty");
        }

        categoryRepository.findById(product.getCategory().getCategoryId())
                .orElseThrow(() -> new BadRequestException(
                        "Category ID " + product.getCategory().getCategoryId() + " not available"));

        return productRepository.save(product);
    }

    @Override
    public void deleteProductById(Long productId) {
        productRepository.deleteById(productId);

    }
}
