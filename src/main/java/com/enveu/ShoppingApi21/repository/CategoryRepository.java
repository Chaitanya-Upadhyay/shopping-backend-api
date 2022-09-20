package com.enveu.ShoppingApi21.repository;

import com.enveu.ShoppingApi21.entity.Category;
import com.enveu.ShoppingApi21.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    Long findById(Optional<Product> byId);
}
