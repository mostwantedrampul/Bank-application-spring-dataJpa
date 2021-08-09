package com.gg.bankingaapp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gg.bankingaapp.model.CurrentAccount;
import com.gg.bankingaapp.model.Logger;
import com.gg.bankingaapp.service.CurrentAccountService;

@RestController
@RequestMapping("/")
public class CurrentAccountController {


	@Autowired
	private CurrentAccountService currentAccountService;
	@Autowired
	private LoggerController loggerController;
	
	public void saveCurrentAccountController(Long acctID, double d, String string) {
		// TODO Auto-generated method stub	
	}
	public void createAccount(Long acctID, double currentAccountbalance, String acctStatus) {
		CurrentAccount acct = new CurrentAccount(acctID , currentAccountbalance, acctStatus);
		currentAccountService.createCurrentAccount(acct);
	}
	// checkBalance
		@GetMapping("/currentaccount/{acctID}/balance")
		public int getCurrentBalance(@PathVariable Long acctID) {
			return currentAccountService.getCurrentBalance(acctID);
		}

		// depositAmount
		@PutMapping("/currentaccount/{acctID}/deposit/{amount}")
		public void depositAmount(@PathVariable Long acctID, @PathVariable Long amount, int savingsAccountbalance) {
			int initBal = getCurrentBalance(acctID);
			currentAccountService.depositAmount(acctID, amount);
			Logger logger = new Logger(acctID, "Deposited", "Success", initBal, initBal + amount );
			loggerController.addLog(logger);
		}
		
		// withdrawAmount
		@PutMapping("/currentaccount/{acctID}/withdraw/{amount}")
		public void withdrawAmount(@PathVariable Long acctID, @PathVariable Long amount) {
			int initBal = getCurrentBalance(acctID);
			currentAccountService.withdrawAmount(acctID, amount);
			Logger logger = new Logger(acctID, "Withdrawn", "Success", initBal, initBal - amount);
			loggerController.addLog(logger);
		}
		// transferAmount
		@PutMapping("/currentaccount/{acctID}/transfer/{destAcctID}/{amount}")
		public void transferAmount(@PathVariable Long acctID, @PathVariable Long destAcctID, @PathVariable Long amount) {
			int initBalSender = getCurrentBalance(acctID);
			int initBalReceiver = getCurrentBalance(destAcctID);
			currentAccountService.transferAmount(acctID, destAcctID, amount);
			Logger loggerSender = new Logger(acctID, "Transferred", "Success", initBalSender, initBalSender - amount);
			loggerController.addLog(loggerSender);
			Logger loggerReceiver = new Logger(destAcctID, "Received", "Success", initBalReceiver,
					initBalReceiver + amount);
			loggerController.addLog(loggerReceiver);
		}
		
		// deleteAccount
		@DeleteMapping("/currentaccount/{acctID}")
		public void deleteAccount(@PathVariable Long acctID) {
			currentAccountService.deleteCurrentAccount(acctID);
			loggerController.deleteLog(acctID);
		}

		// getAccountInfo
		@GetMapping("/currentaccount/{acctID}")
		public Optional<CurrentAccount> getAccountInfo(@PathVariable Long acctID) {
			return currentAccountService.getAccountInfo(acctID);
		}
		public void saveCurrentAccountController(Long acctID, int i, String string) {
			// TODO Auto-generated method stub
			
		}
}


