
/**
 
 This class is written to perform database operation. 
 This program contains insertion of vendor details, retrieval by location, retrieval by name from database.
 */

package com.cg.currypoint.dao;
public interface QueryRepository {
		//query to insert data in address table
		public static final String queryInsertAddress= "INSERT INTO address  "
	    		+ "(house_no, landmark, area, city, state, pincode) VALUES (?,?,?,?,?,?)";
		//query to insert data in Vendor table
		public static final String queryInsertVendor="INSERT INTO vendor (vendor_name,vendor_email,vendor_phone,address_id) VALUES (?, ?, ?,?)";
		//query to insert data in item table
		public static final String queryInsertItem = "INSERT INTO item (item_name,item_price,vendor_id) VALUES (?,?,?)";
		//query to fetch the last id from address table
		public static final String queryMaxAddressId="select max(id) from address";
		//query to fetch the last id from vendor table		
		public static final String queryMaxVendorId = "select max(vendor_id) from vendor";
		//query to fetch the address of vendor from particular location
		public static final String queryFindByLocation ="select v.vendor_name, a.house_no, a.landmark, a.area, a.city, a.state, a.pincode From"
				+ " vendor v join address a on v.address_id=a.id where city=?"; 
		// query to fetch the vendor items by vendor name
		public static final String queryFindByName="select v.vendor_name,i.item_id, i.item_name,i.item_price From vendor v join item  i on "
				+ "i.vendor_id=v.vendor_id where v.vendor_name=?";
}
