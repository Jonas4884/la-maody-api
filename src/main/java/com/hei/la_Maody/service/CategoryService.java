package com.hei.la_Maody.service;

import com.hei.la_Maody.model.Category;
import com.hei.la_Maody.repository.categoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryService {
    public categoryRepository categoryRepository;

    public List<Category> GetCategories(){
        return categoryRepository.findAll();
    }
    public Optional<Category> getCategoryById(Long id){
        return categoryRepository.findById(id);
    }
    public Category createCategory(Category category){
        return categoryRepository.save(category);
    }
}
