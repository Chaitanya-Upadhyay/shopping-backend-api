package com.enveu.ShoppingApi21.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
@Entity
public class WishList {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//
//    @OneToOne(targetEntity = Customer.class, fetch = FetchType.EAGER)
//    @JoinColumn(nullable = false, name = "user_id")
    private int customerId;

    @Column(name = "created_date")
    LocalDate date = LocalDate.now();
//
//    @ManyToOne()
//    @JoinColumn(name = "product_id")
    private Long productId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
