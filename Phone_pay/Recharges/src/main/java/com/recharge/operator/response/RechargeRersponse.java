package com.recharge.operator.response;

import java.util.List;

import org.springframework.stereotype.Component;

import com.recharge.operator.model.RechargeDTO;

import lombok.Data;

@Component
@Data
public class RechargeRersponse {
	
	private int responsecode ;
	private boolean error;
	private List<RechargeDTO> dtos;
	

}
