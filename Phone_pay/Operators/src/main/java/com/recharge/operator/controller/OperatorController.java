package com.recharge.operator.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recharge.operator.model.OperatorDTO;
import com.recharge.operator.response.OperatorResponse;
import com.recharge.operator.response.ResponseValueObject;
import com.recharge.operator.services.OperatorServices;

@RestController
@RequestMapping("api/operator")
public class OperatorController {

	@Autowired
	private OperatorServices services;

	@Autowired
	private OperatorResponse response;

	@PostMapping("/saveOperator")
	public ResponseEntity<OperatorResponse> saveOperator(@RequestBody OperatorDTO dto) {
		OperatorDTO dto2 = services.saveoperator(dto);
		if (dto2!= null) {
			response.setResponsecode(200);
			response.setError(false);
			response.setArrDtos(Arrays.asList());

			return new ResponseEntity<OperatorResponse>(response, HttpStatus.OK);

		} else {
			response.setResponsecode(401);
			response.setError(true);		
			response.setArrDtos(null);
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}

	}

//	@GetMapping("fetchOperator/{id}")
//	public ResponseEntity<OperatorResponse> fetchoperator(@PathVariable("id") int id) {
//		OperatorDTO dto = services.fetchoperator(id);
//		if (dto != null) {
//			response.setResponsecode(200);
//			response.setError(false);
//			response.setArrDtos(Arrays.asList(dto));
//
//			return new ResponseEntity<OperatorResponse>(response, HttpStatus.OK);
//
//		} else {
//			response.setError(true);
//			response.setResponsecode(401);
//			response.setArrDtos(null);
//			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
//		}
//	}
	
	@GetMapping("/fetchOperator/{id}")
	public OperatorDTO fetchOperator (@PathVariable("id") int id){
		return services.fetchoperator(id);			
	}

	@GetMapping("/fetchOperBankbyId/{id}")
	public ResponseValueObject fetchOperBankbyId(@PathVariable ("id") int id ) {
		return services.fetchOperBankbyId(id);
	}
}
