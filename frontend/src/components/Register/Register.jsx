import React, { useState } from 'react'
import "./Register.scss"
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import { BsEyeFill, BsEyeSlashFill } from "react-icons/bs";
import { Link, useNavigate } from 'react-router-dom';



export default function Register() {
    const [passwordVisible, setPasswordVisible] = useState(false);
    const navigate = useNavigate();

    const togglePasswordVisibility = () => {
        setPasswordVisible(prevVisible => !prevVisible);
    };

    const [phoneNumber, setPhoneNumber] = useState('');

    const handlePhoneNumberChange = (event) => {
        const inputPhoneNumber = event.target.value;
        // Ensure the input only contains digits
        if (/^\d{0,10}$/.test(inputPhoneNumber)) {
            setPhoneNumber(inputPhoneNumber);
        }
    };

    const handleRegister = async () => {
        // Simulate registration logic
        const investorName = document.getElementById("name").value;
        const investorPhoneNumber = document.getElementById("phoneNumber").value;
        const investorEmail = document.getElementById("email").value;
        const investorPassword = document.getElementById("password").value;
        const userData = { investorPassword, investorName, investorEmail, investorPhoneNumber };
        // dispatch({ type: 'REGISTER', payload: userData });
        console.log(userData);
        navigate('/login');

    };





    return (
        <div className="login-container">
            <div className="fields">
                <Form data-bs-theme="dark">
                    <Form.Group className="mb-3" >
                        <Form.Control type="text" id="name" placeholder="Full Name" required />
                    </Form.Group>
                    <Form.Group className="mb-3" >
                        <Form.Control type="number" id="phoneNumber" value={phoneNumber}
                            onChange={handlePhoneNumberChange}
                            maxLength="10" placeholder="Phone Number" required />
                    </Form.Group>
                    <Form.Group className="mb-3" >
                        <Form.Control type="email" id="email" placeholder="Email" required />
                    </Form.Group>
                    <Form.Group className="mb-3" >
                        <Form.Control type={passwordVisible ? 'text' : 'password'} id="password" placeholder='Password' required />
                        <BsEyeFill
                            className={`eye ${passwordVisible ? 'visible' : ''}`}
                            onClick={togglePasswordVisibility}
                        />
                        <BsEyeSlashFill
                            className={`eye ${!passwordVisible ? 'visible' : ''}`}
                            onClick={togglePasswordVisibility}
                        />
                    </Form.Group>
                </Form>
            </div>
            <div className="btn-container">
                <Button variant="primary" className="login-btn" onClick={handleRegister}>Register</Button>
            </div>
            <div className="link-container">
                <span>Already Registered?</span>
                <Link to="/login" className="login-link">Login</Link>
            </div>
        </div>
    )
}
