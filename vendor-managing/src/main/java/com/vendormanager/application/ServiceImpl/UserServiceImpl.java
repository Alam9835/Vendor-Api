package com.vendormanager.application.ServiceImpl;


import java.util.List;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vendormanager.application.Repository.VendorRepo;
import com.vendormanager.application.Service.VendorService;
import com.vendormanager.application.entities.Vendor;
import com.vendormanager.application.payload.VendorDto;
import com.vendormanager.application.exception.*;
@Service
public class UserServiceImpl implements VendorService {

	@Autowired
	private VendorRepo vendorRepo;

	@Autowired
	private ModelMapper modelMapper;


	@Override
	public VendorDto createUser(VendorDto vendorDto) {
		// TODO Auto-generated method stub
		Vendor user=this.modelMapper.map(vendorDto,Vendor.class);
	
		
		
		Vendor vendor=this.vendorRepo.save(user);

        // user object gets converted to userDto object
        VendorDto savedUser=this.modelMapper.map(vendor,VendorDto.class);

        //saved user is returned
        return savedUser;
		}
	
	

	@Override
	public VendorDto updateUser(VendorDto vendorDto, Integer userId) {
		// TODO Auto-generated method stub
		
		Vendor userVendor=this.vendorRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("Vendor","id",Integer.toString(userId)));

		userVendor.setAddress(vendorDto.getAddress());
		userVendor.setCity(vendorDto.getCity());
		userVendor.setCode(vendorDto.getCode());
		userVendor.setState(vendorDto.getState());
		userVendor.setEmail(vendorDto.getEmail());
		userVendor.setName(vendorDto.getName());
		userVendor.setPhone(vendorDto.getPhone());
		userVendor.setPincode(vendorDto.getPincode());

		Vendor updatedVendor =this.vendorRepo.save(userVendor);
		
		return this.modelMapper.map(updatedVendor,VendorDto.class);
	}

	@Override
	public VendorDto getUserById(Integer userId) {

		Vendor vendor=this.vendorRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User"," id ", Integer.toString(userId)));

		
		return this.modelMapper.map(vendor,VendorDto.class);
	}

	@Override
	public List<VendorDto> getAllUsers() {

		List<Vendor> vendors=this.vendorRepo.findAll();
        

        List<VendorDto> vendorDtos=vendors.stream().map(vendor->this.modelMapper.map(vendor,VendorDto.class)).collect(Collectors.toList());
        
        return vendorDtos;
	}

	@Override
	public void deleteUser(Integer userId) {

		Vendor vendor=this.vendorRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User"," id ", Integer.toString(userId)));

		this.vendorRepo.delete(vendor);



		

	}
	
	
}