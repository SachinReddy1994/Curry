
/**
 
 This class is written to retrieval data from data source. 
 This program contains three methods which performs adding vendor details, findby given location and findby by vendor name.
*/

package com.cg.currypoint.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.cg.currypoint.dto.Vendor;
import com.cg.currypoint.util.DbUtil;

public class VendorRepositoryImpl implements VendorRepository {
	EntityManager em;
	public Vendor save(Vendor vendor) {
		em=DbUtil.getConnection();
		em.getTransaction().begin();
		em.persist(vendor);
		em.getTransaction().commit();
		//em.close();
		return vendor;
	}

	public List<Vendor> findByLocation(String city) {
		Query query=em.createQuery(QueryRepository.FIND_BY_LOCATION);
		query.setParameter("city", city);
		return query.getResultList();
	}

	public List<Vendor> findByName(String name) {
		Query query=em.createQuery(QueryRepository.FIND_BY_NAME);
		query.setParameter("name", name);
		return query.getResultList();
	}
	
}
