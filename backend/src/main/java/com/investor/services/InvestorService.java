package com.investor.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.investor.models.Investor;
import com.repository.InvestorRepository;

@Service
public class InvestorService {
	
	@Autowired
	InvestorRepository ir;
	
	public String createInvestor(Investor investor) {
		System.out.println("Calling Service");
		try {
			ir.save(investor);
			return "User created successfully";
		}catch (Exception e) {
			return e.getMessage();
		}
    }

    public String getInvestorById(int investorId) {
        return "Investor not found.";
    }

    public String getInvestorByName(String name) {
        return "Investor not found.";
    }

    public String updateInvestorByIdCompletely(Investor investor, int investorId) {
 
        return "Investor completely updated by ID successfully!";
    }

    public String updateInvestorByNameCompletely(Investor investor, String name) {

        return "Investor completely updated by name successfully!";
    }

    public String updateInvestorByEmailCompletely(Investor investor, String email) {
     
        return "Investor completely updated by email successfully!";
    }

    public String updateInvestorByPhoneNumberCompletely(Investor investor, int phoneNumber) {

        return "Investor completely updated by phone number successfully!";
    }

    public String updateInvestorById(Investor investor, int investorId) {
   
        return "Investor partially updated by ID successfully!";
    }

    public String updateInvestorByEmail(Investor investor, String email) {
     
        return "Investor partially updated by email successfully!";
    }

    public String updateInvestorByPhoneNumber(Investor investor, int phoneNumber) {
 
        return "Investor partially updated by phone number successfully!";
    }
}
