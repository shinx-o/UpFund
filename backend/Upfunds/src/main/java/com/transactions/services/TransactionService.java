package com.transactions.services;

public class TransactionService {
	private List<InvestorTransaction> transactions = new ArrayList<>();

    public String getAllTransactions() {
        return transactions.toString();
    }

    public String getInvestorTransactions(int investorId) {
        List<InvestorTransaction> investorTransactions = new ArrayList<>();
        for (InvestorTransaction transaction : transactions) {
            if (transaction.getId() == investorId) {
                investorTransactions.add(transaction);
            }
        }
        return investorTransactions.isEmpty() ? "No transactions found." : investorTransactions.toString();
    }

    public String createBuyTransaction(InvestorTransaction transaction) {
        transactions.add(transaction);
        return "Buy transaction created successfully!";
    }

    public String createSellTransaction(InvestorTransaction transaction) {
        transactions.add(transaction);
        return "Sell transaction created successfully!";
    }
}
