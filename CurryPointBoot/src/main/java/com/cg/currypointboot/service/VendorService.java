/**
 * @author syerrana
 * interface : contains the method information of vendor
 */
package com.cg.currypointboot.service;

import java.util.List;

import com.cg.currypointboot.dto.Vendor;


public interface VendorService {
	/**
	 * @author syerrana
	 * @param vendor
	 * data will be added in vendor
	 */
	public Vendor addVendor(Vendor vendor);
	/**
	 * @author syerrana
	 * @param city
	 * @return : it returns the list of vendor present, searched through city
	 */
	public List<Vendor> searchByCity(String city);
	/**
	 * @author syerrana
	 * @param name
	 * @return : it returns the items present, searched by name
	 */
	public List<Vendor> searchByName(String name);
}
