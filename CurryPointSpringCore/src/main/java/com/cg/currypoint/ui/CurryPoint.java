/**
 * @author syerrana
  project name: Curry Point
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

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.cg.currypoint.config.JavaConfig;
import com.cg.currypoint.dto.Address;
import com.cg.currypoint.dto.Item;
import com.cg.currypoint.dto.Vendor;
import com.cg.currypoint.exception.VendorNotFoundException;
import com.cg.currypoint.service.VendorService;
import com.cg.currypoint.service.VendorServiceImpl;
import com.cg.currypoint.util.DbUtil;

@Component//this makes Currypoint class as a bean
public class CurryPoint {

	private static VendorService service;
	@Autowired
	private VendorService vendorService;
	@PostConstruct
	private void init() {
		service = this.vendorService;
	}

	public static void main(String[] args) {
		List<Vendor> vendors = new ArrayList<Vendor>();
		/**It will look for JavaConfig.class bean file if it is not in path then throw execption.*/
		AnnotationConfigApplicationContext app=new AnnotationConfigApplicationContext(JavaConfig.class);
		Scanner sc = new Scanner(System.in);

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
				String landmark = sc.nextLine();
				sc.nextLine();
				System.out.println("Enter the Area : ");
				String area = sc.nextLine();
				System.out.println("Enter the City : ");
				String city = sc.nextLine();
				System.out.println("Enter the State : ");
				String state = sc.nextLine();
				System.out.println("Enter the Pincode : ");
				Long pincode = sc.nextLong();
				System.out.println("Enter the Vendor Name : ");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.println("Enter the Vendor PhoneNumber : ");
				BigInteger phoneNumber = sc.nextBigInteger();
				System.out.println("Enter the Email Id : ");
				String email = sc.next();
				List<Item> items = new ArrayList<Item>();
				do {
					System.out.println("Enter the Item Name : ");
					String item_name = sc.nextLine();
					sc.nextLine();
					System.out.println("Enter the Item item Price : ");
					BigDecimal item_price = sc.nextBigDecimal();
					/**if JavaConfig.class contains any bean named "item" and holds reference to class(item)
					load it immediately and return object of that class*/
					Item item=(Item) app.getBean("item");
					item.setName(item_name);
					item.setPrice(item_price);
					items.add(item);
					System.out.println("Enter more item ? (Y or N): ");
					ch=sc.next();
				}while(ch.equals("Y") || ch.equals("y")); //it asks to vendor whether want to add more items
				/**if JavaConfig.class contains any bean named "address" and holds reference to class(address)
				load it immediately and return object of that class*/
				Address address=(Address) app.getBean("address");
				address.setHouseNumber(houseNumber);
				address.setLandmark(landmark);
				address.setArea(area);
				address.setCity(city);
				address.setState(state);
				address.setPincode(pincode);
				/**if JavaConfig.class contains any bean named "vendor" and holds reference to class(vendor)
				load it immediately and return object of that class*/
				Vendor vendor = (Vendor) app.getBean("vendor");
				vendor.setName(name);
				vendor.setPhoneNumber(phoneNumber);
				vendor.setEmail(email);
				vendor.setAddress(address);
				vendor.setItems(items);
				service.addVendor(vendor);
				System.out.println(vendor);
				break;

			case 2:	// in this case it fetch the list of vendors through a given location
				System.out.println("Enter location:");
				sc.nextLine();
				city=sc.nextLine();
				try {
					vendors=service.searchByLocation(city);
					for(Vendor v: vendors) {
						System.out.println(v.getName()+" Address : "+v.getAddress());//it displays list of vendors with their address
					}
				}catch(VendorNotFoundException e) {
					System.out.println(e.getMessage());//it prints the exception
				}			
				break;

			case 3: // in this case it displays the items present searching by  vendor name
				System.out.println("Enter  name: ");
				sc.nextLine();
				name=sc.nextLine();
				try {
					vendors=service.searchByName(name);
					for(Vendor v: vendors) { 
						System.out.println(v.getName()+" Area : "+v.getAddress().getArea());//it displays list of vendors with their items
						System.out.println();
						System.out.println(v.getItems());
					}
				}catch(VendorNotFoundException e) {
					System.out.println(e.getMessage());//it prints the exception
				}	
				break;	

			case 4:
				return;
			default:
				System.out.println("Please choose anyone of below option: ");
				printDetails();//to display the functions option
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