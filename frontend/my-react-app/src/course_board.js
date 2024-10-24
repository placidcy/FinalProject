import React, { useEffect, useState } from 'react';
import { useLocation, useNavigate } from 'react-router-dom';
import Sidebar from './side_course';
import './css/course_board.css';

const CourseBoard = () => {
	const location = useLocation();
	const navigate = useNavigate();
	const [courseId, setCourseId] = useState(null);
	const [posts, setPosts] = useState([]);
	const [baseURL, setBaseURL] = useState('');
	const [userId, setUserId] = useState(null);
	const [userRole, setUserRole] = useState(null);

	useEffect(() => {
		const { protocol, host } = window.location;
		setBaseURL(`${protocol}//${host.split(':')[0]}:8080`);
	}, []);

	useEffect(() => {
		const queryParams = new URLSearchParams(location.search);
		const id = queryParams.get('courseId');
		const user = queryParams.get('userId');
		const role = queryParams.get('role');

		if (id && baseURL) {
			setCourseId(id);
			if (user) {
				sessionStorage.setItem('userId', user);
				if (role) {
					sessionStorage.setItem('userRole', role);
				}
				navigate(`/CourseBoard?courseId=${id}`);
			} else {
				const storedUserId = sessionStorage.getItem('userId');
				const storedUserRole = sessionStorage.getItem('userRole');
				setUserId(storedUserId);
				setUserRole(storedUserRole);
			}
			fetchPosts(id);
		}
	}, [location, baseURL, navigate]);

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

	const notices = posts.filter(post => post.typeId === 1);
	const materials = posts.filter(post => post.typeId === 2);
	const questions = posts.filter(post => post.typeId === 3);

	return (
		<>
			<Sidebar courseId={courseId} />

			<main>
				<div className="cb_header">
					<a href={`/CourseBoard?courseId=${courseId}`} className="button active">전체 목록</a>
					<a href={`/notices?courseId=${courseId}`} className="button">공지 사항</a>
					<a href={`/CourseMaterials?courseId=${courseId}`} className="button">강의 자료</a>
					<a href={`/questions?courseId=${courseId}`} className="button">질문</a>
				</div>

				<div className="cb_course-board-list">
					<div className="cb_course-notice">
						<span className="cb_board-title">공지 사항</span>
						<div className="cb_item">
							{notices.length > 0 ? (
								notices.map(notice => (
									<a href="#" className="cb_post" key={notice.postId}>
										<span className="cb_title">{notice.title}</span>
										<span className="cb_date">게시일: {notice.regDate}</span>
									</a>
								))
							) : (
								<span className='cb_noFile'>작성된 공지 사항이 없습니다.</span>
							)}
						</div>
					</div>

					<div className="cb_course-materials">
						<span className="cb_board-title">강의 자료</span>
						<div className="cb_item">
							{materials.length > 0 ? (
								materials.map((material) => (
									<div className='cb_material-list' key={material.postId}>
										<a href="#" className="cb_title">{material.title}</a>
										<div className="cb_file-list">
											<div className="cb_file-info">
												<span className="cb_file">첨부된 파일</span>
												<div className="cb_files">
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
								<span className='cb_noFile'>업로드된 자료가 없습니다.</span>
							)}
						</div>
					</div>

					<div className="cb_course-question">
						<span className="cb_board-title">질문</span>
						<div className="cb_item">
							{questions.length > 0 ? (
								questions.map(question => (
									<a href="#" className="cb_post" key={question.postId}>
										<span className="cb_title">{question.title}</span>
										<span className="cb_date">게시일: {question.regDate}</span>
									</a>
								))
							) : (
								<span className='cb_noFile'>작성된 질문 게시글이 없습니다.</span>
							)}
						</div>
					</div>
				</div>
			</main>
		</>
	);
};

export default CourseBoard;
