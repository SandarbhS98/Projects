package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.boot.autoconfigure.ssl.JksSslBundleProperties.Store;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;

@Service
public class UserService {
	
	private List<User> store = new ArrayList<>();
	
	public UserService() {
		store.add(new User(UUID.randomUUID().toString(),"Om","king@gmail.com"));
		store.add(new User(UUID.randomUUID().toString(),"Jai","king@gmail.com"));
		store.add(new User(UUID.randomUUID().toString(),"Jagdesh","king@gmail.com"));
		
	}
	
	public List<User> getUsers() {
		
		return this.store;
		
	}

}
