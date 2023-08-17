package com.transactions.services;

import org.springframework.stereotype.Service;

import com.transaction.models.InvestorTransaction;

@Service
public class TransactionService {
	
    public String getAllTransactions() {
        return "Dummy";
    }

    public String getInvestorTransactions(int investorId) {
        return  "No transactions found.";
    }

    public String createBuyTransaction(InvestorTransaction transaction) {
        return "Buy transaction created successfully!";
    }

    public String createSellTransaction(InvestorTransaction transaction) {
        return "Sell transaction created successfully!";
    }
}
