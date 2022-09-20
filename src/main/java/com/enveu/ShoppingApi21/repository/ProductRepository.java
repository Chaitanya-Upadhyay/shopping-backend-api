package com.enveu.ShoppingApi21.repository;

import com.enveu.ShoppingApi21.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    Product findByCategoryId(Long categoryId);
}
