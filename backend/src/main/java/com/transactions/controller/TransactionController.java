package com.transactions.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
	@RequestMapping(value="/transactions",method=RequestMethod.GET, produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public String getAllTransactions()
	{
	
		return ts.getAllTransactions();
		
	}
	@RequestMapping(value="/tranasctions/investor",method=RequestMethod.GET, produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public String getInvestorTransactions()
	{
	
		return ts.getInvestorTransactions(0);
		
	}
	@RequestMapping(value="/transaction/buy",method=RequestMethod.POST)
	public String createBuyTransaction(@RequestBody InvestorTransaction t)
	{
		return ts.createBuyTransaction(t);
	}
	@RequestMapping(value="/transaction/sell",method=RequestMethod.POST)
	public String createSellTransaction(@RequestBody InvestorTransaction t)
	{
		return ts.createSellTransaction(t);
	}
	

}