import React, { useEffect, useState } from 'react';
import { useLocation } from 'react-router-dom';
import Sidebar from './side_course';
import './css/course_meterials.css';
import './css/course_mu.css';

const CourseMaterials = () => {
	const location = useLocation();
	const [courseId, setCourseId] = useState(null);
	const [materials, setMaterials] = useState([]);
	const [baseURL, setBaseURL] = useState('');
	const [userRole, setUserRole] = useState(null);

	useEffect(() => {
		const { protocol, host } = window.location;
		setBaseURL(`${protocol}//${host.split(':')[0]}:8080`);
	}, []);

	useEffect(() => {
		const queryParams = new URLSearchParams(location.search);
		const id = queryParams.get('courseId');
		if (id && baseURL) {
			setCourseId(id);
			fetchMaterials(id);
		}

		const storedUserRole = sessionStorage.getItem('userRole');
		setUserRole(storedUserRole);
	}, [location, baseURL]);

	const fetchMaterials = async (id) => {
		const apiUrl = `${baseURL}/api/courseMaterials/${id}`;

		try {
			const response = await fetch(apiUrl, {
				headers: {
					Accept: "application/json",
				},
				method: "GET",
			});

			if (!response.ok) {
				throw new Error(`Fetch error / status: ${response.status}`);
			}

			const data = await response.json();
			setMaterials(data);
		} catch (error) {
			console.error('Fetch error:', error);
		}
	};

	return (
		<>
			<Sidebar courseId={courseId} />

			<main>
				<div className="header">
					<a href={`/CourseBoard?courseId=${courseId}`} className="button">전체 목록</a>
					<a href={`/notices?courseId=${courseId}`} className="button">공지 사항</a>
					<a href={`/CourseMaterials?courseId=${courseId}`} className="button active">강의 자료</a>
					<a href={`/questions?courseId=${courseId}`} className="button">질문</a>
					{(userRole === '0' || userRole === '2') && (
						<a href={`/WriteMaterials?courseId=${courseId}`} className="material_write_button">강의 자료 작성</a>
					)}
				</div>

				<div className="course-board-list">
					{materials.length > 0 ? (
						materials.map((material) => (
							<div className="course-note" key={material.postId}>
								<span className="board-title">{material.title}</span>
								<div className="item-mt">
									<div className="file-list">
										<div className="file-info">
											<span className="file" style={{ float: 'left' }}>첨부된 파일</span>
											<div className="files" style={{ clear: 'both' }}>
												{material.attachments && material.attachments.length > 0 ? (
													material.attachments.map((file, index) => (
														<a key={index} href="#">{file}</a>
													))
												) : (
													<span>업로드된 자료가 없습니다.</span>
												)}
											</div>
										</div>
									</div>
								</div>
							</div>
						))
					) : (
						<div className="course-note">
							<div className="item-mt">
								<div className="file-list">
									<div className="file-info">
										<span className='noFile'>업로드된 자료가 없습니다.</span>
									</div>
								</div>
							</div>
						</div>
					)}
				</div>

				{(userRole === '0' || userRole === '2') && (
					<a href="/write-material" className="notice_write_button_mobile">자료 등록</a>
				)}
			</main>
		</>
	);
};

export default CourseMaterials;
