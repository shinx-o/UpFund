package com.utilities.services;

import java.util.List;

import com.investor.models.InvestorPortfolio;
import com.manager.models.MutualFund;
import com.transaction.models.InvestorTransaction;

public class UtilityFunctions {

	public static void calculateTotalInvestmentandUnits(MutualFund mf, List<Double> weightages, double initialCorpus,
			List<Double> stockPrices) {
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

		mf.setCashBalance(mf.getCashBalance() - totalInvestment);
		mf.setTotalInvestment(totalInvestment);
		mf.setTotalUnitsOutstanding(totalUnitsOutstanding);
	}

	public static void calculateNav(MutualFund mf) {
		double expenseRatio = mf.getExpenseRatio();
		double totalInvestment = mf.getTotalInvestment();
		double totalUnitsOutstanding = mf.getTotalUnitsOutstanding();
		double nav = (totalInvestment - expenseRatio) / totalUnitsOutstanding;

		mf.setCurrentNav(nav);
	}

	public static double calculateCurrentNavAtTimeOfBuy(double oldUnits, List<Double> stockUnits,
			List<Double> stockPrices) {
		double newValueOfStocks = 0;
		int index = 0;
		for (double stockUnit : stockUnits) {
			newValueOfStocks += stockUnit * stockPrices.get(index);
			index += 1;
		}
		double newNav = newValueOfStocks / oldUnits;
		return newNav;
	}

	public static void performBuyTransaction(MutualFund mutualFund, InvestorTransaction investorTransaction) {
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

		mutualFund.setCashBalance(cashBalance);
		mutualFund.setTotalInvestment(mutualFundTotalInvestment);

		investorTransaction.setUnits(unitsBought);

	}

	public static void perfomSellTransaction(MutualFund mutualFund, InvestorTransaction investorTransaction,
			InvestorPortfolio investorPortfolio) {
		double unitsRedeemed = 0;
		double exitLoad = mutualFund.getExitLoad();
		double cashBalance = mutualFund.getCashBalance();
		double nav = mutualFund.getCurrentNav();
		double mutualFundTotalInvestment = mutualFund.getTotalInvestment();
		double redemptionAmount = investorTransaction.getTransactionAmount();
		unitsRedeemed = redemptionAmount / nav;
		double loadAmount = (exitLoad * redemptionAmount) / 100;
		redemptionAmount -= loadAmount;
		mutualFund.setTotalInvestment(mutualFundTotalInvestment - redemptionAmount);
		investorTransaction.setUnits(investorPortfolio.getUnits() - unitsRedeemed);
		mutualFund.setCashBalance(cashBalance + loadAmount);
	}

}
