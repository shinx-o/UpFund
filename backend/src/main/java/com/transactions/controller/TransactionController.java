package com.transactions.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.transaction.models.InvestorTransaction;
import com.transactions.services.TransactionService;



@RestController
public class TransactionController {
	
	@Autowired
	TransactionService ts;
	
	@RequestMapping(value="/transactions",method=RequestMethod.GET, produces= "application/json")
	public List<InvestorTransaction> getAllTransactions()
	{
	
		return ts.getAllTransactions();
		
	}
	@RequestMapping(value="/tranasctions/investor/{id}",method=RequestMethod.GET, produces="application/json")
	public List<InvestorTransaction> getInvestorTransactions(@PathVariable("id") int investorId)
	{
		return ts.getInvestorTransactions(investorId);
		
	}
	@RequestMapping(value="/transaction/buy",method=RequestMethod.POST, produces="application/json")
	public InvestorTransaction createBuyTransaction(@RequestBody InvestorTransaction t)
	{
		return ts.createBuyTransaction(t);
	}
	@RequestMapping(value="/transaction/sell",method=RequestMethod.POST, produces="application/json")
	public String createSellTransaction(@RequestBody InvestorTransaction t)
	{
		return ts.createSellTransaction(t);
	}
	

}
