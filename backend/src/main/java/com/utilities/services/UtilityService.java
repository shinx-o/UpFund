package com.utilities.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.investor.models.Investor;
import com.repository.InvestorRepository;

@Service
public class UtilityService {
	
	@Autowired
	InvestorRepository ir;
	
	public Map<String, Boolean> authenticateUser(Map<String, String> hm) {
		String email = hm.get("username");
		String password = hm.get("password");
		
		Map<String, Boolean> res = new HashMap<>();
		
		if (email.equals("shinixAdmin") && password.equals("adminPassword")) {
			res.put("isAdmin", true);
			res.put("authenticated", true);
			return res;
		}
		ArrayList<Investor> list = (ArrayList<Investor>) ir.findAll();
		System.out.println(list);
		for (Investor investor : list) {
			if(investor.getInvestorEmail().equals(email) && investor.getInvestorPassword().equals(password)) {
				res.put("isAdmin", false);
				res.put("authenticated", true);
				return res;
			}
		}
		
		res.put("isAdmin", false);
		res.put("authenticated", false);
		return res;
	}
}
