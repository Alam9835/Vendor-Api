package com.vendormanager.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.vendormanager.application.Repository.VendorRepo;
import com.vendormanager.application.entities.Vendor;

@SpringBootTest
class VendorManagingApplicationTests {

	@Autowired
	VendorRepo vRepo;
	@Test
	public void testCreate () {
		Vendor v = new Vendor();
		v.setId(24);
		v.setName("subho");
		v.setCode("3369");
		v.setAddress("uk");
		v.setCity("London");
		v.setState("London21");
		v.setPincode("789456");
		v.setPhone("8794561236");
		v.setEmail("subho@gmail.com");
		
		vRepo.save(v);
		assertNotNull(vRepo.findById(24).get());
	}
	
	@Test
	public void testReadAll () {
		List list = vRepo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	
	@Test
	public void testRead () {
		Vendor vendor = vRepo.findById(24).get();
		assertEquals("subho", vendor.getName());
	}
	
	@Test
	public void testUpdate () {
		Vendor vendor = vRepo.findById(24).get();
		vendor.setPincode("564894");
		vRepo.save(vendor);
		assertNotEquals("826437",vRepo.findById(24).get().getPincode());
	}

	@Test
	public void testDelete () {
		vRepo.deleteById(9);
		assertThat(vRepo.existsById(9)).isFalse();
	}
}
