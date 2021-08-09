package com.gg.bankingaapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gg.bankingaapp.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
