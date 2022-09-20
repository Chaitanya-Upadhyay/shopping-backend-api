package com.enveu.ShoppingApi21.filter;

import com.enveu.ShoppingApi21.entity.Customer;
import com.enveu.ShoppingApi21.repository.CustomerRepository;
import com.enveu.ShoppingApi21.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Component
public class MyFilter implements Filter{

//    @Autowired
//    CustomerRepository customerRepository;


    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    CustomerRepository customerRepository;
    public static List<String> allowedUrls;
    public static List<String> allowedUrlsUser;
    public static List<String> allowedUrlsAdmin;

    static{
        allowedUrls = new ArrayList<>();
        allowedUrls.add("/login");
        allowedUrls.add("/register");
        allowedUrls.add("/product/list");
        allowedUrls.add("/category");
//        allowedUrls.add("/product/details/id/{id}");
//        allowedUrls.add("/products/{id}");
    }
    static{
        allowedUrlsUser=new ArrayList<>();
        allowedUrlsUser.add("/user/profile");
        allowedUrlsUser.add("/user/changePassword");
        allowedUrlsUser.add("/products");
        allowedUrlsUser.add("/update/customer");
        allowedUrlsUser.add("/order");
        allowedUrlsUser.add("/addToCart");
        allowedUrlsUser.add("/delete/cart");
        allowedUrlsUser.add("/wishList/add");
        allowedUrlsUser.add("/wishList/remove");
    }

    static {
        allowedUrlsAdmin=new ArrayList<>();
        allowedUrlsAdmin.add("/user/profile");
        allowedUrlsAdmin.add("/addProduct");
        allowedUrlsAdmin.add("/product/update");
        allowedUrlsAdmin.add("/user/changePassword");
        allowedUrlsAdmin.add("/products");
        allowedUrlsAdmin.add("/update/customer");
        allowedUrlsAdmin.add("/products/stock");
        allowedUrlsAdmin.add("/product/publish");
        allowedUrlsAdmin.add("/product/unpublish");

    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        //check if api is allowed
        if (isAllowed(req.getRequestURI())) {
            chain.doFilter(request, response);
        } else {
            String token = req.getHeader("authToken");
            //check if token is verified and valid
            if (jwtUtil.isVerified(token)) {
                String email = jwtUtil.getSubject(token);
                request.setAttribute("email", email);
                Customer customer = customerRepository.findByEmail(email);
                String roleName = customer.getRole().getRollName();
                if (roleName.equals("ADMIN")){
                    if (isAllowedAdmin(req.getRequestURI())) {
                        chain.doFilter(request, response);
                    }
                }
                else {
                        if (isAllowedUser(req.getRequestURI())) {
                            chain.doFilter(request, response);}
            }
            }else{

                throw new ServletException("Exception is authorization");
            }
        }

    }


    private boolean isAllowed(String requestURI) {
        return allowedUrls.stream().anyMatch(requestURI::startsWith);
    }
    private boolean isAllowedAdmin(String requestURI){
        return allowedUrlsAdmin.stream().anyMatch(requestURI::startsWith);
    }
    private boolean isAllowedUser(String requestURI){
        return allowedUrlsUser.stream().anyMatch(requestURI::startsWith);
    }



    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
