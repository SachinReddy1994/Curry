package com.cg.currypoint.dto;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Item {
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="item_id")
	private Integer id;
	@Column(name="item_name")
	private String name;
	@Column(name="item_price")
	private BigDecimal price;
	
	@ManyToOne
	@JoinColumn(name="vendor_id")
	private Vendor vendor;
	public Item() {
		
	}

	public Integer getId() {
		return id;
	}
	public Item( String name, BigDecimal price, Vendor vendor) {
	super();
	//this.id = id;
	this.name = name;
	this.price = price;
	this.vendor = vendor;
}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Vendor getVendor() {
		return vendor;
	}
	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", price=" + price + ", vendor=" + vendor + "]";
	}

}
