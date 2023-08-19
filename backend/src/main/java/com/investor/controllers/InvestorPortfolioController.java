package com.investor.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.investor.models.InvestorPortfolio;
import com.investor.services.InvestorPortfolioService;

@RestController
public class InvestorPortfolioController {

	@Autowired
	InvestorPortfolioService ips;

	@RequestMapping(value = "/investorportfolio", method = RequestMethod.GET, produces = "application/json")
	public List<InvestorPortfolio> getAllInvestments() {
		return ips.getAllInvestments();
	}

	@RequestMapping(value = "/investorportfolio/id/{id}", method = RequestMethod.GET, produces = "application/json")
	public List<InvestorPortfolio> getInvestmentsById(@PathVariable("id") int PortfolioId) {
		return ips.getInvestmentsById(PortfolioId);
	}

	@RequestMapping(value = "/investorportfolio/id/{id}", method = RequestMethod.PATCH, produces = "application/json")
	public String updateInvestorPortfolioById(@PathVariable("id") int PortfolioId, @RequestBody InvestorPortfolio ipf) {
		System.out.println("Investor protfolio updated sucessfully");
		return ips.updateInvestorPortfolioById(PortfolioId, ipf);
	}

}
