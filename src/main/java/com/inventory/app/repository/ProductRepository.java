package com.inventory.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.inventory.app.model.Customer;
import com.inventory.app.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
	List <Product> findByPname(String pname);

	Optional <Product> findByPid(long pid);

	Integer deleteByPid(long uid);
	
	List<Product> findByUid(long uid);
}