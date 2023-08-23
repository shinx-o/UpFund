import React, { useEffect, useState } from "react";
import "./MutualFund.scss";
import { getMutualFund } from "../DataFetch/fetchManagerData";
import { useParams } from "react-router-dom";

export default function MutualFund() {
  const [mutualFund, setMutualFund] = useState(null);
  const { mutualFundId } = useParams();
  

  useEffect(() => {
    async function fetchMutualFunds() {
      try {
        const response = await getMutualFund(mutualFundId);
        setMutualFund(response);
      } catch (error) {
        console.error(error);
      }
    }
    fetchMutualFunds();
  }, []);

  const formatNumber = (number) => {
    if (number >= 10000000) {
        return (number / 10000000).toFixed(1) + " Crore";
    } else if (number >= 100000) {
        return (number / 100000).toFixed(1) + " Lakhs";
    } else {
        return number.toString();
    }
};
  return (
    <div className="mutual-fund-container">
      {mutualFund && (
        <div className="main-container">
          <div className="left-main">
            <div className="header-main">
              <h2>{mutualFund.mutualFundName}</h2>
            </div>
            <div className="bottom-main">
              <div className="field">
                <span className="entry name">ID</span>
                <span className="entry value">{mutualFund.mutualFundId}</span>
              </div>
              <div className="field">
                <span className="entry name">Entry Load</span>
                <span className="entry value">{mutualFund.entryLoad}%</span>
              </div>
              <div className="field">
                <span className="entry name">Exit Load</span>
                <span className="entry value">{mutualFund.exitLoad}%</span>
              </div>
              <div className="field">
                <span className="entry name">Cash Balance</span>
                <span className="entry value">{mutualFund.cashBalance}</span>
              </div>
              <div className="field">
                <span className="entry name">Expense Ratio</span>
                <span className="entry value">{mutualFund.expenseRatio}</span>
              </div>
              <div className="field">
                <span className="entry name">Net Assest Value</span>
                <span className="entry value">{mutualFund.currentNav}</span>
              </div>
              <div className="field">
                <span className="entry name">Total Investment</span>
                <span className="entry value">₹
                  {formatNumber(mutualFund.totalInvestment)}
                </span>
              </div>
              <div className="field">
                <span className="entry name">Total Units Outstanding</span>
                <span className="entry value">
                  {mutualFund.totalUnitsOutstanding.toFixed(2)}
                </span>
              </div>
            </div>
          </div>
          <div className="right-main">
            <div className="header-main">
              <h2>Stocks</h2>
            </div>
            <div className="bottom-main">
              {mutualFund.stocks &&
                mutualFund.stocks
                  .sort((a, b) => (a.stockId > b.stockId ? 1 : -1))
                  .map((fund, idx) => {
                    return (
                      <div key={idx} className="field-two">
                        <span className="entry name">{fund.stockId}</span>
                        <span className="entry value">
                          {(fund.weightage * 100).toFixed(1)}%
                        </span>
                      </div>
                    );
                  })}
            </div>
          </div>
        </div>
      )}
    </div>
  );
}
