package com.Bank.details.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Bank.details.model.BankDTO;

public interface BankRespository extends JpaRepository<BankDTO , Integer> {

}
