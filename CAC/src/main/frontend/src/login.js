import React, {useEffect, useState} from 'react';
import axios from 'axios';
import {Link} from "react-router-dom";

function Login() {
    const [kakaoUrl, setKakaoUrl] = useState('');

    useEffect(() => {
        axios.get('/api/login')
            .then(response => {
                const responseData = response.data;
                setKakaoUrl(responseData.kakaoUrl);
            })
            .catch(error => console.log(error));
    }, []);

    return (
        <main className="col-md-9 ms-sm-auto col-lg-10 px-md-4">
            <div className="card">
                <div className="col-12 upload-btn">
                    <Link to={kakaoUrl} >
                        <img className="kakao" alt="kakao" src="img/kakao_login.png" />
                    </Link>
                </div>
            </div>
        </main>
    );
}

export default Login;
