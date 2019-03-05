package com.finalYear.restservice.controller;

import java.security.Principal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

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


import com.finalYear.restservice.entity.User;
import  com.finalYear.restservice.repository.UserRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UserController{

	@Autowired
	UserRepository repository;
    	
	
	@RequestMapping("/login")
    public boolean login(@RequestBody User user) {
		
		List<User> users;		
		users = repository.findByName(user.getName());
		
		for(User myUser: users){
			if(myUser.getPassword().equals(user.getPassword())){
				return true;
			}else{
				return false;
			}	
		} 
		return false;
		
	//	return user.getName().equals("Mary") && user.getPassword().equals("tester");
		
	}
	
	@RequestMapping("/user")
    public Principal user(HttpServletRequest request) {
		String authToken = request.getHeader("Authorization").substring("Basic".length()).trim();
		return () -> new String(Base64.getDecoder().decode(authToken)).split(":")[0];
    }

	@GetMapping("/users")
	public List<User> getAllUsers() {
		System.out.println("Get all Users...");

		List<User> users = new ArrayList<>();
		repository.findAll().forEach(users::add);

		return users;
	}

	@PostMapping(value = "/users/create")
	public User postUser(@RequestBody User user) {

		user = repository.save(new User(user.getName(), user.getAddress(), user.getPhone(),user.getPassword()));
		return user;
	}

	@DeleteMapping("/users/{uid}")
	public ResponseEntity<String> deleteUser(@PathVariable("uid") long uid) {
		System.out.println("Delete User with UID = " + uid + "...");

		repository.deleteByUid(uid);

		return new ResponseEntity<>("User has been deleted!", HttpStatus.OK);
	}

	@DeleteMapping("/users/delete")
	public ResponseEntity<String> deleteAllUsers() {
		System.out.println("Delete All Users...");

		repository.deleteAll();

		return new ResponseEntity<>("All users have been deleted!", HttpStatus.OK);
	}

	@GetMapping(value = "users/name/{name}")
	public List<User> findByAge(@PathVariable String name) {

		List<User> users = repository.findByName(name);
		return users;
	}

	@PutMapping("/users/{uid}")
	public ResponseEntity<User> updateUser(@PathVariable("uid") long uid, @RequestBody User user) {
		System.out.println("Update User with UID = " + uid + "...");

		Optional<User> userData = repository.findByUid(uid);

		if (userData.isPresent()) {
			User _user = userData.get();
			_user.setName(user.getName());
			_user.setAddress(user.getAddress());
			_user.setPhone(user.getPhone());
			return new ResponseEntity<>(repository.save(_user), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
