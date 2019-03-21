package com.grokonez.jwtauthentication.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long pid;

	@Column(name = "pname")
	private String pname;

	@Column(name = "stock")
	private int stock;

	@Column(name = "cost_price")
	private float cost_price;

	@Column(name = "sale_price")
	private float sale_price;

	@Column(name = "uid")
	private int uid;

	public Product() { }

	public Product(long pid, String pname, int stock, float cost_price, float sale_price, int uid) {
		this.pid = pid;
		this.pname = pname;
		this.stock = stock;
		this.cost_price = cost_price;
		this.sale_price = sale_price;
		this.uid = uid;
	}

	public long getPid() {
		return pid;
	}

	public void setPid(long pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public float getCost_price() {
		return cost_price;
	}

	public void setCost_price(float cost_price) {
		this.cost_price = cost_price;
	}

	public float getSale_price() {
		return sale_price;
	}

	public void setSale_price(float sale_price) {
		this.sale_price = sale_price;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", stock=" + stock + ", cost_price=" + cost_price
				+ ", sale_price=" + sale_price + ", uid=" + uid + "]";
	}
	
	
	
}