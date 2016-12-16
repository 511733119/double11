package com.hjc.double11.model;

import java.util.Set;

public class User implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private String pass;
	private String phone;
	private int age;
	private String address;
	private Set<Pack> packSet;
	
	public User() {
	}
	public User(Set<Pack> packSet) {
		super();
		this.packSet = packSet;
	}
	public User(String name, String pass) {
		this.name = name;
		this.pass = pass;
	}
	public User(int id ,String name, String pass) {
		this.id = id;
		this.name = name;
		this.pass = pass;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set<Pack> getPackSet() {
		return packSet;
	}

	public void setPackSet(Set<Pack> packSet) {
		this.packSet = packSet;
	}
}