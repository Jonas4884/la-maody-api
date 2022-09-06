package com.hei.la_Maody.controller;

import com.hei.la_Maody.model.article;
import com.hei.la_Maody.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class CustomerController {

    @Autowired
    public CustomerService customerService;


    @GetMapping("/customer/{id_customer}/item")
    public List<article> getALlArticle(@PathVariable Long id){
        return customerService.getALlBagsArticle(id);
    }

    @GetMapping("/{id_customer}/item/{id}")
    public  article getItemById(@PathVariable Long id_customer,
                                @PathVariable Long id
    ){
        return customerService.getItemById(id,id_customer);
    }

    @PutMapping("/{id_customer}/item")
    public void createOrUpdateArticle(
            @PathVariable(name = "id") Long id,
            @RequestBody article article){
        customerService.AddNewArticleInBags(id, article);
    }
}
