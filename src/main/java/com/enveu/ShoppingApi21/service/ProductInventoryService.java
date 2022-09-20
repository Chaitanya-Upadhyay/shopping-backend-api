package com.enveu.ShoppingApi21.service;

import com.enveu.ShoppingApi21.entity.Category;
import com.enveu.ShoppingApi21.entity.Customer;
import com.enveu.ShoppingApi21.entity.Product;
import com.enveu.ShoppingApi21.entity.ProductInventory;
import com.enveu.ShoppingApi21.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductInventoryService {

    @Autowired
    ProductRepository productRepository;

    //    public Product stockUpdate(Long id,ProductInventory productInventory){
//
//        Product product=productRepository.findById(id).get();
//        ProductInventory productInventory1=new ProductInventory();
//        productInventory1.setAvailableQuantity(checkNull(productInventory1.getAvailableQuantity(),productInventory.getAvailableQuantity()));
//        productInventory1.setTotalQuantity(checkNull(productInventory1.getTotalQuantity(),productInventory.getTotalQuantity()));
//        product.setProductInventory(productInventory1);
//        return productRepository.save(product);
//    }
//    private String checkNull(String customer1,String customer)
//    {
//        if(customer==null)
//            return customer1;
//        return customer;
    //   }
//    public Product stockUpdate(Long id, ProductInventory productInventory) {
//        Product product = productRepository.findById(id).orElse(new Product());
//        ProductInventory productInventory1 = product.getProductInventory();
//        productInventory1.setAvailableQuantity(productInventory.getAvailableQuantity() + productInventory1.getAvailableQuantity());
//        productInventory1.setTotalQuantity(productInventory.getTotalQuantity() + productInventory1.getTotalQuantity());
//        product.setProductInventory(productInventory1);
//        return productRepository.save(product);
//    }

    public Product stockUpdate(Long productId, Long productQuantity) {
        Product product = productRepository.findById(productId).orElse(new Product());
        ProductInventory productInventory1 = product.getProductInventory();
        productInventory1.setAvailableQuantity(productQuantity+ productInventory1.getAvailableQuantity());
        productInventory1.setTotalQuantity(productQuantity + productInventory1.getTotalQuantity());
        product.setProductInventory(productInventory1);
        return productRepository.save(product);

    }

}

