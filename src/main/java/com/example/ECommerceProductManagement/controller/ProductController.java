package com.example.ECommerceProductManagement.controller;

import com.example.ECommerceProductManagement.dto.ResponseDTO;
import com.example.ECommerceProductManagement.model.Product;
import com.example.ECommerceProductManagement.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/createProd")
    public ResponseDTO createProducts(@RequestBody Product product){
        return productService.createProduct(product);
    }

    @GetMapping("/readProd/{productId}")
    public ResponseDTO readProduct(@PathVariable Long productId){
        return productService.readProduct(productId);
    }

    @PutMapping("/updateProd")
    public ResponseDTO updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }

    @DeleteMapping("/deleteProd/{productId}")
    public ResponseDTO deleteProduct(@PathVariable Long productId){
        return productService.deleteProduct(productId);
    }

    @PostMapping("/disortax/{productId}")
    public ResponseDTO discountProduct(@PathVariable Long productId){
        return productService.discountProduct(productId);
    }

}
