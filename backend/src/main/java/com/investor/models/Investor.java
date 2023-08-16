package com.investor.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Investor {
@Id
private int investorId;
@Column
private String investorPassword;
@Column
private String investorName;
@Column
private String investorEmail;
@Column
private int investorPhoneNumber;
	
public Investor(int investorId, String investorPassword, String investorName, String investorEmail,
		int investorPhoneNumber) {
	super();
	this.investorId = investorId;
	this.investorPassword = investorPassword;
	this.investorName = investorName;
	this.investorEmail = investorEmail;
	this.investorPhoneNumber = investorPhoneNumber;
}

public int getInvestorId() {
	return investorId;
}

public void setInvestorId(int investorId) {
	this.investorId = investorId;
}

public String getInvestorPassword() {
	return investorPassword;
}

public void setInvestorPassword(String investorPassword) {
	this.investorPassword = investorPassword;
}

public String getInvestorName() {
	return investorName;
}

public void setInvestorName(String investorName) {
	this.investorName = investorName;
}

public String getInvestorEmail() {
	return investorEmail;
}

public void setInvestorEmail(String investorEmail) {
	this.investorEmail = investorEmail;
}

public int getInvestorPhoneNumber() {
	return investorPhoneNumber;
}

public void setInvestorPhoneNumber(int investorPhoneNumber) {
	this.investorPhoneNumber = investorPhoneNumber;
}

@Override
public String toString() {
	return "Investor [investorId=" + investorId + ", investorPassword=" + investorPassword + ", investorName="
			+ investorName + ", investorEmail=" + investorEmail + ", investorPhoneNumber=" + investorPhoneNumber + "]";
}

public Investor() {
	// TODO Auto-generated constructor stub
}
}
