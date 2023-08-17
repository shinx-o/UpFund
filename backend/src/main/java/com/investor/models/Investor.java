package com.investor.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "INVESTOR")
public class Investor {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "investor_seq")
	@SequenceGenerator(name = "investor_seq", sequenceName = "investor_id_seq_new", allocationSize = 1)
	private int investorId;
	@Column(name = "PASSWORD")
	private String investorPassword;
	@Column(name = "NAME")
	private String investorName;
	@Column(name = "EMAIL")
	private String investorEmail;
	@Column(name = "PHONE_NUMBER")
	private int investorPhoneNumber;

	public Investor(String investorPassword, String investorName, String investorEmail,
			int investorPhoneNumber) {
		super();
		this.investorPassword = investorPassword;
		this.investorName = investorName;
		this.investorEmail = investorEmail;
		this.investorPhoneNumber = investorPhoneNumber;
	}

	public int getInvestorId() {
		return investorId;
	}

	public void setInvestorId(int investorId) {
		this.investorId = investorId;
	}

	public String getInvestorPassword() {
		return investorPassword;
	}

	public void setInvestorPassword(String investorPassword) {
		this.investorPassword = investorPassword;
	}

	public String getInvestorName() {
		return investorName;
	}

	public void setInvestorName(String investorName) {
		this.investorName = investorName;
	}

	public String getInvestorEmail() {
		return investorEmail;
	}

	public void setInvestorEmail(String investorEmail) {
		this.investorEmail = investorEmail;
	}

	public int getInvestorPhoneNumber() {
		return investorPhoneNumber;
	}

	public void setInvestorPhoneNumber(int investorPhoneNumber) {
		this.investorPhoneNumber = investorPhoneNumber;
	}

	@Override
	public String toString() {
		return "Investor [investorId=" + investorId + ", investorPassword=" + investorPassword + ", investorName="
				+ investorName + ", investorEmail=" + investorEmail + ", investorPhoneNumber=" + investorPhoneNumber
				+ "]";
	}

	public Investor() {
		// TODO Auto-generated constructor stub
	}
}
