package com.investor.services;

public class InvestorService {
	public String createInvestor(Investor investor) {
        investors.put(investor.getId(), investor);
        nameToIdMap.put(investor.getName(), investor.getId());
        emailToIdMap.put(investor.getEmail(), investor.getId());
        phoneNumberToIdMap.put(investor.getPhoneNumber(), investor.getId());
        return "Investor created successfully!";
    }

    public String getInvestorById(int investorId) {
        Investor investor = investors.get(investorId);
        return investor != null ? investor.toString() : "Investor not found.";
    }

    public String getInvestorByName(String name) {
        Integer investorId = nameToIdMap.get(name);
        Investor investor = investors.get(investorId);
        return investor != null ? investor.toString() : "Investor not found.";
    }

    public String updateInvestorByIdCompletely(Investor investor, int investorId) {
        if (!investors.containsKey(investorId)) {
            return "Investor not found.";
        }
        investors.put(investorId, investor);
        return "Investor completely updated by ID successfully!";
    }

    public String updateInvestorByNameCompletely(Investor investor, String name) {
        Integer investorId = nameToIdMap.get(name);
        if (investorId == null) {
            return "Investor not found.";
        }
        investors.put(investorId, investor);
        return "Investor completely updated by name successfully!";
    }

    public String updateInvestorByEmailCompletely(Investor investor, String email) {
        Integer investorId = emailToIdMap.get(email);
        if (investorId == null) {
            return "Investor not found.";
        }
        investors.put(investorId, investor);
        return "Investor completely updated by email successfully!";
    }

    public String updateInvestorByPhoneNumberCompletely(Investor investor, int phoneNumber) {
        Integer investorId = phoneNumberToIdMap.get(phoneNumber);
        if (investorId == null) {
            return "Investor not found.";
        }
        investors.put(investorId, investor);
        return "Investor completely updated by phone number successfully!";
    }

    public String updateInvestorById(Investor investor, int investorId) {
        if (!investors.containsKey(investorId)) {
            return "Investor not found.";
        }
        Investor existingInvestor = investors.get(investorId);
        existingInvestor.setName(investor.getName());
        existingInvestor.setEmail(investor.getEmail());
        existingInvestor.setPhoneNumber(investor.getPhoneNumber());
        return "Investor partially updated by ID successfully!";
    }

    public String updateInvestorByEmail(Investor investor, String email) {
        Integer investorId = emailToIdMap.get(email);
        if (investorId == null) {
            return "Investor not found.";
        }
        Investor existingInvestor = investors.get(investorId);
        existingInvestor.setName(investor.getName());
        existingInvestor.setEmail(investor.getEmail());
        existingInvestor.setPhoneNumber(investor.getPhoneNumber());
        return "Investor partially updated by email successfully!";
    }

    public String updateInvestorByPhoneNumber(Investor investor, int phoneNumber) {
        Integer investorId = phoneNumberToIdMap.get(phoneNumber);
        if (investorId == null) {
            return "Investor not found.";
        }
        Investor existingInvestor = investors.get(investorId);
        existingInvestor.setName(investor.getName());
        existingInvestor.setEmail(investor.getEmail());
        existingInvestor.setPhoneNumber(investor.getPhoneNumber());
        return "Investor partially updated by phone number successfully!";
    }
}
