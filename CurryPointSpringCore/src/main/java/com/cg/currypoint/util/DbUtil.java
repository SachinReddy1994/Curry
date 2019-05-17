/**
 @author syerrana
 This util class will store the data in vendors.  
*/
package com.cg.currypoint.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cg.currypoint.dto.Vendor;
@Component
public class DbUtil {
	public static List<Vendor> vendors=new ArrayList<Vendor>();
}
