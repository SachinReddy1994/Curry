package com.cg.currypoint.dto;

public class Address {
		
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

		public long getHouseNumber() {
			return houseNumber;
		}

		public void setHouseNumber(Long houseNumber) {
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

		public void setPincode(Long pincode) {
			this.pincode = pincode;
		}

		@Override
		public String toString() {
			return "Address [houseNumber=" + houseNumber + ", landmark=" + landmark + ", area=" + area + ", city="
					+ city + ", state=" + state + ", pincode=" + pincode + "]";
		}
		
}
