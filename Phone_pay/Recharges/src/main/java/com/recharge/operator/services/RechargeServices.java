package com.recharge.operator.services;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.recharge.operator.model.RechargeDTO;
import com.recharge.operator.pojo.BankDTO;
import com.recharge.operator.pojo.OperatorDTO;
import com.recharge.operator.repository.RechargeRepository;
import com.recharge.operator.response.RechargeRersponse;
import com.recharge.operator.response.ResponseValueObject;

@Service
public class RechargeServices {
	
	@Autowired
	private RechargeRepository repository;
	
	@Autowired
	private ResponseValueObject valueObject;
	
	@Autowired
	private RestTemplate template; 

	public RechargeDTO SavePlans(RechargeDTO dto) {
		return repository.save(dto);
	}

	public RechargeDTO fetchRecharge(int id) {
		return repository.findById(id).orElse(null) ;
	}

	public RechargeDTO updateRecharge(RechargeDTO dto) {
		return repository.save(dto);
	}
	
	public ResponseValueObject fetchRechOperBankById(int id) {
		ResponseValueObject responseValueObject = new ResponseValueObject();
		RechargeDTO rechargeDTO = repository.findById(id).orElse(null);
		OperatorDTO operatorDTO = template.getForObject("http://localhost:8071/api/operator/fetchOperBankbyId/" + rechargeDTO.getId(), OperatorDTO.class);
		responseValueObject.setRechdto(rechargeDTO);
		responseValueObject.setOperdto(operatorDTO);
		return responseValueObject;
	}
	public ResponseValueObject fetchRechOperbyId(int id) {
		//ResponseValueObject respoValObj = new ResponseValueObject();
		RechargeDTO rechdto= repository.findById(id).orElse(null);
		OperatorDTO operdto = template.getForObject("http://localhost:8071/api/operator/fetchOperator/" + rechdto.getId() , OperatorDTO.class);
		valueObject.setRechdto(rechdto);
		valueObject.setOperdto(operdto);
		return valueObject;
	}

//	public ResponseValueObject fetchRechBankbyId(int id) {
//		RechargeDTO rechdto= repository.findById(id).orElse(null);
//		//OperatorDTO dto = repository.findById(id).orElse(null);
//		BankDTO bankDTO = template.getForObject("http://localhost:8072/api/Bank/fetchBank/" + rechdto.getId()   , BankDTO.class);
//		valueObject.setRechdto(rechdto);
//		valueObject.setBankDTO(bankDTO);
//		return valueObject;
//	}

	
}
