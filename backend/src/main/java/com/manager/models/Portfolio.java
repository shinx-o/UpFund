package com.manager.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.utilities.models.Stock;


@Entity
@Table(name = "PORTFOLIO")
public class Portfolio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "portfolio_seq")
	@SequenceGenerator(name = "portfolio_seq", sequenceName = "portfolio_id_seq", allocationSize = 1)
	private int portfolioId;
	
	@Column
	private int mutualFundId;
	
	@Column
	private int stockId;
	
	@Column
	private double weightage;

	public int getPortfolioId() {
		return portfolioId;
	}

	public void setPortfolioId(int portfolioId) {
		this.portfolioId = portfolioId;
	}

	public int getMutualFundId() {
		return mutualFundId;
	}

	public void setMutualFundId(int mutualFundId) {
		this.mutualFundId = mutualFundId;
	}

	public int getStockId() {
		return stockId;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

	public double getWeightage() {
		return weightage;
	}

	public void setWeightage(double weightage) {
		this.weightage = weightage;
	}

	public Portfolio() {
		super();
	}

	public Portfolio(int portfolioId, int mutualFundId, int stockId, double weightage) {
		super();
		this.portfolioId = portfolioId;
		this.mutualFundId = mutualFundId;
		this.stockId = stockId;
		this.weightage = weightage;
	}
}
