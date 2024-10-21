import "../css/course_mu.css";
function Sidebar_hiddenMenu(props) {
	return (
		<>
			<ul className="sidebar-menu">
				<a href="/home" className="sidebar-menu-selected" style={{width:'33.333%'}}><li>홈</li></a>
				<a href="#" className="sidebar-menu-unselected" style={{width:'33.333%'}}>
					<li>강의 게시판</li>
				</a>

				<a href="/attendanceCalendar" className="sidebar-menu-unselected" style={{width:'33.333%'}}><li>출결 확인</li></a>
			</ul>

			<ul id="menuList" style={{visibility: 'hidden'}}>
				<li><a href="/">코스</a></li>
				<li>출석 체크</li>
				<li><a href="register">수강 신청</a></li>
				<li><a href="/alert">알림</a></li>
				<li><a href="/mypage">마이 페이지</a></li>
				<li><a href="/notice">공지사항</a></li>
				<li><a href="/logout">로그아웃</a></li>
			</ul>



			<ul className="sidebar-menu">
				<a href="/home" className="sidebar-menu-selected" style={{width:'25%'}}><li>홈</li></a>
				<a href="#" className="sidebar-menu-unselected" style={{width:'25$'}}>
					<li>강의 게시판</li>
				</a>
				<a href="/currentAttendance" className="sidebar-menu-unselected" style={{width:'25%'}}><li>출결 확인</li></a>
				<a href="/acceptanceManagement" className="sidebar-menu-unselected" style={{width:'25%'}}><li>수강 신청 관리</li></a>
				<a href="/courseAttend" className="sidebar-menu-unselected" style={{width:'25%'}}><li>강의 일정 관리</li></a>
			</ul>

			<ul id="menuList" style={{visibility: 'hidden'}}>
				<li><a href="/">코스</a></li>
				<li>출석 체크</li>
				<li><a href="/alert">알림</a></li>
				<li><a href="/mypage">마이 페이지</a></li>
				<li><a href="/notice">공지사항</a></li>
				<li><a href="/logout">로그아웃</a></li>
			</ul>

		</>
	)
}

export default Sidebar_hiddenMenu;