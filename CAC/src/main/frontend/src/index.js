import React from 'react';
import ReactDOM from 'react-dom/client';
import {BrowserRouter, Route, Routes} from "react-router-dom";

import "./index.css";

import Nav from "./nav";
import Sidebar from "./sidebar";
import Table from "./table";
import Login from "./login";
import Redirection_kakaologin from "./redirection_kakaologin";
import Redirection_kakaologout from "./redirection_kakaologout";
import Upload_board from "./upload_board";

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    <React.StrictMode>
        <BrowserRouter basename={process.env.PUBLIC_URL}>
            <Nav/>
            <div style={{display: 'flex'}}>
                <Routes>
                    <Route path="*" element={<>
                        <Sidebar />
                        <Table />
                    </>} />
                    <Route path="/login" element={<>
                        <Sidebar />
                        <Login />
                    </>} />
                    <Route path="/upload_board" element={<>
                        <Sidebar />
                        <Upload_board />
                    </>} />
                    <Route path="/kakao/callback" element={<Redirection_kakaologin />} />
                    <Route path="/kakao/reset-session" element={<Redirection_kakaologout />} />
                </Routes>
            </div>
        </BrowserRouter>
    </React.StrictMode>,
);

