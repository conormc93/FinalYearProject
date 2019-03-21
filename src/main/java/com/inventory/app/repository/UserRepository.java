package com.grokonez.jwtauthentication.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.grokonez.jwtauthentication.model.User;


public interface UserRepository extends CrudRepository<User, Long> {
	Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
	User findAllByUsername(String username);
}