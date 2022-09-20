package com.enveu.ShoppingApi21.entity;

import javax.persistence.*;

@Entity
@Table(name = "Product_Descrption")
public class ProductDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ProductKey;
    private String ProductValue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductKey() {
        return ProductKey;
    }

    public void setProductKey(String productKey) {
        ProductKey = productKey;
    }

    public String getProductValue() {
        return ProductValue;
    }

    public void setProductValue(String productValue) {
        ProductValue = productValue;
    }
}
