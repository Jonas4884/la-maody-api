package com.hei.la_Maody.controller;

import com.hei.la_Maody.model.category;
import com.hei.la_Maody.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class categoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category")
    public List<category> getAllCategory(){
        return categoryService.GetCategories();
    }

    @GetMapping("/category/{id}")
    public Optional<category> getCategoryById(@PathVariable (name = "id") Long id){
        return categoryService.getCategoryById(id);
    }

    @PutMapping("/category")
    public category createCategory(@RequestBody category category){
        return categoryService.createCategory(category);
    }
}
