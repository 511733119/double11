package com.hjc.double11.model;

import java.math.BigDecimal;

public class Pack implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private BigDecimal price;
	private User user;
	
	
	public Pack() {
		super();
	}

	public Pack(BigDecimal price,User user) {
		this.price = price;
		this.user = user;
	}

	public Pack(int id, BigDecimal price) {
		this.id = id;
		this.price = price;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	
}
