import React, { useState } from 'react'
import "./Register.scss"
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import { BsEyeFill, BsEyeSlashFill } from "react-icons/bs";
import { Link } from 'react-router-dom';


export default function Register() {
    const [passwordVisible, setPasswordVisible] = useState(false);

    const togglePasswordVisibility = () => {
        setPasswordVisible(prevVisible => !prevVisible);
    };


    return (
        <div className="login-container">
            <div className="fields">
                <Form data-bs-theme="dark">
                    <Form.Group className="mb-3" >
                        <Form.Control type="text" placeholder="Full Name" required />
                    </Form.Group>
                    <Form.Group className="mb-3" >
                        <Form.Control type="text" placeholder="Phone Number" required />
                    </Form.Group>
                    <Form.Group className="mb-3" >
                        <Form.Control type="email" placeholder="Email" required />
                    </Form.Group>
                    <Form.Group className="mb-3" >
                        <Form.Control type={passwordVisible ? 'text' : 'password'} id="inputPassword5" placeholder='Password' required />
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
                <Button variant="primary" className="login-btn">Register</Button>
            </div>
            <div className="link-container">
                <span>Already Registered?</span>
                <Link to="/login" className="login-link">Login</Link>
            </div>
        </div>
    )
}
