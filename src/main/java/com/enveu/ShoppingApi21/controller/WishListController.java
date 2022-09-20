package com.enveu.ShoppingApi21.controller;

import com.enveu.ShoppingApi21.entity.WishList;
import com.enveu.ShoppingApi21.globalException.GlobalException;
import com.enveu.ShoppingApi21.service.JwtSessionService;
import com.enveu.ShoppingApi21.service.WishListService;
import com.enveu.ShoppingApi21.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class WishListController {

    @Autowired
    WishListService wishListService;
    @Autowired
    JwtUtil jwtUtil;
    @Autowired
    JwtSessionService jwtSessionService;
    @Autowired
    GlobalException globalException;

    @PostMapping("wishList/add")
    public Object addWishList(HttpServletRequest request,@RequestBody WishList wishList)
    {
        String token = request.getHeader("authToken");
        String email = jwtUtil.getSubject(token);
        return wishListService.addWishList(wishList);
    }

    @DeleteMapping("/wishList/remove/{id}")
    public String removeWishList(HttpServletRequest request,@PathVariable("id") Long wishListId) throws GlobalException
    {
        String token = request.getHeader("authToken");
        String email = jwtUtil.getSubject(token);
        return wishListService.removeWishList(wishListId);
    }
}
