package com.hei.la_Maody.service;

import com.hei.la_Maody.model.category;
import com.hei.la_Maody.repository.categoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryService {
    public categoryRepository categoryRepository;

    public List<category> GetCategories(){
        return categoryRepository.findAll();
    }
    public Optional<category> getCategoryById(Long id){
        return categoryRepository.findById(id);
    }
    public category createCategory(category category){
        return categoryRepository.save(category);
    }
}
