import React, { useEffect } from 'react'
import "./Home.scss"
import Register from '../Register/Register'
import anime from 'animejs';
import Login from '../Login/Login'
import { Route, Routes } from 'react-router-dom'; // Correct import



export default function Home() {
    useEffect(() => {
        const arrow = document.querySelector('.arrow-move');

        anime({
            targets: arrow,
            strokeDashoffset: [anime.setDashoffset, 0],
            easing: 'linear',
            duration: 10000,
            delay: function (el, i) { return i * 250 },
            loop: true
        });
    }, []);

    useEffect(() => {
        const arrow = document.querySelector('.arrow-two');
        anime({
            targets: arrow,
            strokeDashoffset: [anime.setDashoffset, 0],
            easing: 'linear',
            duration: 10000,
            delay: function (el, i) { return i * 250 },
            loop: true
        });
    }, []);

    return (
        <div className="home-container">
            <div className="left-container">
                <h1>UpFunds</h1>
                <p>Discover financial growth with UpFunds. Our personalized mutual funds and expert guidance
                    nurture your prosperity, supporting your journey towards a secure and rewarding future.
                </p>
            </div>
            <div className="right-container">
                {<Routes>
                    <Route path="*" element={<Register />} />
                    <Route path="/login" element={<Login />} />
                    <Route path="/register" element={<Register />} />
                </Routes>}
            </div>
            <div className="arrow">
                <svg
                    id="wave"
                    width="100vw"
                    height="calc(100vh - 50px)"
                    style={{ transform: 'rotate(0deg)', transition: '0.3s' }}
                    viewBox="0 0 1440 330"
                    version="1.1"
                    xmlns="http://www.w3.org/2000/svg"
                >
                    <path
                        style={{ transform: 'translate(0, 0px)' }}
                        className="arrow-move"
                        d="M0,198L65.5,66L130.9,165L196.4,0L261.8,99L327.3,66L392.7,231L458.2,99L523.6,198L589.1,33L654.5,198L720,99L785.5,198L850.9,165L916.4,66L981.8,132L1047.3,99L1112.7,132L1178.2,165L1243.6,198L1309.1,231L1374.5,297L1440,99"
                        fill="none"
                        stroke="#3399FF"
                        strokeWidth="3"
                    ></path>
                </svg>
            </div>
            <div className="arrow-second">
                <svg
                    id="wave"
                    width="100vw"
                    height="calc(100vh - 50px)"
                    style={{ transform: 'rotate(0deg)', transition: '0.3s' }}
                    viewBox="0 0 1440 330"
                    version="1.1"
                    xmlns="http://www.w3.org/2000/svg"
                >
                    <path
                        style={{ transform: 'translate(0, 0px)' }}
                        className="arrow-two"
                        d="M0,198L65.5,132L130.9,198L196.4,66L261.8,165L327.3,33L392.7,231L458.2,99L523.6,198L589.1,66L654.5,198L720,132L785.5,231L850.9,99L916.4,165L981.8,0L1047.3,99L1112.7,66L1178.2,198L1243.6,132L1309.1,231L1374.5,297L1440,99"
                        fill="none"
                        stroke="#FF5733"
                        strokeWidth="3"
                    ></path>
                </svg>
            </div>
        </div>
    )
}
