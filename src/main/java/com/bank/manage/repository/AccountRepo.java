package com.bank.manage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.manage.entity.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {

}
