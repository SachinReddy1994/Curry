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
import com.cg.currypoint.dto.Vendor;
import com.cg.currypoint.exception.VendorNotFoundException;

public class DbUtil {
	//public static List<Vendor> vendors=new ArrayList<Vendor>();
	static Connection conn;
	
	public static Connection getConnection()  {
		Properties prop = new Properties();
	
		try {
			InputStream it = new FileInputStream("src/main/resources/jdbc.properties");
			prop.load(it);

				if(prop!=null) {
			String driver = prop.getProperty("jdbc.driver");
			String url = prop.getProperty("jdbc.url");
			String uname = prop.getProperty("jdbc.username");
			String upass = prop.getProperty("jdbc.password");
			Class.forName(driver);
			conn=  DriverManager.getConnection(url, uname, upass);//establishing a connection with database
			}
		
		} catch (FileNotFoundException e  ) {
			throw new VendorNotFoundException("File not Found");//if file not found it throws given exception
		}
		catch (ClassNotFoundException |SQLException |IOException e ) {
			throw new VendorNotFoundException("Class or Input/Output or SqL Problem");
			
		} 
		return conn;
		
	}
}
	

