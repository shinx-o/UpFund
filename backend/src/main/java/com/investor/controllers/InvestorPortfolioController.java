package com.investor.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.investor.models.InvestorPortfolio;
import com.investor.services.InvestorPortfolioService;
import com.utilities.services.ExceptionHandler;

@RestController
public class InvestorPortfolioController {

	@Autowired
	InvestorPortfolioService ips;

	@RequestMapping(value = "/investorportfolio", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getAllInvestments() {
		try {
			List<InvestorPortfolio> folios =  ips.getAllInvestments();
			return new ResponseEntity<>(folios , HttpStatus.OK);
			
		}catch(Exception e) {
			return new ResponseEntity<>(e.getMessage() ,ExceptionHandler.resolveHttpStatus(e));

		}
	}

	@RequestMapping(value = "/investorportfolio/{id}", method = RequestMethod.GET, produces = "application/json")
	public  ResponseEntity<?> getInvestmentsById(@PathVariable("id") int investorPortfolioId) {
		try {
			List<InvestorPortfolio> folios =  ips.getInvestmentsById(investorPortfolioId);
			return new ResponseEntity<>(folios , HttpStatus.OK);
			
		}catch(Exception e) {
			return new ResponseEntity<>(e.getMessage() ,ExceptionHandler.resolveHttpStatus(e));

		}
	}

}
