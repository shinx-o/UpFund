package com.utilities.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "NAV_HISTORY")
public class NavHistory {
	
	@Id
	private int mutualFundId;
	
	@Column(insertable = false)
	private Date businessDate;
	
	@Column
	private double nav;

	public NavHistory(int mutualFundId, Date businessDate, double nav) {
		super();
		this.mutualFundId = mutualFundId;
		this.businessDate = businessDate;
		this.nav = nav;
	}

	@Override
	public String toString() {
		return "NavHistory [mutualFundId=" + mutualFundId + ", businessDate=" + businessDate + ", nav=" + nav + "]";
	}

	public int getMutualFundId() {
		return mutualFundId;
	}

	public void setMutualFundId(int mutualFundId) {
		this.mutualFundId = mutualFundId;
	}

	public Date getBusinessDate() {
		return businessDate;
	}

	public void setBusinessDate(Date businessDate) {
		this.businessDate = businessDate;
	}

	public double getNav() {
		return nav;
	}

	public void setNav(double nav) {
		this.nav = nav;
	}

	public NavHistory() {
		// TODO Auto-generated constructor stub
	}
}
