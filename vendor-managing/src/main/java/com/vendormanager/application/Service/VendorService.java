package com.vendormanager.application.Service;

import java.util.List;

import java.util.Optional;

import com.vendormanager.application.entities.Vendor;
import com.vendormanager.application.payload.VendorDto;

public interface VendorService {

    VendorDto createUser(VendorDto user);
    
    VendorDto updateUser(VendorDto user,Integer userId);
    
    VendorDto getUserById(Integer userId);
    
    List<VendorDto> getAllUsers();
    
    void deleteUser(Integer userId);
    

	
}
