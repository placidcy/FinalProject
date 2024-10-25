import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Link } from "react-router-dom";
import "../css/course_notice.css";
import "../css/course_mu.css";
import Sidebar from "../side_course";

// Axios 기본 설정
axios.defaults.headers.common['Access-Control-Allow-Origin'] = 'http://localhost:3000';

function CourseNotice_Main() {
	const [noticeList, setNoticeList] = useState([]);
	const [userInfo, setUserInfo] = useState({});
	const [courseName, setCourseName] = useState("");
	const [courseId, setCourseId] = useState(0);

	// useEffect를 사용하여 컴포넌트가 처음 렌더링될 때 데이터 가져오기
	useEffect(() => {
		const storedCourseId = sessionStorage.getItem("courseId");
		if (storedCourseId) {
			setCourseId(JSON.parse(storedCourseId));
		}
		axios.get('/getCourseNoticePosts', {
			headers: {
				"Content-Type": "application/json",
			}
		})
			.then(response => setNoticeList(Array.from(response.data)))
			.catch(error => console.log(error));
		axios.get("/getUserInfo",
			{
				headers: {
					"Content-Type": "application/json"
				}
			})
			.then((response) => { setUserInfo(JSON.parse(response.data)) })
			.catch((error) => { console.log(error) });


		axios.get("/getCourseName",
			{
				headers: {
					"Content-Type": "application/json"
				}
			})
			.then((response) => { setCourseName(JSON.stringify(response.data)) })
			.catch((error) => { console.log(error) });

		/*axios.get("/getCourseId",
			{
				headers: {
					"Content-Type": "application/json"
				}
			})
			.then((response) => {
				let responseResult = sessionStorage.setItem("course_id", JSON.parse(response.data))
				if(responseResult != null)
					setCourseId(sessionStorage.getItem("course_id").course_id)
			})
			.catch((error) => { console.log(error) });*/
	}, []); // 빈 배열을 두 번째 인자로 사용하여 컴포넌트가 처음 렌더링될 때 한 번만 실행

	console.log(courseId);

	return (
		<div className="container" id="container">
			<Sidebar courseId={courseId} />

			<main className="contents">
				<div className="header">
					<Link to={`/CourseBoard?courseId=${courseId}`}><div className="button">전체 목록</div></Link>
					<Link to={`/notices?courseId=${courseId}`}><div className="button active">공지 사항</div></Link>
					<Link to={`/CourseMaterials?courseId=${courseId}`}><div className="button">강의 자료</div></Link>
					<Link to={`/questions?courseId=${courseId}`}><div className="button">질문</div></Link>
				</div>
				<div className="announcement">
					<div className="item">
						{
							noticeList.map((notice, index) => {
								return (
									<div key={index}>
										<Link to="">
											<span className="title">{notice.noticeTitle}</span>
											<span className="date">게시일: {notice.regDate}</span>
											<span className="content">{notice.noticeContents}</span>
										</Link>
										<br />

										{notice.attachment != null ? <Link to="">첨부파일명</Link> : null}
									</div>
								)
							})
						}
					</div>
				</div>

				{
					userInfo.m_role == 2 ? <Link to="http://localhost:8080/admin/notice/write"><div className="notice_write_button_mobile">공지 작성</div></Link> : null
				}
			</main>
		</div>
	);
}

export default CourseNotice_Main;
