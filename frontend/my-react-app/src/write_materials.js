import React, { useEffect, useState } from 'react';
import { useLocation, useNavigate } from 'react-router-dom';
import Sidebar from './side_course';
import './css/write_materials.css';

const WriteMaterials = () => {
	const location = useLocation();
	const navigate = useNavigate();
	const [title, setTitle] = useState('');
	const [attachments, setAttachments] = useState([]);
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

	const handleTitleChange = (e) => {
		setTitle(e.target.value);
	};

	const handleFileChange = (e) => {
		const files = Array.from(e.target.files);
		setAttachments(files);
	};

	const handleSubmit = async (e) => {
		e.preventDefault();

		if (!title || attachments.length === 0) {
			alert("제목과 첨부파일을 모두 입력해 주세요.");
			return;
		}

		const formData = new FormData();
		formData.append('title', title);
		formData.append('courseId', courseId);

		const userId = sessionStorage.getItem('userId');

		if (userId) {
			formData.append('userId', userId);
		} else {
			alert('사용자 ID를 찾을 수 없습니다.');
			return;
		}

		attachments.forEach((file) => {
			formData.append('attachments', file);
		});

		try {
			const response = await fetch(`${baseURL}/api/courseMaterials`, {
				method: 'POST',
				body: formData,
			});

			if (!response.ok) {
				throw new Error(`Error: ${response.status}`);
			}

			alert('자료가 성공적으로 업로드되었습니다!');
			navigate(`/CourseBoard?courseId=${courseId}`);
		} catch (error) {
			console.error('업로드 오류:', error);
			alert('자료 업로드 중 오류가 발생했습니다.');
		}
	};

	const handleCancel = () => {
		setTitle('');
		setAttachments([]);
	};

	const handleFileInputClick = () => {
		document.getElementById('file-input').click();
	};

	return (
		<div id="container">
			<Sidebar courseId={courseId} />

			<main>
				<div className="wm_header">
					<a href={`/CourseBoard?courseId=${courseId}`} className="button">전체 목록</a>
					<a href={`/notices?courseId=${courseId}`} className="button">공지 사항</a>
					<a href={`/CourseMaterials?courseId=${courseId}`} className="button active">강의 자료</a>
					<a href={`/questions?courseId=${courseId}`} className="button">질문</a>
				</div>

				<div className="wm_write-material">
					<h1>강의 자료 작성</h1>

					<div className="wm_wt_buttons">
						<a href="#" onClick={handleSubmit}>
							<div className="wm_save_button">저장</div>
						</a>
						<a href="#" onClick={handleCancel}>
							<div className="wm_cancel_button">취소</div>
						</a>
					</div>

					<hr />

					<div className='wm_course-write'>
						<div className="wm_course-title-wt">
							<span className="wm_title">제목</span>
							<input
								type="text"
								value={title}
								onChange={handleTitleChange}
								placeholder="제목을 작성해 주세요."
								required
							/>
						</div>

						<div className="wm_coruse-day">
							<div className="wm_file_input">
								<span className="wm_title">파일</span>
								<span className="wm_title select-file" onClick={handleFileInputClick}>
									이미지 / 문서 첨부
								</span>
								<input
									type="file"
									id="file-input"
									multiple
									onChange={handleFileChange}
									style={{ display: 'none' }}
								/>
								{attachments.length > 0 && (
									<div className="wm_file-list">
										<h4>첨부된 파일 :</h4>
										<ul>
											{attachments.map((file, index) => (
												<li key={index}>{file.name}</li>
											))}
										</ul>
									</div>
								)}
							</div>
						</div>
					</div>

					<div className="wm_buttons-mobile">
						<a href="#" onClick={handleSubmit}>
							<div className="wm_save_button">저장</div>
						</a>
						<a href="#" onClick={handleCancel}>
							<div className="wm_cancel_button">취소</div>
						</a>
					</div>
				</div>
			</main>
		</div>
	);
};

export default WriteMaterials;
