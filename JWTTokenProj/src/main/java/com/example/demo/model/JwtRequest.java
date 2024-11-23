package com.example.demo.model;

import org.springframework.context.annotation.Configuration;

import lombok.Builder;

@Configuration
@Builder
public class JwtRequest {
	
	private String email;
	private String password;
	public String getEmail() {
		return email;
	}
	public JwtRequest() {
		super();
	}
	@Override
	public String toString() {
		return "JwtRequest [email=" + email + ", password=" + password + "]";
	}
	public JwtRequest(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}