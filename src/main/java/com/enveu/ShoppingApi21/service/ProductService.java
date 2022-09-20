package com.enveu.ShoppingApi21.service;

import com.enveu.ShoppingApi21.dto.ProductDTO;
import com.enveu.ShoppingApi21.entity.Product;

import com.enveu.ShoppingApi21.repository.CategoryRepository;
import com.enveu.ShoppingApi21.repository.CustomerRepository;
import com.enveu.ShoppingApi21.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
   private CustomerRepository customerRepository;
    @Autowired
    CategoryRepository categoryRepository;


    public Product addProduct(Product product) {
//        employee.setCommunityList(communityRepo.saveAll(employee.getCommunityList()));
        product.setCategory(categoryRepository.save(product.getCategory()));
        return productRepository.save(product);
    }


    public Product updateProd(Product product) {
        Product product1 = productRepository.findById(product.getId()).get();
        product1.setProductName(checkNull(product1.getProductName(), product.getProductName()));
        product1.setPrice(Long.valueOf(checkNull(String.valueOf(product1.getPrice()), String.valueOf(product.getPrice()))));
        product1.setDiscount(checkNull(product1.getDiscount(), product.getDiscount()));
        product1.setProductDese(checkNull(product1.getProductDese(), product.getProductDese()));
        return productRepository.save(product1);
    }

    private String checkNull(String product1, String product) {
        if (product == null)
            return product1;
        return product;
    }

    public List<ProductDTO> getlist() {
        List<Product> productsList = productRepository.findAll();
        List<ProductDTO> productDTOList = new ArrayList<>();
        productsList.forEach(product -> {
            if (product.isPublished()) {
                ProductDTO productDTO = new ProductDTO();
                BeanUtils.copyProperties(product,productDTO);
                productDTOList.add(productDTO);
            }
        });

        return productDTOList;
    }

    public Optional<Product> listId(Long id) {
        return productRepository.findById(id);
    }


    public String deleteProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product != null) {
            productRepository.deleteById(id);
            return "valid";
        } else {
            return null;
        }
    }

    public Optional<Product> findProductById(Long id) {
        return productRepository.findById(id);
    }

    public Optional<Product> prodListByCatogry(Long categoryId){

     productRepository.findByCategoryId(categoryId);
        return null;
    }

    public boolean publishOrUnpublish(Long productId,boolean publish)
    {
        Product product =  productRepository.findById(productId).get();
        product.setPublished(publish);
        productRepository.save(product);
        return true;
    }
}
