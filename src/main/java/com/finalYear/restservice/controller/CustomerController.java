package com.finalYear.restservice.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finalYear.restservice.entity.Customer;
import com.finalYear.restservice.entity.User;
import com.finalYear.restservice.repository.CustomerRepository;

import javassist.tools.web.BadHttpRequest;

@RestController
@RequestMapping(path = "/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository repository;

    @GetMapping
    public Iterable<Customer> findAll() {
        return repository.findAll();
    }

    @GetMapping(path = "/{cname}")
    public Customer find(@PathVariable("cname") String cname) {
        return repository.findOne(cname);
    }

    @PostMapping(consumes = "application/json")
    public Customer create(@RequestBody Customer customer) {
        return repository.save(customer);
    }

    @DeleteMapping(path = "/{cname}")
    public void delete(@PathVariable("cname") String cname) {
        repository.delete(cname);
    }

    @PutMapping(path = "/{cname}")
    public Customer update(@PathVariable("cname") String cname, @RequestBody Customer customer) throws BadHttpRequest {
        if (repository.exists(cname)) {
            customer.setCname(cname);
            return repository.save(customer);
        } else {
            throw new BadHttpRequest();
        }
    }

}