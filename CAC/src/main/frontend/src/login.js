import React, {useEffect, useState} from 'react';
import axios from 'axios';

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

    const handleLogin = () => {
        window.location.replace(kakaoUrl);
    };

    return (
        <main className="col-md-9 ms-sm-auto col-lg-10 px-md-4">
            <div className="card">
                <div className="col-12 upload-btn">
                    <a>
                        <img className="kakao" alt="kakao" src="img/kakao_login.png" onClick={handleLogin}/>
                    </a>
                </div>
            </div>
        </main>
    );
}

export default Login;
