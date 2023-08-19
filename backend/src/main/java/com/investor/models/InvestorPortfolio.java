package com.investor.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "INVESTOR_PORTFOLIO")
public class InvestorPortfolio {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "portfolio_seq")
	@SequenceGenerator(name = "portfolio_seq", sequenceName = "test_investor_portfolio_id_seq", allocationSize = 1)
	private int investorPortfolioId;
	
	@Column
	private int investorId;
	
	@Column
	private int mutualFundId;
	
	@Column
	private double units;
	
	@Column
	private double totalInvestment;

	public InvestorPortfolio(int investorPortfolioId, int investorId, int mutualFundId, double units,
			double totalInvestment) {
		super();
		this.investorPortfolioId = investorPortfolioId;
		this.investorId = investorId;
		this.mutualFundId = mutualFundId;
		this.units = units;
		this.totalInvestment = totalInvestment;
	}

	public int getInvestorId() {
		return investorId;
	}

	public void setInvestorId(int investorId) {
		this.investorId = investorId;
	}

	public InvestorPortfolio() {
		// TODO Auto-generated constructor stub
	}

	public int getInvestorPortfolioId() {
		return investorPortfolioId;
	}

	public void setInvestorPortfolioId(int investorPortfolioId) {
		this.investorPortfolioId = investorPortfolioId;
	}

	public int getMutualFundId() {
		return mutualFundId;
	}

	public void setMutualFundId(int mutualFundId) {
		this.mutualFundId = mutualFundId;
	}

	public double getUnits() {
		return units;
	}

	public void setUnits(double units) {
		this.units = units;
	}

	public double getTotalInvestment() {
		return totalInvestment;
	}

	public void setTotalInvestment(double totalInvestment) {
		this.totalInvestment = totalInvestment;
	}

}
