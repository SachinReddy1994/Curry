package com.cg.currypoint.service;

import java.util.List;
import com.cg.currypoint.dto.Vendor;
import com.cg.currypoint.exception.VendorNotFoundException;

public interface VendorService {
	public Vendor addVendor(Vendor vendor);
	public List<Vendor> searchByLocation(String city) throws VendorNotFoundException;
	public List<Vendor> searchByName(String name) throws VendorNotFoundException;
}
