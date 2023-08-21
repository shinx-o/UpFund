import React, { useEffect, useState } from 'react'
import './CreateMutualFund.scss'
import { getAllStocks } from '../DataFetch/fetchManagerData';




export default function CreateMutualFund() {
    const [mutualFundData, setMutualFundData] = useState({
        mutualFundName: '',
        entryLoad: 0,
        exitLoad: 0,
        expenseRatio: 0,
        stocks: []
    });


    useEffect(() => {
        async function fetchMutualFunds() {
            try {
                const response = await getAllStocks();
            } catch (error) {
                console.error(error);
            }
        }
        fetchMutualFunds();
    }, []);

    return (
        <div className='create-container'>
            <div className="input-container">
                <div className="left">
                    <div className="fund-name field-entity">
                        <label htmlFor="fundName">Enter Fund Name</label>
                        <input type="text" name='fundName' id="fundName" className="field" />
                    </div>
                    <div className="entry-load field-entity">
                        <label htmlFor="entryLoad">Entry Load</label>
                        <input type="number" name='entryLoad' id="entryLoad" className="field" />
                    </div>
                    <div className="exit-field field-entity">
                        <label htmlFor="exitLoad">Exit Load</label>
                        <input type="number" name='exitLoad' id="exitLoad" className="field" />
                    </div>
                    <div className="expense-ratio field-entity">
                        <label htmlFor="expenseRatio">Expense Ratio</label>
                        <input type="number" name='expenseRatio' id="expenseRatio" className="field" />
                    </div>
                    <div className="submit field-entity">
                        <button name='sumbit' id="submit" className="btn">Create Mutual Fund</button>
                    </div>
                </div>
                <div className="right">
                    <table className="data-table">
                        <thead className="table-header">
                            <tr></tr>
                            <tr>Stock Name</tr>
                            <tr>Weightage</tr>
                        </thead>
                    </table>
                </div>
            </div>
        </div>
    )
}
