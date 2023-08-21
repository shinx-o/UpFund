import React, { useState } from 'react'
import "./NavBar.scss"
import { Link, useNavigate } from 'react-router-dom'
import Avatar from '@mui/material/Avatar';
import { deepPurple } from '@mui/material/colors';
import { BsHouseFill, BsFillInfoCircleFill, BsFillTelephoneOutboundFill } from "react-icons/bs";

export default function NavBar() {
    const [isOpen, setIsOpen] = useState(false);
    const [isSignOut, setIsSignOut] = useState(false);
    const navigate = useNavigate();

    const handleAnimation = () => {
        setIsOpen(!isOpen);
    };
    
    const handleLogout = () => {
        setIsSignOut(false);
        setIsOpen(false);
        navigate("/login")
    }


    return (
        <div className='navbar-container'>
            <div className="left-part">
                <div className="ham">
                    <div className={`icon nav-icon-4 icon-background  ${isOpen ? 'open' : ''}`} onClick={handleAnimation}>
                        <span></span>
                        <span></span>
                        <span></span>
                    </div>
                </div>
                <Link to="/" id="home" className={`navlink ${isOpen ? 'move-out-home' : 'move-in-home'}`}><BsHouseFill /></Link>
                <Link to="/aboutus" id="about" className={`navlink ${isOpen ? 'move-out-about' : 'move-in-about'}`}><BsFillInfoCircleFill /></Link>
                <Link to="/contact" id="contact" className={`navlink ${isOpen ? 'move-out-contact' : 'move-in-contact'}`}><BsFillTelephoneOutboundFill /></Link>
            </div>
            <div className={`right-part ${isSignOut ? "open-profile" : "" }`}>
                <button className={`signout ${isSignOut ? "open-profile" : "close-profile" }`} onClick={handleLogout}>Sign Out</button>
                <Avatar sx={{ bgcolor: deepPurple[500] }} className="profile-pic" onClick={e => {setIsSignOut(!isSignOut)}}>AK</Avatar>
            </div>
        </div>
    )
}
