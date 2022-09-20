package com.enveu.ShoppingApi21.dto;

import com.enveu.ShoppingApi21.entity.Category;
import com.enveu.ShoppingApi21.entity.ProductDetails;
import com.enveu.ShoppingApi21.entity.ProductImage;
import com.enveu.ShoppingApi21.entity.ProductInventory;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

public class ProductDTO {

    private Long id;
    private String productName;
    private Long price;
    private String discount;
    //    private Long actualPrice;
//    private String quantity;
    private String productDese;

    private List<ProductDetails> productDetails;

    private Category category;

    private ProductInventory productInventory;

    private List<ProductImage> productImage;

    public ProductDTO() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }


    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }


    public String getProductDese() {
        return productDese;
    }

    public void setProductDese(String productDese) {
        this.productDese = productDese;
    }

    public List<ProductDetails> getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(List<ProductDetails> productDetails) {
        this.productDetails = productDetails;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public ProductInventory getProductInventory() {
        return productInventory;
    }

    public void setProductInventory(ProductInventory productInventory) {
        this.productInventory = productInventory;
    }

    public List<ProductImage> getProductImage() {
        return productImage;
    }

    public void setProductImage(List<ProductImage> productImage) {
        this.productImage = productImage;
    }

}
