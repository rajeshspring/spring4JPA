package com.medic.model;

import java.util.Date;

public class BankDetails 
{

	private long bank_id;
	private String bank_name;
	private String bank_address;
	private String bank_email;
	private String bank_phone;
	private long countryId;
	private long stateId;
	private Date bankOpenDate;
	private boolean active;
	
	
	
	
	
	public long getBank_id() {
		return bank_id;
	}
	public void setBank_id(long bank_id) {
		this.bank_id = bank_id;
	}
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	public String getBank_address() {
		return bank_address;
	}
	public void setBank_address(String bank_address) {
		this.bank_address = bank_address;
	}
	public String getBank_email() {
		return bank_email;
	}
	public void setBank_email(String bank_email) {
		this.bank_email = bank_email;
	}
	public String getBank_phone() {
		return bank_phone;
	}
	public void setBank_phone(String bank_phone) {
		this.bank_phone = bank_phone;
	}
	public long getCountryId() {
		return countryId;
	}
	public void setCountryId(long countryId) {
		this.countryId = countryId;
	}
	public long getStateId() {
		return stateId;
	}
	public void setStateId(long stateId) {
		this.stateId = stateId;
	}
	public Date getBankOpenDate() {
		return bankOpenDate;
	}
	public void setBankOpenDate(Date bankOpenDate) {
		this.bankOpenDate = bankOpenDate;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	
}
