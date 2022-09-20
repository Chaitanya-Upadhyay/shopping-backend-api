package com.enveu.ShoppingApi21.repository;

import com.enveu.ShoppingApi21.entity.JwtSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessionRepository extends JpaRepository<JwtSession,Integer> {
    JwtSession findByEmail(String email);

    List<JwtSession> findAllByEmail(String email);
}
