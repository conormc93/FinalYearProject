package com.grokonez.jwtauthentication.model;

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
	
	@Column(name = "uid")
	private long uid;
	
 
	public Customer() {
	}
 
	public Customer(String cname,String address,String phone,long uid) {
		this.cname = cname;
		this.address = address;
		this.phone = phone;
		this.uid = uid;
	}
 
	public long getCid() {
		return cid;
	}
 
	public void setName(String cname) {
		this.cname = cname;
	}
 
	public String getName() {
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
	
	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", address=" + address + ", phone=" + phone + " uid=" + uid + "]";
	}
}