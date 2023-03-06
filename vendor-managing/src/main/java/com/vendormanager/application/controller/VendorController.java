package com.vendormanager.application.controller;



import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vendormanager.application.Service.VendorService;
import com.vendormanager.application.payload.ApiResponse;
import com.vendormanager.application.payload.VendorDto;



@RestController
@RequestMapping("/api/users")
public class VendorController {


    @Autowired
    private VendorService vendorService;

    // create User
    @PostMapping("/") 
    public ResponseEntity<VendorDto> createUser(@Valid @RequestBody VendorDto vendorDto) {

    	VendorDto vendorDto1=this.vendorService.createUser(vendorDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(vendorDto1);

    }



    // Update User
    @PutMapping("/{userId}")
    public ResponseEntity<VendorDto> updateUserDetails(@Valid @RequestBody VendorDto vendorDto,@PathVariable Integer userId){

    	VendorDto vendorDto1=this.vendorService.updateUser(vendorDto,userId);
        return ResponseEntity.status(HttpStatus.OK).body(vendorDto1);

    }

    @GetMapping("/{userId}")
    public ResponseEntity<VendorDto> getUserDetails(@PathVariable Integer userId){

    	VendorDto vendorDto=this.vendorService.getUserById(userId);

        return ResponseEntity.status(HttpStatus.OK).body(vendorDto);

    }



    // Delete User
    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer userId){

        this.vendorService.deleteUser(userId);

        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("User Deleted Successfully",true));

    }


    //get all Users
    @GetMapping("/")
    public ResponseEntity<List<VendorDto>> getAllUsers(){

        List<VendorDto> users=this.vendorService.getAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(users);
        
    }
    
    
}