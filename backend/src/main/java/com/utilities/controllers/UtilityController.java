package com.utilities.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.utilities.models.Stock;
import com.utilities.models.StockPrice;
import com.utilities.services.ExceptionHandler;
import com.utilities.services.UtilityService;

@RestController
public class UtilityController {

	@Autowired
	UtilityService us;

	@RequestMapping(value = "/stocks", produces = "application/json", method = RequestMethod.GET)
	public ResponseEntity<?> getStocks() {
		try {
			List<Stock> res = us.getAllStocks();
			return new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), ExceptionHandler.resolveHttpStatus(e));
		}
	}

	@RequestMapping(value = "/stockPrices", consumes = "application/json", produces = "application/json", method = RequestMethod.GET)
	public ResponseEntity<?> getStockPrices() {
		try {
			List<StockPrice> res = us.getAllStockPrices();
			return new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), ExceptionHandler.resolveHttpStatus(e));
		}
	}

	@RequestMapping(value = "/login", consumes = "application/json", produces = "application/json", method = RequestMethod.POST)
	public ResponseEntity<?> loginUser(@RequestBody Map<String, String> hm) {
		try {
			Map<String, Boolean> res = us.authenticateUser(hm);
			return new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), ExceptionHandler.resolveHttpStatus(e));
		}
	}

}
