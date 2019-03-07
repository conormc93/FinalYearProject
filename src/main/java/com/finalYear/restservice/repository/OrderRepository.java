package com.finalYear.restservice.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.finalYear.restservice.entity.Order;


public interface OrderRepository extends CrudRepository<Order, Long>{
	List<Order> findByOid(long oid);
	Void deleteByOid(long oid);

}
