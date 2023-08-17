import React from 'react'
import "./InvestorDashboard.scss"
import LineChart from './LineChart/LineChart';


export default function InvestorDashboard() {
    const rows = [
        { id: 1, fundName: "Growth Fund", type: 'buy', units: '1024', amount: '120000', date: '22-06-2023' },
        { id: 2, fundName: "Income Fund", type: 'sell', units: '500', amount: '55000', date: '15-07-2023' },
        { id: 3, fundName: "Equity Fund", type: 'buy', units: '800', amount: '90000', date: '05-03-2023' },
        { id: 4, fundName: "Balanced Fund", type: 'sell', units: '750', amount: '81000', date: '08-09-2023' },
        { id: 5, fundName: "Technology Fund", type: 'buy', units: '600', amount: '72000', date: '30-11-2023' }
    ];

    return (
        <div className='investor-dashboard-container' >
            <div className="left">
                <div className="investment-container">
                    <div className="theader">
                        <div className="header">Fund Name</div>
                        <div className="header">Units</div>
                        <div className="header">Transaction</div>
                    </div>
                    <div className="tbody-container">
                        <div className="tbody">
                            {rows.map((row, idx) => {
                                return (
                                    <div className="tr" key={idx}>
                                        <div className="td ">{row.fundName}</div>
                                        <div className="td">{row.units}</div>
                                        <button className="td">View</button>
                                    </div>
                                )
                            })}
                        </div>
                    </div>
                </div>
            </div>
            <div className="right">
                <div className="investment-chart">
                <LineChart />
                </div>
                <div className="btn-grp"></div>
            </div>
        </div >
    )
}
