package com.transaction.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "INVESTOR_TRANSACTION")
public class InvestorTransaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_id_seq")
	@SequenceGenerator(name = "transaction_id_seq", sequenceName = "test_transaction_id_seq", allocationSize = 1)
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
	private double transactionAmount;
	
	@Column(insertable = false)
	private Date businessDate;

	public Date getBusiness_date() {
		return businessDate;
	}

	public void setBusiness_date(Date businessDate) {
		this.businessDate = businessDate;
	}

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

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	@Override
	public String toString() {
		return "InvestorTransaction [transactionId=" + transactionId + ", investorId=" + investorId + ", mutualFundId="
				+ mutualFundId + ", transactionType=" + transactionType + ", units=" + units + ", transactionAmount="
				+ transactionAmount + "]";
	}

	public InvestorTransaction(int transactionId, int investorId, int mutualFundId, String transactionType,
			double units, double transactionAmount, Date date) {
		super();
		this.transactionId = transactionId;
		this.investorId = investorId;
		this.mutualFundId = mutualFundId;
		this.transactionType = transactionType;
		this.units = units;
		this.transactionAmount = transactionAmount;
		this.businessDate = date;
	}

}
