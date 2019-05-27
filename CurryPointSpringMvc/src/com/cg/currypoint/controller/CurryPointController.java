 /**
		 * @author syerrana 
		 * {@link CurryPointController} : every request and response from the client and server has been handled in this class

		 * */
package com.cg.currypoint.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cg.currypoint.dto.Address;
import com.cg.currypoint.dto.Item;
import com.cg.currypoint.dto.Vendor;
import com.cg.currypoint.exception.VendorNotFoundException;
import com.cg.currypoint.service.VendorService;

@Controller
public class CurryPointController {
	   @Autowired
	   VendorService vendorService;
	   Vendor vedo;
	   static int id=100;
	   static int addressId=10;
	   /**
		 * @author syerrana 
		 * @return :- "Welcome"

		 * */
		@GetMapping("welcome")
		public ModelAndView welcome() {
			return new ModelAndView("Welcome");
		}
		
		  /**
				 * @author syerrana 
				 * @return :- "addVendor"
				 *@param :- "vendo"
				 * */	
		@GetMapping("add")
		public ModelAndView getVendor(@ModelAttribute("vend") Vendor vendo) {
			return new ModelAndView("addVendor");
		}
		  /**
		 * @author syerrana 
		 * @return :- "addItems"
		 *@param :- "vendo"
		 * */	
		@PostMapping("addVendor")
		public ModelAndView addVendor(@ModelAttribute("vend") Vendor vendo,ModelMap map) {
			this.vedo=vendo;
			vedo.setId(id);
			vedo.getAddress().setId(addressId);
			addressId++;
			id++;
			return new ModelAndView("addItems");
		}
		  /**
		 * @author syerrana 
		 * @return :- "searchByCity"
		 *@param :- "add"
		 * */	
		@GetMapping("search")
		public ModelAndView searchCity(@ModelAttribute("add") Address add) {
			return new ModelAndView("searchByCity");
		}
		  /**
				 * @author syerrana 
				 * @return :- "searchByCity","sCity",vendor
				 *@param :- "add"
				 *@param:- "city"
				 *@throws :- "VendorNotFoundException"
				 *@exception :"message"
				 * */
		@GetMapping("searchByCity")
		public ModelAndView findCity(@RequestParam("city") String city,@ModelAttribute("add") Address add,ModelMap map) {
			List<Vendor> vendor=null;
			try {
				vendor = vendorService.searchByLocation(city);
			} catch (VendorNotFoundException e) {
				// TODO Auto-generated catch block
				map.addAttribute("message",e.getMessage());
			}
		//	List<Vendor> vendor=vendorService.searchByLocation(vendo.getAddress().getCity());
			return new ModelAndView("searchByCity","sCity",vendor);
		}
		/**
		 * @author syerrana 
		 * @return :- "searchByName"
		 *@param :- "vendo"
		 * */
		@GetMapping("searchby")
		public ModelAndView searchName(@ModelAttribute("vend") Vendor vendo) {
			return new ModelAndView("searchByName");
		}
		/**
		 * @author syerrana 
		 * @return :- "searchByName","sName",vendorOne
		 *@param :- "vendo"
		 *@param:- "name"
		 **@throws :- "VendorNotFoundException"
		 *@exception :"message"
		 * */
		@GetMapping("searchByName")
		public ModelAndView findName(@RequestParam("name") String name,@ModelAttribute("vend") Vendor vendo,ModelMap map) {
			List<Vendor> vendorOne=null;;
			try {
				vendorOne = vendorService.searchByName(vendo.getName());
			} catch (VendorNotFoundException e) {
				// TODO Auto-generated catch block
				map.addAttribute("message",e.getMessage());
			}
			
			return new ModelAndView("searchByName","sName",vendorOne);
		}
		
		
		/**
		 * @author syerrana 
		 * @return :- "Welcome","adV",vendor
		 *@param :- "id"
		 *@param :- "name"
		 *@param:- "price"
		 * */
		@PostMapping("additem")
		public ModelAndView additems(@RequestParam("name") String name,
				@RequestParam("price") BigDecimal price,ModelMap map )
		{
			
			Item itm=new Item();
			//itm.setId(id);
			itm.setName(name);
			itm.setPrice(price);;
			List<Item> itmList=new ArrayList<>();
			itmList.add(itm);
			Vendor vdor=new Vendor();
			vdor.setId(vedo.getId());
			vdor.setName(vedo.getName());
			vdor.setEmail(vedo.getEmail());
			vdor.setPhoneNumber(vedo.getPhoneNumber());
			vdor.setAddress(vedo.getAddress());
			vdor.setItems(itmList);
			Vendor vendor=vendorService.addVendor(vdor);
			map.addAttribute("message","Item Saved successfully to:"+vdor.getId());
			map.addAttribute("item",new Item());
			return new ModelAndView("addItems");
		}
}
