package com.utilities.services;

import java.text.DecimalFormat;
import java.util.List;

import com.investor.models.InvestorPortfolio;
import com.manager.models.MutualFund;
import com.transaction.models.InvestorTransaction;

public class UtilityFunctions {

	public static void calculateTotalInvestmentandUnits(MutualFund mf, List<Double> weightages, double initialCorpus,
			List<Double> stockPrices) {
		DecimalFormat decimalFormat = new DecimalFormat("#.##");
		double totalInvestment = 0;
		double totalUnitsOutstanding = 0;
		int index = 0;
		for (double weightage : weightages) {
			double stockInvestment = initialCorpus * weightage; 
			totalInvestment += stockInvestment;
			double investedUnits = stockInvestment / stockPrices.get(index);
			totalUnitsOutstanding += investedUnits;
			index += 1;
		}
		
		mf.setCashBalance(Double.parseDouble(decimalFormat.format(mf.getCashBalance() - totalInvestment)));
		mf.setTotalInvestment(Double.parseDouble(decimalFormat.format(totalInvestment)));
		mf.setTotalUnitsOutstanding(Double.parseDouble(decimalFormat.format(totalUnitsOutstanding)));
	}

	public static void calculateNav(MutualFund mf) {
		DecimalFormat decimalFormat = new DecimalFormat("#.##");

		double expenseRatio = mf.getExpenseRatio();
		double totalInvestment = mf.getTotalInvestment();
		double totalUnitsOutstanding = mf.getTotalUnitsOutstanding();
		double nav = (totalInvestment - expenseRatio) / totalUnitsOutstanding;

		mf.setCurrentNav(Double.parseDouble(decimalFormat.format(nav)));
	}

	public static double calculateCurrentNav(double oldUnits, List<Double> stockUnits,
			List<Double> stockPrices) {
		DecimalFormat decimalFormat = new DecimalFormat("#.##");

		double newValueOfStocks = 0;
		int index = 0;
		for (double stockUnit : stockUnits) {
			newValueOfStocks += stockUnit * stockPrices.get(index);
			index += 1;
		}
		double newNav = newValueOfStocks / oldUnits;
		return Double.parseDouble(decimalFormat.format(newNav));
	}

	public static void performBuyTransaction(MutualFund mutualFund, InvestorTransaction investorTransaction) {
		DecimalFormat decimalFormat = new DecimalFormat("#.##");

		double unitsBought = 0;
		double entryLoad = mutualFund.getEntryLoad();
		double cashBalance = mutualFund.getCashBalance();
		double nav = mutualFund.getCurrentNav();
		double mutualFundTotalInvestment = mutualFund.getTotalInvestment();
		double investmentAmount = investorTransaction.getTransactionAmount();
		double loadAmount = (entryLoad * investmentAmount) / 100;
		investmentAmount -= loadAmount;
		cashBalance += loadAmount;
		unitsBought = (investmentAmount / nav);
		mutualFundTotalInvestment += investmentAmount;

		mutualFund.setCashBalance(Double.parseDouble(decimalFormat.format(cashBalance)));
		mutualFund.setTotalInvestment(Double.parseDouble(decimalFormat.format(mutualFundTotalInvestment)));

		investorTransaction.setUnits(Double.parseDouble(decimalFormat.format(unitsBought)));

	}

	public static void perfomSellTransaction(MutualFund mutualFund, InvestorTransaction investorTransaction,
			InvestorPortfolio investorPortfolio) {
		DecimalFormat decimalFormat = new DecimalFormat("#.##");

		double unitsRedeemed = 0;
		double exitLoad = mutualFund.getExitLoad();
		double cashBalance = mutualFund.getCashBalance();
		double nav = mutualFund.getCurrentNav();
		double mutualFundTotalInvestment = mutualFund.getTotalInvestment();
		double redemptionAmount = investorTransaction.getTransactionAmount();
		unitsRedeemed = redemptionAmount / nav;
		double loadAmount = (exitLoad * redemptionAmount) / 100;
		redemptionAmount -= loadAmount;
		double newUnits = Double.parseDouble(decimalFormat.format(mutualFundTotalInvestment - redemptionAmount));
		mutualFund.setTotalInvestment(newUnits);
		investorTransaction.setUnits(investorPortfolio.getUnits() - unitsRedeemed);
		mutualFund.setCashBalance(Double.parseDouble(decimalFormat.format(cashBalance + loadAmount)));
		investorPortfolio.setUnits(newUnits);
		if(newUnits <= 0) {
			investorPortfolio.setTotalInvestment(0);
		}else {
			double totalInvestment = Double.parseDouble(decimalFormat.format(investorPortfolio.getTotalInvestment() - redemptionAmount));
			investorPortfolio.setTotalInvestment(totalInvestment);
		}
	}

}
