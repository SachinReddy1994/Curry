/**
 
 This class is written to establish a connection with database. 
*/
package com.cg.currypoint.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cg.currypoint.dto.Vendor;
import com.cg.currypoint.exception.VendorNotFoundException;

public class DbUtil {
	static EntityManager em = null;
	public static EntityManager getConnection() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("currypointjpa");
		 em = emf.createEntityManager();
		 //em.getTransaction().begin();
		return em;
	}
}
	

