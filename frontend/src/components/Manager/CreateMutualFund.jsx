import React, { useEffect, useState } from 'react'
import './CreateMutualFund.scss'
import Form from 'react-bootstrap/Form';
import Table from 'react-bootstrap/Table';
import { BsXCircleFill } from "react-icons/bs";
import { Link } from 'react-router-dom';
import { getAllStocks } from '../DataFetch/fetchManagerData';




export default function CreateMutualFund() {
    const [passwordVisible, setPasswordVisible] = useState(false);
    const [stocksList, setStocksList] = useState([]);
    const [addStock, setAddStocks] = useState([]);
    const [enableButton, setEnableButton] = useState(false);
    const [corpus, setCorpus] = useState(1000000000);
    const [mutualFundData, setMutualFundData] = useState({
        mutualFundName: '',
        entryLoad: 0,
        exitLoad: 0,
        expenseRatio: 0,
        stocks: []
    });


    const togglePasswordVisibility = () => {
        setPasswordVisible(true);
    };

    useEffect(() => {
        async function fetchMutualFunds() {
            try {
                const response = await getAllStocks();
                setStocksList(response);
            } catch (error) {
                console.error(error);
            }
        }
        fetchMutualFunds();
    }, []);

    const handleCheckBox = (event) => {
        const fields = document.getElementsByClassName("checkbox-field")
        if (event.target.checked) {
            for (let field of fields) {
                const withoutPrefix = field.id.substring("field-".length);
                if (withoutPrefix === event.target.value) {
                    field.disabled = false;
                }
            }
        } else {
            for (let field of fields) {
                const withoutPrefix = field.id.substring("field-".length);
                if (withoutPrefix === event.target.value) {
                    field.disabled = true;
                }
            }
        }
    }

    const handleAddStocks = () => {
        setPasswordVisible(false);
        const checkboxes = document.getElementsByClassName("form-check-input");
        const fields = document.getElementsByClassName("checkbox-field");
        const stocks = []
        for (let i in checkboxes) {
            if (checkboxes[i].checked) {
                const obj = {
                    stockId: checkboxes[i].value,
                    weightage: parseFloat(fields[i].value) / 100
                }
                stocks.push(obj);
            }
        }

        const validStocks = stocks.filter(element => {
            return (element.weight > 0);
        })

        setAddStocks(prevAddStocks => [...prevAddStocks, ...validStocks]); // Update addStocks state

        // Update mutualFundData state (if needed)
        setMutualFundData(prevMutualFundData => ({
            ...prevMutualFundData,
            stocks: [...prevMutualFundData.stocks, ...validStocks],
        }));
    }


    const handleFields = (event) => {
        if (parseFloat(event.target.value) >= 100) {
            event.target.value = 100;
        }
    }

    const handleSubmit = () => {
        const fundName = parseFloat(document.getElementById("fundName").value);
        const entryLoad = parseFloat(document.getElementById("entryLoad").value);
        const exitLoad = parseFloat(document.getElementById("exitLoad").value);
        setMutualFundData(prev => ({
            ...prev,
            mutualFundName: fundName,
            entryLoad: entryLoad,
            exitLoad: exitLoad,
        }))

        console.log(mutualFundData);
    }

    return (
        <div className='create-container'>
            <div className="create-fields">
                <div className="left-container">
                    <Form data-bs-theme="dark">
                        <Form.Group className="mb-3" >
                            <Form.Label htmlFor='mfn' className="field-label">Mutual Fund Name</Form.Label>
                            <Form.Control name="mfn" id='fundName' type="text" className='field' placeholder="Random Name" />
                        </Form.Group>
                        <Form.Group className="mb-3" >
                            <Form.Label htmlFor='entryLoad' className="field-label">Entry Load</Form.Label>
                            <Form.Control name='entryLoad' id='entryLoad' type="number" min={1} max={4} step='0.1' defaultValue={0.1} className='field' placeholder="Entry Load" />
                        </Form.Group>
                        <Form.Group className="mb-3" >
                            <Form.Label htmlFor='exitLoad' className="field-label">Exit Load</Form.Label>
                            <Form.Control name='exitLoad' id='exitLoad' type="number" min={1} max={4} step='0.1' defaultValue={0.1} className='field' placeholder="Exit Load" />
                        </Form.Group>
                        <div className="btn-group">
                            <button className="stock-btn" onClick={togglePasswordVisibility}>Add / Edit Stocks</button>
                            <button className="stock-btn submit-btn" onClick={handleSubmit} >Create Mutual Fund</button>
                        </div>
                    </Form>
                </div>
                <div className="line-part"></div>
                <div className="right-container">
                    <h6 className='stock-header'>Stocks Added :</h6>
                    <div className="line"></div>
                    <div className="stock-list-container">
                        <Table variant='dark' className='stock-table'>
                            <thead>
                                <tr>
                                    <th>Stock Name</th>
                                    <th>Stock Weightage</th>
                                </tr>
                            </thead>
                            <tbody>
                                {(addStock && addStock.length>0) && addStock.map(stock => {
                                    return (
                                        <tr key={stock.stockId}>
                                            <td>{stock.stockId}</td>
                                            <td>{stock.weight}</td>
                                        </tr>
                                    )
                                })}
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
                            {stocksList && stocksList.map(stock => {
                                return (
                                    <div className="check-field" key={stock.stockId}>
                                        <Form.Group className="mb-3 form-fields" >
                                            <Form.Check type='checkbox' onChange={handleCheckBox} id={`check-${stock.stockId}`} className='checkbox data-checkbox' label={stock.stockName} value={stock.stockId} />
                                            <Form.Control type="number" disabled id={`field-${stock.stockId}`} onChange={handleFields} min={0} max={100} step='0.1' className='checkbox-field' required />
                                        </Form.Group>
                                    </div>
                                )
                            })}
                        </div>
                        <div className="stock-data-bottom">
                            <button className="add-stocks" onClick={handleAddStocks}>Confirm</button>
                        </div>
                    </div>
                </div>
                <button className="close" onClick={e => setPasswordVisible(false)}><BsXCircleFill /></button>
            </div>
        </div>
    )
}
