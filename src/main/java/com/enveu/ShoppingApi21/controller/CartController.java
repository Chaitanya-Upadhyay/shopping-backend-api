package com.enveu.ShoppingApi21.controller;

import com.enveu.ShoppingApi21.entity.Cart;
import com.enveu.ShoppingApi21.service.CartService;
import com.enveu.ShoppingApi21.service.JwtSessionService;
import com.enveu.ShoppingApi21.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private JwtSessionService jwtSessionService;

    @PostMapping("/addToCart")
    private ResponseEntity<?> addProductToCart(HttpServletRequest request, @RequestBody Cart cart)
    {
        String token = request.getHeader("authToken");
        String email = jwtUtil.getSubject(token);
        String validate = jwtSessionService.checkToken(email, token);
        if (validate!=null){
            return ResponseEntity.ok(cartService.addCart(cart));
        }
        else {
            return ResponseEntity.ok("Token is not valid");
        }
    }

    @DeleteMapping("/delete/cart/{id}")
    private ResponseEntity<?> deleteCart(HttpServletRequest request , @PathVariable ("id") Long id)
    {
        String token = request.getHeader("authToken");
        String email = jwtUtil.getSubject(token);
        String validate = jwtSessionService.checkToken(email,token);
        if (validate!=null){
            return ResponseEntity.ok(cartService.remove(id));
        }
        else {
            return ResponseEntity.ok("There is no Cart at this user Id");
        }
    }
}
