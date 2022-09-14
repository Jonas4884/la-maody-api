package com.hei.la_Maody.repository;

import com.hei.la_Maody.model.Article;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface articleRepository extends JpaRepository<Article,Long> {
    List<Article> findByNameContainingIgnoreCaseOrderByPriceAsc(String name, Pageable pageable);

    List<Article> findArticleByCategoryLabelContains(String name,Pageable pageable);

    void deleteById(Long id);
}
