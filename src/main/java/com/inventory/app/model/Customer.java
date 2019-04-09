package com.inventory.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import java.util.Comparator;

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
	
	@Column(name = "amount_purchased")
	private float amount_purchased;
	
	
 
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

	public float getAmount_purchased() {
		return amount_purchased;
	}

	public void setAmount_purchased(float amount_purchased) {
		this.amount_purchased = amount_purchased;
	}



	public static Comparator<Customer> apComparator = new Comparator<Customer>() {         
	    @Override         
	    public int compare(Customer x, Customer y) {             
	      return (y.getAmount_purchased() < x.getAmount_purchased() ? -1 :                     
	              (y.getAmount_purchased() == x.getAmount_purchased() ? 0 : 1));           
	    }     
	  };      

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", address=" + address + ", phone=" + phone + " uid=" + uid + "]";
	}
}