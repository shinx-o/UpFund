import React from 'react'
import "./Register.scss"
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';

export default function Register() {
    return (
        <div className="login-container">
            <div className="fields">
                <Form data-bs-theme="dark">
                    <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                        <Form.Control type="text" placeholder="Enter Full Name" required />
                    </Form.Group>
                    <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                        <Form.Control type="text" placeholder="Enter Phone Number" required />
                    </Form.Group>
                    <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                        <Form.Control type="text" placeholder="Enter Your Username" required />
                    </Form.Group>
                    <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                        <Form.Control type="email" placeholder="Enter Email" required />
                    </Form.Group>
                    <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                        <Form.Control type="password" id="inputPassword5" placeholder='Enter Password' required />
                    </Form.Group>
                </Form>
            </div>
            <div className="btn-container">
                <Button variant="primary" className="login-btn">Register</Button>
            </div>
            <div className="link-container">
                <span>Already Registered?</span>
                <a href="/login" className="login-link">Login</a>
            </div>
        </div>
    )
}
