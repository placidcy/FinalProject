<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강사 관리 페이지</title>
<link rel="stylesheet" href="/resources/css/admin_aside.css">
<link rel="stylesheet" href="/resources/css/instructorManagement.css">
<link rel="stylesheet" href="/resources/css/instructorDialog.css">
<link rel="stylesheet" href="/resources/css/search.css">
<link rel="stylesheet" as="style" crossorigin
    href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.9/dist/web/static/pretendard.min.css" />
<script src="/resources/js/instructorManagement.js" defer></script> 
</head>
<body>
    <div id="container">
        <jsp:include page="common/admin_sidebar.jsp" />
        <main>
            <div id="manageTableArea">
                <h1 class="h1_Title">강사 관리</h1>

                <div class="nav_SideBarBox">
                    <nav id="navBox">
                        <div id="titleBox">
                            <h1>강사 관리</h1>
                        </div>
                    </nav>
                </div>
                <div class="subtitleInput">
                    <div class="inputArea">
                        <select id="searchType">
                            <option value="name">이름</option>
                            <option value="department">소속</option>
                            <option value="email">이메일</option>
                            <option value="id">아이디</option>
                        </select> 
                        <input type="text" placeholder="검색어를 입력하세요" id="searchText" class="researchTag" />
                        <button class="researchBtn" onclick="searchInstructor()">검색</button>
                    </div>
                    <button class="impleBtn issueBtn" id="openIssueModalBtn">발급</button>
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
                            <c:forEach items="${instructorList}" var="instructor" varStatus="status">
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
				            <label>
				                <span>이름:</span>
				                <input type="text" name="name" id="name" required>
				            </label>
				            <label>
				                <span>이메일:</span>
				                <input type="email" name="email" id="email" required>
				            </label>
				            <label>
				                <span>소속:</span>
				                <input type="text" name="department" id="department">
				            </label>
				            <label>
				                <span>전화번호:</span>
				                <input type="text" name="tel" id="phone">
				            </label>
				            <button type="submit" class="impleBtn">발급</button>
				        </form>
				    </div>
				</dialog>
				    </div>
				</dialog>
                </div>
            </div>
        </main>
    </div>
</body>
</html>
