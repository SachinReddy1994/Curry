package com.cg.currypoint.dto;

import java.math.BigDecimal;

public class Item {
	private int id;
	private String name;
	private BigDecimal price;
	
	public Item() {
		
	}

	public Item( String name, BigDecimal price) {
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
