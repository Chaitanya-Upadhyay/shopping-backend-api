package com.enveu.ShoppingApi21.repository;

import com.enveu.ShoppingApi21.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
