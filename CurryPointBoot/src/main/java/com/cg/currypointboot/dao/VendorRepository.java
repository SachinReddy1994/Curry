	/**
	 * @author syerrana
	 * this dao interface is to link or use the database application and perform certain operations
	 * */
package com.cg.currypointboot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.currypointboot.dto.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Integer> {
	/**
	 * @author syerrana
	 * @param city
	 *  @return : it returns the list of vendor present in database, searched through city
	 */
	@Query("SELECT v FROM Vendor v, IN(v.address) a WHERE a.city= :city")
	public List<Vendor> findByCity(@Param("city") String city);
	//@Query("SELECT v FROM Vendor v WHERE v.name= :name")
	/**
	 * @author syerrana
	 * @param name
	 *  @return : it returns the list of items present in database, searched through name
	 */
	public List<Vendor> findByName(String name);
}
