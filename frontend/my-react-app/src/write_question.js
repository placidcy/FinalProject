import React, { useEffect, useState } from 'react';
import { useLocation, useNavigate } from 'react-router-dom';
import Sidebar from './side_course';
import './css/write_question.css';
import axios from 'axios';

// 기본 axios 헤더 설정
axios.defaults.headers.common['Access-Control-Allow-Origin'] = 'http://localhost:3000';

const WriteQuestion = () => {
	const location = useLocation();
	const navigate = useNavigate();
	const [title, setTitle] = useState('');
	const [content, setContent] = useState('');
	const [courseId, setCourseId] = useState(null);
	const [userId, setUserId] = useState(null);
	const [baseURL, setBaseURL] = useState('');

	useEffect(() => {
		const queryParams = new URLSearchParams(location.search);
		const id = queryParams.get('courseId');
		setCourseId(id);

		const user = sessionStorage.getItem('userId');
		setUserId(user);

		const { protocol, host } = window.location;
		setBaseURL(`${protocol}//${host.split(':')[0]}:8080`);
	}, [location]);

	const handleCancel = () => {
		if (window.confirm("취소하시겠습니까?")) {
			navigate(`/CourseQuestion?courseId=${courseId}`);
		}
	};

	const handleSubmit = async (e) => {
		e.preventDefault();

		if (!title || !content) {
			alert("제목과 내용을 모두 입력해 주세요.");
			return;
		}

		try {
			const response = await axios.post(`${baseURL}/api/courseQuestions`, {
				title,
				content,
				memberId: userId,
				courseId,
			}, {
				headers: {
					'Content-Type': 'application/json',
				},
			});

			if (!response.status === 200) {
				throw new Error(`오류: ${response.status}`);
			}

			alert('질문이 성공적으로 업로드되었습니다!');
			navigate(`/CourseQuestion?courseId=${courseId}`);
		} catch (error) {
			console.error('업로드 오류:', error);
			alert('질문 업로드 중 오류가 발생했습니다.');
		}
	};

	return (
		<>
			<Sidebar courseId={courseId} />

			<main>
				<div className="wq_header">
					<a href={`/CourseBoard?courseId=${courseId}`} className="button">전체 목록</a>
					<a href={`/notices?courseId=${courseId}`} className="button">공지 사항</a>
					<a href={`/CourseMaterials?courseId=${courseId}`} className="button">강의 자료</a>
					<a href={`/CourseQuestion?courseId=${courseId}`} className="button active">질문</a>
				</div>

				<div className="wq_write-question">
					<h1>질문 작성</h1>

					<div className="wq_wt_buttons">
						<button onClick={handleSubmit} className="wq_save_button">저장</button>
						<button onClick={handleCancel} className="wq_cancel_button">취소</button>
					</div>

					<hr />

					<div className='wq_course-write'>
						<div className="wq_course-title-wt">
							<span className="wq_title">제목</span>
							<input
								type="text"
								value={title}
								onChange={(e) => setTitle(e.target.value)}
								placeholder="제목을 작성해 주세요."
								required
							/>
						</div>
						<div className="wq_course-content-wt">
							<span className="wq_title">내용</span>
							<textarea
								value={content}
								onChange={(e) => setContent(e.target.value)}
								placeholder="내용을 작성해 주세요."
								required
							/>
						</div>
					</div>
				</div>

				<div className="wq_buttons-mobile">
					<button onClick={handleSubmit} className="wq_save_button">저장</button>
					<button onClick={handleCancel} className="wq_cancel_button">취소</button>
				</div>
			</main>
		</>
	);
};

export default WriteQuestion;
