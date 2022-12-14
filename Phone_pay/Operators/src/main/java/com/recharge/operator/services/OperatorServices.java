package com.recharge.operator.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.recharge.operator.model.OperatorDTO;
import com.recharge.operator.pojo.BankDTO;
import com.recharge.operator.repository.OperatorRepository;
import com.recharge.operator.response.OperatorResponse;
import com.recharge.operator.response.ResponseValueObject;

@Service
public class OperatorServices {
	
	@Autowired
	private OperatorRepository repository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ResponseValueObject valueObject;

	public OperatorDTO saveoperator(OperatorDTO dto) {
		return repository.save(dto);
	}
	public OperatorDTO fetchoperator(int id) {
		return repository.findById(id).orElse(null);
	}
	public ResponseValueObject fetchOperBankbyId(int id) {
		//ResponseValueObject valueObject = new ResponseValueObject();  +operdto.getId()
		OperatorDTO operdto= repository.findById(id).orElse(null);
		System.out.println("Id::"+operdto.getId());
		BankDTO bankDTO = restTemplate.getForObject("http://localhost:8072/api/Bank/fetchBank/" + operdto.getId(), BankDTO.class);
		valueObject.setOperatorDTO(operdto);
		valueObject.setBankDTO(bankDTO);
		return valueObject;
		
	}	
	
}
