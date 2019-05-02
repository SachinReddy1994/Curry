
/**
 
 This interface is written to perform the logic operations. 
 This program contains three methods which performs adding vendor details, searchby given location and search by vendor name.
*/


package com.cg.currypoint.service;

import java.util.List;
import com.cg.currypoint.dto.Vendor;

public interface VendorService {
	public Vendor addVendor(Vendor vendor);
	public List<Vendor> searchByLocation(String city);
	public List<Vendor> searchByName(String name);
}
