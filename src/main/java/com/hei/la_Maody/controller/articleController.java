package com.hei.la_Maody.controller;


import com.hei.la_Maody.controller.mapper.articleMapper;
import com.hei.la_Maody.controller.mapper.model.restArticle;
import com.hei.la_Maody.model.article;
import com.hei.la_Maody.repository.articleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class articleController {

    @Autowired
    private articleRepository articleRepository;

    @GetMapping("/item")
    public List<article> getAllArticle(){
        return articleRepository.findAll();
    }

    @GetMapping("/item/{id}")
    public restArticle getAllArticle(@PathVariable(name = "id") Long id){
        return articleMapper.toRest(articleRepository.getById(id));
    }

    @PutMapping("/article")
    public article createArticle(@RequestBody article article){
        return articleRepository.save(article);
    }
}
