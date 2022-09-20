//package com.enveu.ShoppingApi21.service;
//
//import com.enveu.ShoppingApi21.entity.Order;
//import com.enveu.ShoppingApi21.entity.ProductOrderDetails;
//import com.enveu.ShoppingApi21.entity.Product;
//import com.enveu.ShoppingApi21.repository.OrderRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.concurrent.atomic.AtomicLong;
//
//@Service
//public class OrderCal {
//
//    @Autowired
//    private OrderRepository orderRepository;
//
//    public Order saveOrder(Order order)
//    {
//        AtomicLong total =new AtomicLong(0);
//        order.getOrderDetailsList().forEach(productOrderDetails -> {
//            total.set(total.get() + (productOrderDetails.getProductQty() * productOrderDetails.getProduct().getPrice())); //long price
//        });
//        order.setTotalAmount(total.get());
//        return orderRepository.save(order);
//    }
//}
