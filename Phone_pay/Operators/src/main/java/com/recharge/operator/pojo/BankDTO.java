package com.recharge.operator.pojo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class BankDTO {
	
	private int id;
	private String name;
	private String location;
	private Long accountno;

}
