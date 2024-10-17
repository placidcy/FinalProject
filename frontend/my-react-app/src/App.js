import React, { useEffect, useState } from 'react';
import { BrowserRouter as Router, Route, Routes, useLocation } from 'react-router-dom';
import Sidebar from './side_course';
import './css/course_board.css';
import './css/course_mu.css';

const CourseBoard = () => {
	const location = useLocation();
	const [courseId, setCourseId] = useState(null);
	const [posts, setPosts] = useState([]);
	const [baseURL, setBaseURL] = useState('');

	useEffect(() => {
		const { protocol, host } = window.location;
		setBaseURL(`${protocol}//${host.split(':')[0]}:8080`);
	}, []);

	useEffect(() => {
		const queryParams = new URLSearchParams(location.search);
		const id = queryParams.get('courseId');
		if (id && baseURL) {
			setCourseId(id);
			fetchPosts(id);
		}
	}, [location, baseURL]);

	const fetchPosts = async (id) => {
		const apiUrl = `${baseURL}/api/coursesBoard/${id}`;

		try {
			const response = await fetch(apiUrl, {
				headers: {
					Accept: "application/json",
				},
				method: "GET",
			});

			if (!response.ok) {
				throw new Error(`response 오류 / status: ${response.status}`);
			}

			const data = await response.json();
			setPosts(data);
		} catch (error) {
			console.error('Fetch error:', error);
		}
	};

	// 게시글 분류
	const notices = posts.filter(post => post.typeId === 1);
	const materials = posts.filter(post => post.typeId === 2);
	const questions = posts.filter(post => post.typeId === 3);

	return (
		<>
			<Sidebar courseId={courseId} />

			<main>
				<div className="header">
					<div className="button active">전체 목록</div>
					<div className="button">공지 사항</div>
					<div className="button">강의 자료</div>
					<div className="button">질문</div>
				</div>

				<div className="course-board-list">
					<div className="course-notice">
						<span className="board-title">공지 사항</span>
						<div className="item">
							{notices.length > 0 ? (
								notices.map(notice => (
									<a href="#" className="post" key={notice.postId}>
										<span className="title">{notice.title}</span>
										<span className="date">게시일: {notice.regDate}</span>
									</a>
								))
							) : (
								<span>작성된 공지 사항이 없습니다.</span>
							)}
						</div>
					</div>

					<div className="course-materials">
						<span className="board-title">강의 자료</span>
						<div className="item">
							{materials.length > 0 ? (
								materials.map((material) => (
									<div key={material.postId}>
										<a href="#" className="title">{material.title}</a>
										<div className="file-list">
											<div className="file-info">
												<span className="file">첨부된 파일</span>
												<div className="files">
													{material.attachments && material.attachments.map((file, index) => (
														<a key={index} href="#">{file}</a>
													))}
													{material.attachments.length === 0 && (
														<span>업로드된 자료가 없습니다.</span>
													)}
												</div>
											</div>
										</div>
									</div>
								))
							) : (
								<span>업로드된 자료가 없습니다.</span>
							)}
						</div>
					</div>

					<div className="course-question">
						<span className="board-title">질문</span>
						<div className="item">
							{questions.length > 0 ? (
								questions.map(question => (
									<a href="#" className="post" key={question.postId}>
										<span className="title">{question.title}</span>
										<span className="date">게시일: {question.regDate}</span>
									</a>
								))
							) : (
								<span>작성된 질문 게시글이 없습니다.</span>
							)}
						</div>
					</div>
				</div>
			</main>
		</>
	);
};

const App = () => {
	return (
		<Router>
			<Routes>
				<Route path="/CourseBoard" element={<CourseBoard />} />
			</Routes>
		</Router>
	);
};

export default App;
