import React, {useEffect, useState} from 'react';
import axios from 'axios';

function Update() {
    const [update, setUpdate] = useState('')

    useEffect(() => {
        axios.get('/api/update')
            .then(response => setUpdate(response.data))
            .catch(error => console.log(error))
    }, []);

    return (
        <div>
            업데이트 점검 중(프론트 -> react 변경) : {update}
        </div>
    );
}

export default Update;
