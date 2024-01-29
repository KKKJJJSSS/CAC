import React, {useEffect} from 'react';
import axios from 'axios';
import {useNavigate} from "react-router-dom";

function Redirection_kakaologout() {

    const navigate = useNavigate();

    useEffect(() => {
        axios.get('/kakao/reset-session')
            .then(response => {
                if (response.status === 200) {
                    navigate('/');
                } else {
                    alert("에러 발생");
                }
            })
            .catch(error => console.log(error));

    }, []);
}

export default Redirection_kakaologout;