package com.recharge.operator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recharge.operator.model.OperatorDTO;
import com.recharge.operator.pojo.BankDTO;

@Repository
public interface OperatorRepository extends JpaRepository<OperatorDTO, Integer> {
	
	BankDTO save(BankDTO bankDTO);

}
