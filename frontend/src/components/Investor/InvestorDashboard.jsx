import React from 'react'
import "./InvestorDashboard.scss"
import { DataGrid } from '@mui/x-data-grid';
import Stack from '@mui/material/Stack';
import Button from '@mui/material/Button';
import { Link } from 'react-router-dom';

export default function InvestorDashboard() {
    const columns = [
        { field: 'id', headerName: 'ID', align: 'center', width: 40 },
        { field: 'fundName', headerName: 'Fund Name', align: 'center', width: 130 },
        { field: 'type', headerName: 'Type', align: 'center', width: 40 },
        { field: 'units', headerName: 'Units', type: 'number', align: 'center', width: 80 },
        { field: 'amount', headerName: 'Amount', type: 'number', align: 'center', width: 100 },
        { field: 'date', headerName: 'Date', align: 'center', width: 100 },
    ];
    const rows = [
        { id: 1, fundName: "Growth Fund", type: 'buy', units: '1024', amount: '120000', date: '22-06-2023' },
        { id: 2, fundName: "Income Fund", type: 'sell', units: '500', amount: '55000', date: '15-07-2023' },
        { id: 3, fundName: "Equity Fund", type: 'buy', units: '800', amount: '90000', date: '05-03-2023' },
        { id: 4, fundName: "Balanced Fund", type: 'sell', units: '750', amount: '81000', date: '08-09-2023' },
        { id: 5, fundName: "Technology Fund", type: 'buy', units: '600', amount: '72000', date: '30-11-2023' }
    ];

    return (
        <div className='dashboard-container' >
            <div className="mutual-fund-container">
                <div className="mutual-fund-table">
                    <div style={{ height: '80%', width: '60%' }}>
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
