package com.bank.manage.mapperr;

import com.bank.manage.dto.AccountDto;
import com.bank.manage.entity.Account;


public class AccountMapper {

	public static AccountDto maptoAccountdto(Account account) {

		return new AccountDto(account.getId(), account.getName(), account.getBalance());

	}
//
//	public static Account maptoAccount(AccountDto dto) {
//		return new Account(dto.getId(), dto.getName(), dto.getBalance());
//
//	}
	// After Record class
	public static Account maptoAccount(AccountDto dto) {
		return new Account(dto.id(), dto.name(), dto.balance());

	}

}
