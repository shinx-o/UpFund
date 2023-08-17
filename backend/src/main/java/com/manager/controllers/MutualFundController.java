package com.manager.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.manager.models.MutualFund;
import com.manager.models.Portfolio;
import com.manager.services.MutualFundService;

@RestController
public class MutualFundController<T> {

	@Autowired
	MutualFundService ms;

	@RequestMapping(value = "/mutualfunds/create", method = RequestMethod.POST)
	public String createMutualFund(@RequestBody Map<String, T> req) {
		try {

			MutualFund mf = new MutualFund();
			mf.setMutualFundName((String) req.get("mutualFundName"));
			mf.setCashBalance(1000000000.00);
			mf.setEntryLoad((double) req.get("entryLoad"));
			mf.setExitLoad((double) req.get("exitLoad"));
			mf.setExpenseRatio((double) req.get("expenseRatio"));
			@SuppressWarnings("unchecked")
			List<Map<String, Double>> stocks = (List<Map<String, Double>>) req.get("stocks");
			return ms.createMutualFund(mf, stocks);

		} catch (Exception e) {
			return e.getMessage();
		}
	}

	@RequestMapping(value = "/mutualfunds", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public String getAllMutualFund() {

		return ms.getAllMutualFund();

	}

	@RequestMapping(value = "/mutualfunds/{id}", method = RequestMethod.GET)
	public String getMutualFundById(@PathVariable("id") int mId) {

		return ms.getMutualFundById(mId);
	}


}
