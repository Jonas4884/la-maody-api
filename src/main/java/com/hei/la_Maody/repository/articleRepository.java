package com.hei.la_Maody.repository;

import com.hei.la_Maody.model.article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories
public interface articleRepository extends JpaRepository<article,Long> {
}
