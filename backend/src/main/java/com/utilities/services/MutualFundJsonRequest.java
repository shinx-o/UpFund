package com.utilities.services;

import java.util.List;
import java.util.Map;

public class MutualFundJsonRequest {
	private String mutualFundName;
	private double entryLoad;
	private double exitLoad;
	private double expenseRatio;
	private List<StocksJsonRequest> stocks;

	public MutualFundJsonRequest(String mutualFundName, double entryLoad, double exitLoad, double expenseRatio,
			List<StocksJsonRequest> stocks) {
		super();
		this.mutualFundName = mutualFundName;
		this.entryLoad = entryLoad;
		this.exitLoad = exitLoad;
		this.expenseRatio = expenseRatio;
		this.stocks = stocks;
	}

	public String getMutualFundName() {
		return mutualFundName;
	}

	public void setMutualFundName(String mutualFundName) {
		this.mutualFundName = mutualFundName;
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

	public List<StocksJsonRequest> getStocks() {
		return stocks;
	}

	public void setStocks(List<StocksJsonRequest> stocks) {
		this.stocks = stocks;
	}

	public MutualFundJsonRequest() {
		super();
	}

}
