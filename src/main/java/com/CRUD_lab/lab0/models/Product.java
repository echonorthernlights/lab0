package com.CRUD_lab.lab0.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	private Long id;
	private String prod_ref;
	private String prod_name;
	private String prod_brand;
	private double prod_price;
	

	public Product() {
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProd_ref() {
		return prod_ref;
	}
	public void setProd_ref(String prod_ref) {
		this.prod_ref = prod_ref;
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	public String getProd_brand() {
		return prod_brand;
	}
	public void setProd_brand(String prod_brand) {
		this.prod_brand = prod_brand;
	}
	public double getProd_price() {
		return prod_price;
	}
	public void setProd_price(double d) {
		this.prod_price = d;
	}
	

}
