package com.cg.currypointboot.dto;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Item {
	@Id
	@Column(name="item_id")
	private int id;
	@Column(name="item_name")
	private String name;
	@Column(name="item_price")
	private BigDecimal price;
	
	public Item() {
		// TODO Auto-generated constructor stub
	}

	public Item(String name, BigDecimal price) {
		super();
		//this.id = id;
		this.name = name;
		this.price = price;
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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	
}
