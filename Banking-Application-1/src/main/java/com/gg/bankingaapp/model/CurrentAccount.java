package com.gg.bankingaapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties
public class CurrentAccount {
	
	@Id
	private Long AccountID;
	private double currentAccountbalance;
	private String currentAccounttStatus;
	public Long getAccountID() {
		return AccountID;
	}
	public void setAccountID(Long accountID) {
		AccountID = accountID;
	}
	public double getCurrentAccountbalance() {
		return currentAccountbalance;
	}
	public void setCurrentAccountbalance(double currentAccountbalance) {
		this.currentAccountbalance = currentAccountbalance;
	}
	public String getCurrentAccounttStatus() {
		return currentAccounttStatus;
	}
	public void setCurrentAccounttStatus(String currentAccounttStatus) {
		this.currentAccounttStatus = currentAccounttStatus;
	}
	public CurrentAccount(Long accountID, double currentAccountbalance, String currentAccounttStatus) {
		super();
		AccountID = accountID;
		this.currentAccountbalance = currentAccountbalance;
		this.currentAccounttStatus = currentAccounttStatus;
	}
	public CurrentAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
