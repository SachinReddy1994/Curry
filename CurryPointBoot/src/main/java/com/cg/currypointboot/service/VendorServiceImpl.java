/**
 * @author syerrana
 * this class implements interface and performs business logic for vendor
 */
package com.cg.currypointboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.currypointboot.controller.CurryPointController;
import com.cg.currypointboot.dao.VendorRepository;
import com.cg.currypointboot.dto.Item;
import com.cg.currypointboot.dto.Vendor;

@Service
public class VendorServiceImpl implements VendorService {
	@Autowired
	VendorRepository vendorRepository;
		static int id=100;
		static int addressId=10;
		static int itemId=200;
		/**
		 * @author syerrana
		 * @param vendor
		 *@return :  data will be added in vendor
		 */
	@Override
	public Vendor addVendor(Vendor vendor) {

		if(CurryPointController.logger.isDebugEnabled()){
			CurryPointController.logger.debug("addVendorService addVendor(Vendor) is executed!");
			CurryPointController.logger.debug(" Id "+id+" set to Vendor object");
		} 
		vendor.setId(id);
		vendor.getAddress().setId(addressId);
		for(Item item: vendor.getItems()){
			item.setId(itemId);
			itemId++;
		}
		addressId++;
		id++;
		return vendorRepository.save(vendor);
	}
	/**
	 * @author syerrana
	 * @param city
	 * @return : returns the list of vendor present, searched through city
	 */
	@Override
	public List<Vendor> searchByName(String name) {
		// TODO Auto-generated method stub
		if(CurryPointController.logger.isDebugEnabled()){
			CurryPointController.logger.debug("searchByNameVendorService searchByName(name) is executed!");
			CurryPointController.logger.debug(" name "+name+" list of items in vendor");
		}
		return vendorRepository.findByName(name);
	}
	/**
	 * @author syerrana
	 * @param name
	 * @return: it returns the items present, searched by name
	 */
	@Override
	public List<Vendor> searchByCity(String city) {
		if(CurryPointController.logger.isDebugEnabled()){
			CurryPointController.logger.debug("searchByCityVendorService searchByCity(city) is executed!");
			CurryPointController.logger.debug(" city "+city+" list of vendors in city");
		}
		return vendorRepository.findByCity(city);
	}

}
