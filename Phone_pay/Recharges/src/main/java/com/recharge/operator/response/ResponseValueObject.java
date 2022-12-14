package com.recharge.operator.response;

import org.springframework.stereotype.Component;

import com.recharge.operator.model.RechargeDTO;
import com.recharge.operator.pojo.BankDTO;
import com.recharge.operator.pojo.OperatorDTO;

import lombok.Data;

@Component
@Data
public class ResponseValueObject {
	
	private RechargeDTO rechdto;
	private OperatorDTO operdto;
	//private BankDTO bankDTO;
	
}