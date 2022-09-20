package com.enveu.ShoppingApi21.service;

import com.enveu.ShoppingApi21.entity.Cart;
import com.enveu.ShoppingApi21.repository.CartRepository;
import com.enveu.ShoppingApi21.repository.CustomerRepository;
import com.enveu.ShoppingApi21.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductRepository productRepository;

    public Cart addCart(Cart cart) {
//        employee.setCommunityList(communityRepo.saveAll(employee.getCommunityList()));
//        customer.setRole(roleRepository.save(customer.getRole()));
//        cart.setProduct(productRepository.save(cart.getProduct()));

        return cartRepository.save(cart);
    }

    public String remove(Long id) {
        if (cartRepository.existsById(id)) {
            cartRepository.deleteById(id);
        }
        return "Cart removed successfully";
    }

}
