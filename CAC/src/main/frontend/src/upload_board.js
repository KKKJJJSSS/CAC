import React, {useEffect, useState} from 'react';
import axios from 'axios';
import {useNavigate} from "react-router-dom";
import moment from 'moment';

function UploadBoard() {

    const [kakao_id, setKakaoId] = useState([]);
    const navigate = useNavigate();

    useEffect(() => {
        axios.get('/api/id-check')
            .then(response => {
                if (response.status !== 200) {
                    navigate("/login");
                } else {
                    setKakaoId(response.data.kakao_id);
                }
            })
            .catch(error => console.log(error));
    }, []);

    const handleSubmit = (event) => {
        event.preventDefault();

        if (form_check()) {
            const form = event.target;
            axios.post('/api/new-table', new FormData(form))
                .then(response => {
                    if (response.status === 200) {
                        navigate("/");
                    }
                })
                .catch(error => {
                    alert("게시물 등록을 실패했습니다.");
                    console.log(error);
                });
        }
    };

    const form_check = () => {
        const title = document.getElementById("title").value;
        const location = document.getElementById("location").value;
        const age = document.getElementById("age").value;
        const relationship = document.getElementById("relationship").value;
        const money = document.getElementById("money").value;
        const money_type = document.getElementById("money_type").value;

        if (title === "") {
            alert("건물명을 입력해 주세요.");
            return false;
        }

        if (location === "") {
            alert("지역을 입력해 주세요.");
            return false;
        }

        if (age === "") {
            alert("나이를 입력해 주세요.");
            return false;
        } else if (isNaN(age)) {
            alert("숫자를 입력해 주세요.");
            return false;
        }

        if (relationship === "") {
            alert("관계를 입력해 주세요.");
            return false;
        }

        if (money === "") {
            alert("금액을 입력해 주세요.");
            return false;
        } else if (isNaN(money)) {
            alert("숫자를 입력해 주세요.");
            return false;
        }

        if (money_type === "") {
            alert("선택해 주세요.");
            return false;
        }

        return true;
    };

    return (
        <main className="col-md-9 ms-sm-auto col-lg-10 px-md-4">
            <div className="card" style={{ marginTop: '6rem!important' }}>
                <form className="row g-3 card-content" method="post" name="board" onSubmit={handleSubmit}>
                    <div className="col-md-6">
                        <label className="form-label" htmlFor="title">건물명</label>
                        <input className="form-control" id="title" name="title" placeholder="ex) 웨딩스퀘어 강남점" type="text" />
                    </div>
                    <div className="col-md-6">
                        <label className="form-label" htmlFor="location">주소</label>
                        <input className="form-control" id="location" name="location" placeholder="ex) 서울특별시 강남구" type="text" />
                    </div>
                    <div className="col-md-6">
                        <label className="form-label" htmlFor="age">본인 나이</label>
                        <input className="form-control" id="age" name="age" placeholder="ex) 20" type="text" />
                    </div>
                    <div className="col-md-6">
                        <label className="form-label" htmlFor="relationship">관계</label>
                        <input className="form-control" id="relationship" name="relationship" placeholder="ex) 친구(20)" type="text" />
                    </div>
                    <div className="col-md-6">
                        <label className="form-label" htmlFor="money">금액</label>
                        <input className="form-control" id="money" name="money" placeholder="ex) 100000" type="text" />
                    </div>
                    <div className="col-md-6">
                        <label className="form-label" htmlFor="money_type">수입/지출</label><br />
                        <select className="form-control" name="money_type" id="money_type">
                            <option value="">선택</option>
                            <option value="수입">수입</option>
                            <option value="지출">지출</option>
                        </select>
                    </div>
                    <input type="hidden" name="kakao_id" value={kakao_id} />
                    <input type="hidden" name="create_date" value={moment().format('YYYY-MM-DD')} />
                    <div className="col-12 upload-btn">
                        <button className="btn btn-success" type="submit">등록</button>
                    </div>
                </form>
            </div>
        </main>
    );
}

export default UploadBoard;
