import React, { useEffect, useState } from 'react';
import { Link, useLocation } from 'react-router-dom';
import Sidebar_hiddenMenu from "./Sidebar_hiddenMenu";
import '../css/course_mu.css';

function Sidebar_course() {
	const location = useLocation();
	const [baseUrl, setBaseUrl] = useState('');

	useEffect(() => {
		const { protocol, hostname } = window.location;
		setBaseUrl(`${protocol}//${hostname}:8080`);
	}, [location]);

	return (
		<>
			<aside>
				<div className="course-sidebar-left">
					<ul className="sidebar-menu">
						<li>
							<a href={`${baseUrl}/mypage`}>
								<img className="sidebar-icon" src={require('../img/mypage.png')} alt="마이 페이지" />
							</a>
						</li>
						<li>
							<a href={`${baseUrl}/`}>
								<img className="sidebar-icon" src={require('../img/course.png')} alt="코스" />
							</a>
						</li>
						<li>
							<a href={`${baseUrl}/#`}>
								<img className="sidebar-icon" src={require('../img/attend.png')} alt="출석 체크" />
							</a>
						</li>
						<li>
							<a href={`${baseUrl}/register`}>
								<img className="sidebar-icon" src={require('../img/register.png')} alt="수강 신청" />
							</a>
						</li>
						<li>
							<a href={`${baseUrl}/alert`}>
								<img className="sidebar-icon" src={require('../img/alert.png')} alt="알림" />
							</a>
						</li>
						<li>
							<a href={`${baseUrl}/notice`}>
								<img className="sidebar-icon" src={require('../img/notice.png')} alt="공지사항" />
							</a>
						</li>
						<li>
							<a href={`${baseUrl}/logout`}>
								<img className="sidebar-icon" src={require('../img/logout.png')} alt="로그아웃" />
							</a>
						</li>
					</ul>
				</div>

				<div className="course-sidebar-right">
					<div className="sidebar-logo">
						<a href="home"><h1>CHECK</h1></a>
						<h3>HTML의 기초</h3>
						<hr />
					</div>

					<div id="mobile-menu">
						<h1 id="backBtn">◀</h1>
						<p className="menuName" >HTML의 기초</p>
						<div id="mobile-menu-icon">
							<svg xmlns="http://www.w3.org/2000/svg" width="30px" height="30px" viewBox="0 0 24 24" fill="none">
								<path d="M4 6H20M4 12H20M4 18H20" stroke="#000000" strokeWidth="2" strokeLinecap="round"
									strokeLinejoin="round" />
							</svg>
						</div>
					</div>


					<Sidebar_hiddenMenu />
				</div>
			</aside>
		</>
	);
};

export default Sidebar_course;