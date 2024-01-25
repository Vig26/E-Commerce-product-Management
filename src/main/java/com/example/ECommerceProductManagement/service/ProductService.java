package com.example.ECommerceProductManagement.service;


import com.example.ECommerceProductManagement.dto.ResponseDTO;
import com.example.ECommerceProductManagement.model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ProductService {

    private final Map<Long, Product> productMap = new ConcurrentHashMap<>();

    private static Long prodIdCounter = 1L;

    public ResponseDTO createProduct(Product product){
        ResponseDTO responseDTO = new ResponseDTO();
        product.setProductId(prodIdCounter++);
        productMap.put(product.getProductId(), product);
        responseDTO.setData(product);
        responseDTO.setStatus(true);
        responseDTO.setStatusCode(200);
        responseDTO.setMessage("Success");
        return responseDTO;
    }

    public ResponseDTO readProduct(Long productId){
        ResponseDTO responseDTO = new ResponseDTO();
        Object product = productMap.get(productId);
        if(product != null){
            responseDTO.setData(product);
            responseDTO.setStatus(true);
            responseDTO.setStatusCode(200);
            responseDTO.setMessage("Success");
        }
        else {
            responseDTO.setStatus(false);
            responseDTO.setStatusCode(400);
            responseDTO.setMessage("Error: Product not found.");
        }
        return responseDTO;
    }

    public ResponseDTO updateProduct(Product product){
        ResponseDTO responseDTO = new ResponseDTO();
        if(productMap.containsKey(product.getProductId())){
            productMap.put(product.getProductId(),product);
            responseDTO.setStatus(true);
            responseDTO.setStatusCode(200);
            responseDTO.setMessage("Success: Product Updated.");
        }
        else{
            responseDTO.setStatus(false);
            responseDTO.setStatusCode(400);
            responseDTO.setMessage("Error: Product not found.");
        }
        return responseDTO;
    }

    public ResponseDTO deleteProduct(Long productId){
        ResponseDTO responseDTO = new ResponseDTO();
        if(productMap.containsKey(productId)){
            productMap.remove(productId);
            responseDTO.setStatus(true);
            responseDTO.setStatusCode(200);
            responseDTO.setMessage("Success: Product Deleted.");
        }
        else{
            responseDTO.setStatus(false);
            responseDTO.setStatusCode(400);
            responseDTO.setMessage("Error: Product not found.");
        }
        return responseDTO;
    }

    public ResponseDTO discountProduct(Long productId, Object discount){
        ResponseDTO responseDTO = new ResponseDTO();
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> reqbodyMap = objectMapper.convertValue(discount, Map.class);
        if(productMap.containsKey(productId)){
            double newPrice;
            if((boolean) reqbodyMap.get("isDiscount")){
                newPrice = productMap.get(productId).getPrice() * (1 - (double) reqbodyMap.get("rate") / 100);
            }
            else {
                newPrice = productMap.get(productId).getPrice() * (1 + (double) reqbodyMap.get("rate") / 100);
            }
            productMap.get(productId).setPrice(newPrice);
            responseDTO.setData(productMap.get(productId));
            responseDTO.setStatus(true);
            responseDTO.setStatusCode(200);
            responseDTO.setMessage("Success: Product Deleted.");
        }
        else{
            responseDTO.setStatus(false);
            responseDTO.setStatusCode(400);
            responseDTO.setMessage("Error: Product not found.");
        }
        return responseDTO;
    }

}
