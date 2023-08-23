package com.investor.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.investor.models.Investor;
import com.investor.services.InvestorService;
import com.manager.models.MutualFund;
import com.utilities.services.ExceptionHandler;

@RestController
public class InvestorController {

	@Autowired
	InvestorService is;

	@RequestMapping(value = "/investor/create", method = RequestMethod.POST)
	public ResponseEntity<?> createInvestor(@RequestBody Investor investor) {
		try {
			String res = is.createInvestor(investor);
			return new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), ExceptionHandler.resolveHttpStatus(e));
		}

	}

	@RequestMapping(value = "/investor/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getInvestorById(@PathVariable("id") int investorId) {
		try {
			Map<String, Object> res = is.getInvestorById(investorId);
			return new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), ExceptionHandler.resolveHttpStatus(e));
		}
	}

	@RequestMapping(value = "/investor/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateInvestorById(@PathVariable("id") int investorId, @RequestBody Investor i) {
		try {
			String res = is.updateInvestorById(investorId, i);
			return new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), ExceptionHandler.resolveHttpStatus(e));
		}
	}

	@RequestMapping(value = "/investor/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteInvestorById(@PathVariable("id") int investorId) {
		try {
			String res = is.deleteInvestorById(investorId);
			return new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), ExceptionHandler.resolveHttpStatus(e));
		}
	}

}
