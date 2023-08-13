import React from 'react'
import "./Register.scss"
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';

export default function Login() {
    return (
        <div className="login-container">
            <div className="fields">
                <Form data-bs-theme="dark">
                    <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                        <Form.Control type="text" placeholder="Enter Your Username" required />
                    </Form.Group>
                    <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                        <Form.Control type="password" id="inputPassword5" placeholder='Enter Password' required />
                    </Form.Group>
                </Form>
            </div>
            <div className="btn-container">
                <Button variant="primary" className="login-btn">Login</Button>
            </div>
            <div className="link-container">
                <span>Not Registered?</span>
                <a href="/login" className="login-link">Register</a>
            </div>
        </div>
    )
}
