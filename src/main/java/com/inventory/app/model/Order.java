package com.grokonez.jwtauthentication.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long oid;

	@Column(name = "cname")
	private String cname;
	
	@Column(name = "uid")
	private long uid;
	
	@Column(name = "amount")
	private int amount;

	@Column(name = "pname")
	private String pname;
	
	@Column(name = "total")
	private float total;
	

	public Order() { }


	public Order(long oid, long uid, String cname, int amount, String pname,float total) {
		super();
		this.oid = oid;
		this.cname = cname;
		this.uid = uid;
		this.amount = amount;
		this.pname = pname;
		this.total = total;
	}


	public long getOid() {
		return oid;
	}

	public void setOid(long oid) {
		this.oid = oid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}


	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}
	
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}
	
}