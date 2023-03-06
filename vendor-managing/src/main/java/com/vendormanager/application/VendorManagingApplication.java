package com.vendormanager.application;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VendorManagingApplication {

	public static void main(String[] args) {
		SpringApplication.run(VendorManagingApplication.class, args);
	
	System.out.println("Helo");
	}
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	
	
	}
   


}
