package com.utilities.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StockPrice {

@Id
private int stockId;
@Column
private String businessDate;
@Column
private double openingPrice;
@Column
private double closingPrice;

public StockPrice(int stockId, String businessDate, double openingPrice, double closingPrice) {
	super();
	this.stockId = stockId;
	this.businessDate = businessDate;
	this.openingPrice = openingPrice;
	this.closingPrice = closingPrice;
}

@Override
public String toString() {
	return "StockPrice [stockId=" + stockId + ", businessDate=" + businessDate + ", openingPrice=" + openingPrice
			+ ", closingPrice=" + closingPrice + "]";
}

public int getStockId() {
	return stockId;
}

public void setStockId(int stockId) {
	this.stockId = stockId;
}

public String getBusinessDate() {
	return businessDate;
}

public void setBusinessDate(String businessDate) {
	this.businessDate = businessDate;
}

public double getOpeningPrice() {
	return openingPrice;
}

public void setOpeningPrice(double openingPrice) {
	this.openingPrice = openingPrice;
}

public double getClosingPrice() {
	return closingPrice;
}

public void setClosingPrice(double closingPrice) {
	this.closingPrice = closingPrice;
}

public StockPrice() {
	// TODO Auto-generated constructor stub
}

}
