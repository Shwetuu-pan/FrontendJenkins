package com.nagarro.clientapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nagarro.clientapp.service.Book;
import com.nagarro.clientapp.service.HomeService;

@Controller
@RequestMapping(path = "/home")
public class HomeController {

	public final HomeService homeService;

	@Autowired
	public HomeController(HomeService homeService) {
		this.homeService = new HomeService();
	}

	@GetMapping
	public String home(HttpServletRequest request)
			throws IOException, ParseException, org.json.simple.parser.ParseException, java.text.ParseException {

		List<Book> booksdata = homeService.getBooksdata();

		HttpSession session = request.getSession();
		session.setAttribute("booksdata", booksdata);
		return "home";
	}

	@PostMapping("/addbook")
	public String addbook(HttpServletRequest request) throws IOException, org.json.simple.parser.ParseException, java.text.ParseException {
		homeService.addbook(request);

		List<Book> booksdata = homeService.getBooksdata();

		HttpSession session = request.getSession();
		session.setAttribute("booksdata", booksdata);
		
		return "redirect:/home/";
	}

	@GetMapping(path="/edit")
	public String editbook(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		session.setAttribute("id", request.getAttribute("sumbit"));
		
		return "edit";
	}

	@PostMapping(path="/edit")
	public String editbook(HttpServletRequest request) throws IOException, org.json.simple.parser.ParseException, java.text.ParseException {

		homeService.editbook(request);
		
		HttpSession session = request.getSession();
		List<Book> booksdata = homeService.getBooksdata();
		session.setAttribute("booksdata", booksdata);
		
		return "home";

	}

	@PostMapping("/delete")
	public String deletebook(HttpServletRequest request)
			throws IOException, org.json.simple.parser.ParseException, java.text.ParseException {
		homeService.deletebook(request);

		List<Book> booksdata = homeService.getBooksdata();

		HttpSession session = request.getSession();
		session.setAttribute("booksdata", booksdata);
		return "home";
	}

	@PostMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("username");
		session.invalidate();

		return "redirect:/";
	}

}



