package com.enveu.ShoppingApi21.controller;

import com.enveu.ShoppingApi21.dto.ProductDTO;
import com.enveu.ShoppingApi21.entity.Product;
import com.enveu.ShoppingApi21.service.JwtSessionService;
import com.enveu.ShoppingApi21.service.ProductInventoryService;
import com.enveu.ShoppingApi21.service.ProductService;
import com.enveu.ShoppingApi21.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    JwtUtil jwtUtil;
    @Autowired
    JwtSessionService jwtSessionService;

    @Autowired
    ProductInventoryService productInventoryService;

    // Add product (ADMIN access only)
    @PostMapping("/addProduct")
    public Product addProd(HttpServletRequest request, @RequestBody Product product) {
        String token = request.getHeader("authToken");
        String email = jwtUtil.getSubject(token);
        return productService.addProduct(product);
    }

    // Product Update (ADMIN access only)
    @PutMapping("/product/update")
    public Product updateProduct(HttpServletRequest request, @RequestBody Product product) {
        String token = request.getHeader("authToken");
        String email = jwtUtil.getSubject(token);
        return productService.updateProd(product);
    }


    // All Product list
    @GetMapping("/product/list")
    public List<ProductDTO> listProd() {
        return productService.getlist();
    }

    @GetMapping("/product/publish/{id}")
    public boolean publishProduct(HttpServletRequest request,@PathVariable("id") Long id)
    {
        String token = request.getHeader("authToken");
        String email = jwtUtil.getSubject(token);
        return productService.publishOrUnpublish(id,true);
    }

    @GetMapping("/product/unpublish/{id}")
    public boolean unpublishProduct(HttpServletRequest request,@PathVariable("id") Long id)
    {
        String token = request.getHeader("authToken");
        String email = jwtUtil.getSubject(token);
        return productService.publishOrUnpublish(id,false);
    }


    // Delete product using product Id (Only ADMIN access)
    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteById(HttpServletRequest request, @PathVariable("id") Long id) {
        String token = request.getHeader("authToken");
        String email = jwtUtil.getSubject(token);
        String validate = jwtSessionService.checkToken(email, token);
        String x = productService.deleteProductById(id);
        if (x != null) {
            return ResponseEntity.ok("Delete SuccessFully");
        } else {
            return ResponseEntity.ok("Id not found");
        }
    }

    //Get product details by id
    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public Optional<Product> productById(HttpServletRequest request, @PathVariable("id") Long id) {
        String token = request.getHeader("authToken");
        String email = jwtUtil.getSubject(token);
        String validate = jwtSessionService.checkToken(email, token);
        return productService.findProductById(id);
    }


    // Stock update(Admin)
    @RequestMapping(value = "/products/stock/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> stockUpdate(HttpServletRequest request, @PathVariable("id") Long id, @RequestParam Long productQuantity) {
        String token = request.getHeader("authToken");
        String email = jwtUtil.getSubject(token);
        String validate = jwtSessionService.checkToken(email, token);
        return ResponseEntity.ok(productInventoryService.stockUpdate(id, productQuantity));
    }
//
//    @GetMapping("/category/{id}")
//    public Optional<Product> listCategory(@PathVariable("id") Long id) {
//        return productService.prodListByCatogry(id);
//    }

}

