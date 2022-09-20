package com.enveu.ShoppingApi21.repository;

import com.enveu.ShoppingApi21.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,String> {
//    Role findByRollame(String name);
}
