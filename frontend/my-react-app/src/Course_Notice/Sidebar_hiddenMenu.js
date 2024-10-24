import "../css/course_mu.css";
import { Link } from "react-router-dom";

function Sidebar_hiddenMenu(props) {
	let hostAddress = "http://localhost:8080"
	
	// 임시
	let courseId = 2;
	
	let sideBarForStudent = 
					<>
						<ul className="sidebar-menu">
						<Link to="/home"
							className="menu"
							style={{ width: "33.3%" }}>
							<li>홈</li></Link>
	
						<Link to={`/CourseBoard?courseId=${courseId}`} className="sidebar-menu-unselected" style={{ width: "33.3%" }}><li>강의 게시판</li></Link>
	
						<Link to={`${hostAddress}/attendanceCalendar`}
							className="menu"
							style={{ width: "33.3%" }}>
							<li>출결 확인</li></Link>
						</ul>
					</>

	let sideBarForOthers = 
					<>
						<ul className="sidebar-menu">
							<Link to="/home"
								className="menu"
								style={{ width: "25%" }}>
								<li>홈</li></Link>
	
							<Link to={`/CourseBoard?courseId=${courseId}`} className="sidebar-menu-unselected" style={{ width: "25%" }}><li>강의 게시판</li></Link>
	
							<Link to={`${hostAddress}/currentAttendance`}
								className="menu"
								style={{ width: "25%" }}>
								<li>출결 확인</li></Link>
	
	
							<Link to={`${hostAddress}/acceptanceManagement`}
								className="menu"
								style={{ width: "25%" }}>
								<li>수강 신청 관리</li></Link>
	
	
							<Link to={`${hostAddress}/courseAttend`}
								className="menu"
								style={{ width: "25%" }}>
								<li>강의 일정 관리</li></Link>						
						</ul>
					
						<ul id="menuList" style={{ visibility: "hidden" }}>
								<li><Link to="/">코스</Link></li>
								<li><Link to={`${hostAddress}/main/checkin_i`}>출석 체크</Link></li>
								<li><Link to={`${hostAddress}/mypage`}>마이 페이지</Link></li>
								<li><Link to={`${hostAddress}/notice`}>공지사항</Link></li>
								<li><Link to={`${hostAddress}/logout`}>로그아웃</Link></li>
						</ul>	
					</>
	return (
		<>
			{props.userRole === 1 ? sideBarForStudent : sideBarForOthers}
		</>
	)
}

export default Sidebar_hiddenMenu;