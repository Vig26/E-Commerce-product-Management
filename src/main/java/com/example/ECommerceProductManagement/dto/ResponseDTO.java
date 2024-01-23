package com.example.ECommerceProductManagement.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ResponseDTO {
    private Boolean status;
    private Integer statusCode;
    private String message;
    private Object data ;
}
