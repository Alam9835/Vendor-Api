package com.vendormanager.application.payload;

import javax.validation.constraints.Pattern;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class VendorDto {

	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "vendor_id")
	    private Integer Id;

	    @Column(name = "vendor_name")
	    @NotBlank(message = "Vendor name is required")
	    private String Name;

	    @Column(name = "vendor_code", unique = true)
	    @NotBlank(message = "Vendor code is required")
	    private String Code;

	  
	   @NotBlank(message = "Address is required")
	    private String address;

	
	    @NotBlank(message = "City is required")
	    private String city;

	 
	    @NotBlank(message = "State is required")
	    private String state;

	  
    @Pattern(regexp = "\\d{6}", message = "Pincode should be a 6 digit number")
	    @NotBlank(message = "Pincode is required")
	    private String pincode;

	    
	    @Pattern(regexp = "\\d{10}", message = "Phone should be a 10 digit number")
	    @NotBlank(message = "Phone is required")
	    private String phone;


	    @Email(message = "Invalid email")
    @NotBlank(message = "Email is required")
	    private String email;


		
}
