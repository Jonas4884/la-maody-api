package com.hei.la_Maody.controller;


import com.hei.la_Maody.controller.mapper.articleMapper;
import com.hei.la_Maody.controller.mapper.createArticleMapper;
import com.hei.la_Maody.controller.mapper.model.createRestArticle;
import com.hei.la_Maody.controller.mapper.model.restArticle;
import com.hei.la_Maody.model.Customer;
import com.hei.la_Maody.model.Article;
import com.hei.la_Maody.service.ManagerService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@AllArgsConstructor
public class ManagerController {

    private final ManagerService mService;

    @GetMapping("/product")
    public List<restArticle> getAllArticle(
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer pageSize
    )
    {
        return mService.GetAllArticle(page, pageSize).stream().map(articleMapper::toRest).toList();
    }

    @GetMapping("/customer")
    public Page<Customer> getAllCustomer(@RequestParam Integer page,
                                         @RequestParam Integer pageSize){
        return mService.getAllCustomer(page,pageSize);
    }


    @GetMapping("/product/{id}")
    public restArticle getArticleById(@PathVariable Long id){
        return articleMapper.toRest(mService.getArticleById(id));
    }
    @GetMapping("/article")
    public List<restArticle> getAllArticleContainingWord(
            @RequestParam String name
    )
    {

        return mService.findArticleByContainingName(name).stream().map(articleMapper::toRest).toList();
    }
    @GetMapping("/article/category")
    public List<restArticle> getAllArticleWithAnSpecifiedCategory(
            @RequestParam String category
    )
    {
        return mService.findArticleByCategory(category).stream().map(articleMapper::toRest).toList();
    }

    @GetMapping("/customer/{id}")
    public Customer getCustomerById(@PathVariable(name = "id") Long id) {
        return mService.getCustomerByid(id);
    }
    @GetMapping("/customer/{id}/bagsitems")
    public List<restArticle> getCustomerBagsItemById(@PathVariable(name = "id") Long id){
        return mService.getAllBagsCustomer().get(Math.toIntExact(id)).getBags_item().stream().map(articleMapper::toRest).toList();
    }


    @GetMapping("/customer/user")
    public Customer getCustomerByName(@RequestParam String name){
        return  mService.getCustomerByName(name);
    }

    @PutMapping("/createarticle")
    public Article updateCustomerItemById( @RequestBody createRestArticle article){
        return mService.createArticle(article);
    }
    @PutMapping("/customer/{id}")
    public Article UpdateArticle(@PathVariable Long id,@RequestBody Article article){
        return mService.updateArticle(article, id);
    }
    @DeleteMapping("/item/{id}")
    public void removeArticleById(@PathVariable Long id){
         mService.removeArticle(id);
    }


}
