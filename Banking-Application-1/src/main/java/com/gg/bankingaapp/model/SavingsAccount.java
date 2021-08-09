package com.gg.bankingaapp.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties
@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]")

public class SavingsAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long AccountID;
	private double savingsAccountbalance;
	private String savingsAccounttStatus;
	private LocalDateTime updatedTime;
	public LocalDateTime getUpdatedTime() {
		return updatedTime;
	}
	public SavingsAccount(LocalDateTime updatedTime) {
		super();
		this.updatedTime = updatedTime;
	}
	public String getSavingsAccounttStatus() {
		return savingsAccounttStatus;
	}
	public void setSavingsAccounttStatus(String savingsAccounttStatus) {
		this.savingsAccounttStatus = savingsAccounttStatus;
	}
	public void setUpdatedTime(LocalDateTime updatedTime) {
		this.updatedTime = updatedTime;
	}
	public Long getAccountID() {
		return AccountID;
	}
	public void setAccountID(Long accountID) {
		AccountID = accountID;
	}
	
	
	public double getSavingsAccountbalance() {
		return savingsAccountbalance;
	}
	public void setSavingsAccountbalance(double savingsAccountbalance) {
		this.savingsAccountbalance = savingsAccountbalance;
	}
	public String getSavindsAccounttStatus() {
		return savingsAccounttStatus;
	}
	public void setSavindsAccounttStatus(String savindsAccounttStatus) {
		this.savingsAccounttStatus = savindsAccounttStatus;
	}
	public SavingsAccount(Long accountID, double savingsAccountbalance,
			String savindsAccounttStatus) {
		super();
		AccountID = accountID;
		this.savingsAccountbalance = savingsAccountbalance;
		this.savingsAccounttStatus = savindsAccounttStatus;
	}
	public SavingsAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
