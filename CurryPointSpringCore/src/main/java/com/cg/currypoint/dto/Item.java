package com.cg.currypoint.dto;

import java.math.BigDecimal;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component////it makes items class as a bean
@Scope("prototype")//This scopes a single bean definition to have any number of object instances.
public class Item {
	private int item_id;
	private String name;
	private BigDecimal price;
	
	public Item() {
		
	}

	public Item( String name, BigDecimal price) {
		super();
		this.item_id = item_id;
		this.name = name;
		this.price = price;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
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
		return "Item [item_id=" + item_id + ", name=" + name + ", price=" + price + "]";
	}

	
}
