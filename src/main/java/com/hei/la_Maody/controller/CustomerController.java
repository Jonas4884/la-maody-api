package com.hei.la_Maody.controller;

import com.hei.la_Maody.model.Article;
import com.hei.la_Maody.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CustomerController {

    @Autowired
    public CustomerService customerService;


    @GetMapping("/item/{id_customer}")
    public List<Article> getItemById(@PathVariable Long id_customer){
        return customerService.getALlBagsArticle(id_customer);
    }

    @GetMapping("/item/{id_customer}/{id}")
    public Article getItemById(@PathVariable Long id_customer,
                               @PathVariable Long id
    ){
        return customerService.getItemById(id,id_customer);
    }

    @PutMapping("/item/{id_customer}")
    public void createOrUpdateArticle(
            @PathVariable int id_customer,
            @RequestBody Article article){
        customerService.AddNewArticleInBags((long) id_customer, article);
    }
}
