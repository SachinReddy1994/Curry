
/**
 
 This class is written to perform database operation. 
 This program contains insertion of vendor details, retrieval by location, retrieval by name from database.
 */

package com.cg.currypoint.dao;
public interface QueryRepository {

	public static final String FIND_BY_LOCATION="SELECT v FROM Vendor v, IN(v.address) a WHERE a.city= :city";
	public static final String FIND_BY_NAME="SELECT v FROM Vendor v WHERE v.name= :name";
}
