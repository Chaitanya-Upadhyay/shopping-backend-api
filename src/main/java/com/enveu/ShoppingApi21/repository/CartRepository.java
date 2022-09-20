package com.enveu.ShoppingApi21.repository;

import com.enveu.ShoppingApi21.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {
}
