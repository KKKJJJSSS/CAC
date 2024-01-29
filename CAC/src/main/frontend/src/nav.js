import React from 'react';
import {Link} from "react-router-dom";

function Nav() {
    return (
        <nav className="navbar sticky-top bg-dark flex-md-nowrap shadow" data-bs-theme="dark">
            <Link to={"/"} className="navbar-brand col-md-3 col-lg-2 me-0 px-3 fs-6 text-white" >CAC</Link>
        </nav>
    );
}

export default Nav;