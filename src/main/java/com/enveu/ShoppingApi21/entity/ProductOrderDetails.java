//package com.enveu.ShoppingApi21.entity;
//
//import javax.persistence.*;
//
//@Entity
//@Table
//public class ProductOrderDetails {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//    @OneToOne
//    @JoinColumn(name = "product_fk")
//    private Product product;
//    private Long productQty;
////    private Long totalAmount;
////    private String payableAmount;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Product getProduct() {
//        return product;
//    }
//
//    public void setProduct(Product product) {
//        this.product = product;
//    }
//
//    public Long getProductQty() {
//        return productQty;
//    }
//
//    public void setProductQty(Long productQty) {
//        this.productQty = productQty;
//    }
//}
