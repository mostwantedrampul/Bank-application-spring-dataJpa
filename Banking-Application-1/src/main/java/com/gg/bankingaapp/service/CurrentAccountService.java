package com.gg.bankingaapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gg.bankingaapp.dao.CurrentAccountRepository;
import com.gg.bankingaapp.model.CurrentAccount;

@Service
public class CurrentAccountService {
	
	@Autowired
	private CurrentAccountRepository currentAccountRepository;

	public void createCurrentAccount(CurrentAccount acct) {
		// TODO Auto-generated method stub
		currentAccountRepository.save(acct);
	}
	public int getCurrentBalance(Long acctID) {
		// TODO Auto-generated method stub
		return 100000;
	}

	public void depositAmount(Long acctID, Long amount) {
		// TODO Auto-generated method stub
		currentAccountRepository.saveBalanceByAcctID(acctID, amount);
		
	}
	public void withdrawAmount(Long acctID, Long amount) {
		// TODO Auto-generated method stub
		currentAccountRepository.withdrawAmountByAcctID(acctID, amount);
		
	}

	public void transferAmount(Long acctID, Long destAcctID, Long amount) {
		// TODO Auto-generated method stub
		
		currentAccountRepository.withdrawAmountByAcctID(acctID, amount);
		currentAccountRepository.saveBalanceByAcctID(destAcctID, amount);
	}
	public void deleteCurrentAccount(Long acctID) {
		// TODO Auto-generated method stub
		currentAccountRepository.deleteById(acctID);
	}
	public Optional<CurrentAccount> getAccountInfo(Long acctID) {
		// TODO Auto-generated method stub
		return currentAccountRepository.findById(acctID);
	}

}
