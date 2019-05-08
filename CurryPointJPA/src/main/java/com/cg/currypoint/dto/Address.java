package com.cg.currypoint.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Address {
		@Id
		@Column(name="addr_id")
		private int id;
		@Column(name="houseNo")
		private long houseNumber;
		@Column(name="landmark")
		private String landmark;
		@Column(name="area")
		private String area;
		@Column(name="city")
		private String city;
		@Column(name="state")
		private String state;
		@Column(name="pincode")
		private long pincode;
		
		public Address() {
			
		}

		public Address( long houseNumber, String landmark, String area, String city, String state,
				long pincode) {
			super();
			//this.addr_id = addr_id;
			this.houseNumber = houseNumber;
			this.landmark = landmark;
			this.area = area;
			this.city = city;
			this.state = state;
			this.pincode = pincode;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
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
			return "Address [addr_id=" + id + ", houseNumber=" + houseNumber + ", landmark=" + landmark + ", area="
					+ area + ", city=" + city + ", state=" + state + ", pincode=" + pincode + "]";
		}
		
	
}
