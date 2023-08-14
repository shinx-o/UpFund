import React from 'react'
import "./NavBar.scss"
import { Link } from 'react-router-dom'

export default function NavBar() {
    return (
        <div className='navbar-container'>
            <div className="left-part">
                <Link to="/" className='navlink logo-upfunds'>UpFunds</Link>
                <Link to="/" className='navlink'>Home</Link>
                <Link to="/aboutus" className='navlink'>About Us</Link>
                <Link to="/contact" className='navlink'>Contact</Link>
            </div>
            <div className="right-part">
                <span className="profile-pic">Profile</span>
            </div>
        </div>
    )
}
