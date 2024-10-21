import { Link } from "react-router-dom";
import "../css/course_notice.css";
import Sidebar_course from "./Sidebar_course";
import { useEffect, useState } from "react";
import axios from 'axios';

function CourseNotice_Main() {
	const [data, setData] = useState("");
	
    fetch('http://localhost:8080/getCourseNoticePosts', {
			method: "GET",
			headers: {
				 "Content-Type": "application/json",
				 "Origin" : "http://localhost:3000"
				 
			},
		}
	).then((result) => {setData(result.json())})
	.catch(error => console.log(error));
	
	return (
		<div id="container">
			<Sidebar_course />
			
			<main>
				<div className="header">
					<a href=""><div className="button">전체 목록</div></a>
					<a href=""><div className="button active">공지 사항</div></a>
					<a href=""><div className="button">강의 자료</div></a>
					<a href=""><div className="button">질문</div></a>
				</div>
				<a href="">
					<div className="notice_write_button">공지 작성</div>
				</a>

				<div className="announcement">
					<div className="item">
						<a href="">
							<span className="title"></span>
							<span className="date">게시일: </span>
							<span className="content"></span>
						</a> <br />

						<a href="">첨부파일명</a>
					</div>

				</div>

				<a href="">
					<div className="notice_write_button_mobile">공지 작성</div>
				</a>
			</main>
		</div>
	);
};

export default CourseNotice_Main;