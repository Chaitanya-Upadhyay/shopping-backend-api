package com.enveu.ShoppingApi21.service;

import com.enveu.ShoppingApi21.entity.Product;
import com.enveu.ShoppingApi21.entity.WishList;
import com.enveu.ShoppingApi21.repository.CustomerRepository;
import com.enveu.ShoppingApi21.repository.ProductRepository;
import com.enveu.ShoppingApi21.repository.WishListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WishListService {

    @Autowired
    private WishListRepository wishListRepository;
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public Object addWishList(WishList wishList) {
        int customerId = wishList.getCustomerId();
        Product product = productRepository.findById(wishList.getProductId()).get();
        if (customerRepository.existsById(customerId)) {
            if (product.isPublished()) {
                return wishListRepository.save(wishList);
            }

        }
        return "Sorry...This product is currently not available";
    }

    public String removeWishList(Long id) {

        if (wishListRepository.existsById(id)) {
            wishListRepository.deleteById(id);

            return "Product removed from WishList...";
        }
        return "Product not found";
    }
}