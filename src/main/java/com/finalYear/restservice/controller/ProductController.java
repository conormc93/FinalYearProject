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

import com.finalYear.restservice.entity.Product;
import com.finalYear.restservice.repository.ProductRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	ProductRepository repository;

	@GetMapping("/products")
	public List<Product> getAllProducts() {
		System.out.println("Get all Products...");

		List<Product> products = new ArrayList<>();
		repository.findAll().forEach(products::add);

		return products;
	}

	@PostMapping(value = "/products/create")
	public Product postProduct(@RequestBody Product product) {

		product = repository.save(new Product(product.getPid(), product.getPname(), product.getStock(),
				product.getCost_price(), product.getSale_price(), product.getUid()));
		return product;
	}

	@DeleteMapping("/products/{pid}")
	public ResponseEntity<String> deleteProduct(@PathVariable("pid") long pid) {
		System.out.println("Delete Product with Pid = " + pid + "...");

		repository.deleteByPid(pid);

		return new ResponseEntity<>("Product has been deleted!", HttpStatus.OK);
	}

	@DeleteMapping("/products/delete")
	public ResponseEntity<String> deleteAllProducts() {
		System.out.println("Delete All Products...");

		repository.deleteAll();

		return new ResponseEntity<>("All products have been deleted!", HttpStatus.OK);
	}

	@GetMapping(value = "products/pname/{pname}")
	public List<Product> findByName(@PathVariable String name) {

		List<Product> products = repository.findByPname(name);
		return products;
	}

	@PutMapping("/products/{pid}")
	public ResponseEntity<Product> updateProduct(@PathVariable("pid") long pid, @RequestBody Product product) {

		System.out.println("Update Product with Pid = " + pid + "...");

		Optional<Product> productData = repository.findByPid(pid);

		if (productData.isPresent()) {
			Product _product = productData.get();
			_product.setPname(product.getPname());
			_product.setStock(product.getStock());
			_product.setCost_price(product.getCost_price());
			_product.setSale_price(product.getSale_price());
			return new ResponseEntity<>(repository.save(_product), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
