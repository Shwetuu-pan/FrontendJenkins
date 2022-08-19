package com.nagarro.clientapp.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nagarro.clientapp.model.User;

@Repository
public interface UserRepository 
	extends JpaRepository<User,Long>{

	@Query("select u from User u where u.username = ?1 and u.password = ?2")
	Optional<User> findUserByUsername(String username ,String password);
	
}



