package com.manager.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.manager.models.MutualFund;
import com.manager.services.MutualFundService;

@RestController
public class MutualFundController<T> {

	@Autowired
	MutualFundService ms;

	@RequestMapping(value = "/mutualfunds/create", method = RequestMethod.POST)
	public ResponseEntity<?> createMutualFund(@RequestBody Map<String, T> req) {
		try {

			MutualFund mf = new MutualFund();
			mf.setMutualFundName((String) req.get("mutualFundName"));
			mf.setCashBalance(1000000000.00);
			mf.setEntryLoad((Double) req.get("entryLoad"));
			mf.setExitLoad((Double) req.get("exitLoad"));
			mf.setExpenseRatio((Double) req.get("expenseRatio"));
			@SuppressWarnings("unchecked")
			List<Map<String, Double>> stocks = (List<Map<String, Double>>) req.get("stocks");
			mf = ms.createMutualFund(mf, stocks);

			return new ResponseEntity<>(mf, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/mutualfunds", method = RequestMethod.GET, produces = "application/json")
	public List<MutualFund> getAllMutualFund() {

		return ms.getAllMutualFund();

	}

	@RequestMapping(value = "/mutualfunds/{id}", method = RequestMethod.GET)
	public String getMutualFundById(@PathVariable("id") int mId) {

		return ms.getMutualFundById(mId);
	}

}
