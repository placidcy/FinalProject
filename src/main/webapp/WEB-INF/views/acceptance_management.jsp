<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>

<head>
    <link href="https://fonts.googleapis.com/css?family=Inter&display=swap" rel="stylesheet" />
    <link rel="stylesheet" as="style" crossorigin
        href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.9/dist/web/static/pretendard.min.css" />
    <link rel="stylesheet" href="/resources/css/course_acceptance_management.css">
    <link rel="stylesheet" href="/resources/css/course_mu.css">
    <script src="/resources/js/course_acceptance_management.js"></script>
    <title>Document</title>
</head>

<body>
    <div id="container">
        <jsp:include page="common/sidebar_course.jsp" />
 
        <main>
            <h1>수강 신청 관리</h1>

            <form class="search" method="POST" action="/acceptanceManagementSearch">
                <span class="search_title">검색</span>
                <select name="searchType" class="searchType">
                    <option value="name">이름</option>
                    <option value="dept">소속</option>
                </select>
                <div class="search-box">
                    <div>
                        <input type="text" id="searchText" name="searchText" placeholder="검색어를 입력하세요.">
                        <button type="submit" id="search-button">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 50 50" width="20px" height="20px">
                                <path
                                    d="M 21 3 C 11.601563 3 4 10.601563 4 20 C 4 29.398438 11.601563 37 21 37 C 24.355469 37 27.460938 36.015625 30.09375 34.34375 L 42.375 46.625 L 46.625 42.375 L 34.5 30.28125 C 36.679688 27.421875 38 23.878906 38 20 C 38 10.601563 30.398438 3 21 3 Z M 21 7 C 28.199219 7 34 12.800781 34 20 C 34 27.199219 28.199219 33 21 33 C 13.800781 33 8 27.199219 8 20 C 8 12.800781 13.800781 7 21 7 Z" />
                            </svg>
                        </button>
                    </div>
                </div>
            </form>

            <div class="students_enrolleds">
                <div class="std_head">
                    <span class="name">이름</span>
                    <span class="belong">소속</span>
                    <span class="state">상태</span>
                </div>
			<c:choose>
				<c:when test="${courseRegList.size() != 0}">
				<c:forEach items="${courseRegList}" var="courseReg">
	                <div class="std_body">
	                    <span class="std_name">${courseReg.m_name}</span>
	                    <span class="std_belong">${courseReg.m_dept}</span>
	                    <a href="" class="std_approval">승인</a>
	                    <a href="" class="std_rejection">거절</a>
	                </div>
	            </c:forEach>
				</c:when>
				<c:otherwise>
					<div id="noStd">
	                    <span>수강신청 중인 학생이 없습니다.</span>
	                </div>
				</c:otherwise>
			</c:choose>
            </div>
			<div id="page">
				<c:choose>
					<c:when test="${acceptPage==0}">
						<button id="minusPage" disabled>이전</button>
					</c:when>
					<c:otherwise>
						<a href="/acceptanceManagement?acceptPage=${acceptPage-1}"><button id="minusPage" style="cursor:pointer">이전</button></a>	
					</c:otherwise>
				</c:choose>
				
				<c:choose>
					<c:when test="${courseRegList.size()==0}">
						<span id="targetPage" class="pageNumber">1</span>
					</c:when>
					<c:otherwise>
						<c:forEach  begin="0" end="${Math.floor((courseRegList.size()-1)/10)}" varStatus="status">
							<a href="/acceptanceManagement?acceptPage=${status.count-1}"><span id="targetPage" class="pageNumber">${status.count}</span></a>
						</c:forEach>
					</c:otherwise>
				</c:choose>
				
				
				<c:choose>
					<c:when test="${courseRegList.size()==0 || Math.floor((courseRegList.size()-1)/10) == acceptPage}">
						<button id="plusPage" disabled>다음</button>
					</c:when>
					<c:otherwise>
						<a href="/acceptanceManagement?acceptPage=${acceptPage+1}"><button id="plusPage" style="cursor:pointer">다음</button></a>
					</c:otherwise>
				</c:choose>
            </div>
        </main>
    </div>
</body>

</html>