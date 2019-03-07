package com.finalYear.restservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.finalYear.restservice.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
	List <User> findByName(String name);

	Optional <User> findByUid(long uid);

	Void deleteByUid(long uid);
}