package com.hei.la_Maody.controller;


import com.hei.la_Maody.controller.mapper.articleMapper;
import com.hei.la_Maody.controller.mapper.model.restArticle;
import com.hei.la_Maody.model.Article;
import com.hei.la_Maody.repository.articleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class articleController {

    @Autowired
    private articleRepository articleRepository;

    @GetMapping("/item")
    public List<restArticle> getAllArticle(){
        return articleRepository.findAll().stream().map(articleMapper::toRest).toList();
    }
    @GetMapping("/topitem")
    public List<restArticle> gettopArticle(){
        return articleRepository.findAll().stream().map(articleMapper::toRest).toList().subList(0,5);
    }

    @GetMapping("/item/{id}")
    public restArticle getAllArticle(@PathVariable(name = "id") Long id){
        return articleMapper.toRest(articleRepository.findById(id).get());
    }

    @PutMapping("/article")
    public Article createArticle(@RequestBody Article article){
        return articleRepository.save(article);
    }
}
