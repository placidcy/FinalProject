import React, { useEffect, useState } from 'react';
import './css/course_mu.css';

const Sidebar = ({ courseId }) => {
	const [baseUrl, setBaseUrl] = useState('');
	const [menuVisible, setMenuVisible] = useState(false);
	const [menuName, setMenuName] = useState('');
	const [userRole, setUserRole] = useState(null);

	useEffect(() => {
		const { protocol, hostname } = window.location;
		setBaseUrl(`${protocol}//${hostname}:8080`);

		const role = sessionStorage.getItem('userRole');
		setUserRole(role ? Number(role) : null);

		if (courseId) {
			fetch(`${baseUrl}/api/courseName/${courseId}`)
				.then(response => {
					if (!response.ok) {
						throw new Error('Network response was not ok');
					}
					return response.text();
				})
				.then(data => {
					setMenuName(data);
				})
				.catch(error => console.error('Error fetching course name:', error));
		}
	}, [courseId, baseUrl]);

	const toggleMenu = () => {
		setMenuVisible(prev => !prev);
	};

	const handleBackButtonClick = () => {
		window.history.back();
	};

	return (
		<aside>
			<div className="course-sidebar-left">
				<ul className="sidebar-menu">
					<li>
						<a href={`${baseUrl}/mypage`}>
							<img className="sidebar-icon" src={require('./img/mypage.png')} alt="마이 페이지" />
						</a>
					</li>
					<li>
						<a href={`${baseUrl}/`}>
							<img className="sidebar-icon" src={require('./img/course.png')} alt="코스" />
						</a>
					</li>
					<li>
						<a href={`${baseUrl}/#`}>
							<img className="sidebar-icon" src={require('./img/attend.png')} alt="출석 체크" />
						</a>
					</li>
					<li>
						<a href={`${baseUrl}/register`}>
							<img className="sidebar-icon" src={require('./img/register.png')} alt="수강 신청" />
						</a>
					</li>
					<li>
						<a href={`${baseUrl}/alert`}>
							<img className="sidebar-icon" src={require('./img/alert.png')} alt="알림" />
						</a>
					</li>
					<li>
						<a href={`${baseUrl}/notice`}>
							<img className="sidebar-icon" src={require('./img/notice.png')} alt="공지사항" />
						</a>
					</li>
					<li>
						<a href={`${baseUrl}/logout`}>
							<img className="sidebar-icon" src={require('./img/logout.png')} alt="로그아웃" />
						</a>
					</li>
				</ul>
			</div>

			<div className="course-sidebar-right">
				<div className="sidebar-logo">
					<a href="home">
						<h1>CHECK</h1>
					</a>
					<h3>{menuName}</h3>
					<hr />
				</div>

				<div id="mobile-menu">
					<h1 id="backBtn" onClick={handleBackButtonClick}>◀</h1>
					<h1 className="menuName">{menuName}</h1>
					<div id="mobile-menu-icon" onClick={toggleMenu}>
						<svg xmlns="http://www.w3.org/2000/svg" width="30px" height="30px" viewBox="0 0 24 24" fill="none">
							<path d="M4 6H20M4 12H20M4 18H20" stroke="#000000" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round" />
						</svg>
					</div>
				</div>

				<ul className="menulist" id="menuList" style={{ visibility: menuVisible ? 'visible' : 'hidden' }}>
					<li className="menu cffffff"><a href={`${baseUrl}/`}>코스</a></li>
					<li className="menu cffffff"><a href={`${baseUrl}/checkin`}>출석 체크</a></li>
					<li className="menu cffffff"><a href={`${baseUrl}/register`}>수강 신청</a></li>
					<li className="menu cffffff"><a href={`${baseUrl}/alert`}>알림</a></li>
					<li className="menu cffffff"><a href={`${baseUrl}/notice`}>공지사항</a></li>
					<li className="menu cffffff"><a href={`${baseUrl}/mypage`}>마이 페이지</a></li>
					<li className="menu cffffff"><a href={`${baseUrl}/logout`}>로그아웃</a></li>
				</ul>

				<ul className="sidebar-menu">
					<a href={`${baseUrl}/goCourseHome?courseId=${courseId}`} className="sidebar-menu-unselected" style={{ width: '33.333%' }}>
						<li>홈</li>
					</a>
					<a href={`/CourseBoard?courseId=${courseId}`} className="sidebar-menu-selected" style={{ width: '33.333%' }}>
						<li>강의 게시판</li>
					</a>
					{(userRole === 1) && (
						<>
							<a href={`${baseUrl}/goAttendanceCalendar?courseId=${courseId}`} className="sidebar-menu-unselected" style={{ width: '33.333%' }}>
								<li>출결 확인</li>
							</a>
						</>
					)}
					{(userRole === 0 || userRole === 2) && (
						<>
							<a href={`${baseUrl}/goCurrentAttendance?courseId=${courseId}`} className="sidebar-menu-unselected" style={{ width: '33.333%' }}>
								<li>출결 확인</li>
							</a>
							<a href={`${baseUrl}/acceptanceManagement`} className="sidebar-menu-unselected" style={{ width: '33.333%' }}>
								<li>수강 신청 관리</li>
							</a>
							<a href={`${baseUrl}/courseAttend`} className="sidebar-menu-unselected" style={{ width: '33.333%' }}>
								<li>강의 일정 관리</li>
							</a>
						</>
					)}
				</ul>
			</div>
		</aside>
	);
};

export default Sidebar;
