package com.cg.currypoint.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.currypoint.dao.VendorRepository;
import com.cg.currypoint.dto.Item;
import com.cg.currypoint.dto.Vendor;
import com.cg.currypoint.exception.VendorNotFoundException;

@Service
@Transactional
public class VendorServiceImpl implements VendorService{
		@Autowired	
		VendorRepository repository;
		// static int id=100;
		static int addressId=10;
		static int itemId=200;
		
	public Vendor addVendor(Vendor vendor) {
	
		//vendor.setId(id);
		//vendor.getAddress().setId(addressId);	
	
		for(Item item: vendor.getItems()){
			item.setId(itemId);
			itemId++;
		}
		//addressId++;
		//id++;
		return repository.save(vendor);
	}

	public List<Vendor> searchByLocation(String city) throws VendorNotFoundException{
		if(repository.findByLocation(city).isEmpty()){
			throw new VendorNotFoundException("Vendor Not Found");
			}
		return repository.findByLocation(city);
	}

	public List<Vendor> searchByName(String name) throws VendorNotFoundException{
		if(repository.findByName(name).isEmpty()){
			throw new VendorNotFoundException("Vendor Not Found");
		}
		return repository.findByName(name);
	}

}
