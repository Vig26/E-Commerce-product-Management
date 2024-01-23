package com.example.ECommerceProductManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class ECommerceProductManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceProductManagementApplication.class, args);
	}

}
