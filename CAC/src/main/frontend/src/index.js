import React from 'react';
import ReactDOM from 'react-dom/client';
import {BrowserRouter} from "react-router-dom";
import Nav from "./nav";
import Sidebar from "./sidebar";
import Table from "./table";
import "./index.css";

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    <React.StrictMode>
        <BrowserRouter>
            <Nav/>
            <div style={{display: 'flex'}}>
                <Sidebar/>
                <Table/>
            </div>
        </BrowserRouter>
    </React.StrictMode>,
);

