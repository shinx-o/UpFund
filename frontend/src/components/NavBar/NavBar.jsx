import React from 'react'
import "./NavBar.scss"
import { Link } from 'react-router-dom'
import Avatar from '@mui/material/Avatar';
import { deepPurple } from '@mui/material/colors';

export default function NavBar() {
    return (
        <div className='navbar-container'>
            <div className="left-part">
                <Link to="/register" className='navlink logo-upfunds'>UpFunds</Link>
                <Link to="/register" className='navlink'>Home</Link>
                <Link to="/aboutus" className='navlink'>About Us</Link>
                <Link to="/contact" className='navlink'>Contact</Link>
            </div>
            <div className="right-part">
            <Avatar sx={{ bgcolor: deepPurple[500] }} className="profile-pic">AK</Avatar>
            </div>
        </div>
    )
}
