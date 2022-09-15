package com.hei.la_Maody.repository;

import com.hei.la_Maody.model.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface articleRepository extends JpaRepository<Article,Long> {
    List<Article> findByNameContainingIgnoreCaseOrderByPriceAsc(String name);

    List<Article> getArticleByCategory_Label(String label);

    void deleteById(Long id);
}
