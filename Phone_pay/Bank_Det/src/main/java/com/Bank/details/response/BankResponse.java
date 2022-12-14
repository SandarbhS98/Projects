package com.Bank.details.response;

import java.util.List;

import org.springframework.stereotype.Component;

import com.Bank.details.model.BankDTO;

import lombok.Data;

@Component
@Data
public class BankResponse {
	
	private int responsecode;
	private boolean error;
	private List<BankDTO>dtos;

}
