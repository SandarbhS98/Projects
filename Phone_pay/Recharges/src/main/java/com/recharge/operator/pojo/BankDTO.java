package com.recharge.operator.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
public class BankDTO {
	
	private int id;
	private String name;
	private String location;
	private Long accountno;
}
