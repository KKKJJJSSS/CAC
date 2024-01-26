import React, {useEffect, useState} from 'react';
import axios from 'axios';

function App2() {
    const [hello2, setHello2] = useState('')

    useEffect(() => {
        axios.get('/api/hello2')
            .then(response => setHello2(response.data))
            .catch(error => console.log(error))
    }, []);

    return (
        <div>
            백엔드에서 가져온 데이터입니다2 : {hello2}
        </div>
    );
}

export default App2;
