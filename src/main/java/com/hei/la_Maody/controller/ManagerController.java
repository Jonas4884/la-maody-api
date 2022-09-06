package com.hei.la_Maody.controller;


import com.hei.la_Maody.model.Customer;
import com.hei.la_Maody.model.article;
import com.hei.la_Maody.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ManagerController {

    @Autowired
    private ManagerService mService;

    @GetMapping("/customer")
    public List<Customer> getAllCustomer(){
        return mService.getAllCustomer();
    }
    @GetMapping("/product")
    public List<article> getAllArticle(){
        return mService.GetAllArticle();
    }

    @GetMapping("/customer/{id}")
    public List<article> getCustomerById(@PathVariable(name = "id") Long id){
        return mService.getAllCustomer().get(Math.toIntExact(id)).getBags_item();
    }

    @PutMapping("/customer/{id}")
    public article getCustomerById(@PathVariable(name = "id") Long id, @RequestBody article article){
        mService.getAllCustomer().get(Math.toIntExact(id)).getBags_item().add(article);
        return article;
    }

}
