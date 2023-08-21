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
            <div className="input-container">
                
            </div>
        </div>
    )
}
