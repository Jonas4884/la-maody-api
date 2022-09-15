package com.hei.la_Maody.service;

import com.hei.la_Maody.controller.mapper.createArticleMapper;
import com.hei.la_Maody.controller.mapper.model.createRestArticle;
import com.hei.la_Maody.controller.mapper.model.restArticle;
import com.hei.la_Maody.model.Category;
import com.hei.la_Maody.model.Customer;
import com.hei.la_Maody.model.Article;
import com.hei.la_Maody.repository.CustomerRepository;
import com.hei.la_Maody.repository.ManagerRepository;
import com.hei.la_Maody.repository.articleRepository;
import com.hei.la_Maody.repository.categoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ManagerService {

   private final CustomerRepository customerRepository;

    private ManagerRepository managerRepository;
    private articleRepository articleRepository;
    private final Integer defaultPage = 1;
    private final Integer defaultPageSize = 8;

    private final createArticleMapper createRestMapper;


    private final com.hei.la_Maody.repository.categoryRepository categoryRepository;


    public Page<Article> GetAllArticle(Integer page, Integer pageSize){
        if(page != null && pageSize != null){
            return articleRepository.findAll(
                    PageRequest.of(page - 1, pageSize, Sort.by(Sort.Direction.DESC, "price"))
            );
        }
        page = defaultPage;
        pageSize = defaultPageSize;

        return articleRepository.findAll(
                PageRequest.of(page - 1, pageSize, Sort.by(Sort.Direction.DESC, "price"))
        );
    }

    public Article getArticleById(Long id){
        return articleRepository.findById(id).get();
    }

    public List<Article> findArticleByContainingName(String name) {
//        Pageable pageable = PageRequest.of(page,pageSize);
        return articleRepository.findByNameContainingIgnoreCaseOrderByPriceAsc(name);
    }

    public List<Article> findArticleByCategory(String name) {
//        Pageable pageable = PageRequest.of(page,pageSize);
        return articleRepository.getArticleByCategory_Label(name);
    }

    public Article createArticle(createRestArticle restArticle1){
       Article article =  createRestMapper.toRestArticle(restArticle1);
         return  articleRepository.save(article);
    }

    @Transactional
    public Article updateArticle(Article article, Long id){
        return articleRepository.findById(id)
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
        return customerRepository.findAll();
    }

    public Customer getCustomerByName(String name){
        return customerRepository.findByFirstName(name);
    }


    public void removeArticle(Long id){
           articleRepository.delete(articleRepository.getById(id));
    }
};

