package com.utilities.services;

import java.util.List;

import com.manager.models.MutualFund;

public class UtilityFunctions {
	
	public static void calculateTotalInvestmentandUnits(MutualFund mf, List<Double> weightages, double initialCorpus, List<Double> stockPrices) {
		double totalInvestment = 0;
		double totalUnitsOutstanding = 0;
		int index = 0;
		for (double weightage : weightages) {
			double stockInvestment = initialCorpus * weightage;
			totalInvestment += stockInvestment;
			double investedUnits = stockInvestment / stockPrices.get(index);
			totalUnitsOutstanding += investedUnits;
		}
		
		mf.setTotalInvestment(totalInvestment);
		mf.setTotalUnitsOutstanding(totalUnitsOutstanding);
	}
	
	public static void calculateNav(MutualFund mf) {
		double expenseRatio = mf.getExpenseRatio();
		double totalInvestment = mf.getTotalInvestment();
		double totalUnitsOutstanding = mf.getTotalUnitsOutstanding();
		double nav = (totalInvestment - expenseRatio)/ totalUnitsOutstanding;
		
		mf.setCurrentNav(nav);
	}
	
	
}
