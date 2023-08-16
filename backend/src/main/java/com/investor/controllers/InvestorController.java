package com.investor.controllers;

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
		return is.createInvestor(i);
	}
	@RequestMapping(value="/investor/id/{id}",method=RequestMethod.GET)
	public String getInvestorById(@PathVariable("id") int investorId)
	{

		return is.getInvestorById(investorId);
	}
	
	@RequestMapping(value="/investor/name/{name}",method=RequestMethod.GET)
	public String getInvestorByName(@PathVariable("name") String name)
	{

		return is.getInvestorByName(name);
	}
	@RequestMapping(value="/investor/id/{id}",method=RequestMethod.PUT)
	public String updateInvestorByIdCompletely(@PathVariable("id") int investorId, @RequestBody Investor i) {
		System.out.println("Update Investor Id received is "+investorId);
		return is.updateInvestorByIdCompletely(i, investorId);
	}
	
	@RequestMapping(value="/investor/id/{id}",method=RequestMethod.PATCH)
	public String updateInvestorById(@PathVariable("id") int investorId , @RequestBody Investor i) {
		System.out.println("Update Investor id received is "+investorId);
		return is.updateInvestorById(i, investorId);
	}
	
	@RequestMapping(value="/investor/name/{name}",method=RequestMethod.PUT)
	public String updateInvestorByNameCompletely(@PathVariable("name") String name, @RequestBody Investor i) {
		System.out.println("Update Investor name received is "+name);
		return is.updateInvestorByNameCompletely(i,name);
	}
	
	@RequestMapping(value="/investor/email/{email}",method=RequestMethod.PUT)
	public String updateInvestorByEmailCompletely(@PathVariable("email") String email, @RequestBody Investor i) {
		System.out.println("Update Investor Email received is "+email);
		return is.updateInvestorByEmailCompletely(i,email);
	}
	
	@RequestMapping(value="/investor/email/{email}",method=RequestMethod.PATCH)
	public String updateInvestorByEmail(@PathVariable("email") String email , @RequestBody Investor i) {
		System.out.println("Update Investor Email received is "+email);
		return is.updateInvestorByEmail(i, email);
	}
	
	
	@RequestMapping(value="/investor/phoneNumber/{phoneNumber}",method=RequestMethod.PUT)
	public String updateInvestorByPhoneNumberCompletely(@PathVariable("phoneNumber") int phoneNumber, @RequestBody Investor i) {
		System.out.println("Update Investor Phone Number received is "+phoneNumber);
		return is.updateInvestorByPhoneNumberCompletely(i,phoneNumber);
	}
	
	@RequestMapping(value="/investor/phoneNumber/{phoneNumber}",method=RequestMethod.PATCH)
	public String updateInvestorByPhoneNumber(@PathVariable("phoneNumber") int phoneNumber, @RequestBody Investor i) {
		System.out.println("Update PhoneNumber received is "+phoneNumber);
		return is.updateInvestorByPhoneNumber(i, phoneNumber);
	}
	

	
}
