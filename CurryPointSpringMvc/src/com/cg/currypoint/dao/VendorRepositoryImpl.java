package com.cg.currypoint.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

import com.cg.currypoint.dto.Item;
import com.cg.currypoint.dto.Vendor;

@Repository
public class VendorRepositoryImpl implements VendorRepository {
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public Vendor save(Vendor vendor) {
		Vendor venddo=getVendor(vendor.getId());
		if(venddo==null) {
		entityManager.persist(vendor);
		entityManager.flush();
		}else {
			Item itms=new Item();
			itms.setId(vendor.getItems().get(0).getId());
			itms.setName(vendor.getItems().get(0).getName());
			itms.setPrice(vendor.getItems().get(0).getPrice());
			itms.setVendor(vendor);
			entityManager.persist(itms);
			entityManager.flush();
		}
		return vendor;
	}

	@Override
	public List<Vendor> findByLocation(String city) {
		Query query=entityManager.createQuery(QueryRepository.FIND_BY_LOCATION);
		query.setParameter("city", city);
		return query.getResultList();
	}

	@Override
	public List<Vendor> findByName(String name) {
		Query query=entityManager.createQuery(QueryRepository.FIND_BY_NAME);
		query.setParameter("name", name);
		return query.getResultList();
	}
	
	public Vendor getVendor(Integer vendId) {
		Vendor vendorOne=null;
		try {
			Query query=entityManager.createQuery("FROM Vendor WHERE id=:vendId");
			query.setParameter("vendId", vendId);
			vendorOne=(Vendor) query.getSingleResult();
		}catch (NoResultException e) {
			System.out.println("Not Found");
		}
		return vendorOne;
	}
}
