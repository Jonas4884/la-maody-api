package com.hei.la_Maody.repository;

import com.hei.la_Maody.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface ManagerRepository extends JpaRepository<Manager,Long> {
}
