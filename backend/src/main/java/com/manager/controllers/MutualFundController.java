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
import com.utilities.services.ExceptionHandler;
import com.utilities.services.MutualFundJsonRequest;
import com.utilities.services.StocksJsonRequest;

@RestController
public class MutualFundController {

	@Autowired
	MutualFundService ms;

	@RequestMapping(value = "/mutualfunds/create", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> createMutualFund(@RequestBody MutualFundJsonRequest req) {
		try {

			MutualFund mf = new MutualFund();
			mf.setMutualFundName(req.getMutualFundName());
			mf.setCashBalance(1000000000.00);
			mf.setEntryLoad(req.getEntryLoad());
			mf.setExitLoad(req.getExitLoad());
			mf.setExpenseRatio(req.getExpenseRatio());
			List<StocksJsonRequest> stocks = req.getStocks();
			mf = ms.createMutualFund(mf, stocks);

			return new ResponseEntity<>(mf, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage() ,ExceptionHandler.resolveHttpStatus(e));
		}
	}

	@RequestMapping(value = "/mutualfunds", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getAllMutualFund() {
		try {
			List<MutualFund> res = ms.getAllMutualFund();
			return new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), ExceptionHandler.resolveHttpStatus(e));
		}

	}

	@RequestMapping(value = "/mutualfunds/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getMutualFundById(@PathVariable("id") int mutualFundId) {
		try {
			Map<String, Object> res = ms.getMutualFundById(mutualFundId);
			return new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), ExceptionHandler.resolveHttpStatus(e));
		}
	}

}
