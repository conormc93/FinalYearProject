package com.finalYear.restservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.finalYear.restservice.entity.Customer;

@RestResource(exported = false)
public interface CustomerRepository extends JpaRepository<Customer, String> {

}