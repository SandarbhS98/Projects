package com.bank.manage.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.manage.dto.AccountDto;
import com.bank.manage.service.AccountService;

@RestController
@RequestMapping("/api/banking/")
public class AccountController {

	@Autowired
	private AccountService accservice;

	@PostMapping
	public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto) {
		return new ResponseEntity<AccountDto>(accservice.createAccount(accountDto), HttpStatus.CREATED);

	}

	@GetMapping("{id}")
	public ResponseEntity<AccountDto> getAccountById(@PathVariable("id") Long id) {
		return new ResponseEntity<AccountDto>(accservice.getAccById(id), HttpStatus.OK);

	}

	@PutMapping("{id}/deposite")
	public ResponseEntity<AccountDto> depositeBalance(@PathVariable("id") Long id,
			@RequestBody Map<String, Double> request) {
		Double amount = request.get("amount");
		AccountDto accountDto = accservice.depositeBal(id, amount);

		return ResponseEntity.ok(accountDto);

	}

	@PutMapping("{id}/withdraw")
	public ResponseEntity<AccountDto> withdrawBalance(@PathVariable("id") Long id,
			@RequestBody Map<String, Double> request) {
		Double amount = request.get("amount");
		AccountDto accountDto = accservice.withdrawBal(id, amount);

		return ResponseEntity.ok(accountDto);

	}

	@GetMapping("/")
	public ResponseEntity<List<AccountDto>> getAllAccounts() {
		List<AccountDto> getAllAcc = accservice.getAllAccountss();

		return ResponseEntity.ok(getAllAcc);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteAccountById(@PathVariable("id") Long id) {
		accservice.delAccbyId(id);
		return  ResponseEntity.ok("Deleted Successfully");

	}

}
