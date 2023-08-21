package com.transactions.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.investor.models.InvestorPortfolio;
import com.manager.models.MutualFund;
import com.manager.models.Portfolio;
import com.repository.InvestorPortfolioRepository;
import com.repository.InvestorTransactionRepository;
import com.repository.MutualFundRepository;
import com.repository.PortfolioRepository;
import com.repository.StockPriceRepository;
import com.transaction.models.InvestorTransaction;
import com.utilities.services.UtilityFunctions;

@Service
public class TransactionService {

	@Autowired
	InvestorTransactionRepository itr;

	@Autowired
	InvestorPortfolioRepository ipr;

	@Autowired
	MutualFundRepository mfr;

	@Autowired
	PortfolioRepository pr;

	@Autowired
	StockPriceRepository spr;

	public List<InvestorTransaction> getAllTransactions() {
		return itr.findAll();
	}

	public List<InvestorTransaction> getInvestorTransactions(int investorId) {
		return itr.findByInvestorId(investorId);
	}

	public InvestorTransaction createBuyTransaction(InvestorTransaction transaction) {
		transaction.setTransactionType("buy");
		int mutualFundId = transaction.getMutualFundId();
		int investorId = transaction.getInvestorId();
		List<Double> stockPrices = new ArrayList<>();
		List<Double> stockUnits = new ArrayList<>();

		MutualFund mutualFund = mfr.findOne(mutualFundId);

		List<Portfolio> stocks = pr.findByMutualFundId(mutualFund.getMutualFundId());
		for (Portfolio stock : stocks) {
			double openingPrice = spr.findOpeningPricesByStockId(stock.getStockId());
			stockPrices.add(openingPrice);
			stockUnits.add(stock.getStockUnits());
		}

		double currentNav = UtilityFunctions.calculateCurrentNavAtTimeOfBuy(mutualFund.getTotalUnitsOutstanding(),
				stockUnits, stockPrices);
		mutualFund.setCurrentNav(currentNav);
		mfr.save(mutualFund);
		UtilityFunctions.performBuyTransaction(mutualFund, transaction);

		double units = transaction.getUnits();
		double transactionAmount = transaction.getTransactionAmount();

		InvestorPortfolio portfolio = ipr.findByMutualFundIdAndInvestorId(mutualFundId, investorId);
		if (portfolio != null) {
			double previouslyBoughtUnits = portfolio.getUnits();
			double previouslyInvestedAmount = portfolio.getTotalInvestment();
			portfolio.setUnits(previouslyBoughtUnits + units);
			portfolio.setTotalInvestment(previouslyInvestedAmount + transactionAmount);
			ipr.save(portfolio);

		} else {
			portfolio = new InvestorPortfolio();
			portfolio.setInvestorId(transaction.getInvestorId());
			portfolio.setMutualFundId(transaction.getMutualFundId());
			portfolio.setUnits(units);
			portfolio.setTotalInvestment(transactionAmount);
			ipr.save(portfolio);
		}

		transaction = itr.save(transaction);

		return transaction;
	}

	public String createSellTransaction(InvestorTransaction transaction) {
		transaction.setTransactionType("sell");
		int mutualFundId = transaction.getMutualFundId();
		int investorId = transaction.getInvestorId();
		List<Double> stockPrices = new ArrayList<>();
		List<Double> stockUnits = new ArrayList<>();

		MutualFund mutualFund = mfr.findOne(mutualFundId);

		List<Portfolio> stocks = pr.findByMutualFundId(mutualFund.getMutualFundId());
		for (Portfolio stock : stocks) {
			double openingPrice = spr.findOpeningPricesByStockId(stock.getStockId());
			stockPrices.add(openingPrice);
			stockUnits.add(stock.getStockUnits());
		}

		double currentNav = UtilityFunctions.calculateCurrentNavAtTimeOfBuy(mutualFund.getTotalUnitsOutstanding(),
				stockUnits, stockPrices);
		mutualFund.setCurrentNav(currentNav);
		mfr.save(mutualFund);
		InvestorPortfolio portfolio = ipr.findByMutualFundIdAndInvestorId(mutualFundId, investorId);
		UtilityFunctions.perfomSellTransaction(mutualFund, transaction, portfolio);
		
		
		
		return "Sell transaction created successfully!";
	}
}
