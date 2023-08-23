package com.manager.services;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.models.MutualFund;
import com.manager.models.Portfolio;
import com.repository.MutualFundRepository;
import com.repository.NavHistoryRepository;
import com.repository.PortfolioRepository;
import com.repository.StockPriceRepository;
import com.utilities.models.NavHistory;
import com.utilities.services.StocksJsonRequest;
import com.utilities.services.UtilityFunctions;

@Service
public class MutualFundService {

	@Autowired
	MutualFundRepository mfr;

	@Autowired
	PortfolioRepository pr;

	@Autowired
	StockPriceRepository spr;

	public MutualFund createMutualFund(MutualFund mutualFund, List<StocksJsonRequest> stocks) throws Exception {
		DecimalFormat decimalFormat = new DecimalFormat("#.##");
		double initialCorpus = 1000000000;
		List<Double> stockPrices = new ArrayList<>();
		List<Double> weightagesList = new ArrayList<Double>();

		try {

			for (StocksJsonRequest stock : stocks) {
				int stockId = stock.getStockId();
				double weight = stock.getWeightage();
				double openingPrice = mfr.findOpeningPriceByStockIdAndBusinessDate(stockId);
				stockPrices.add(openingPrice);
				weightagesList.add(weight);
			}

			UtilityFunctions.calculateTotalInvestmentandUnits(mutualFund, weightagesList, mutualFund.getCashBalance(),
					stockPrices);
			UtilityFunctions.calculateNav(mutualFund);

			mutualFund = mfr.save(mutualFund);

			for (StocksJsonRequest stock : stocks) {
				int index = 0;
				int stockId = stock.getStockId();
				double weight = stock.getWeightage();
				Portfolio port = new Portfolio();
				port.setMutualFundId(mutualFund.getMutualFundId());
				port.setStockId(stockId);
				port.setWeightage(weight);
				double stockUnits = (initialCorpus * weight) / stockPrices.get(index);
				stockUnits = Double.parseDouble(decimalFormat.format(stockUnits));
				port.setStockUnits(stockUnits);
				pr.save(port);
				index += 1;
			}
			
			return mutualFund;
			
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	public List<MutualFund> getAllMutualFund() throws Exception {
		try {
			List<MutualFund> funds = mfr.findAll();
			if(funds.isEmpty()) {
				throw new Exception("No Mutual Funds Exist");
			}
			
			return funds;
			
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	public Map<String, Object> getMutualFundById(int mutualFundId) throws Exception{
		try {
			MutualFund fund =  mfr.findOne(mutualFundId);
			if (fund == null) {
				throw new Exception("Mutual Fund With ID: " + mutualFundId + " Does Not Exist!");
			}
			
			List<Portfolio> stocks = pr.findByMutualFundId(mutualFundId);
			
			Map<String, Object> response = new HashMap<String, Object>();
			response.put("mutualFundId" , fund.getMutualFundId());
			response.put("mutualFundName", fund.getMutualFundName());
			response.put("entryLoad", fund.getEntryLoad());
			response.put("exitLoad", fund.getExitLoad());
			response.put("expenseRatio", fund.getExpenseRatio());
			response.put("cashBalance", fund.getCashBalance());
			response.put("currentNav", fund.getCurrentNav());
			response.put("totalInvestment", fund.getTotalInvestment());
			response.put("totalUnitsOutstanding", fund.getTotalUnitsOutstanding());
			response.put("stocks", stocks);
			
			return response;
			
		}catch(Exception e) {
			throw new Exception(e);
		}
	}

}
