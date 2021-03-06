package com.inventory.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.inventory.app.model.Order;


public interface OrderRepository extends CrudRepository<Order, Long>{
	List<Order> findByOid(long oid);
	Integer deleteByOid(long oid);
	List<Order> findByUid(long uid);
}
