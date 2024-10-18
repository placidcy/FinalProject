import React, { useEffect, useState } from 'react';
import { BrowserRouter as Router, Route, Routes, useLocation } from 'react-router-dom';
import Sidebar from "./Course_Notice/Sidebar_course";

const CourseBoard = () => {
	const location = useLocation();
	const queryParams = new URLSearchParams(location.search);
	const [baseUrl, setBaseUrl] = useState('');
	const courseId = queryParams.get('courseId');

	useEffect(() => {
		const { protocol, host } = window.location;
		setBaseUrl(`${protocol}//${host.split(':')[0]}:8080`);
	}, [location]);

	const handleRedirect = () => {
		if (courseId) {
			const redirectUrl = `${baseUrl}/goCourseHome?courseId=${courseId}`;
			window.location.href = redirectUrl;
		} else {
			console.error('Course ID is not available.');
		}
	};

	return (
		<div>
			<h1>강의 게시판</h1>
			<p>여기에 강의 게시판 내용을 작성하세요.</p>
			<a href={`${baseUrl}/goCourseHome?courseId=${courseId}`}>강의 게시판</a>
			<Sidebar courseId={courseId} />
		</div>
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