import React, { useEffect, useState } from 'react'
import "./ManagerDashboard.scss"
import dummyLogo from '../../dummyLogo.jpg';
import { Link } from 'react-router-dom';
import { getAllMutualFunds } from '../DataFetch/fetchManagerData';
import BarChart from '../BarChart/BarChart';

export default function ManagerDashBoard() {
    const [moveTransition, setMoveTransition] = useState(false);
    const [mutualFundsList, setMutualFundsList] = useState([]);
    const handleMove = () => {
        setMoveTransition(!moveTransition);
    }

    useEffect(() => {
        async function fetchMutualFunds() {
            try {
                const response = await getAllMutualFunds();
                setMutualFundsList(response);
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
        <div className='manager-dashboard-container' >
            <div className="top">
                <div className="total-amount top-entity">
                    <h3>Total Investment</h3>
                    <span className="text-data">₹7000</span>
                </div>
                <div className="current-value top-entity">
                    <h3>Current Value</h3>
                    <span className="text-data">₹8000</span>
                </div>
                <div className="return top-entity">
                    <h3>Returns</h3>
                    <span className="text-data">20%</span>
                </div>
                <div className="invest-btn-container top-entity">
                    <Link to='/createMutualFund'><button className="invest-button">Create</button></Link>
                </div>
            </div>
            <div className="middle">
                <BarChart data={mutualFundsList && mutualFundsList} />
            </div>
            <div className="bottom">
                <div className="header">
                    <div className="header-top">
                        <h2 onClick={handleMove}>Existing Mutual Funds</h2>
                    </div>
                </div>
                <div className="footer">
                    <div className="funds-container">
                        {mutualFundsList && mutualFundsList.map((row, idx) => {
                            console.log(row);
                            return (
                                <div className="funds" key={idx} style={{ borderBottom: `${idx === mutualFundsList.length - 1 && "none"}` }}>
                                    <img src={dummyLogo} alt="" className="fund-img" />
                                    <div className="funds-name">
                                        <h4>{row.mutualFundName}</h4>
                                    </div>
                                    <div className="funds-folio-number fund-entity">
                                        <h5 className="fund-entity-header">Folio-Number</h5>
                                        <span className="fund-entity-details">{row.mutualFundId}</span>
                                    </div>
                                    <div className="funds-entry-load fund-entity">
                                        <h5 className="fund-entity-header">Entry Load</h5>
                                        <span className="fund-entity-details">{row.entryLoad}%</span>
                                    </div>
                                    <div className="funds-exit-load fund-entity">
                                        <h5 className="fund-entity-header">Exit Load</h5>
                                        <span className="fund-entity-details">{row.exitLoad}%</span>
                                    </div>
                                    <div className="funds-cash-balance fund-entity">
                                        <h5 className="fund-entity-header">Cash Balance</h5>
                                        <span className="fund-entity-details">₹{formatNumber(row.cashBalance)}</span>
                                    </div>
                                    <div className="funds-expense-ratio fund-entity">
                                        <h5 className="fund-entity-header">Expense Ratio</h5>
                                        <span className="fund-entity-details">{row.expenseRatio * 100}%</span>
                                    </div>
                                    <div className="funds-nav fund-entity">
                                        <h5 className="fund-entity-header">Net Assest Value</h5>
                                        <span className="fund-entity-details">{row.currentNav}</span>
                                    </div>
                                    <div className="funds-redeem fund-entity">
                                        <button className="btn-investment">View</button>
                                    </div>
                                </div>
                            )
                        })}
                    </div>
                </div>
            </div>
        </div >
    )
}
