package com.hei.la_Maody.controller;


import com.hei.la_Maody.controller.mapper.articleMapper;
import com.hei.la_Maody.controller.mapper.model.restArticle;
import com.hei.la_Maody.model.Article;
import com.hei.la_Maody.repository.articleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class articleController {

    @Autowired
    private articleRepository articleRepository;

    @GetMapping("/articles")
    public List<restArticle> getAllArticle(){
        return articleRepository.findAll().stream().map(articleMapper::toRest).toList();
    }
    @GetMapping("/topitem")
    public List<restArticle> gettopArticle(){
        return articleRepository.findAll().stream().map(articleMapper::toRest).toList().subList(0,5);
    }

    @GetMapping("/article/{id}")
    public restArticle getArticleById(@PathVariable(name = "id") Long id){
        return articleMapper.toRest(articleRepository.getById(id));
    }

    @PutMapping("/article")
    public Article createOrUpdateArticle(@RequestBody Article article){
        return articleRepository.save(article);
    }

    /*
    * If only,the items to delete is not rattached with a bags item
    *
    */
    @DeleteMapping("/article/{id}")
    public void DeleteArticle(@PathVariable Long id){
        articleRepository.deleteById(id);
    }

}
