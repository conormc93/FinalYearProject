package com.finalYear.restservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.finalYear.restservice.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
	List <Product> findByPname(String pname);

	Optional <Product> findByPid(long pid);

	Void deleteByPid(long uid);
}