package com.hei.la_Maody.repository;

import com.hei.la_Maody.model.Paying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface payingRepository extends JpaRepository<Paying,Long> {
}
