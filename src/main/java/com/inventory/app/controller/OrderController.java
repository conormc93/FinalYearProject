package com.inventory.app.controller;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.inventory.app.model.Customer;
import com.inventory.app.model.Order;
import com.inventory.app.model.Product;
import com.inventory.app.repository.CustomerRepository;
import com.inventory.app.repository.OrderRepository;
import com.inventory.app.repository.ProductRepository;
import com.inventory.app.repository.UserRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class OrderController {

	@Autowired
	OrderRepository repository;
	
	@Autowired
	CustomerRepository CustRepository;
	
	@Autowired
    UserRepository userRepo;
	
	@Autowired
    ProductRepository productRepo;
	
	Gson gson = new Gson();
	File file = new File("piechart.json");

	@GetMapping("/orders")
	public List<Order> getAllProducts() {
		System.out.println("Get all Orders...");

		List<Order> orders = new ArrayList<>();
		repository.findAll().forEach(orders::add);

		return orders;
	}
	
	@GetMapping("/orders/{username}")
	public List<Order> getOrders(@PathVariable("username")String username){
			
		List<Order> orders = new ArrayList<>();
		repository.findByUid(userRepo.findAllByUsername(username).getId()).forEach(orders::add);

		return orders;
	}
	
	@GetMapping("/orders/recent/{username}")
	public List<Order> getRecentOrders(@PathVariable("username")String username){
			
		List<Order> orders = new ArrayList<>();
		repository.findByUid(userRepo.findAllByUsername(username).getId()).forEach(orders::add);

		int a = orders.size();
		
		if(a > 5) {
			return orders.subList(0, 4);
		}
		return orders;
	}
	
	@GetMapping("/orders/top/{username}")
	public List<Customer> getTopCustomers(@PathVariable("username")String username){
			
		List<Customer> customers = new ArrayList<>();
		List<Order> orders = new ArrayList<>();
		repository.findByUid(userRepo.findAllByUsername(username).getId()).forEach(orders::add);

		for(Order o: orders){
			
		}

		int a= customers.size();
		
		if(a > 5) {
			return customers.subList((customers.size() - 4), customers.size());
		}
		return customers;
	}

	@PostMapping(value = "/orders/{username}/create")
	public Order postOrder(@RequestBody Order order, @PathVariable("username")String username) throws Exception {
		
		float total = 0;
		float profit = 0;
		List<Product> products = new ArrayList<>();
		products = productRepo.findByPname(order.getPname());
		
		//Update Stock
		for(Product p: products) {
			if(order.getAmount() > p.getStock()) {
				
				throw new Exception();
			}
			total = (p.getSale_price() * order.getAmount());
			p.setStock(p.getStock()-order.getAmount());
		}
		
		//Get Profit
		for(Product p: products) {
			float sale = (order.getAmount() * p.getSale_price());
			float cost = (order.getAmount() * p.getCost_price());
			profit = sale - cost;
		}
		
		order = repository.save(new Order(order.getOid(), userRepo.findAllByUsername(username).getId(), order.getCname(),
				order.getAmount(), order.getPname(), total, profit));
		
		List<Customer> customers = new ArrayList<>();
		CustRepository.findByCname(order.getCname()).forEach(customers::add);
		
		for(Customer c: customers) {
			
			c.setAmount_purchased(c.getAmount_purchased() + order.getTotal());
			CustRepository.save(c);
		}
		
		List<Customer> xs = new ArrayList<>();
		CustRepository.findAll().forEach(xs::add);
		for(Customer x: xs) {
			gson.toJson(x.getName(), new FileWriter(file));	
		}
		
		return order;
	}

	@Transactional
	@DeleteMapping("/orders/{oid}")
	public ResponseEntity<String> deleteProduct(@PathVariable("oid") long oid) {
		System.out.println("Delete Order with Oid = " + oid + "...");

		repository.deleteByOid(oid);

		return new ResponseEntity<>("Order has been deleted!", HttpStatus.OK);
	}

	@DeleteMapping("/orders/delete")
	public ResponseEntity<String> deleteAllOrders() {
		System.out.println("Delete All Ordrers...");

		repository.deleteAll();

		return new ResponseEntity<>("All orders have been deleted!", HttpStatus.OK);
	}

	@GetMapping(value = "orders/oid/{oid}")
	public List<Order> findByOid(@PathVariable long oid) {

		List<Order> orders = repository.findByOid(oid);
		return orders;
	}

}
