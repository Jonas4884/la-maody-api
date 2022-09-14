package com.hei.la_Maody.repository;

import com.hei.la_Maody.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Customer findByFirstName(String name);
}
