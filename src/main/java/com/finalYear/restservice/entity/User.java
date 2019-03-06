package com.finalYear.restservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
@Entity
@Table(name = "user")
public class User {
 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long uid;
 
	@Column(name = "name")
	private String name;
 
	@Column(name = "address")
	private String address;
 
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "password")
	private String password;
 
	public User() {
	}
 
	public User(String name,String address,String phone,String password) {
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.password = password;
	}
 
	public long getUid() {
		return uid;
	}
 
	public void setName(String name) {
		this.name = name;
	}
 
	public String getName() {
		return this.name;
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
		return "User [id=" + uid + ", name=" + name + ", address=" + address + ", phone=" + phone + " password=" + password + "]";
	}
}