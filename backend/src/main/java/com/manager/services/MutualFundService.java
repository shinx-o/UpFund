package com.manager.services;

import java.util.ArrayList;
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
import com.utilities.services.UtilityFunctions;

@Service
public class MutualFundService {

	@Autowired
	MutualFundRepository mfr;

	@Autowired
	PortfolioRepository pr;
	
	@Autowired
	StockPriceRepository spr;
	

	public <T> MutualFund createMutualFund(MutualFund mutualFund, List<Map<String, T>> stocks) throws Exception {
		double initialCorpus = 1000000000; 
		List<Double> stockPrices = new ArrayList<>();
		List<Double> weightagesList = new ArrayList<Double>();
		
		try {
			
			for (Map<String, T> map : stocks) {
				int stockId = (Integer) map.get("stockId");
				double weight = (Double) map.get("weightage");
				double openingPrice = mfr.findOpeningPriceByStockIdAndBusinessDate(stockId);
				stockPrices.add(openingPrice);
				weightagesList.add(weight);
			}
			
			UtilityFunctions.calculateTotalInvestmentandUnits(mutualFund, weightagesList, mutualFund.getCashBalance(), stockPrices);
			UtilityFunctions.calculateNav(mutualFund);
			
			mutualFund = mfr.save(mutualFund);
			
			for (Map<String, T> map : stocks) {
				int index = 0;
				int stockId = (Integer) map.get("stockId");
				double weight = (Double) map.get("weightage");
				Portfolio port = new Portfolio();
				port.setMutualFundId(mutualFund.getMutualFundId());
				port.setStockId(stockId);
				port.setWeightage(weight);
				port.setStockUnits((initialCorpus * weight)/stockPrices.get(index));
				pr.save(port);
				index += 1;

			}

			return mutualFund;
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	public List<MutualFund> getAllMutualFund() {
		return mfr.findAll();
	}

	public String getMutualFundById(int mId) {
		return "Mutual Fund not found.";
	}

	public String getMutualFundByName(String name) {

		return "Mutual Fund not found.";
	}

	public String updateMutualFundByIdCompletely(MutualFund m, int mId) {

		return "Mutual Fund completely updated by ID successfully!";
	}

	public String updateMutualFundByNameCompletely(MutualFund mutualFund, String name) {

		return "Mutual Fund completely updated by name successfully!";
	}

	public String updateMutualFundById(MutualFund mutualFund, int mId) {

		return "Mutual Fund partially updated by ID successfully!";
	}

	public String updateMutualFundByName(MutualFund mutualFund, String name) {

		return "Mutual Fund partially updated by name successfully!";
	}
}
