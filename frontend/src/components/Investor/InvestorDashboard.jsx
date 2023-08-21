import React, { useState } from 'react'
import "./InvestorDashboard.scss"
import LineChart from './LineChart/LineChart';
import DoughnutChart from './DoughnutChart/DoughnutChart';
import dummyLogo from '../../dummyLogo.jpg';


export default function InvestorDashboard() {
    const [moveTransition, setMoveTransition] = useState(false);

    const handleMove = () => {
        setMoveTransition(!moveTransition);
    }

    const investmentRows = [
        { id: 132392, fundName: "Growth Fund", units: '1024', amount: '120000', date: '22-06-2023' },
        { id: 132323, fundName: "Income Fund", units: '500', amount: '55000', date: '15-07-2023' },
        { id: 145234, fundName: "Equity Fund", units: '800', amount: '90000', date: '05-03-2023' },
        { id: 135262, fundName: "Balanced Fund", units: '750', amount: '81000', date: '08-09-2023' },
        { id: 123525, fundName: "Technology Fund", units: '600', amount: '72000', date: '30-11-2023' }
    ];
    
    const transactionRows = [
        { id: 132392, fundName: "Growth Fund", amount: '120000', date: '22-06-2023' },
        { id: 132323, fundName: "Income Fund", amount: '55000', date: '15-07-2023' },
        { id: 145234, fundName: "Equity Fund", amount: '90000', date: '05-03-2023' },
        { id: 135262, fundName: "Balanced Fund", amount: '81000', date: '08-09-2023' },
        { id: 123525, fundName: "Technology Fund", amount: '72000', date: '30-11-2023' }
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
                    <button className="invest-button">Invest</button>
                </div>
            </div>
            <div className="middle">
                <div className="left">
                    <div className="donut-chart">
                        <DoughnutChart data={investmentRows} />
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
                        {investmentRows.map((row, idx) => {
                            return (
                                <div className="funds" key={idx} style={{ borderBottom: `${idx === investmentRows.length - 1 && "none"}` }}>
                                    <img src={dummyLogo} alt="" className="fund-img" />
                                    <div className="funds-name">
                                        <h4>{row.fundName}</h4>
                                        <div className="fund-name-details">
                                            <span className='cap'>Large Cap</span>
                                            <span className="risk">High risk</span>
                                        </div>
                                    </div>
                                    <div className="funds-investment fund-entity">
                                        <h5 className="fund-entity-header">Investment Value</h5>
                                        <span className="fund-entity-details">₹{row.amount}</span>
                                    </div>
                                    <div className="funds-units fund-entity">
                                        <h5 className="fund-entity-header">Units</h5>
                                        <span className="fund-entity-details">{row.units}.00</span>
                                    </div>
                                    <div className="funds-folio-number fund-entity">
                                        <h5 className="fund-entity-header">Folio-Number</h5>
                                        <span className="fund-entity-details">{row.id}</span>
                                    </div>
                                    <div className="funds-redeem fund-entity">
                                        <button className="btn-investment">Redeem</button>
                                        <span className="fund-entity-details exit-load">Exit Load of 1%</span>
                                    </div>
                                </div>
                            )
                        })}
                    </div>
                    <div className={`funds-container ${moveTransition ? 'move-down' : 'move-up'}`}>
                        {transactionRows.map((row, idx) => {
                            return (
                                <div className="funds" key={idx} style={{ borderBottom: `${idx === transactionRows.length - 1 && "none"}` }}>
                                    <img src={dummyLogo} alt="" className="fund-img" />
                                    <div className="funds-name">
                                        <h4>{row.fundName}</h4>
                                        <div className="fund-name-details">
                                            <span className='cap'>Large Cap</span>
                                            <span className="risk">High risk</span>
                                        </div>
                                    </div>
                                    <div className="funds-investment fund-entity">
                                        <h5 className="fund-entity-header">Investment Value</h5>
                                        <span className="fund-entity-details">₹{row.amount}</span>
                                    </div>
                                    <div className="funds-folio-number fund-entity">
                                        <h5 className="fund-entity-header">Folio-Number</h5>
                                        <span className="fund-entity-details">{row.id}</span>
                                    </div>
                                    <div className="funds-units fund-entity">
                                        <h5 className="fund-entity-header">Date</h5>
                                        <span className="fund-entity-details">{row.date}</span>
                                    </div>
                                    <div className="funds-redeem fund-entity">
                                        <button className="btn-investment" key={idx}>View</button>
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
