import React, { useEffect, useState } from 'react';
import { useLocation } from 'react-router-dom';
import Sidebar from './side_course';
import './css/course_question.css';
import axios from 'axios';

// 기본 axios 헤더 설정
axios.defaults.headers.common['Access-Control-Allow-Origin'] = 'http://localhost:3000';

const QuestionPage = () => {
	const location = useLocation();
	const [courseId, setCourseId] = useState(null);
	const [baseURL, setBaseURL] = useState('');
	const [userRole, setUserRole] = useState(null);
	const [questions, setQuestions] = useState([]);
	const [currentPage, setCurrentPage] = useState(1);
	const [questionsPerPage] = useState(10);

	useEffect(() => {
		const { protocol, host } = window.location;
		setBaseURL(`${protocol}//${host.split(':')[0]}:8080`);
	}, []);

	useEffect(() => {
		const queryParams = new URLSearchParams(location.search);
		const id = queryParams.get('courseId');
		if (id && baseURL) {
			setCourseId(id);
			fetchQuestions(id);
		}

		const storedUserRole = sessionStorage.getItem('userRole');
		setUserRole(storedUserRole);
	}, [location, baseURL]);

	const fetchQuestions = async (id) => {
		const apiUrl = `${baseURL}/api/questions/${id}`;

		try {
			const response = await axios.get(apiUrl, {
				headers: {
					Accept: "application/json",
				},
			});
			setQuestions(response.data);
		} catch (error) {
			console.error('Fetch error:', error);
		}
	};

	const indexOfLastQuestion = currentPage * questionsPerPage;
	const indexOfFirstQuestion = indexOfLastQuestion - questionsPerPage;
	const currentQuestions = questions.slice(indexOfFirstQuestion, indexOfLastQuestion);
	const paginate = (pageNumber) => setCurrentPage(pageNumber);
	const totalPages = Math.ceil(questions.length / questionsPerPage);

	return (
		<>
			<Sidebar courseId={courseId} />

			<main>
				<div className="cq_header">
					<a href={`/CourseBoard?courseId=${courseId}`} className="button">전체 목록</a>
					<a href={`/notices?courseId=${courseId}`} className="button">공지 사항</a>
					<a href={`/CourseMaterials?courseId=${courseId}`} className="button">강의 자료</a>
					<a href={`/CourseQuestion?courseId=${courseId}`} className="button active">질문</a>
					<a href={`/WriteQuestion?courseId=${courseId}`} className="cq_write_button">질문 작성</a>
				</div>

				<div className="cq_course-question">
					{currentQuestions.length > 0 ? (
						currentQuestions.map((question) => (
							<div className="cq_post" key={question.postId}>
								<a href="#">
									<span className="cq_title">{question.title}</span>
									<span className="cq_date">게시일: {question.regDate}</span>
									<span className="cq_comment">댓글: {question.replyCount || 0}</span>
								</a>
							</div>
						))
					) : (
						<div className="cq_post">
							<span>등록된 질문이 없습니다.</span>
						</div>
					)}
				</div>

				<div className="cq_paging_list">
					{currentPage > 1 && (
						<a onClick={() => paginate(currentPage - 1)} href="#">
							<span className="cq_paging">이전</span>
						</a>
					)}

					{Array.from({ length: totalPages }, (_, index) => (
						<a key={index + 1} onClick={() => paginate(index + 1)} href="#">
							<span className={`cq_paging ${currentPage === index + 1 ? 'active' : ''}`}>{index + 1}</span>
						</a>
					))}

					{currentPage < totalPages && (
						<a onClick={() => paginate(currentPage + 1)} href="#">
							<span className="cq_paging">다음</span>
						</a>
					)}
				</div>

				<a href={`/WriteQuestion?courseId=${courseId}`} className="cq_question_write_button_mobile">질문 작성</a>
			</main>
		</>
	);
};

export default QuestionPage;
