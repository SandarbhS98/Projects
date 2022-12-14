package com.recharge.operator.response;

import org.springframework.stereotype.Component;

import com.recharge.operator.model.OperatorDTO;
import com.recharge.operator.pojo.BankDTO;

import lombok.Data;

@Component
@Data
public class ResponseValueObject {
	
	private OperatorDTO operatorDTO;
	private BankDTO bankDTO;

}
