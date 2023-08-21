import React, { useState } from 'react'
import "../Register/Register.scss"
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import { Link, useNavigate } from 'react-router-dom';
import { BsEyeFill, BsEyeSlashFill } from 'react-icons/bs';
import axios from 'axios';


export default function Login() {
    // const { dispatch } = useAuth();
    const navigate = useNavigate();

    
    const [passwordVisible, setPasswordVisible] = useState(false);

    const togglePasswordVisibility = () => {
        setPasswordVisible(prevVisible => !prevVisible);
    };

    const handleLogin = async () => {
        // dispatch({ type: 'LOGIN_REQUEST' });
        const username = document.getElementById("username").value;
        const password = document.getElementById("password").value;

        try {
            const response = await axios.post('http://localhost:5000/login', { username, password });
            console.log(response.data);
            if(response.data.isAdmin && response.data.authenticated) {
                navigate("/managerDashboard");
            }else if (!response.data.isAdmin && response.data.authenticated) {
                navigate("/investorDashboard");
            }else {
                console.log("Invalid Creds")
            }
        } catch (error) {
            console.log(error);
        }
    };
    return (
        <div className="login-container">
            <div className="fields">
                <Form data-bs-theme="dark">
                    <Form.Group className="mb-3" >
                        <Form.Control type="text" id="username" placeholder="Enter Your Phone Number/Email" required />
                    </Form.Group>
                    <Form.Group className="mb-3" >
                        <Form.Control type={passwordVisible ? 'text' : 'password'} id="password" placeholder='Enter Password' required />
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
               <Button variant="primary" className="login-btn" onClick={handleLogin}>Login</Button>
            </div>
            <div className="link-container">
                <span>Not Registered?</span>
                <Link to="/register" className="login-link">Register</Link>
            </div>
        </div>
    )
}
