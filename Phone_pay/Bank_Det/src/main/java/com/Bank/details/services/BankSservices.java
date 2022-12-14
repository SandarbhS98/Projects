package com.Bank.details.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.Bank.details.model.BankDTO;
import com.Bank.details.repository.BankRespository;
import com.Bank.details.response.BankResponse;
import com.Bank.details.response.ResponseValueObject;

@Service
public class BankSservices {
	
	@Autowired
	private BankRespository respository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ResponseValueObject responseValueObject;
	
	public BankDTO saveBank(BankDTO bankDTO) {
		return respository.save(bankDTO);
	}

	public BankDTO fetchBankAcc(int id) {
		return respository.findById(id).orElse(null);
	}

}
