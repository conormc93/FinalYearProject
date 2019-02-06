package com.finalYear.restservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {

    private int cid;
    @Id
    private String cname;
    private String address;
    private String phone;
	
    
    public Customer() {
	}


	public Customer(int cid, String cname, String address, String phone) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.address = address;
		this.phone = phone;
	}


	public int getCid() {
		return cid;
	}


	public void setCid(int cid) {
		this.cid = cid;
	}


	public String getCname() {
		return cname;
	}


	public void setCname(String cname) {
		this.cname = cname;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	

}