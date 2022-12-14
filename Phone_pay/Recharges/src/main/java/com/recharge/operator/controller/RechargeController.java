package com.recharge.operator.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.recharge.operator.model.RechargeDTO;
import com.recharge.operator.response.RechargeRersponse;
import com.recharge.operator.response.ResponseValueObject;
import com.recharge.operator.services.RechargeServices;

@RestController
@RequestMapping("api/recharge")
public class RechargeController {
	
	@Autowired
	private RechargeRersponse response;
	
	@Autowired
	private RechargeServices services;
	
	@PostMapping("SaveRecharge")
	public ResponseEntity<RechargeRersponse> SavePlans(@RequestBody RechargeDTO dto ){	
		RechargeDTO dto2 = services.SavePlans(dto);
		if (dto2!=null) {
			response.setResponsecode(200);
			response.setError(false);	
			response.setDtos(Arrays.asList());
			return new ResponseEntity<RechargeRersponse>(response, HttpStatus.OK);	
		} else {
			response.setResponsecode(401);
			response.setError(true);
			response.setDtos(null);
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}	
	}
	@GetMapping("fetchRecharge/{id}")
	public ResponseEntity<RechargeRersponse> fetchoRecharge(@PathVariable("id") int id) {
		RechargeDTO dto = services.fetchRecharge(id);
		if (dto!= null) {
			response.setResponsecode(200);
			response.setError(false);
			response.setDtos(Arrays.asList(dto));	
			return new ResponseEntity<RechargeRersponse>(response, HttpStatus.OK);	
		} else {
			response.setResponsecode(401);
			response.setError(true);	
			response.setDtos(null);
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
	}
	@PutMapping("updateRecharge/{id}")
	public ResponseEntity<RechargeRersponse> updateRecharge(@RequestBody RechargeDTO dto){		
		RechargeDTO dto2= services.updateRecharge(dto);
		if (dto2!=null) {
			response.setResponsecode(200);
			response.setError(false);
			response.setDtos(Arrays.asList(dto2));
			
			return new ResponseEntity<RechargeRersponse>(response, HttpStatus.OK) ;
		} else {
			response.setResponsecode(404);
			response.setError(true);
			response.setDtos(null);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("fetchRechOperbyId/{id}")
	public ResponseValueObject fetchRechOperbyId(@PathVariable("id") int id) {
		return services.fetchRechOperbyId(id);
	}
	
	@GetMapping("fetchRechOperBankById/{id}")
	public ResponseValueObject fetchRechOperBankById (@PathVariable ("id") int id ) {
		return services.fetchRechOperBankById(id);
	}
	
//	@GetMapping("fetchRechBankbyId{id}")
//	public ResponseValueObject fetchRechBankbyId(@PathVariable ("id") int id ) {
//		return services.fetchRechBankbyId(id) ;
//	}
	
}
