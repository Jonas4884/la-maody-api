package com.hei.la_Maody.repository.Security;

import com.hei.la_Maody.model.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}