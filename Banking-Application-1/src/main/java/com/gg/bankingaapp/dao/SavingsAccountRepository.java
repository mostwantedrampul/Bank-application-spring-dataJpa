package com.gg.bankingaapp.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gg.bankingaapp.model.SavingsAccount;

@Repository
public interface SavingsAccountRepository extends JpaRepository<SavingsAccount, Long> {

	void saveBalanceByAcctID(Long acctID, Long amount);

	void withdrawAmountByAcctID1(Long acctID, Long amount);
	@Query("select balance from Accounts where acctID = ?1")
	public int findBalanceByAcctID(int acctID);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update SavingsAccounts set balance = balance+?2 where acctID=?1")
	public void saveBalanceByAcctID(int acctID, int balance);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update SavingsAccounts set balance = balance-?2 where acctID=?1")
	public void withdrawAmountByAcctID(Long acctID, Long balance);

}
