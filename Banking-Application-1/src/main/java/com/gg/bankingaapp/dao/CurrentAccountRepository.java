package com.gg.bankingaapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gg.bankingaapp.model.CurrentAccount;

@Repository
public interface CurrentAccountRepository extends JpaRepository<CurrentAccount, Long> {

	void saveBalanceByAcctID(Long acctID, Long amount);

	void withdrawAmountByAcctID(Long acctID, Long amount);

}
