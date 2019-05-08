package com.cg.currypoint.dto;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Vendor {
	@Id
	@Column(name="vendor_id")
	private int id;
	@Column(name="vendor_name")
	private String name;
	@Column(name="vendor_email")
	private String email;
	@Column(name="vendor_mobile")
	private BigInteger phoneNumber;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="addr_id")
	private Address address;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="vendor_id")
	private List<Item> items;
	
	public Vendor() {
		
	}

	public Vendor( String name, String email, BigInteger phoneNumber, Address address, List<Item> items) {
		super();
		//this.id = id;
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
		return "Vendor [id=" + id + ", name=" + name + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", address=" + address + ", items=" + items + "]";
	}
	

}
