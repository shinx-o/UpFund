package com.investor.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.investor.models.Investor;
import com.investor.services.InvestorService;
import com.manager.models.MutualFund;


@RestController
public class InvestorController {
	
	@Autowired
	InvestorService is;
	

	@RequestMapping(value="/investor/create",method=RequestMethod.POST)
	public String createInvestor(@RequestBody Investor i)
	{
		System.out.println("Calling Controller");
		String res = is.createInvestor(i);
		System.out.println(res);
		return res;
	}
	
	@RequestMapping(value="/investor/id/{id}",method=RequestMethod.GET)
	public Map<String,String> getInvestorById(@PathVariable("id") int investorId)
	{

		return is.getInvestorById(investorId);
	}
	
	
	@RequestMapping(value="/investor/id/{id}",method=RequestMethod.PUT)
	public String updateInvestorByIdCompletely(@PathVariable("id") int investorId, @RequestBody Investor i) {
		System.out.println("Update Investor Id received is "+investorId);
		return is.updateInvestorByIdCompletely(investorId,i);
	}
	
	@RequestMapping(value="/investor/id/{id}",method=RequestMethod.PATCH)
	public String updateInvestorById(@PathVariable("id") int investorId , @RequestBody Investor i) {
		System.out.println("Update Investor id received is "+investorId);
		return is.updateInvestorById(investorId,i);
	}
	
	@RequestMapping(value="/investor/id/{id}",method=RequestMethod.DELETE)
	
	public String deleteInvestorById(@PathVariable("id") int investorId)
	{
		return is.deleteInvestorById(investorId);
	}
	
}

