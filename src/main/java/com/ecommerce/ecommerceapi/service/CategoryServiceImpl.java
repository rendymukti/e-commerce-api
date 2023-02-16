package com.ecommerce.ecommerceapi.service;

import com.ecommerce.ecommerceapi.entity.Category;
import com.ecommerce.ecommerceapi.exception.ResourceNotFoundException;
import com.ecommerce.ecommerceapi.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category createNewCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category findCategoryById(Long categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category not available"));
    }



    @Override
    public void deleteById(Long categoryId) {

        categoryRepository.deleteById(categoryId);

    }

    @Override
    public Category editCategory(Long categoryId, Category category) {
        Category currCategory = categoryRepository.findById(categoryId).get();
        if (Objects.nonNull(currCategory.getCategoryName())
                && !"".equalsIgnoreCase(category.getCategoryName() ))
        {
            currCategory.setCategoryName(category.getCategoryName());
        }

        return categoryRepository.save(currCategory);


    }


}
