package com.ecommerce.ecommerceapi.controller;
import com.ecommerce.ecommerceapi.entity.Category;
import com.ecommerce.ecommerceapi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category")
    public List<Category> findAll() {

        return categoryService.findAllCategory();
    }


    @GetMapping("/category/{id}")
    public Category findCategoryById(@PathVariable("id") Long categoryId) {
        return categoryService.findCategoryById(categoryId);
    }

    @PostMapping("/category")
    public Category createNewCategory(@RequestBody Category category) {
        return categoryService.createNewCategory(category);
    }
//
    @PutMapping("/category/{id}")
    public Category editCategory(@PathVariable("id") Long categoryId, @RequestBody Category category) {
        return categoryService.editCategory(categoryId, category);
    }

    @DeleteMapping("/category/{id}")
    public void deleteCategoryById(@PathVariable("id") Long categoryId) {
        categoryService.deleteById(categoryId);
    }





}
