<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강사 관리 페이지</title>

<link rel="stylesheet" href="/resources/css/instructorManagement.css">
<link rel="stylesheet" href="/resources/css/admin_aside.css">
<link rel="stylesheet" as="style" crossorigin
	href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.9/dist/web/static/pretendard.min.css" />
</head>
<body>
	<div id="container">
		<jsp:include page="common/admin_sidebar.jsp" />
		<main>
			<div id="manageTableArea">
				<h1 class="h1_Title">강사 관리</h1>

				<div class="nav_SideBarBox">
					<nav id="navBox">
						<div class="backBtnBox">
							<button class="backBtn">
								<img alt="backButton" src="../imgs/backBtn.png" width="15px"
									height="15px">
							</button>
						</div>

						<div id="titleBox">
							<h1>강사 관리</h1>
						</div>

						<div class="menuBtnBox">
							<button class="menuBtn">
								<img alt="menuButton" src="../imgs/menuBtn.png" width="15px"
									height="15px">
							</button>
						</div>
					</nav>

				</div>

				<div class="subtitleInput">
					<div class="inputArea">
						<select>
							<option>이름</option>
							<option>소속</option>
							<option>이메일</option>
							<option>아이디</option>
						</select> <input type="text" placeholder="검색어를 입력하세요" class="researchTag" />
						<button class="researchBtn">검색</button>
					</div>

					<button class="impleBtn issueBtn">발급</button>
				</div>

				<div class="instructorTable">
					<table>
						<thead>
							<tr>
								<th><input type="checkbox" class="checkbox" /></th>
								<th>번호</th>
								<th>이름</th>
								<th>소속</th>
								<th>담당 강의</th>
								<th>이메일</th>
								<th>아이디</th>
							</tr>
						</thead>

						<tbody>
							<tr>
								<td><input type="checkbox" class="checkbox" /></td>
								<td>1</td>
								<td>두루미</td>
								<td>유데미</td>
								<td>HTML의 기초</td>
								<td><a href="#">do@naver.com</a></td>
								<td>do1do</td>
							</tr>

							<tr>
								<td><input type="checkbox" class="checkbox" /></td>
								<td>2</td>
								<td>황새</td>
								<td>유데미</td>
								<td>빅데이터와 비즈니스의 미래</td>
								<td><a href="#">hbird@naver.com</a></td>
								<td>brownbird123</td>
							</tr>

							<tr>
								<td><input type="checkbox" class="checkbox" /></td>
								<td>3</td>
								<td>고길동</td>
								<td>유데미</td>
								<td>데이터베이스 기초 및 설계</td>
								<td><a href="#">ggd@naver.com</a></td>
								<td>gogil777</td>
							</tr>

							<tr>
								<td><input type="checkbox" class="checkbox" /></td>
								<td>4</td>
								<td>김수강</td>
								<td>유데미</td>
								<td>프로그래밍 언어의 기초</td>
								<td><a href="#">ksk@naver.com</a></td>
								<td>ksk333</td>
							</tr>

							<tr>
								<td><input type="checkbox" class="checkbox" /></td>
								<td>5</td>
								<td>강호동</td>
								<td>유데미</td>
								<td>소프트웨어 개발 도구의 이해와 응용</td>
								<td><a href="#">hod@nate.com</a></td>
								<td>hodking404</td>
							</tr>

							<tr>
								<td><input type="checkbox" class="checkbox" /></td>
								<td>6</td>
								<td>남궁혁</td>
								<td>멀티캠퍼스</td>
								<td></td>
								<td><a href="#">ngh@daum.net</a></td>
								<td>hyuk123</td>
							</tr>

							<tr>
								<td><input type="checkbox" class="checkbox" /></td>
								<td>7</td>
								<td>박혁거세</td>
								<td>멀티캠퍼스</td>
								<td></td>
								<td><a href="#">phgs@nate.com</a></td>
								<td>eggking32</td>
								<td></td>

							</tr>
						</tbody>
					</table>
				</div>

				<div class="pagenation">
					<ul>
						<li><a href="#">이전</a></li>
						<li><a href="#">1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">다음</a></li>
					</ul>
				</div>
			</div>
		</main>
	</div>
</body>
</html>