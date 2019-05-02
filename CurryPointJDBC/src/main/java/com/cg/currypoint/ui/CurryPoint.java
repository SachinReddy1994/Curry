/*
 * project name: Curry Point
 * 			This project is about adding vendor and displaying the address, and what items they are having.
 * 
 * 
 * 
 * 
 *  This is user interface class.
 * Where user is adding the vendor details,vendor items , vendor address and fetching those details.
 * The data is coming and going through the service layer 
 */ 

package com.cg.currypoint.ui;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cg.currypoint.dto.Address;
import com.cg.currypoint.dto.Item;
import com.cg.currypoint.dto.Vendor;
import com.cg.currypoint.exception.ConnectionException;
import com.cg.currypoint.exception.VendorNotFoundException;
import com.cg.currypoint.service.VendorService;
import com.cg.currypoint.service.VendorServiceImpl;
import com.cg.currypoint.util.DbUtil;

public class CurryPoint {
	public static void main(String[] args) {
			
		List<Vendor> vendors = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		VendorService service=new VendorServiceImpl();
		int choice;
		String ch="Y";
			do {
			printDetails();
			choice=sc.nextInt();
			switch (choice) {
			case 1: // this is case is to add the data of vendor
			System.out.println("Enter the House Number : ");
			Long houseNumber = sc.nextLong();
			System.out.println("Enter the Landmark : ");
			String landmark = sc.next();
			System.out.println("Enter the Area : ");
			String area = sc.next();
			System.out.println("Enter the City : ");
			String city = sc.next();
			System.out.println("Enter the State : ");
			String state = sc.next();
			System.out.println("Enter the Pincode : ");
			Long pincode = sc.nextLong();
			System.out.println("Enter the Vendor Name : ");
			String name = sc.next();
			System.out.println("Enter the Vendor PhoneNumber : ");
			String phoneNumber = sc.next();
			System.out.println("Enter the Email Id : ");
			String email = sc.next();
			List<Item> items = new ArrayList<>();
			do {
			System.out.println("Enter the Item Name : ");
			String item_name = sc.next();
			System.out.println("Enter the Item item Price : ");
			BigDecimal item_price = sc.nextBigDecimal();
			items.add(new Item(item_name,item_price));
			System.out.println("Enter more item ? (Y or N): ");
			ch=sc.next();
			}while(ch.equals("Y") || ch.equals("y")); //it asks to vendor whether want to add more items
			Address address=new Address(houseNumber,landmark, area, city, state, pincode);
			Vendor vendor =new Vendor(name,email,new BigInteger(phoneNumber),address,items);
			service.addVendor(vendor);
			break;
			
			case 2: // in this case it fetch the list of vendors through a given location
				try {
				System.out.println("Enter location:");
				city=sc.next();
				vendors=service.searchByLocation(city);
				for(Vendor v: vendors) {
					System.out.println(v.getName()+" Address : "+v.getAddress());//it displays list of vendors with their address
				}
				}catch(ConnectionException e) {
					e.getMessage();
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3: // in this case it displays the items present searching by  vendor name
				try {
				System.out.println("Enter  name: ");
				name=sc.next();
				vendors=service.searchByName(name);
				for(Vendor v: vendors) { 
					System.out.println(v.getName());//it displays vendor name
					System.out.println(v.getItems());//it shows list of items 
				}
				}catch(ConnectionException e) {
					e.getMessage();
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
				break;	

			case 4:
				return;
			default:
				System.out.println("Please choose anyone of below option: ");
				
				break;
			}
		}while(choice!=4);
	}

	public static void printDetails() {
		System.out.println("1. Add Vendor : ");
		System.out.println("2. Search By Location : ");
		System.out.println("3. Search By Name : ");
		System.out.println("4. Exit: ");
	}
}