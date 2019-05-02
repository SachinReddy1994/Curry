
/**
 
 This class is written to retrieval data from data source. 
 This program contains three methods which performs adding vendor details, findby given location and findby by vendor name.
*/

package com.cg.currypoint.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cg.currypoint.dto.Address;
import com.cg.currypoint.dto.Item;
import com.cg.currypoint.dto.Vendor;
import com.cg.currypoint.exception.ConnectionException;
import com.cg.currypoint.exception.VendorNotFoundException;
import com.cg.currypoint.util.DbUtil;

public class VendorRepositoryImpl implements VendorRepository {
	Connection connection ;//it establishes connection with database
	PreparedStatement pstm; 
	public Vendor save(Vendor vendor) {
		 try {
			 connection= DbUtil.getConnection();//creating connection to DB
			 pstm = connection.prepareStatement(QueryRepository.queryInsertAddress);//creating query to insert into address table
			System.out.println(vendor);
			int addressId=0;
			//converting java object to table row form
		        pstm.setLong(1, vendor.getAddress().getHouseNumber());   
		        pstm.setString(2, vendor.getAddress().getLandmark());
				pstm.setString(3, vendor.getAddress().getArea());
				pstm.setString(4, vendor.getAddress().getCity());
				pstm.setString(5, vendor.getAddress().getState());
				pstm.setLong(6, vendor.getAddress().getPincode());           
		        pstm.executeUpdate();
		        
		       pstm = connection.prepareStatement( QueryRepository.queryMaxAddressId);// in this situation it takes last inserted id
		       ResultSet result = pstm.executeQuery();//storing the execute query data in result by using resultset
		       //this result.next goes to next row
		       if(result.next()) {
		    	   addressId = result.getInt(1);
		       }
		    
			//insertion of data into vendor table
		    PreparedStatement pstm = connection.prepareStatement
		    		(QueryRepository.queryInsertVendor);
		    {
		    	//converting java object to table row form
		        pstm.setString(1, vendor.getName());  
		        pstm.setString(2, vendor.getEmail());
		        pstm.setString(3, vendor.getPhoneNumber().toString());
		        pstm.setInt(4, addressId);
		        pstm.executeUpdate();
		    }
		 
		 int vendorId=0; 
		
			pstm = connection.prepareStatement(QueryRepository.queryMaxVendorId);// in this situation it takes last inserted id
		       ResultSet resultOne = pstm.executeQuery();//storing the execute query data in result by using resultset
		       if(resultOne.next()) {
		    	    vendorId= resultOne.getInt(1);
		       
		       //inserting data into item table
			pstm = connection.prepareStatement(QueryRepository.queryInsertItem);
	      for (Item items : vendor.getItems()) {
	    	//converting java object to table row form
			pstm.setString(1, items.getName());
			pstm.setBigDecimal(2, items.getPrice());
			pstm.setInt(3, vendorId);

	        pstm.executeUpdate();
		}
		       }
		 }
		       catch (SQLException e) {
		    	   throw new ConnectionException("Connection not done...");
	    }finally {
			//closing all the DB connection 
			if(pstm!=null && connection!=null) {
				try {
					pstm.close();
					connection.close();
				} catch (SQLException e) {
					throw new ConnectionException("Problem in closing...");
				}
			}
	    }
		return vendor;
	}
		
	
	public List<Vendor> findByLocation(String city) {//in this it search by location and returns the list of vendors found
		List<Vendor> vendors=new ArrayList<>();//storing the list of vendors in vendors
		try {
			connection= DbUtil.getConnection();//creating connection to DB
			pstm=connection.prepareStatement(QueryRepository.queryFindByLocation );//Creating object of prepared statement
			pstm.setString(1, city);//setting parameter
			ResultSet rs=pstm.executeQuery();//executing prepared statement query
			if(rs!=null) {
				//iterating result set
				while(rs.next()) {
					Vendor vendor=new Vendor();
					Address address=new Address();
					vendor.setName(rs.getString(1));
					address.setHouseNumber(rs.getLong(2));
					address.setLandmark(rs.getString(3));
					address.setArea(rs.getString(4));
					address.setCity(rs.getString(5));
					address.setState(rs.getString(6));
					address.setPincode(rs.getLong(7));
					vendor.setAddress(address);
					vendors.add(vendor);
				}
			}
		} catch (SQLException e) {
			throw new ConnectionException("Connection not done...");
		}finally {
			//closing all the DB connection 
			if(pstm!=null && connection!=null) {
				try {
					pstm.close();
					connection.close();
				} catch (SQLException e) {
					throw new ConnectionException("Problem in closing...");
				}
			}
	    }
		return vendors;
		
	}

	public List<Vendor> findByName(String name) {//in this it search by name and returns the list of vendors and items present in it
		List<Vendor> vendors=new ArrayList<>();//storing the list of vendors in vendors
		try {
			connection= DbUtil.getConnection();	//creating connection to DB
			pstm=connection.prepareStatement(QueryRepository.queryFindByName);//creating prepared statement object
			pstm.setString(1, name);//setting parameter
			ResultSet rs=pstm.executeQuery();
			if(rs!=null) {
				//iterating over the result set
				while(rs.next()) {
					Vendor vendor=new Vendor();
					List<Item> items=new ArrayList<Item>();
					Item item=new Item();
					vendor.setName(rs.getString(1));
					item.setId(rs.getInt(2));
					item.setName(rs.getString(3));
					item.setPrice(rs.getBigDecimal(4));
					items.add(item);
					vendor.setItems(items);
					vendors.add(vendor);
				}
			}
		} catch (SQLException e) {
			throw new ConnectionException("Connection not done..."); 
		}finally {
			//closing all the DB connection 
			if(pstm!=null && connection!=null) {
				try {
					pstm.close();
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
	    }
		return vendors;
	}

}
