<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강사 관리 페이지</title>
<link rel="stylesheet" href="/resources/css/admin_aside.css">
<link rel="stylesheet" href="/resources/css/instructorManagement.css">
<link rel="stylesheet" href="/resources/css/instructorDialog.css">
<link rel="stylesheet" href="/resources/css/common.css">
<link rel="stylesheet" as="style" crossorigin
	href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.9/dist/web/static/pretendard.min.css" />
<script src="/resources/js/instructorManagement.js" defer></script>
</head>
<body>
	<div class="container" id="container">
		<jsp:include page="common/admin_sidebar.jsp" />
		<main class="contents">
			<div id="manageTableArea">
				<h1 class="h1_Title">강사 관리</h1>

				<div class="nav_SideBarBox">
					<nav id="navBox">
						<div id="titleBox">
							<h1>강사 관리</h1>
						</div>
					</nav>
				</div>
				<div class="search-and-button">
					<div class="buttonContainer">
						<button class="impleBtn issueBtn" id="openIssueModalBtn">발급</button>
					</div>
					<jsp:include page="./instructor_searchbar.jsp"></jsp:include>
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
							<c:forEach items="${instructorList}" var="instructor"
								varStatus="status">
								<tr>
									<td><input type="checkbox" class="checkbox" /></td>
									<td>${status.count}</td>
									<td>${instructor.m_name}</td>
									<td>${instructor.m_dept}</td>
									<td>${instructor.courseName}</td>
									<td>${instructor.m_email}</td>
									<td>${instructor.m_acctid}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>

				<!-- 발급 모달창 -->
				<dialog id="issueInstructorModal">
				<div class="modal-top flex cen">
					<span class="close-button exit" id="closeIssueModal">✕</span>
					<h2>강사 세부 정보</h2>
				</div>
				<div class="modal-bottom">
					<form id="issueInstructorForm">
						<label> <span>이름:</span> <input type="text" name="name"
							id="name" required placeholder="홍길동">
						</label> <label> <span>이메일:</span> <input type="email"
							name="email" id="email" required placeholder="abc@example.com">
						</label> <label> <span>소속:</span> <input type="text"
							name="department" id="department" required placeholder="소속">
						</label> <label> <span>전화번호:</span> <input type="text" name="tel"
							id="phone" required placeholder="010-0000-0000">
						</label>

						<button type="submit" class="impleBtn">발급</button>
					</form>
				</div>
				</dialog>

				<ul class="pagination">
					<c:if test="${currentPage ne 1}">
						<li
							onclick="location.href='/instructorManagement?page=${currentPage - 1}'">이전</li>
					</c:if>
					<c:forEach var="i" begin="1" end="${totalPages}">
						<li class="${i eq currentPage ? 'selected' : ''}"
							onclick="location.href='/instructorManagement?page=${i}'">
							${i}</li>
					</c:forEach>
					<c:if test="${currentPage ne totalPages}">
						<li
							onclick="location.href='/instructorManagement?page=${currentPage + 1}'">다음</li>
					</c:if>
				</ul>

			</div>
		</main>
	</div>
</body>
</html>
