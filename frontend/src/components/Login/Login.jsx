import React, { useState } from 'react'
import "../Register/Register.scss"
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import { Link } from 'react-router-dom';
import { BsEyeFill, BsEyeSlashFill } from 'react-icons/bs';


export default function Login() {
    const [passwordVisible, setPasswordVisible] = useState(false);

    const togglePasswordVisibility = () => {
        setPasswordVisible(prevVisible => !prevVisible);
    };
    return (
        <div className="login-container">
            <div className="fields">
                <Form data-bs-theme="dark">
                    <Form.Group className="mb-3" >
                        <Form.Control type="text" placeholder="Enter Your Phone Number/Email" required />
                    </Form.Group>
                    <Form.Group className="mb-3" >
                        <Form.Control type={passwordVisible ? 'text' : 'password'} id="inputPassword5" placeholder='Enter Password' required />
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
                <Button variant="primary" className="login-btn">Login</Button>
            </div>
            <div className="link-container">
                <span>Not Registered?</span>
                <Link to="/register" className="login-link">Register</Link>
            </div>
        </div>
    )
}
