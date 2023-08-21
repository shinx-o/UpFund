import React, { useEffect, useState } from "react";
import "./CreateMutualFund.scss";
import { createMutualFund, getAllStocks } from "../DataFetch/fetchManagerData";
// import { useNavigate } from 'react-router-dom';

export default function CreateMutualFund() {
  const [stockList, setStockList] = useState([]);
  const [mutualFundData, setMutualFundData] = useState({
    mutualFundName: "",
    entryLoad: 0,
    exitLoad: 0,
    expenseRatio: 0,
    stocks: [],
  });

  useEffect(() => {
    async function fetchMutualFunds() {
      try {
        const response = await getAllStocks();
        setStockList(response);
      } catch (error) {
        console.error(error);
      }
    }
    fetchMutualFunds();
  }, []);

  const handleInputChange = (event) => {
    const { name, value } = event.target;
    setMutualFundData((prevData) => ({
      ...prevData,
      [name]:
        name !== "mutualFundName"
          ? parseFloat(parseFloat(value).toFixed(2))
          : value,
    }));
  };

  const handleCheckboxChange = (stockId, event) => {
    let newStock = [];
    if (event.target.checked) {
      newStock = [...mutualFundData.stocks, { stockId: stockId, weightage: 0 }];
    } else {
      newStock = mutualFundData.stocks.filter(
        (item) => item.stockId !== stockId
      );
    }
    setMutualFundData((prev) => ({
      ...prev,
      stocks: newStock,
    }));
};

const handleWeightChange = (stockId, weight) => {
    const updatedStocks = mutualFundData.stocks.map((stock) => {
      if (stock.stockId === stockId) {
        return { ...stock, weightage: parseFloat(weight) };
      }
      return stock;
    });
    setMutualFundData((prevData) => ({
      ...prevData,
      stocks: updatedStocks,
    }));
  };

  const handleSubmit = async (event) => {
    event.preventDefault();
    for(let obj of Object.keys(mutualFundData)) {
        console.log(obj);
    }

    // Now you can call your API to create the mutual fund
    // if (mutualFundData.mutualFundName.length > 0) {
    //     const res = await createMutualFund(mutualFundData);
    //     console.log(res);
    // }
  };

  return (
    <div className="create-container">
      <div className="alert alert-danger visible" role="alert">
        A simple danger alert—check it out!
      </div>
      <div className="input-container">
        <form id="main-form" onSubmit={handleSubmit}>
          <div className="left">
            <div className="fund-name field-entity">
              <label htmlFor="mutualFundName">Enter Fund Name</label>
              <input
                type="text"
                name="mutualFundName"
                id="fundName"
                onChange={handleInputChange}
                className="field"
              />
            </div>
            <div className="entry-load field-entity">
              <label htmlFor="entryLoad">Entry Load</label>
              <input
                type="number"
                name="entryLoad"
                id="entryLoad"
                onChange={handleInputChange}
                step={0.1}
                max={4}
                min={0}
                className="field"
              />
            </div>
            <div className="exit-field field-entity">
              <label htmlFor="exitLoad">Exit Load</label>
              <input
                type="number"
                name="exitLoad"
                id="exitLoad"
                onChange={handleInputChange}
                step={0.1}
                max={4}
                min={0}
                className="field"
              />
            </div>
            <div className="expense-ratio field-entity">
              <label htmlFor="expenseRatio">Expense Ratio</label>
              <input
                type="number"
                name="expenseRatio"
                id="expenseRatio"
                onChange={handleInputChange}
                step={0.1}
                max={4}
                min={0}
                className="field"
              />
            </div>
            <div className="submit field-entity">
              <button type="submit" name="sumbit" id="submit" className="btn">
                Create Mutual Fund
              </button>
            </div>
          </div>
          <div className="right">
            <div className="header-container">
              <div className="header check"></div>
              <div className="header stock-name-header">Stock Name</div>
              <div className="header stock-weight-header">Stock Weightages</div>
            </div>
            <div className="bottom-container">
              {stockList &&
                stockList.map((stock) => {
                  return (
                    <div className="field-row" key={stock.stockId}>
                      <input
                        type="checkbox"
                        name={`checkbox-${stock.stockId}`}
                        id={`checkbox-${stock.stockId}`}
                        className="checkbox"
                        onChange={(event) =>
                          handleCheckboxChange(stock.stockId, event)
                        }
                      />
                      <span className="stock-name">{stock.stockName}</span>
                      <input
                        type="number"
                        name={`stock-weight-${stock.stockId}`}
                        id={`stock-weight-${stock.stockId}`}
                        className="stock-weight"
                        onChange={(event) =>
                          handleWeightChange(stock.stockId, event.target.value)
                        }
                      />
                    </div>
                  );
                })}
            </div>
          </div>
        </form>
      </div>
    </div>
  );
}
