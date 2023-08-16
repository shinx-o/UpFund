import React, { useState } from 'react'
import './CreateMutualFund.scss'
import Form from 'react-bootstrap/Form';
import Table from 'react-bootstrap/Table';
import { BsXCircleFill } from "react-icons/bs";
import { Link } from 'react-router-dom';




export default function CreateMutualFund() {
    const [passwordVisible, setPasswordVisible] = useState(false);

    const togglePasswordVisibility = () => {
        setPasswordVisible(true);
    };

    const stocks = [
        "Apple Inc.",
        "Microsoft Corporation",
        "Amazon.com Inc.",
        "Alphabet Inc. (Google)",
        "Facebook Inc.",
        "Tesla Inc.",
        "NVIDIA Corporation",
        "Visa Inc.",
        "Mastercard Incorporated",
        "Johnson & Johnson",
        "Procter & Gamble Co.",
        "Walmart Inc.",
        "The Home Depot Inc.",
        "JPMorgan Chase & Co.",
        "Bank of America Corporation",
        "Verizon Communications Inc.",
        "AT&T Inc.",
        "Intel Corporation",
        "Coca-Cola Company",
        "Netflix Inc.",
        "Adobe Inc.",
        "McDonald's Corporation",
        "IBM",
        "The Walt Disney Company",
        "PayPal Holdings Inc."
    ]


    return (
        <div className='create-container'>
            <div className="create-fields">
                <div className="left-container">
                    <Form data-bs-theme="dark">
                        <Form.Group className="mb-3" >
                            <Form.Label htmlFor='mfn' className="field-label">Mutual Fund Name</Form.Label>
                            <Form.Control name="mfn" type="text" className='field' placeholder="Random Name" required />
                        </Form.Group>
                        <Form.Group className="mb-3" >
                            <Form.Label htmlFor='entryLoad' className="field-label">Entry Load</Form.Label>
                            <Form.Control name='entryLoad' type="number" min={1} max={8} step='0.1' defaultValue={0.1} className='field' placeholder="Entry Load" required />
                        </Form.Group>
                        <Form.Group className="mb-3" >
                            <Form.Label htmlFor='exitLoad' className="field-label">Exit Load</Form.Label>
                            <Form.Control name='exitLoad' type="number" min={1} max={8} step='0.1' defaultValue={0.1} className='field' placeholder="Exit Load" required />
                        </Form.Group>
                        <div className="btn-group">
                            <button className="stock-btn" onClick={togglePasswordVisibility}>Add Stocks</button>
                            <button className="stock-btn" onClick={togglePasswordVisibility}>Edit Stocks</button>
                            <Link to='/managerDashboard'><button className="stock-btn submit-btn">Create Mutual Fund</button></Link>
                        </div>
                    </Form>
                </div>
                <div className="line-part"></div>
                <div className="right-container">
                    <h6 className='stock-header'>Stocks Added :</h6>
                    <div className="line"></div>
                    <div className="stock-list-container">
                        <Table striped="columns" variant='dark' className='stock-table'>
                            <thead>
                                <tr>
                                    <th>Stock Name</th>
                                    <th>Stock Weightage</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>Mark</td>
                                    <td>Otto</td>
                                </tr>
                            </tbody>
                        </Table>
                    </div>
                </div>
            </div>
            <div className={`stock-container ${passwordVisible ? '' : 'visible'}`}>
                <div className="stock-form">
                    <div className="stock-data">
                        <div className="stock-data-top-header">
                            <span>Stock Names</span>
                            <span>Enter Stock Weightages</span>
                        </div>
                        <div className="stock-data-top">
                            {stocks.map((stock,idx) => {
                                return (
                                    <div className="check-field" key={idx}>
                                        <Form.Group className="mb-3 form-fields">
                                            <Form.Check type='checkbox' className='checkbox' label={stock} value={stock} />
                                            <Form.Control type="number" min={0} max={100} step='0.1' className='checkbox-field' required />
                                        </Form.Group>
                                    </div>
                                )
                            })}
                        </div>
                        <div className="stock-data-bottom">
                            <button className="add-stocks">Add Stocks</button>
                        </div>
                    </div>
                </div>
                <button className="close" onClick={e => setPasswordVisible(false)}><BsXCircleFill /></button>
            </div>
        </div>
    )
}
