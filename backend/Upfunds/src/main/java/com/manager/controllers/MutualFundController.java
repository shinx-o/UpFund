package com.manager.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.manager.models.MutualFund;

@RestController
public class MutualFundController {
	
	@Autowired
	MutualFundService ms;
	
	@RequestMapping(value="/mutualfunds/create",method=RequestMethod.POST)
	public String createMutualFund(@RequestBody MutualFund m)
	{
		return ms.createMutualFund(m);
	}
	@RequestMapping(value="/mutualfunds",method=RequestMethod.GET, produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ArrayList<MutualFund> getAllMutualFund()
	{
	
		return ms.getAllMutualFund();
		
	}
	@RequestMapping(value="/mutualfunds/id/{id}",method=RequestMethod.GET)
	public MutualFund getMutualFundById(@PathVariable("id") int mId)
	{

		return ms.getMutualFundById(mId);
	}
	
	@RequestMapping(value="/mutualfunds/name/{name}",method=RequestMethod.GET)
	public MutualFund getMutualFundByName(@PathVariable("name") String name)
	{

		return ms.getMutualFundByName(name);
	}
	@RequestMapping(value="/mutualfunds/id/{id}",method=RequestMethod.PUT)
	public String updateMutualFundByIdCompletely(@PathVariable("id") int mId, @RequestBody MutualFund m) {
		System.out.println("Update id received is "+mId);
		return ms.updateMutualFundByIdCompletely(mId, m);
	}
	
	@RequestMapping(value="/mutualfunds/id/{id}",method=RequestMethod.PATCH)
	public String updateMutualFundById(@PathVariable("id") int cid, @RequestBody MutualFund m ) {
		System.out.println("Update id received is "+mId);
		return ms.updateMutualFundById(mId, m);
	}
	@RequestMapping(value="/mutualfunds/name/{name}",method=RequestMethod.PUT)
	public String updateMutualFundByNameCompletely(@PathVariable("name") String name, @RequestBody MutualFund m) {
		System.out.println("Update name received is "+name);
		return ms.updateMutualFundByIdCompletely(name, m);
	}
	
	@RequestMapping(value="/mutualfunds/name/{name}",method=RequestMethod.PATCH)
	public String updateMutualFundByName(@PathVariable("name") String name, @RequestBody MutualFund m ) {
		System.out.println("Update name received is "+name);
		return ms.updateMutualFundByName(name, m);
	}
	
	
	

}
