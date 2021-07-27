package com.dev.producer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.producer.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer>{
	
	Users findByEmail(String email);

	Users findByToken(String token);

}
