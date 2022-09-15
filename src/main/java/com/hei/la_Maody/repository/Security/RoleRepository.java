package com.hei.la_Maody.repository.Security;

import com.hei.la_Maody.model.User.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}