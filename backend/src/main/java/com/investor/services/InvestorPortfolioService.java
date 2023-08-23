package com.investor.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.investor.models.InvestorPortfolio;
import com.repository.InvestorPortfolioRepository;

@Service
public class InvestorPortfolioService {

	@Autowired
	InvestorPortfolioRepository ipRepository;

	public List<InvestorPortfolio> getAllInvestments() throws Exception {
		try {

			List<InvestorPortfolio> portfolios = ipRepository.findAll();
			if (portfolios.isEmpty()) {
				throw new Exception("So Far No Investments Have Made!");
			}

			return portfolios;
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	public List<InvestorPortfolio> getInvestmentsById(int investorPortfolioId) throws Exception {
		try {
			List<InvestorPortfolio> portfolios = ipRepository.findByInvestorPortfolioId(investorPortfolioId);
			if (portfolios.isEmpty()) {
				throw new Exception("No Investments Are Made By The Investor With ID: " + investorPortfolioId);
			}

			return portfolios;
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

}
