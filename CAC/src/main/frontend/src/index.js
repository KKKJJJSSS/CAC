import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App';
import App2 from './hello2';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    <React.StrictMode>
        <App/>
        <App2/>
    </React.StrictMode>,
);

