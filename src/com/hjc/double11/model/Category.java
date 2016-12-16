package com.hjc.double11.model;

public class Category implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String type;

	/** default constructor */
	public Category() {
	}

	/** full constructor */
	public Category(String type) {
		this.type = type;
	}
	
	/** full constructor */
	public Category(Integer id,String type) {
		this.id=id;
		this.type = type;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", type=" + type+"]";
	}

	
}