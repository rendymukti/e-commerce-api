package com.ecommerce.ecommerceapi.service;

import com.ecommerce.ecommerceapi.entity.Category;

import java.util.List;

public interface CategoryService {

    public List<Category> findAllCategory();

    Category findCategoryById(Long categoryId);

    Category createNewCategory(Category category);

    void deleteById(Long categoryId);

    Category editCategory(Long categoryId,Category category);
}
