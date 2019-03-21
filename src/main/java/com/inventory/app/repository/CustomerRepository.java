package com.inventory.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.inventory.app.model.Customer;


public interface CustomerRepository extends CrudRepository<Customer, Long>{
	List<Customer> findByCname(String cname);
	Optional<Customer> findByCid(long cid);
	Integer deleteByCid(long cid);
	List<Customer> findByUid(long uid);

}
