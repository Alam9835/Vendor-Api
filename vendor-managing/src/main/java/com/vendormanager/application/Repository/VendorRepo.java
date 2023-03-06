package com.vendormanager.application.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.vendormanager.application.entities.Vendor;

@Repository
public interface VendorRepo extends JpaRepository<Vendor, Integer> {
//    Vendor findByCode(String code);
}

