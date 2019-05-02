package com.cg.currypoint.dto;

import java.math.BigInteger;
import java.util.List;

public class Vendor {
	private int id;
	private String name;
	private String email;
	private BigInteger phoneNumber;
	private Address address;
	private List<Item> items;
	
	public Vendor() {
		
	}

	public Vendor( String name, String email, BigInteger phoneNumber, Address address,
			List<Item> items) {
		super();
		
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.items = items;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public BigInteger getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(BigInteger phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Vendor [id=" + id + ", name=" + name + ", email=" + email + ",  phoneNumber="
				+ phoneNumber + ", address=" + address + ", items=" + items + "]";
	}
	
}
