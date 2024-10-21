import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Link } from "react-router-dom";
import "../css/course_notice.css";
import "../css/common.css";
import Sidebar_course from "./Sidebar_course";

// Axios 기본 설정
axios.defaults.headers.common['Access-Control-Allow-Origin'] = 'http://localhost:3000';

function CourseNotice_Main() {
    const [data, setData] = useState("");

    // useEffect를 사용하여 컴포넌트가 처음 렌더링될 때 데이터 가져오기
    useEffect(() => {
        axios.get('http://localhost:8080/getCourseNoticePosts', {
            headers: {
                "Content-Type": "application/json",
            }
        })
        .then(response => setData(response.data))
        .catch(error => console.log(error));
    }, []); // 빈 배열을 두 번째 인자로 사용하여 컴포넌트가 처음 렌더링될 때 한 번만 실행

    return (
        <div className="container" id="container">
            <Sidebar_course />
            <main class="contents">
                <div className="header">
                    <Link to=""><div className="button">전체 목록</div></Link>
                    <Link to=""><div className="button active">공지 사항</div></Link>
                    <Link to=""><div className="button">강의 자료</div></Link>
                    <Link to=""><div className="button">질문</div></Link>
                </div>
                <Link to=""><div className="notice_write_button">공지 작성</div></Link>
                <div className="announcement">
                    <div className="item">
                        <Link to="">
                            <span className="title"></span>
                            <span className="date">게시일: </span>
                            <span className="content"></span>
                        </Link>
                        <br />
                        <Link to="">첨부파일명</Link>
                    </div>
                </div>
                <Link to=""><div className="notice_write_button_mobile">공지 작성</div></Link>
            </main>
        </div>
    );
}

export default CourseNotice_Main;
