package com.grokonez.jwtauthentication.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.grokonez.jwtauthentication.model.Customer;
import com.grokonez.jwtauthentication.model.Order;


public interface OrderRepository extends CrudRepository<Order, Long>{
	List<Order> findByOid(long oid);
	Void deleteByOid(long oid);
	List<Order> findByUid(long uid);
}
