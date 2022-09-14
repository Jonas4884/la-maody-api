package com.hei.la_Maody.repository;

import com.hei.la_Maody.model.category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface categoryRepository extends JpaRepository<category,Long> {
    Optional<category> findById(Long id);
}
