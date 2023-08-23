package com.transactions.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.transaction.models.InvestorTransaction;
import com.transactions.services.TransactionService;
import com.utilities.services.ExceptionHandler;

@RestController
public class TransactionController {

	@Autowired
	TransactionService ts;

	@RequestMapping(value = "/transactions", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getAllTransactions() {
		try {
			List<InvestorTransaction> transactions = ts.getAllTransactions();
			return new ResponseEntity<>(transactions, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), ExceptionHandler.resolveHttpStatus(e));
 
		}

	}

	@RequestMapping(value = "/tranasctions/investor/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getInvestorTransactions(@PathVariable("id") int investorId) {
		try {
			List<InvestorTransaction> transactions = ts.getInvestorTransactions(investorId);
			return new ResponseEntity<>(transactions, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), ExceptionHandler.resolveHttpStatus(e));
 
		}
	}

	@RequestMapping(value = "/transaction/buy", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> createBuyTransaction(@RequestBody InvestorTransaction t) {
		try {
			InvestorTransaction transaction = ts.createBuyTransaction(t);
			return new ResponseEntity<>(transaction, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),ExceptionHandler.resolveHttpStatus(e));
 
		}
	}

	@RequestMapping(value = "/transaction/sell", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> createSellTransaction(@RequestBody InvestorTransaction t) {
		try {
			InvestorTransaction transaction = ts.createSellTransaction(t);
			return new ResponseEntity<>(transaction, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),ExceptionHandler.resolveHttpStatus(e));
 
		}
	}

}
