package com.utilities.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.investor.models.Investor;
import com.repository.InvestorRepository;
import com.repository.StockPriceRepository;
import com.repository.StockRepository;
import com.utilities.models.Stock;
import com.utilities.models.StockPrice;

@Service
public class UtilityService {
	
	@Autowired
	InvestorRepository ir;
	
	@Autowired
	StockPriceRepository spr;
	
	@Autowired
	StockRepository sr;
	
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
	
	
	public List<StockPrice> getAllStockPrices() {
		List<StockPrice> response = spr.findStocksAndPrices();
		
		return response;
	}
	
	public List<Stock> getAllStocks() {
		List<Stock> response = sr.findAll();
		return response;
	}
}
