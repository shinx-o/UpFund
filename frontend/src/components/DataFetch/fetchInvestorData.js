import axios from "axios";
import { getAllMutualFunds } from "./fetchManagerData";

export const getAllInvestments = async () => {
    try {
        const response = await axios({
            method: 'GET',
            url: 'http://localhost:5000/investorportfolio'
        })
        const mutualFundList = await getAllMutualFunds();
        const newResponse = appendMutualFundNamesToTransactions(response.data,mutualFundList)
        return newResponse;
    } catch (e) {
        console.error(e);
    }
}

export const getInvestorTransactions = async () => {
    try {
        const response = await axios({
            method: 'GET',
            url: 'http://localhost:5000/transactions'
        })
        const mutualFundList = await getAllMutualFunds();
        const newResponse = appendMutualFundNamesToTransactions(response.data,mutualFundList)
        return newResponse;
    } catch (e) {
        console.error(e);
    }
}


function appendMutualFundNamesToTransactions(transactionList, mutualFundList) {
    const resultMap = new Map();

    // Create a map of mutualFundId to mutualFundName from mutualFundList
    mutualFundList.forEach(mutualFund => {
        resultMap.set(mutualFund.mutualFundId, [mutualFund.mutualFundName, mutualFund.exitLoad]);
    });

    // Append mutualFundName to transactionList JSON objects
    const updatedTransactionList = transactionList.map(transaction => ({
        ...transaction,
        mutualFundName: resultMap.get(transaction.mutualFundId)[0] || "Unknown Mutual Fund",
        exitLoad: resultMap.get(transaction.mutualFundId)[1] || "Exit Load Not Found"
    }));

    return updatedTransactionList;
}








