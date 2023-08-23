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

	public List<InvestorTransaction> getAllTransactions() throws Exception {
		try {
			List<InvestorTransaction> transactions = itr.findAll();
			if (transactions.isEmpty()) {
				throw new Exception("Investor Transactions Does Not Exist For This User!");
			}
			return transactions;
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	public List<InvestorTransaction> getInvestorTransactions(int investorId) throws Exception {
		try {
			List<InvestorTransaction> transactions = itr.findByInvestorId(investorId);
			if (transactions == null) {
				throw new Exception("Investor Transactions Does Not Exist For This User!");
			}
			return transactions;
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	public InvestorTransaction createBuyTransaction(InvestorTransaction transaction) throws Exception {
		try {
			transaction.setTransactionType("buy");
			int mutualFundId = transaction.getMutualFundId();
			int investorId = transaction.getInvestorId();

			List<Double> stockPrices = new ArrayList<>();
			List<Double> stockUnits = new ArrayList<>();

			MutualFund mutualFund = mfr.findOne(mutualFundId);
			if (mutualFund == null) {
				throw new Exception("Mutual Fund Not Found!");
			}

			List<Portfolio> stocks = pr.findByMutualFundId(mutualFund.getMutualFundId());
			for (Portfolio stock : stocks) {
				double openingPrice = spr.findOpeningPricesByStockId(stock.getStockId());
				stockPrices.add(openingPrice);
				stockUnits.add(stock.getStockUnits());
			}

			double currentNav = UtilityFunctions.calculateCurrentNav(mutualFund.getTotalUnitsOutstanding(), stockUnits,
					stockPrices);
			mutualFund.setCurrentNav(currentNav);
			mutualFund = mfr.save(mutualFund);
			
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
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	public InvestorTransaction createSellTransaction(InvestorTransaction transaction) throws Exception {
		try {
			transaction.setTransactionType("sell");
			int mutualFundId = transaction.getMutualFundId();
			int investorId = transaction.getInvestorId();
			List<Double> stockPrices = new ArrayList<>();
			List<Double> stockUnits = new ArrayList<>();

			MutualFund mutualFund = mfr.findOne(mutualFundId);
			if (mutualFund == null) {
				throw new Exception("User Investment Not Found");
			}

			List<Portfolio> stocks = pr.findByMutualFundId(mutualFund.getMutualFundId());
			for (Portfolio stock : stocks) {
				double openingPrice = spr.findOpeningPricesByStockId(stock.getStockId());
				stockPrices.add(openingPrice);
				stockUnits.add(stock.getStockUnits());
			}

			double currentNav = UtilityFunctions.calculateCurrentNav(mutualFund.getTotalUnitsOutstanding(), stockUnits,
					stockPrices);
			mutualFund.setCurrentNav(currentNav);
			mfr.save(mutualFund);
			InvestorPortfolio portfolio = ipr.findByMutualFundIdAndInvestorId(mutualFundId, investorId);
			UtilityFunctions.perfomSellTransaction(mutualFund, transaction, portfolio);
			ipr.save(portfolio);
			if (portfolio.getTotalInvestment() == 0) {
				ipr.delete(portfolio.getInvestorPortfolioId());
			}
			transaction = itr.save(transaction);
			return transaction;
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
}
