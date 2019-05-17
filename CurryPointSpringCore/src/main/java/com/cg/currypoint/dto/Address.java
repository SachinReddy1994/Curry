package com.cg.currypoint.dto;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component////it makes address class as a bean
@Scope("prototype")//This scopes a single bean definition to have any number of object instances.
public class Address {
		private int addr_id;
		private long houseNumber;
		private String landmark;
		private String area;
		private String city;
		private String state;
		private long pincode;
		
		public Address() {
			
		}

		public Address(long houseNumber, String landmark, String area, String city, String state, long pincode) {
			super();
			this.houseNumber = houseNumber;
			this.landmark = landmark;
			this.area = area;
			this.city = city;
			this.state = state;
			this.pincode = pincode;
		}

		public int getAddr_id() {
			return addr_id;
		}

		public void setAddr_id(int addr_id) {
			this.addr_id = addr_id;
		}

		public long getHouseNumber() {
			return houseNumber;
		}

		public void setHouseNumber(long houseNumber) {
			this.houseNumber = houseNumber;
		}

		public String getLandmark() {
			return landmark;
		}

		public void setLandmark(String landmark) {
			this.landmark = landmark;
		}

		public String getArea() {
			return area;
		}

		public void setArea(String area) {
			this.area = area;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public long getPincode() {
			return pincode;
		}

		public void setPincode(long pincode) {
			this.pincode = pincode;
		}

		@Override
		public String toString() {
			return "Address [addr_id=" + addr_id + ", houseNumber=" + houseNumber + ", landmark=" + landmark + ", area="
					+ area + ", city=" + city + ", state=" + state + ", pincode=" + pincode + "]";
		}
		
}
