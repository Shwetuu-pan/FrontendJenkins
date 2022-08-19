package com.nagarro.clientapp.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.clientapp.model.User;
import com.nagarro.clientapp.repository.UserRepository;

@Service
public class AuthService {
	
	private final UserRepository userRepository;
	
	@Autowired
	public AuthService(UserRepository userRepository) {
		this.userRepository = userRepository;
		
	}

	public List<User> login() {
		return userRepository.findAll();
	}

	public Boolean authenticate(User user) {
		
		Optional<User> tableuser = userRepository.findUserByUsername(user.getUsername(),user.getPassword());
	
		if(tableuser.isPresent())
			return true;

		return false;
	}
}



