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
	 	
	 	public List<InvestorPortfolio> getAllInvestments(){
	 		return ipRepository.findAll();
	 	}

		public List<InvestorPortfolio> getInvestmentsById(int investorPortfolioId) {
			// TODO Auto-generated method stub
			return ipRepository.findByInvestorPortfolioId(investorPortfolioId);	
		}
		
		public String updateInvestorPortfolioById(int PortfolioId,InvestorPortfolio ipf) {
			 InvestorPortfolio existingProtfolio = ipRepository.findOne(PortfolioId);
			    if (existingProtfolio == null) {
			        return "Investor not found";
			    }

			    // Update only the non-null attributes of the existingInvestor using the data from i
			    if (ipf.getMutualFundId()!= 0) {
			    	existingProtfolio.setMutualFundId(ipf.getMutualFundId());
			    }
			    if(ipf.getTotalInvestment()!=0) {
			    	existingProtfolio.setTotalInvestment(ipf.getTotalInvestment());
			    }
			    if(ipf.getUnits()!=0) {
			    	existingProtfolio.setUnits(ipf.getUnits());
			    }
			    
			    // ...

			    ipRepository.save(existingProtfolio); // Use save to update the entity

			    return "Investor updated successfully";
    
		}

	 	
	 	
}
