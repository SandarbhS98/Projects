package com.recharge.operator.pojo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
public class OperatorDTO {
	
	private int id;
	private String operatorname;
	private String location;
	private int bankid;

}
