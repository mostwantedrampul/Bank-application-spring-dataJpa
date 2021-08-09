package com.gg.bankingaapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties
public class Customer {
	
	@Id
	private Long acctID;
	private String custName;
	private String city;
	private String state;
	private String country;
	private Long phoneNo;
	private String username;
	private String password;
	public Long getAcctID() {
		return acctID;
	}
	public void setAcctID(Long acctID) {
		this.acctID = acctID;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Customer(Long acctID, String custName, String city, String state, String country, Long phoneNo,
			String username, String password) {
		super();
		this.acctID = acctID;
		this.custName = custName;
		this.city = city;
		this.state = state;
		this.country = country;
		this.phoneNo = phoneNo;
		this.username = username;
		this.password = password;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
