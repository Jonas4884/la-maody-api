package com.hei.la_Maody.service;

import com.hei.la_Maody.model.Customer;
import com.hei.la_Maody.model.article;
import com.hei.la_Maody.repository.CustomerRepository;
import com.hei.la_Maody.repository.articleRepository;
import com.hei.la_Maody.service.Exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private com.hei.la_Maody.repository.articleRepository articleRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public List<article> getALlBagsArticle(Long id){

        Customer customer =  customerRepository.getById(id);

        return customer.getBags_item();
    }

    public article getItemById(Long id,Long id_customer){
        Customer customer = customerRepository.findById(id_customer).orElseThrow();
       return customer.getBags_item().get(Math.toIntExact(id));
    }

    public ResponseEntity<Void> removeItemsFromBags(Long id,Long id_customer){
        Customer customer = customerRepository.findById(id_customer).orElseThrow();

        article article = customer.getBags_item().get(Math.toIntExact(id));
        try{
            customer.getBags_item().remove(article);
        }catch (RuntimeException e){
            e.getCause();
        }
        return  ResponseEntity.ok().build();
    }

    public void AddNewArticleInBags(Long id_customer,article article){
        Customer customer = customerRepository.findById(id_customer).orElseThrow();

        //article article1 = customer.setBags_item((List<com.example.springsecuritydemo.model.article>) customer.getBags_item().set(Math.toIntExact(article.getId()),article));
        customer.getBags_item().add(article);
        System.out.println("article modifée");
    }

}
