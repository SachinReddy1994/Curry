package com.cg.currypoint.dao;

import java.util.List;
import com.cg.currypoint.dto.Vendor;

public interface VendorRepository {
	public Vendor save(Vendor vendor);
	public List<Vendor> findByLocation(String city);
	public List<Vendor> findByName(String name);
}
