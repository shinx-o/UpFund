package com.utilities.services;

public class StocksJsonRequest {
	private int stockId;
	private double weightage;

	public StocksJsonRequest() {
		super();
	}

	public StocksJsonRequest(int stockId, double weightage) {
		super();
		this.stockId = stockId;
		this.weightage = weightage;
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

}
