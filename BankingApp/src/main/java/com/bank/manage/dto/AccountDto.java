package com.bank.manage.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//public class AccountDto {
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private long id;
//	private String name;
//	private double balance;
//	public long getId() {
//		return id;
//	}
//	public void setId(long id) {
//		this.id = id;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public double getBalance() {
//		return balance;
//	}
//	public void setBalance(double balance) {
//		this.balance = balance;
//	}
//	@Override
//	public String toString() {
//		return "AccountDto [id=" + id + ", name=" + name + ", balance=" + balance + "]";
//	}
//	public AccountDto(long id, String name, double balance) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.balance = balance;
//	}
//}
public record AccountDto(long id, String name, double balance) {

}