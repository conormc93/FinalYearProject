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

	@Column(name = "cid")
	private int cid;

	@Column(name = "total")
	private float total;
	
	@Column(name = "uid")
	private int uid;
	

	public Order() { }

	public Order(long oid, int cid, float total, int uid) {
		this.oid = oid;
		this.cid = cid;
		this.total = total;
		
	}

	public long getOid() {
		return oid;
	}

	public void setOid(long oid) {
		this.oid = oid;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	@Override
	public String toString() {
		return "Order [oid=" + oid + ", cid=" + cid + ", total=" + total + ", uid=" + uid + "]";
	}
	
}