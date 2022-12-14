package com.Bank.details.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Bank.details.model.BankDTO;
import com.Bank.details.response.BankResponse;
import com.Bank.details.services.BankSservices;

@RestController
@RequestMapping("api/Bank")
public class BankController {

	@Autowired
	private BankSservices bankSservices;

	@Autowired
	private BankResponse response;

	@PostMapping("/Savenbank")
	public ResponseEntity<BankResponse> saveBank(@RequestBody BankDTO bankDTO) {
		BankDTO bankDTO2 = bankSservices.saveBank(bankDTO);
		if (bankDTO2 != null) {
			response.setResponsecode(200);
			response.setError(false);
			response.setDtos(Arrays.asList());

			return new ResponseEntity<BankResponse>(response, HttpStatus.OK);

		} else {
			response.setResponsecode(401);
			response.setError(true);
			response.setDtos(null);

			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/fetchBank/{id}")
	public ResponseEntity<BankResponse> fetchBankAcc(@PathVariable ("id") int id ){
		BankDTO bankDTO = bankSservices.fetchBankAcc(id);
		if (bankDTO!= null) {
			response.setResponsecode(200);
			response.setError(false);
			response.setDtos(Arrays.asList(bankDTO));
			
			return new ResponseEntity<BankResponse>(response, HttpStatus.OK);
			
		} else {
			response.setResponsecode(401);
			response.setError(true);
			response.setDtos(null);
			
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND) ;
		}
		
	}

}
