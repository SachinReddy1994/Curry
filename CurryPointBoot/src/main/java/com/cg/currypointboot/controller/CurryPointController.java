 /**
		 * @author syerrana 
		 * {@link CurryPointController} : every request and response from the client and server has been handled in this class

		 * */
package com.cg.currypointboot.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.currypointboot.dto.Vendor;
import com.cg.currypointboot.service.VendorService;

@RestController
@RequestMapping("/currypoint")
@CrossOrigin(origins="http://localhost:4200")
public class CurryPointController {
	@Autowired
	VendorService vendorService;
	
		public static final Logger logger = Logger.getLogger(CurryPointController.class);
		 

	  /**
	 * @author :- syerrana 
	 * @return :- vendor data
	 *@exception : No Vendor added
	 * */	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public ResponseEntity<Vendor> addVendor(@ModelAttribute Vendor vendo){
		Vendor vendor=vendorService.addVendor(vendo);
		
		return new ResponseEntity<Vendor>(vendor,HttpStatus.OK);
	}
	  /**
	 * @author :- syerrana 
	 * @return :- vendor (name and items present)
	 * @param : pname
	 *@exception : if vendor is not present it shows No Vendor to show
	 * */
	@RequestMapping(value="/search",method=RequestMethod.GET)
	public ResponseEntity<List<Vendor>> search(@RequestParam("pname") String name){
		List<Vendor> vendorList=vendorService.searchByName(name);
		if(vendorList.isEmpty()) {
			return new ResponseEntity("No Vendor to show",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Vendor>>(vendorList,HttpStatus.OK);
}	
	  /**
		 * @author :- syerrana 
		 * @return :- vendor(list of vendors present in given city)
		 * @param : pcity
		 *@exception :if city is not present it shows No City to show
		 * */
	@RequestMapping(value="/searchby",method=RequestMethod.GET)
	public ResponseEntity<List<Vendor>> searchCity(@RequestParam("pcity") String city){
		List<Vendor> vendorList=vendorService.searchByCity(city);
		if(vendorList.isEmpty()) {
			return new ResponseEntity("No Vendor to show",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Vendor>>(vendorList,HttpStatus.OK);
}
}
