import React, {useEffect} from 'react';
import axios from 'axios';
import {useLocation, useNavigate} from "react-router-dom";

function Redirection_kakaologin() {

    const navigate = useNavigate();
    const location = useLocation();
    const searchParams = new URLSearchParams(location.search);
    const code = searchParams.get('code');

    useEffect(() => {
        if (code) {
            axios.get('/api/kakao/callback', {
                params: {
                    code: code
                }
            })
                .then(response => {
                    if (response.status === 200) {
                        navigate('/');
                    } else {
                        alert("에러 발생");
                    }
                })
                .catch(error => console.log(error));
        } else {
            alert("로그인 에러");
        }
    }, [code]);
}

export default Redirection_kakaologin;