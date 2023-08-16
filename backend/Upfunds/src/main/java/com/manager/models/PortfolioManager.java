package com.manager.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PortfolioManager {

@Id
private int portfolioManagerId;
@Column

private String managerUsername;
@Column

private String  managerPassword;

	


@Override
public String toString() {
	return "PortfolioManager [portfolioManagerId=" + portfolioManagerId + ", managerUsername=" + managerUsername
			+ ", managerPassword=" + managerPassword + "]";
}


public int getPortfolioManagerId() {
	return portfolioManagerId;
}


public void setPortfolioManagerId(int portfolioManagerId) {
	this.portfolioManagerId = portfolioManagerId;
}


public String getManagerUsername() {
	return managerUsername;
}


public void setManagerUsername(String managerUsername) {
	this.managerUsername = managerUsername;
}


public String getManagerPassword() {
	return managerPassword;
}


public void setManagerPassword(String managerPassword) {
	this.managerPassword = managerPassword;
}


public PortfolioManager(int portfolioManagerId, String managerUsername, String managerPassword) {
	super();
	this.portfolioManagerId = portfolioManagerId;
	this.managerUsername = managerUsername;
	this.managerPassword = managerPassword;
}


public PortfolioManager() {
	// TODO Auto-generated constructor stub
}

}
