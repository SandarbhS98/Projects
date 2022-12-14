package com.recharge.operator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recharge.operator.model.RechargeDTO;
import com.recharge.operator.pojo.BankDTO;
import com.recharge.operator.pojo.OperatorDTO;

@Repository
public interface RechargeRepository extends JpaRepository  <RechargeDTO, Integer>  {
	
	OperatorDTO save(OperatorDTO operatorDTO);
	//BankDTO save(BankDTO bankDTO);
	
}
