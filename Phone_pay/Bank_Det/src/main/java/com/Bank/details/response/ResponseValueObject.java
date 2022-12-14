package com.Bank.details.response;

import org.springframework.stereotype.Component;

import com.Bank.details.model.BankDTO;

import lombok.Data;

@Component
@Data
public class ResponseValueObject {
	
	private BankDTO bankDTO;

}
