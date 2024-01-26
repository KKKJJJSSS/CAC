import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App';
import Update from './update';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    <React.StrictMode>
        <App/>
        <Update/>
    </React.StrictMode>,
);

