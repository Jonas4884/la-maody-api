package com.hei.la_Maody.service;

import com.hei.la_Maody.model.Customer;
import com.hei.la_Maody.model.Article;
import com.hei.la_Maody.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {


    @Autowired
    private CustomerRepository customerRepository;

    public List<Article> getALlBagsArticle(Long id){

        Customer customer =  customerRepository.getById(id);

        return customer.getBags_item();
    }

    public Article getItemById(Long id, Long id_customer){
        Customer customer = customerRepository.getReferenceById(id_customer);
       return customer.getBags_item().get(Math.toIntExact(id));
    }



    public ResponseEntity<Void> removeItemsFromBags(Long id,Long id_customer){
        Customer customer = customerRepository.findById(id_customer).orElseThrow();

        Article article = customer.getBags_item().get(Math.toIntExact(id));
        try{
            customer.getBags_item().remove(article);
        }catch (RuntimeException e){
            e.getCause();
        }
        return  ResponseEntity.ok().build();
    }

    public void AddNewArticleInBags(Long id_customer, Article article){
        Customer customer = customerRepository.findById(id_customer).orElseThrow();

        //article article1 = customer.setBags_item((List<com.example.springsecuritydemo.model.article>) customer.getBags_item().set(Math.toIntExact(article.getId()),article));
        customer.getBags_item().add(article);
        System.out.println("article modifée");
    }

}
