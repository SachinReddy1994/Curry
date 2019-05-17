/**

This class is written to perform the logic operations. 
This program contains three methods which performs adding vendor and searching operations and throwing the exceptions.
*/
package com.cg.currypoint.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.currypoint.dao.VendorRepository;
import com.cg.currypoint.dao.VendorRepositoryImpl;
import com.cg.currypoint.dto.Item;
import com.cg.currypoint.dto.Vendor;
import com.cg.currypoint.exception.VendorNotFoundException;

@Service("vendorService")//it makes VendorServiceImpl class as a bean
public class VendorServiceImpl implements VendorService{
	@Autowired	
		VendorRepository repository;
	static int id=1001;
	static int addressId=101;
	static int itemId=10;
	/** The addVendor() method returns added vendors.*/			
	public Vendor addVendor(Vendor vendor) {
		vendor.setVendor_id(id);
		vendor.getAddress().setAddr_id(addressId);
		for(Item item: vendor.getItems()){
			item.setItem_id(itemId);
			itemId++;
		}
		addressId++;
		id++;
		return repository.save(vendor);
	}
	/** The searchByLocation() method returns the list vendor present in that given location.*/
	public List<Vendor> searchByLocation(String city) {
		if(repository.findByLocation(city).isEmpty()){
			throw new VendorNotFoundException("Vendor Not Found");//when the vendor is not found in given location it throws exception
			}
		return repository.findByLocation(city);
	}
	/** The searchByName() method returns list of vendor and their items.*/
	public List<Vendor> searchByName(String name) {
		if(repository.findByName(name).isEmpty()){
			throw new VendorNotFoundException("Vendor Not Found");//when the vendor is not found by given name it throws exception
		}
		return repository.findByName(name);
	}

}
