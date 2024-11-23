package com.bank.manage.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.bank.manage.dto.AccountDto;
import com.bank.manage.entity.Account;
import com.bank.manage.exception.AccountException;
import com.bank.manage.mapperr.AccountMapper;
import com.bank.manage.repository.AccountRepo;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepo repo;

	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		Account account = AccountMapper.maptoAccount(accountDto);
		Account saveAcc = repo.save(account);
		return AccountMapper.maptoAccountdto(saveAcc);
	}

	@Override
	public AccountDto getAccById(Long id) {
	//	Account getAcc = repo.findById(id).orElseThrow(null);
		Account getAcc = repo.findById(id).orElseThrow(()-> new AccountException("Acc does not exist"));
		return AccountMapper.maptoAccountdto(getAcc);
	}

	@Override
	public AccountDto depositeBal(Long id, double amount) {
	//	Account account = repo.findById(id).orElseThrow(() -> new RuntimeException("Account does not exist")); // before custom exc
		Account account = repo.findById(id).orElseThrow(() -> new AccountException("Account does not exist"));
		// orElseThrow.setBalance(0);
		double total = account.getBalance() + amount;
		account.setBalance(total);
		Account saveacc = repo.save(account);
		return AccountMapper.maptoAccountdto(saveacc);
	}

	@Override
	public AccountDto withdrawBal(Long id, double amount) {
		Account account = repo.findById(id).orElseThrow(() -> new AccountException("Account does not exist"));
		// orElseThrow.setBalance(0);
		if (account.getBalance()< amount) {
			throw new RuntimeException("Insufficient Balace");
		}
		double total = account.getBalance() - amount;
		account.setBalance(total);
		Account saveacc = repo.save(account);
		return AccountMapper.maptoAccountdto(saveacc);
	}

	@Override
	public List<AccountDto> getAllAccountss() {
		List<Account> all = repo.findAll();
		return all.stream().map((Account) -> AccountMapper.maptoAccountdto(Account)).collect(Collectors.toList());
	}

	@Override
	public void delAccbyId(Long id) {
		 repo.findById(id).orElseThrow(() -> new AccountException("Acc does not exist"));
		 repo.deleteById(id);
	}

}
