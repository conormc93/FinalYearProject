package com.inventory.app.controller;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.inventory.app.model.Customer;
import com.inventory.app.repository.CustomerRepository;
import com.inventory.app.repository.UserRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CustomerController{

	@Autowired
	CustomerRepository repository;
	
	@Autowired
    UserRepository userRepo;
	
	

	@GetMapping("/customers")
	public List<Customer> getAllUsers() {
		System.out.println("Get all Customers...");

		List<Customer> customers = new ArrayList<>();
		repository.findAll().forEach(customers::add);

		return customers;
	}
	
	@GetMapping("/customers/{username}")
	public List<Customer> getCustomers(@PathVariable("username")String username){
			
		List<Customer> customers = new ArrayList<>();
		repository.findByUid(userRepo.findAllByUsername(username).getId()).forEach(customers::add);

		return customers;
	}

	@GetMapping("/customers/data/{username}")
	public Object[] getData(@PathVariable("username")String username){
		List<Customer> customers = new ArrayList<>();
		repository.findByUid(userRepo.findAllByUsername(username).getId()).forEach(customers::add);
		Object[] a = new Object[customers.size()];
		
		for(Customer c: customers) {
			
			String as = ("'customer': " + c.getName() + ", 'amount': " + c.getAmount_purchased() + "");
			appendValue(a, as);
		  }	
		return a;
	}

	private Object[] appendValue(Object[] obj, Object newObj) {

	ArrayList<Object> temp = new ArrayList<Object>(Arrays.asList(obj));
	temp.add(newObj);
	return temp.toArray();

  }
	@GetMapping("/customers/top/{username}")
	public List<Customer> getTopCustomers(@PathVariable("username")String username){
			
		List<Customer> customers = new ArrayList<>();
		repository.findByUid(userRepo.findAllByUsername(username).getId()).forEach(customers::add);

		 Collections.sort(customers, Customer.apComparator);
		return customers;
	}

	@PostMapping(value = "/customers/{username}/create")
	public Customer postCustomer(@RequestBody Customer customer, @PathVariable("username")String username) {

		customer = repository.save(new Customer(customer.getName(), customer.getAddress(), customer.getPhone(), userRepo.findAllByUsername(username).getId()));
		return customer;
	}

	@Transactional
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
	public List<Customer> findByName(@PathVariable String name) {

		List<Customer> customers = repository.findByCname(name);
		return customers;
	}

	@PutMapping("/customers/{cid}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable("cid") long cid, @RequestBody Customer customer) {
		System.out.println("Update Customer with CID = " + cid + "...");

		Optional<Customer> customerData = repository.findByCid(cid);

		if (customerData.isPresent()) {
			Customer _customer = customerData.get();
			_customer.setName(customer.getName());
			_customer.setAddress(customer.getAddress());
			_customer.setPhone(customer.getPhone());
			return new ResponseEntity<>(repository.save(_customer), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
