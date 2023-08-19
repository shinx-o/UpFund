package com.utilities.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Stock")
public class Stock {
	
	@Id
	private int stockId;
	@Column
	private String stockName;
	
	
	
public Stock(int stockId, String stockName) {
		super();
		this.stockId = stockId;
		this.stockName = stockName;
	}



@Override
	public String toString() {
		return "Stock [stockId=" + stockId + ", stockName=" + stockName + "]";
	}



public int getStockId() {
		return stockId;
	}



	public void setStockId(int stockId) {
		this.stockId = stockId;
	}



	public String getStockName() {
		return stockName;
	}



	public void setStockName(String stockName) {
		this.stockName = stockName;
	}



public Stock() {
	// TODO Auto-generated constructor stub
}
}
