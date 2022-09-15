package com.hei.la_Maody.controller;

import com.hei.la_Maody.model.Category;
import com.hei.la_Maody.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class categoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category")
    public List<Category> getAllCategory(){
        return categoryService.GetCategories();
    }

    @GetMapping("/category/{id}")
    public Optional<Category> getCategoryById(@PathVariable (name = "id") Long id){
        return categoryService.getCategoryById(id);
    }

    @PutMapping("/category")
    public Category createCategory(@RequestBody Category category){
        return categoryService.createCategory(category);
    }
}
