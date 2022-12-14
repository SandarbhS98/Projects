package com.recharge.operator.response;

import java.util.List;

import org.springframework.stereotype.Component;

import com.recharge.operator.model.OperatorDTO;

import lombok.Data;

@Component
@Data
public class OperatorResponse {
	
	private int responsecode;
	private boolean error;
	private List<OperatorDTO> arrDtos;
	
}
