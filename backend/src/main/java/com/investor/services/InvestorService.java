package com.investor.services;

import com.investor.models.Investor;

public class InvestorService {
	public String createInvestor(Investor investor) {
  
        return "Investor created successfully!";
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
