package com.gg.bankingaapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.gg.bankingaapp.model.Logger;
import com.gg.bankingaapp.service.LoggerService;

@RestController
public class LoggerController {

	@Autowired
	private LoggerService loggerService;
	
	public void addLog(Logger logger) {
		// TODO Auto-generated method stub
		loggerService.addLog(logger);
		
	}

	public void deleteLog(Long acctID) {
		// TODO Auto-generated method stub
		loggerService.deleteLog(acctID);	
	}
	
	@GetMapping("/account/{acctID}/logs")
	public Logger showLog(@PathVariable Long acctID) {
		return loggerService.showLog(acctID);
	}

}
