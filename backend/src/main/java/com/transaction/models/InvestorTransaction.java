package com.transaction.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class InvestorTransaction {
@Id
 private int transactionId;
@Column
 private int investorId;
@Column
 private int mutualFundId;
@Column
 private String transactionType;
@Column
 private double units;
@Column
 private int transactionAmount;
 
 public InvestorTransaction() {
	// TODO Auto-generated constructor stub
}

public int getTransactionId() {
	return transactionId;
}

public void setTransactionId(int transactionId) {
	this.transactionId = transactionId;
}

public int getInvestorId() {
	return investorId;
}

public void setInvestorId(int investorId) {
	this.investorId = investorId;
}

public int getMutualFundId() {
	return mutualFundId;
}

public void setMutualFundId(int mutualFundId) {
	this.mutualFundId = mutualFundId;
}

public String getTransactionType() {
	return transactionType;
}

public void setTransactionType(String transactionType) {
	this.transactionType = transactionType;
}

public double getUnits() {
	return units;
}

public void setUnits(double units) {
	this.units = units;
}

public int getTransactionAmount() {
	return transactionAmount;
}

public void setTransactionAmount(int transactionAmount) {
	this.transactionAmount = transactionAmount;
}

@Override
public String toString() {
	return "InvestorTransaction [transactionId=" + transactionId + ", investorId=" + investorId + ", mutualFundId="
			+ mutualFundId + ", transactionType=" + transactionType + ", units=" + units + ", transactionAmount="
			+ transactionAmount + "]";
}

public InvestorTransaction(int transactionId, int investorId, int mutualFundId, String transactionType, double units,
		int transactionAmount) {
	super();
	this.transactionId = transactionId;
	this.investorId = investorId;
	this.mutualFundId = mutualFundId;
	this.transactionType = transactionType;
	this.units = units;
	this.transactionAmount = transactionAmount;
}
 
}
