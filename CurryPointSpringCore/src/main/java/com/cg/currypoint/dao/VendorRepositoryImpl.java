/**
 @author syerrana
 This class is written to retrieval data from data source. 
 This program contains three methods which performs adding vendor details, findby given location and findby by vendor name.
*/

package com.cg.currypoint.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cg.currypoint.dto.Vendor;
import com.cg.currypoint.util.DbUtil;

@Repository("vendorRepository")//create a bean for VendorRepositoryImpl class as vendorRepository
public class VendorRepositoryImpl implements VendorRepository {
		/** saves the data to vendor */
	public Vendor save(Vendor vendor) {
		DbUtil.vendors.add(vendor);
		return vendor;
	}
	/** through given city it search in database and prints the required*/
	public List<Vendor> findByLocation(String city) {
		List<Vendor> vendorList=new ArrayList<Vendor>();
		for(Vendor v: DbUtil.vendors){
			if(v.getAddress().getCity().equalsIgnoreCase(city)) {
				vendorList.add(v);//the address and vendor name is stored in list
			}
		}
		return vendorList;
	}
	/** through given vendor name it search in database and prints the items present in it*/
	public List<Vendor> findByName(String name) {
		List<Vendor> vendorList=new ArrayList<Vendor>();
		for(Vendor v: DbUtil.vendors){
			if(v.getName().equalsIgnoreCase(name)) {
				vendorList.add(v);
			}
		}
		return vendorList;
		
	}

}
