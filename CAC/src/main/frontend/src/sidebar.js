import React, {useEffect, useState} from 'react';
import axios from 'axios';
import {Link, useNavigate} from "react-router-dom";

function Sidebar() {
    const [user_id, setUserId] = useState('');
    const [kakaoLogoutUrl, setKakaoLogoutUrl] = useState('');
    const navigate = useNavigate();

    useEffect(() => {
        axios.get('/api/sidebar')
            .then(response => {
                const responseData = response.data;
                setUserId(responseData.user_id);
                setKakaoLogoutUrl(responseData.kakaoLogoutUrl);
            })
            .catch(error => console.log(error));
    }, []);


    const click = (e)=>{
        navigate("/login");
    };

    return (
        <div className="sidebar border border-right col-md-3 col-lg-2 p-0 bg-body-tertiary">
            <ul className="list-group list-group-flush">
                <li className="list-group-item">
                    <Link to={"/"} className="icon-link">
                        <svg aria-hidden="true" className="bi">
                            <use xlinkHref="#house-fill"></use>
                        </svg>
                        Home
                    </Link>
                </li>
                <li className="list-group-item">
                    <Link to={"/upload_board"} className="icon-link">
                        <svg aria-hidden="true" className="bi">
                            <use xlinkHref="#file-earmark-text"></use>
                        </svg>
                        Upload
                    </Link>
                </li>
                <hr></hr>
                {user_id === null && (
                    <li className="list-group-item">
                        {/*<Link to={"/login"} className="icon-link">*/}
                        {/*    <svg aria-hidden="true" className="bi">*/}
                        {/*        <use xlinkHref="#door-open"></use>*/}
                        {/*    </svg>*/}
                        {/*    Login*/}
                        {/*</Link>*/}
                        <button onClick={click}>login</button>
                    </li>
                )}
                {user_id !== null && (
                    <li className="list-group-item">
                        <Link to={kakaoLogoutUrl} className="icon-link">
                            <svg aria-hidden="true" className="bi">
                                <use xlinkHref="#door-closed"></use>
                            </svg>
                            Logout
                        </Link>
                    </li>
                )}
            </ul>
        </div>
    );
}

export default Sidebar;
