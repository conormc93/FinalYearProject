package com.finalYear.restservice.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finalYear.restservice.entity.Order;
import com.finalYear.restservice.repository.OrderRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class OrderController {

	@Autowired
	OrderRepository repository;

	@GetMapping("/orders")
	public List<Order> getAllProducts() {
		System.out.println("Get all Orders...");

		List<Order> orders = new ArrayList<>();
		repository.findAll().forEach(orders::add);

		return orders;
	}

	@PostMapping(value = "/orders/create")
	public Order postOrder(@RequestBody Order order) {

		order = repository.save(new Order(order.getOid(), order.getCid(), order.getTotal(),
				order.getUid()));
		return order;
	}

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
