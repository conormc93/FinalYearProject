package com.finalYear.restservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
@Entity
@Table(name = "customer")
public class Customer {
 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cid;
 
	@Column(name = "cname")
	private String cname;
 
	@Column(name = "address")
	private String address;
 
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "password")
	private String password;
 
	public Customer() {
	}
 
	public Customer(String cname,String address,String phone,String password) {
		this.cname = cname;
		this.address = address;
		this.phone = phone;
		this.password = password;
	}
 
	public long getCid() {
		return cid;
	}
 
	public void setCname(String cname) {
		this.cname = cname;
	}
 
	public String getCname() {
		return this.cname;
	}
 
	public void setAddress(String address) {
		this.address = address;
	}
 
	public String getAddress() {
		return this.address;
	}
 
	public String getPhone() {
		return this.phone;
	}
 
	public void setPhone(String phone) {
		this.phone = phone;
	}
 
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Customer [id=" + cid + ", name=" + cname + ", address=" + address + ", phone=" + phone + "]";
	}
}