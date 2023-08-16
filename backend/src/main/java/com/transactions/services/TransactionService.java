package com.transactions.services;

import com.transaction.models.InvestorTransaction;

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
