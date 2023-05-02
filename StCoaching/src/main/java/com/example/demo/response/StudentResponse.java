package com.example.demo.response;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.model.StDetails;

@Component
public class StudentResponse {

	private int responsecode;
	private boolean error;
	private String message;
	private List<StDetails> dtos;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getResponsecode() {
		return responsecode;
	}

	public void setResponsecode(int responsecode) {
		this.responsecode = responsecode;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public List<StDetails> getDtos() {
		return dtos;
	}

	public void setDtos(List<StDetails> dtos) {
		this.dtos = dtos;
	}


}
