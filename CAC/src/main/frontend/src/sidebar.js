import React, {useEffect, useState} from 'react';
import axios from 'axios';

function Sidebar() {
    const [user_id, setUserId] = useState('');
    const [kakaoLogoutUrl, setKakaoLogoutUrl] = useState('');

    useEffect(() => {
        axios.get('/api/sidebar')
            .then(response => {
                const responseData = response.data;
                setUserId(responseData.user_id);
                setKakaoLogoutUrl(responseData.kakaoLogoutUrl);
            })
            .catch(error => console.log(error));
    }, []);

    return (
        <div className="sidebar border border-right col-md-3 col-lg-2 p-0 bg-body-tertiary">
            <ul className="list-group list-group-flush">
                <li className="list-group-item">
                    <a className="icon-link" href="/">
                        <svg aria-hidden="true" className="bi">
                            <use xlinkHref="#house-fill"></use>
                        </svg>
                        Home
                    </a>
                </li>
                <li className="list-group-item">
                    <a className="icon-link" href="/new-post">
                        <svg aria-hidden="true" className="bi">
                            <use xlinkHref="#file-earmark-text"></use>
                        </svg>
                        Upload
                    </a>
                </li>
                <hr></hr>
                {user_id === null && (
                    <li className="list-group-item">
                        <a className="icon-link" href="/login">
                            <svg aria-hidden="true" className="bi">
                                <use xlinkHref="#door-open"></use>
                            </svg>
                            Login
                        </a>
                    </li>
                )}
                {user_id !== null && (
                    <li className="list-group-item">
                        <a className="icon-link" href={kakaoLogoutUrl}>
                            <svg aria-hidden="true" className="bi">
                                <use xlinkHref="#door-closed"></use>
                            </svg>
                            Logout
                        </a>
                    </li>
                )}
            </ul>
        </div>
    );
}

export default Sidebar;
