import React, {useState, useEffect} from 'react';
import axios from 'axios';

function Table() {
    const [paging, setPaging] = useState([]);
    const [keyword, setKeyword] = useState('');
    const [averageMoney, setAverageMoney] = useState('');
    const [pageNumber, setPageNumber] = useState(0);
    const [totalPages, setTotalPages] = useState(0);
    const pageSize = 15;

    const handleSearch = (event) => {
        event.preventDefault();
    };

    useEffect(() => {
        fetchData();
    }, [pageNumber, keyword]);

    const fetchData = () => {
        axios.get(`/api/table?page=${pageNumber}&keyword=${keyword}`)
            .then(response => {
                const {totalPages, averageMoney, paging} = response.data;
                setPaging(paging.content);
                setTotalPages(totalPages);
                setAverageMoney(averageMoney);
            })
            .catch(error => console.log(error));
    };

    const handlePageChange = (page) => {
        setPageNumber(page);
        fetchData();
    };

    const handleDelete = (id) => {
        axios.post('/api/table/delete', {id})
            .then((response) => {
                if (response.status === 200) {
                    alert("삭제 되었습니다.");
                    fetchData();
                }
            })
            .catch(error => {
                console.log(error);
                alert("권한이 없습니다.");
            });
    };

    return (
        <main className="data-list col-md-9 ms-sm-auto col-lg-10 px-md-4">
            <div className="row">
                <div className="col avg">
                        <p>추천 금액 : {averageMoney}</p>
                </div>
                <div className="col">
                    <form className="d-flex search" onSubmit={handleSearch}>
                        <input className="form-control me-2" id="search" name="keyword" placeholder="Search" type="text"
                               value={keyword} onChange={(e) => setKeyword(e.target.value)}/>
                    </form>
                </div>
            </div>
            <table className="table table-striped table-sm">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">건물명</th>
                    <th scope="col">지역</th>
                    <th scope="col">나이(본인)</th>
                    <th scope="col">관계</th>
                    <th scope="col">금액</th>
                    <th scope="col">수입/지출</th>
                    <th scope="col">등록일</th>
                </tr>
                </thead>
                <tbody>
                {paging.map((data, index) => (
                    <tr key={data.id}>
                        <th scope="row">{index + 1 + (pageNumber * pageSize)}</th>
                        <td>{data.title}</td>
                        <td>{data.location}</td>
                        <td>{data.age}</td>
                        <td>{data.relationship}</td>
                        <td>{data.money}</td>
                        <td>{data.money_type}</td>
                        <td>{data.create_date}</td>
                        <td>
                            <form action="/api/table/delete" method="post">
                                <input type="hidden" name="id" value={data.id}/>
                                <button className="delete-btn" type="submit" onClick={(event) => {
                                    event.preventDefault();
                                    handleDelete(data.id);
                                }}>
                                    삭제
                                </button>
                            </form>
                        </td>
                    </tr>
                ))}
                </tbody>
            </table>
            {totalPages > 0 && (
                <div>
                    <ul className="pagination justify-content-center">
                        <li className={`page-item ${pageNumber === 0 ? 'disabled' : ''}`}>
                            <button className="page-link" onClick={() => handlePageChange(pageNumber - 1)}>
                                이전
                            </button>
                        </li>
                        {Array.from({length: totalPages}, (_, i) => i).map((page) => (
                            <li key={page} className={`page-item ${page === pageNumber ? 'active' : ''}`}>
                                <button className="page-link" onClick={() => handlePageChange(page)}>
                                    {page + 1}
                                </button>
                            </li>
                        ))}
                        <li className={`page-item ${pageNumber === totalPages - 1 ? 'disabled' : ''}`}>
                            <button className="page-link" onClick={() => handlePageChange(pageNumber + 1)}>
                                다음
                            </button>
                        </li>
                    </ul>
                </div>
            )}
        </main>
    );
}

export default Table;

