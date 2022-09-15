package com.hei.la_Maody.controller.mapper;

import com.hei.la_Maody.controller.mapper.model.createRestArticle;
import com.hei.la_Maody.controller.mapper.model.restArticle;
import com.hei.la_Maody.model.Article;
import com.hei.la_Maody.model.Category;
import com.hei.la_Maody.repository.categoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class createArticleMapper {
    @Autowired
    private categoryRepository categoryRepository;
    public Article toRestArticle(createRestArticle article){
        Category category = categoryRepository.getById(article.getId());
        return  Article.builder()
                .id(article.getId())
                .name(article.getName())
                .price(article.getPrice())
                .category(category)
                .build();
    }
}

