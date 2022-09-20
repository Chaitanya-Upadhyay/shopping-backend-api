//import com.enveu.ShoppingApi21.entity.Customer;
//import com.enveu.ShoppingApi21.entity.OrderItem;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//import javax.persistence.*;
//import java.util.Date;
//import java.util.List;
//
//package com.enveu.ShoppingApi21.entity;
//
//@Entity
//public class OrderDelete {
////    @Id
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
////    private Long id;
////
////    @OneToMany
////    @JoinColumn(name = "product_order_details_fk")
////    private List<ProductOrderDetails> orderDetailsList;
////
////    private Long totalAmount;
////
////    public Long getId() {
////        return id;
////    }
////
////    public void setId(Long id) {
////        this.id = id;
////    }
////
////    public List<ProductOrderDetails> getOrderDetailsList() {
////        return orderDetailsList;
////    }
////
////    public void setOrderDetailsList(List<ProductOrderDetails> orderDetailsList) {
////        this.orderDetailsList = orderDetailsList;
////    }
////
////    public Long getTotalAmount() {
////        return totalAmount;
////    }
////
////    public void setTotalAmount(Long totalAmount) {
////        this.totalAmount = totalAmount;
////    }
////}
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//
//
//    @Column(name = "created_date")
//    private Date createdDate;
//
//    @Column(name = "total_price")
//    private Double totalPrice;
//
//
//    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
//    private List<OrderItem> orderItems;
//
//    @ManyToOne()
//    @JsonIgnore
//    @JoinColumn(name = "Customer_id", referencedColumnName = "id")
//    private Customer customer;
//}