package com.example.ECommerceProductManagement.model;


import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Product {

    private Long productId;
    private String name;
    private String desc;
    private double price;
    private int qtyAvail;

}
