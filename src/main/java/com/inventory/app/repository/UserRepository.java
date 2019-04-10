package com.inventory.app.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.inventory.app.model.User;


public interface UserRepository extends CrudRepository<User, Long> {
	Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
	User findAllByUsername(String username);
}