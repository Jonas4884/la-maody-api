package com.hei.la_Maody.service;

import com.hei.la_Maody.model.Customer;
import com.hei.la_Maody.model.Article;
import com.hei.la_Maody.repository.CustomerRepository;
import com.hei.la_Maody.repository.ManagerRepository;
import com.hei.la_Maody.repository.articleRepository;
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

    public List<Article> findArticleByContainingName(String name,Integer page,Integer pageSize) {
        Pageable pageable = PageRequest.of(page,pageSize);
        return articleRepository.findByNameContainingIgnoreCaseOrderByPriceAsc(name,pageable);
    }

    public List<Article> findArticleByCategory(String name,Integer page,Integer pageSize) {
        Pageable pageable = PageRequest.of(page,pageSize);
        return articleRepository.findArticleByCategoryLabelContains(name,pageable);
    }

    public Article createArticle(Article article){
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

//    public List<Customer> getMoreCustomer(){
//
//        List<Customer> Allcustomer =  customerRepository.findAll();
//        return Allcustomer.stream().map(customer -> customer.getBags_item().stream().map(articleMapper::toRest)).toList();
//
//
//    }

    public void removeArticle(Long id){
           articleRepository.delete(articleRepository.getById(id));
    }
};

