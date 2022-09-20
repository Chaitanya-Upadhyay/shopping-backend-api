package com.enveu.ShoppingApi21.entity;

import javax.persistence.*;

@Entity
@Table(name = "Product_Inventory")
public class ProductInventory {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long availableQuantity;
    private Long totalQuantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(Long availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public Long getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(Long totalQuantity) {
        this.totalQuantity = totalQuantity;
    }
}
