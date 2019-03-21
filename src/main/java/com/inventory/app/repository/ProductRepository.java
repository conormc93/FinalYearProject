package com.grokonez.jwtauthentication.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.grokonez.jwtauthentication.model.Customer;
import com.grokonez.jwtauthentication.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
	List <Product> findByPname(String pname);

	Optional <Product> findByPid(long pid);

	Integer deleteByPid(long uid);
	
	List<Product> findByUid(int uid);
}