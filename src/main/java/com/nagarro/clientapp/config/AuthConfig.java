package com.nagarro.clientapp.config;
//import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nagarro.clientapp.model.User;
import com.nagarro.clientapp.repository.UserRepository;

@Configuration
public class AuthConfig {

	@Bean
	CommandLineRunner commandLineRunner(UserRepository loginRepository) {
		
		return args->{
			
			User shweta = new User("shweta@gmail.com","shweta");
			loginRepository.save(shweta);
		
		};
	}
	
}



