package com.hei.la_Maody.repository;

import com.hei.la_Maody.model.Customer;
import com.hei.la_Maody.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends JpaRepository<Manager,Long> {


}
