package com.gg.bankingaapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gg.bankingaapp.dao.SavingsAccountRepository;
import com.gg.bankingaapp.model.SavingsAccount;

@Service
public class SavingsAccountService {

	@Autowired
	private SavingsAccountRepository savingsAccountRepository;
	
	
	public void createAccount(SavingsAccount sacct) {
		// TODO Auto-generated method stub
		savingsAccountRepository.save(sacct);
	}
	public int getSavingsBalance(Long acctID) {
		// TODO Auto-generated method stub
		return 1000;
	}

	public void depositAmount(Long acctID, Long amount) {
		// TODO Auto-generated method stub
		savingsAccountRepository.saveBalanceByAcctID(acctID, amount);
		
	}

	public  void withdrawAmount(Long acctID, Long amount) {
		// TODO Auto-generated method stub
		savingsAccountRepository.withdrawAmountByAcctID(acctID, amount);
	}

	public void transferAmount(Long acctID, Long destAcctID, Long amount) {
		// TODO Auto-generated method stub
		savingsAccountRepository.withdrawAmountByAcctID(acctID, amount);
		savingsAccountRepository.saveBalanceByAcctID(destAcctID, amount);
	}

	
	public Optional<SavingsAccount> getAccountInfo(Long acctID) {
		// TODO Auto-generated method stub
		return savingsAccountRepository.findById(acctID);
	}

	public void deleteSavingsAccount(Long acctID) {
		// TODO Auto-generated method stub
		savingsAccountRepository.deleteById(acctID);
	}

}
