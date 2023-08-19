package com.manager.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "MUTUAL_FUND")
public class MutualFund {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mutual_fund_seq")
	@SequenceGenerator(name = "mutual_fund_seq", sequenceName = "mutual_fund_id_seq", allocationSize = 1)
	private int mutualFundId;
	
	@Column(name = "MF_NAME")
	private String mutualFundName;
	
	@Column
	private double cashBalance;
	
	@Column
	private double entryLoad;
	
	@Column
	private double exitLoad;
	
	@Column
	private double expenseRatio;
	
	@Column
	private double prevNav;
	
	public double getPrevNav() {
		return prevNav;
	}

	public void setPrevNav(double prevNav) {
		this.prevNav = prevNav;
	}

	@Column(name = "LATEST_NAV")
	private double currentNav;
	
	@Column
	private double totalInvestment;
	
	@Column
	private double totalUnitsOutstanding;

	public MutualFund(int mutualFundId, String mutualFundName, double cashBalance, double entryLoad, double exitLoad,
			double expenseRatio,double prevNav, double currentNav, double totalInvestment, double totalUnitsOutstanding) {
		super();
		this.mutualFundId = mutualFundId;
		this.mutualFundName = mutualFundName;
		this.cashBalance = cashBalance;
		this.entryLoad = entryLoad;
		this.exitLoad = exitLoad;
		this.expenseRatio = expenseRatio;
		this.prevNav = prevNav;
		this.currentNav = currentNav;
		this.totalInvestment = totalInvestment;
		this.totalUnitsOutstanding = totalUnitsOutstanding;
	}

	public MutualFund() {
		super();
	}

	public int getMutualFundId() {
		return mutualFundId;
	}

	public void setMutualFundId(int mutualFundId) {
		this.mutualFundId = mutualFundId;
	}

	public String getMutualFundName() {
		return mutualFundName;
	}

	public void setMutualFundName(String mutualFundName) {
		this.mutualFundName = mutualFundName;
	}

	public double getCashBalance() {
		return cashBalance;
	}

	public void setCashBalance(double cashBalance) {
		this.cashBalance = cashBalance;
	}

	public double getEntryLoad() {
		return entryLoad;
	}

	public void setEntryLoad(double entryLoad) {
		this.entryLoad = entryLoad;
	}

	public double getExitLoad() {
		return exitLoad;
	}

	public void setExitLoad(double exitLoad) {
		this.exitLoad = exitLoad;
	}

	public double getExpenseRatio() {
		return expenseRatio;
	}

	public void setExpenseRatio(double expenseRatio) {
		this.expenseRatio = expenseRatio;
	}

	public double getCurrentNav() {
		return currentNav;
	}

	public void setCurrentNav(double currentNav) {
		this.currentNav = currentNav;
	}

	public double getTotalInvestment() {
		return totalInvestment;
	}

	public void setTotalInvestment(double totalInvestment) {
		this.totalInvestment = totalInvestment;
	}

	public double getTotalUnitsOutstanding() {
		return totalUnitsOutstanding;
	}

	public void setTotalUnitsOutstanding(double totalUnitsOutstanding) {
		this.totalUnitsOutstanding = totalUnitsOutstanding;
	}
	
	
	
	
	
}
