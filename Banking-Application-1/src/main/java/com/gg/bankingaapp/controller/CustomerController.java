package com.gg.bankingaapp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gg.bankingaapp.model.Customer;
import com.gg.bankingaapp.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private SavingsAccountController savingsAccountController;
	
	@Autowired
	private CurrentAccountController currentAccountController;
	
	@PostMapping("/customer")
	public void saveCustomer(@RequestBody Customer customer) {
		customerService.saveCustomer(customer);
		savingsAccountController.saveSavingsAccount(customer.getAcctID(), 1000.00, "active");
		currentAccountController.saveCurrentAccountController(customer.getAcctID(), 100000, "active");
		
	}
	@GetMapping("/customer/{acctID}")
	public Optional<Customer> getCustomerInfo(@PathVariable("acctId") Long acctId) {
		return customerService.getCustomerInfo(acctId);
		
	}
	
	@DeleteMapping("/customer/{acctID}")
	public void deleteCustomer(@PathVariable("acctID") Long acctID) {
		customerService.deleteCustomer(acctID);
	
	}
	
}
