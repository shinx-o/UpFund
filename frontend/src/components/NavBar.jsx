import React from 'react'
import "./NavBar.scss"

export default function NavBar() {
    return (
        <div className='navbar-container'>
            <div className="left-part">
                <a href="#home" className="nav-link logo-upfunds">UpFunds</a>
                <a href="#home" className="nav-link">Home</a>
                <a href="#home" className="nav-link">About Us</a>
                <a href="#home" className="nav-link">Contact</a>
            </div>
            <div className="right-part">
                <span className="profile-pic">Profile</span>
            </div>
        </div>
    )
}
