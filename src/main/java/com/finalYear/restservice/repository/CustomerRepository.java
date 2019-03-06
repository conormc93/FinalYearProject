package com.finalYear.restservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.finalYear.restservice.entity.Customer;


public interface CustomerRepository extends CrudRepository<Customer, Long>{
	List<Customer> findByCname(String cname);
	Optional<Customer> findByCid(long cid);
	Void deleteByCid(long cid);

}
