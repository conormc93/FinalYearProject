package com.finalYear.restservice.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finalYear.restservice.entity.Customer;
import  com.finalYear.restservice.repository.CustomerRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CustomerController {

	@Autowired
	CustomerRepository repository;

	@GetMapping("/customers")
	public List<Customer> getAllCustomers() {
		System.out.println("Get all Customers...");

		List<Customer> customers = new ArrayList<>();
		repository.findAll().forEach(customers::add);

		return customers;
	}

	@PostMapping(value = "/customers/create")
	public Customer postCustomer(@RequestBody Customer customer) {

		Customer _customer = repository.save(new Customer(customer.getCname(), customer.getAddress(), customer.getPhone()));
		return _customer;
	}

	@DeleteMapping("/customers/{cid}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("cid") long cid) {
		System.out.println("Delete Customer with CID = " + cid + "...");

		repository.deleteByCid(cid);

		return new ResponseEntity<>("Customer has been deleted!", HttpStatus.OK);
	}

	@DeleteMapping("/customers/delete")
	public ResponseEntity<String> deleteAllCustomers() {
		System.out.println("Delete All Customers...");

		repository.deleteAll();

		return new ResponseEntity<>("All customers have been deleted!", HttpStatus.OK);
	}

	@GetMapping(value = "customers/cname/{cname}")
	public List<Customer> findByAge(@PathVariable String cname) {

		List<Customer> customers = repository.findByCname(cname);
		return customers;
	}

	@PutMapping("/customers/{cid}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable("cid") long cid, @RequestBody Customer customer) {
		System.out.println("Update Customer with CID = " + cid + "...");

		Optional<Customer> customerData = repository.findByCid(cid);

		if (customerData.isPresent()) {
			Customer _customer = customerData.get();
			_customer.setCname(customer.getCname());
			_customer.setAddress(customer.getAddress());
			_customer.setPhone(customer.getPhone());
			return new ResponseEntity<>(repository.save(_customer), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
