package com.gg.bankingaapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gg.bankingaapp.dao.CustomerRepository;
import com.gg.bankingaapp.model.Customer;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	public void saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerRepository.save(customer);
	}

	public Optional<Customer> getCustomerInfo(Long acctId) {
		// TODO Auto-generated method stub
		return customerRepository.findById(acctId);
	}

	public void deleteCustomer(Long acctID) {
		// TODO Auto-generated method stub
		customerRepository.deleteById(acctID);
	}

}
