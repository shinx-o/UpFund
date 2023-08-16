import React from 'react'
import "./ManagerDashboard.scss"
import { DataGrid } from '@mui/x-data-grid';
import Stack from '@mui/material/Stack';
import Button from '@mui/material/Button';
import { Link } from 'react-router-dom';

export default function ManagerDashBoard() {
    const columns = [
        { field: 'id', headerName: 'ID', align: 'center', width: 70 },
        { field: 'fundName', headerName: 'Fund Name', align: 'center', width: 130 },
        { field: 'cashBalance', headerName: 'Cash Balance', type: 'number', align: 'center', width: 130 },
        { field: 'entryLoad', headerName: 'Entry Load', align: 'center', width: 130 },
        { field: 'exitLoad', headerName: 'Exit Load', align: 'center', width: 130 },
        { field: 'expenseRatio', headerName: 'Expense Ratio', type: 'number', align: 'center', width: 130 },
        { field: 'latestNav', headerName: 'Current NAV', type: 'number', align: 'center', width: 130 }

    ];
    const rows = [
        { id: 1, fundName: "Growth Fund", cashBalance: 10000000, entryLoad: '2%', exitLoad: '1.5%', expenseRatio: 0.02, latestNav: 150.00 },
        { id: 2, fundName: "Income Fund", cashBalance: 5000000, entryLoad: '1%', exitLoad: '1%', expenseRatio: 0.015, latestNav: 120.50 },
        { id: 3, fundName: "Equity Fund", cashBalance: 8000000, entryLoad: '1.5%', exitLoad: '1%', expenseRatio: 0.018, latestNav: 180.75 },
        { id: 4, fundName: "Balanced Fund", cashBalance: 7500000, entryLoad: '1.2%', exitLoad: '1%', expenseRatio: 0.017, latestNav: 135.80 },
        { id: 5, fundName: "Technology Fund", cashBalance: 6000000, entryLoad: '2.5%', exitLoad: '2%', expenseRatio: 0.025, latestNav: 220.30 },
        { id: 6, fundName: "Global Fund", cashBalance: 9000000, entryLoad: '2%', exitLoad: '1.8%', expenseRatio: 0.022, latestNav: 175.20 },
    ];

    return (
        <div className='dashboard-container' >
            <div className="mutual-fund-container">
                <div className="mutual-fund-table">
                    <div style={{ height: '80%', width: '100%' }}>
                        <DataGrid
                            sx={{ backgroundColor: '#292b35', color: '#B8B9BA' }}
                            rows={rows}
                            columns={columns}
                            initialState={{
                                pagination: {
                                    paginationModel: { page: 0, pageSize: 5 },
                                },
                            }}
                            pageSizeOptions={[5, 10]}
                            checkboxSelection
                        />
                    </div>
                </div>
                <div className="mutual-fund-btns">
                    <Stack spacing={2} direction="row" style={{ float: 'right', marginRight: '0' }}>
                        <Link to='/createMutualFund'><Button variant="contained" style={{ backgroundColor: '#8167A9' }}>Create</Button></Link>
                        <Button variant="contained" style={{ backgroundColor: '#8167A9' }}>Delete</Button>
                    </Stack>
                </div>
            </div>
            <div className="mutual-fund-charts-container">
            </div>
        </div >
    )
}
