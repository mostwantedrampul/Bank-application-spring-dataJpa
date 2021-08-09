package com.gg.bankingaapp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gg.bankingaapp.model.Logger;
import com.gg.bankingaapp.model.SavingsAccount;
import com.gg.bankingaapp.service.SavingsAccountService;

@RestController
@RequestMapping
public class SavingsAccountController {

	@Autowired
	private SavingsAccountService savingsAccountService;
	@Autowired
	private LoggerController loggerController;
	
	public void saveSavingsAccount(Long acctID, double d, String string) {
		// TODO Auto-generated method stub
		
	}
	
	public void createAccount(@RequestBody Long acctID, double savingsAccountbalance, String acctStatus) {
		SavingsAccount sacct = new SavingsAccount(acctID , savingsAccountbalance, acctStatus);
		if(savingsAccountbalance>=1000) {
		savingsAccountService.createAccount(sacct);
		}
	}
	// checkBalance
		@GetMapping("/savingsaccount/{acctID}/balance")
		public int getSavingsBalance(@PathVariable Long acctID) {
			return savingsAccountService.getSavingsBalance(acctID);
		}

		// depositAmount
		@PutMapping("/savingsaccount/{acctID}/deposit/{amount}")
		public void depositAmount(@PathVariable Long acctID, @PathVariable Long amount) {
			int initBal = getSavingsBalance(acctID);
			savingsAccountService.depositAmount(acctID, amount);
			Logger logger = new Logger(acctID, "Deposited", "Success", initBal, initBal + amount);
			loggerController.addLog(logger);
		}
		
		// withdrawAmount
		@PutMapping("/savingsaccount/{acctID}/withdraw/{amount}")
		public void withdrawAmount(@PathVariable Long acctID, @PathVariable Long amount) {
			int initBal = getSavingsBalance(acctID);
			SavingsAccountService savingsAccountService2 = new SavingsAccountService();
			savingsAccountService2.withdrawAmount(acctID, amount);
			Logger logger = new Logger(acctID, "Withdrawn", "Success", initBal, initBal - amount);
			loggerController.addLog(logger);
		}
		// transferAmount
		@PutMapping("/savingsaccount/{acctID}/transfer/{destAcctID}/{amount}")
		public void transferAmount(@PathVariable Long acctID, @PathVariable Long destAcctID, @PathVariable Long amount) {
			int initBalSender = getSavingsBalance(acctID);
			int initBalReceiver = getSavingsBalance(destAcctID);
			savingsAccountService.transferAmount(acctID, destAcctID, amount);
			Logger loggerSender = new Logger(acctID, "Transferred", "Success", initBalSender, initBalSender - amount);
			loggerController.addLog(loggerSender);
			Logger loggerReceiver = new Logger(destAcctID, "Received", "Success", initBalReceiver,
					initBalReceiver + amount);
			loggerController.addLog(loggerReceiver);
		}
		
		// deleteAccount
		@DeleteMapping("/savingsaccount/{acctID}")
		public void deleteAccount(@PathVariable Long acctID) {
			savingsAccountService.deleteSavingsAccount(acctID);
			loggerController.deleteLog(acctID);
		}

		// getAccountInfo
		@GetMapping("/savingsaccount/{acctID}")
		public Optional<SavingsAccount> getAccountInfo(@PathVariable Long acctID) {
			return savingsAccountService.getAccountInfo(acctID);
		}
		
		
}
