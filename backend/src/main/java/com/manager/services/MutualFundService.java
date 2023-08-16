package com.manager.services;


import com.manager.models.MutualFund;

public class MutualFundService {


    public String createMutualFund(MutualFund mutualFund) {
        return "Mutual Fund created successfully!";
    }

    public String getAllMutualFund() {
        return "Dummy";
    }

    public String getMutualFundById(int mId) {
        return  "Mutual Fund not found.";
    }

    public String getMutualFundByName(String name) {
 
        return "Mutual Fund not found.";
    }

    public String updateMutualFundByIdCompletely(MutualFund m, int mId) {
   
        return "Mutual Fund completely updated by ID successfully!";
    }

    public String updateMutualFundByNameCompletely(MutualFund mutualFund, String name) {
  
        return "Mutual Fund completely updated by name successfully!";
    }

    public String updateMutualFundById(MutualFund mutualFund, int mId) {
 
        return "Mutual Fund partially updated by ID successfully!";
    }

    public String updateMutualFundByName(MutualFund mutualFund, String name) {
 
        return "Mutual Fund partially updated by name successfully!";
    }
}
