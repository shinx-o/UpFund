package com.utilities.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.utilities.models.Stock;
import com.utilities.models.StockPrice;
import com.utilities.services.UtilityService;

@RestController
public class UtilityController {
	
	@Autowired
	UtilityService us;
	
	@RequestMapping(value = "stocks", consumes="application/json", produces="application/json", method = RequestMethod.GET)
	public List<Stock> getStocks(){
		
		return us.getAllStocks();
	}
	
	@RequestMapping(value = "/stockPrices",consumes="application/json", produces="application/json", method = RequestMethod.GET)
	public List<StockPrice> getStockPrices() {
		return us.getAllStockPrices();
	}
	
	@RequestMapping(value = "/login",consumes="application/json", produces="application/json", method=RequestMethod.POST)
	public Map<String, Boolean> loginUser(@RequestBody Map<String, String> hm) {
		return us.authenticateUser(hm);
	}
	
	
}
