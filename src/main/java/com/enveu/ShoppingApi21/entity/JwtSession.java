package com.enveu.ShoppingApi21.entity;

import javax.persistence.*;

@Entity
public class JwtSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    @Column(length = 500)
    private String token;

    public JwtSession() {
    }

    public JwtSession(int id, String email, String token) {
        this.id = id;
        this.email = email;
        this.token = token;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


}
