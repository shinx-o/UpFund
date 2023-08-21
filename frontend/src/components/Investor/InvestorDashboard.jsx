import React, { useEffect, useState } from 'react'
import "./InvestorDashboard.scss"
import LineChart from './LineChart/LineChart';
import DoughnutChart from './DoughnutChart/DoughnutChart';
import dummyLogo from '../../dummyLogo.jpg';
import { getAllInvestments, getInvestorTransactions } from '../DataFetch/fetchInvestorData';
import { Link } from 'react-router-dom';


export default function InvestorDashboard() {
    const [moveTransition, setMoveTransition] = useState(false);
    const [transactionList, setTransactionList] = useState([]);
    const [investmentList, setInvestmentList] = useState([]);


    const handleMove = () => {
        setMoveTransition(!moveTransition);
    }

    useEffect(() => {
        async function fetchMutualFunds() {
            try {
                const response = await getInvestorTransactions();
                console.log(response)
                setTransactionList(response);
            } catch (error) {
                console.error(error);
            }
        }
        fetchMutualFunds();
    }, []);

    useEffect(() => {
        async function fetchAllInvestments() {
            try {
                const response = await getAllInvestments();
                console.log(response)
                setInvestmentList(response);
            } catch (error) {
                console.error(error);
            }
        }
        fetchAllInvestments();
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
    function getRandomValueFromArray(arr) {
        const randomIndex = Math.floor(Math.random() * arr.length);
        return arr[randomIndex];
    }

    const data = [
        { cap: "Large Cap", risk: "High Risk" },
        { cap: "Medium Cap", risk: "Medium Risk" },
        { cap: "Small Cap", risk: "Small Risk" }
    ];



    return (
        <div className='investor-dashboard-container' >
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
                    <Link to='/invest'><button className="invest-button">Invest</button></Link>
                </div>
            </div>
            <div className="middle">
                <div className="left">
                    <div className="donut-chart">
                        <DoughnutChart data={investmentList} />
                    </div>
                </div>
                <div className="right">
                    <div className="investment-chart">
                        <LineChart />
                    </div>
                </div>
            </div>
            <div className="bottom">
                <div className="header">
                    <div className="header-top">
                        <h2 onClick={handleMove}>Invested Funds</h2>
                        <h2 onClick={handleMove}>Transactions</h2>
                    </div>
                    <div className={`header-bottom ${moveTransition ? 'move-slider-right' : 'move-slider-left'}`}></div>
                </div>
                <div className="footer">
                    <div className={`funds-container ${moveTransition ? 'move-up' : 'move-down'}`}>
                        {investmentList.map((row, idx) => {
                            const randomValue = getRandomValueFromArray(data);
                            return (
                                <div className="funds" key={idx} style={{ borderBottom: `${idx === investmentList.length - 1 && "none"}` }}>
                                    <img src={dummyLogo} alt="" className="fund-img" />
                                    <div className="funds-name">
                                        <h4>{row.mutualFundName}</h4>
                                        <div className="fund-name-details">
                                            <span className='cap'>{randomValue.cap}</span>
                                            <span className={`risk ${randomValue.risk}`}>{randomValue.risk}</span>
                                        </div>
                                    </div>
                                    <div className="funds-investment fund-entity">
                                        <h5 className="fund-entity-header">Investment Value</h5>
                                        <span className="fund-entity-details">₹{formatNumber(row.totalInvestment)}</span>
                                    </div>
                                    <div className="funds-units fund-entity">
                                        <h5 className="fund-entity-header">Units</h5>
                                        <span className="fund-entity-details">{parseFloat(row.units).toFixed(2)}</span>
                                    </div>
                                    <div className="funds-folio-number fund-entity">
                                        <h5 className="fund-entity-header">Folio-Number</h5>
                                        <span className="fund-entity-details">{row.investorPortfolioId}</span>
                                    </div>
                                    <div className="funds-redeem fund-entity">
                                        <Link to='/reedeemFund'><button className="btn-investment">Redeem</button></Link>
                                        <span className="fund-entity-details exit-load">Exit Load of {row.exitLoad}%</span>
                                    </div>
                                </div>
                            )
                        })}
                    </div>
                    <div className={`funds-container ${moveTransition ? 'move-down' : 'move-up'}`}>
                        {transactionList.map((row, idx) => {
                            const randomValue = getRandomValueFromArray(data);
                            return (
                                <div className="funds" key={idx} style={{ borderBottom: `${idx === transactionList.length - 1 && "none"}` }}>
                                    <img src={dummyLogo} alt="" className="fund-img" />
                                    <div className="funds-name">
                                        <h4>{row.mutualFundName}</h4>
                                        <div className="fund-name-details">
                                            <span className='cap'>{randomValue.cap}</span>
                                            <span className={`risk ${randomValue.risk}`}>{randomValue.risk}</span>
                                        </div>
                                    </div>
                                    <div className="funds-investment fund-entity">
                                        <h5 className="fund-entity-header">Investment Value</h5>
                                        <span className="fund-entity-details">₹{row.transactionAmount}</span>
                                    </div>
                                    <div className="funds-folio-number fund-entity">
                                        <h5 className="fund-entity-header">Folio-Number</h5>
                                        <span className="fund-entity-details">{row.transactionId}</span>
                                    </div>
                                    <div className="funds-units fund-entity">
                                        <h5 className="fund-entity-header">Date</h5>
                                        <span className="fund-entity-details">{row.business_date}</span>
                                    </div>
                                    <div className="funds-redeem fund-entity">
                                        <Link to='/transaction'><button className="btn-investment" key={idx}>View</button></Link>
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
