package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.investor.models.InvestorPortfolio;

@Repository
public interface InvestorPortfolioRepository extends JpaRepository<InvestorPortfolio, Integer> {

	List <InvestorPortfolio>findByInvestorPortfolioId(int investorPortfolioId);
	InvestorPortfolio findByMutualFundIdAndInvestorId(int mutualFundId, int investorId);
}