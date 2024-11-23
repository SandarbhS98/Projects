package com.bank.manage.service;

import java.util.List;

import com.bank.manage.dto.AccountDto;


public interface AccountService {

	AccountDto createAccount(AccountDto accountDto);

	AccountDto getAccById(Long id);

	AccountDto depositeBal(Long id, double amount);

	AccountDto withdrawBal(Long id, double amount);

	List<AccountDto> getAllAccountss();

	void delAccbyId(Long id);



	

}
