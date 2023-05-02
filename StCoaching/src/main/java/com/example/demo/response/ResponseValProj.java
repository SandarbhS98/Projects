package com.example.demo.response;

import org.springframework.stereotype.Component;

import com.example.demo.model.StDetails;

@Component
public class ResponseValProj {
	
	private StDetails details;

	public StDetails getDetails() {
		return details;
	}

	public void setDetails(StDetails details) {
		this.details = details;
	}

}
