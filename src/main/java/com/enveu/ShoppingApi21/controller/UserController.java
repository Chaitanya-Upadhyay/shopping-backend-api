package com.enveu.ShoppingApi21.controller;


import com.enveu.ShoppingApi21.entity.Customer;
//import com.enveu.ShoppingApi21.entity.JwtPassword;
import com.enveu.ShoppingApi21.entity.JwtPassword;
import com.enveu.ShoppingApi21.entity.JwtRequest;
import com.enveu.ShoppingApi21.entity.JwtResponse;
import com.enveu.ShoppingApi21.service.JwtSessionService;
import com.enveu.ShoppingApi21.service.UserService;
import com.enveu.ShoppingApi21.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private UserService userService;
    @Autowired
    private JwtSessionService jwtSessionService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody JwtRequest jwtRequest, HttpServletResponse response) throws Exception {

        final String user= userService.loginCheck(jwtRequest.getEmail(),jwtRequest.getPassword());
        if (user!=null) {
            final String token = jwtUtil.generateJwtToken(user);


            jwtSessionService.tokenSave(jwtRequest.getEmail(), token);
            response.setHeader("authToken", token);
            return ResponseEntity.ok(userService.profileView(jwtRequest.getEmail()));
        }
        return ResponseEntity.ok("Email or Password is not valid");
    }


    @PostMapping("/register")
    public ResponseEntity<?> saveUser(@RequestBody Customer customer) throws Exception {
        System.out.println(customer);
        return ResponseEntity.ok(userService.addCst(customer));
    }




    @GetMapping("/user/profile")
    public Object getUser(HttpServletRequest request) {
        String s=request.getHeader("authToken");
        String email = jwtUtil.getSubject(s);
        System.out.println(email);
        return userService.profileView(email);
    }
    @PutMapping("/update/customer")
    public Customer updateEmp(HttpServletRequest request,@RequestBody Customer customer)
    {
        String token=request.getHeader("authToken");
        String email=jwtUtil.getSubject(token);
        return userService.updateCs(customer);
    }

@RequestMapping(value = "/user/changePassword", method = RequestMethod.POST)
public ResponseEntity<?> saveUser( @RequestBody JwtPassword jwtPassword, HttpServletRequest request) throws Exception {
    String token = request.getHeader("authToken");
    String email = jwtUtil.getSubject(token);
    String validate = jwtSessionService.checkToken(email, token);
    if (validate != null) {
        String verifyEmail = userService.changePassword(email, jwtPassword.getNewPassword(), jwtPassword.getOldPassword());
        if (verifyEmail != null) {
            String newToken = jwtUtil.generateJwtToken(email);
            jwtSessionService.tokenSave(email, newToken);
            return ResponseEntity.ok("NewToken=======" + newToken);
        }
        return ResponseEntity.ok("old password not match");
    }
    return ResponseEntity.ok("Invalid Token");
}

}





