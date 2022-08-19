package com.nagarro.clientapp.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.clientapp.model.User;
import com.nagarro.clientapp.service.AuthService;

@Controller
public class AuthController {
	
	private final AuthService authService;

	@Autowired
	public AuthController(AuthService authService) {
		this.authService = authService;
	}

	@GetMapping()
	public ModelAndView login() {
		ModelAndView loginpage = new ModelAndView("login");

		return loginpage;
	}
	

	@PostMapping
	public String login(User user, HttpServletRequest request, HttpServletResponse response) {
		
		Boolean userpresent = authService.authenticate(user);
		
		if(userpresent) {
			
			HttpSession session = request.getSession();
			session.setAttribute("username", user.getUsername());
			
			return "redirect:/home/";
		}
		else
			return "error.jsp";

	}

}



