package com.hei.la_Maody.service;

import com.hei.la_Maody.model.Customer;
import com.hei.la_Maody.model.article;
import com.hei.la_Maody.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerService {

    @Autowired
   private CustomerRepository customerRepository;
    @Autowired
    private com.hei.la_Maody.repository.articleRepository articleRepository;

    public List<article> GetAllArticle(){
        return articleRepository.findAll();
    }

    public Optional<article> getArticleById(Long id){
        return articleRepository.findById(id);
    }
    public void createArticle(article article){
        try {
            articleRepository.save(article);
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
            System.out.println("Une erreur s'est produite lors de l'initialisation de requete");
        }
    }

    public article updateArticle(article article,Long id){
        return this.articleRepository.findById(id)
                .map( article1 -> {
                        article1.setName(article.getName());
                        article1.setPrice(article.getPrice());
                        article1.setCategory(article.getCategory());
                        return  articleRepository.save(article1);
                }
                ).orElseGet(()->{
                    article.setId(id);
                   return articleRepository.save(article);
        });
    }

    public List<Customer> getAllCustomer(){
        return this.customerRepository.findAll();
    }

    public void removeArticle(Long id){
       Optional<article> article = articleRepository.findById(id);

       if(article.isPresent()){
           articleRepository.delete(article.orElseThrow());
       }
    }
};

