package com.enveu.ShoppingApi21.entity;

import javax.persistence.*;

@Entity
@Table(name = "Product_Image")
public class ProductImage {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String imgUrl1;
    private String imgUrl2;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImgUrl1() {
        return imgUrl1;
    }

    public void setImgUrl1(String imgUrl1) {
        this.imgUrl1 = imgUrl1;
    }

    public String getImgUrl2() {
        return imgUrl2;
    }

    public void setImgUrl2(String imgUrl2) {
        this.imgUrl2 = imgUrl2;
    }
}
