package com.gg.bankingaapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties
public class Logger {
	@Id
	private Long acctID;
	private String transacType;
	private String transacStatus;
	private int initBal;
	private Long finalBal;
	public Long getAcctID() {
		return acctID;
	}
	public void setAcctID(Long acctID) {
		this.acctID = acctID;
	}
	public String getTransacType() {
		return transacType;
	}
	public void setTransacType(String transacType) {
		this.transacType = transacType;
	}
	public String getTransacStatus() {
		return transacStatus;
	}
	public void setTransacStatus(String transacStatus) {
		this.transacStatus = transacStatus;
	}
	public int getInitBal() {
		return initBal;
	}
	public void setInitBal(int initBal) {
		this.initBal = initBal;
	}
	public Long getFinalBal() {
		return finalBal;
	}
	public void setFinalBal(Long finalBal) {
		this.finalBal = finalBal;
	}
	public Logger() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Logger(Long acctID, String transacType, String transacStatus, int initBal, Long finalBal) {
		super();
		this.acctID = acctID;
		this.transacType = transacType;
		this.transacStatus = transacStatus;
		this.initBal = initBal;
		this.finalBal = finalBal;
	}
	
	

}
