package com.example.demo.controller;

import java.security.Principal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/home")
public class HomeController {
	
	//Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private UserService service;

    @GetMapping("/test")
    public String test() {
      //  this.logger.warn("This is working message");
        System.out.println("This is working message");
        return "Testing message";
    }
    
    @GetMapping("/users")
    public List<User> getUser() {
      //  this.logger.warn("This is working message");
        System.out.println("This is working message");
        return service.getUsers();
    }
    
    @GetMapping("/current-user")
    public String getLoggedInUser(Principal principal) {
        return principal.getName();
    }
    

}
