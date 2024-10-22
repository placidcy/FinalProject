<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>강사 관리 : '${keyword}' 검색결과</title>
<link rel="stylesheet" href="/resources/css/common.css">
<link rel="stylesheet" href="/resources/css/instructorManagement.css">
<link rel="stylesheet" as="style" crossorigin
    href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.9/dist/web/static/pretendard.min.css" />
<script src="/resources/js/instructorManagement.js"></script>
</head>
<body>
    <div class="container flex">
        <!-- 메인 사이드바 -->
        <jsp:include page="../common/admin_sidebar.jsp"></jsp:include>
        <!-- 본문 -->
        <main class="contents bgf2f2f2">
            <div class="grid g20">
                <h3 class="f24">강사 관리</h3>
                <!-- 서치바 -->
                <jsp:include page="./instructor_searchbar.jsp"></jsp:include>
                <table class="tab instructor mbe30">
                    <tr>
                        <td class="keyword"><b>'${keyword}'</b> <c:choose>
                                <c:when test="${empty list}">
                                에 대한 검색결과가 존재하지 않습니다.
                                </c:when>
                                <c:otherwise>
                                에 대한 검색결과입니다.
                                </c:otherwise>
                            </c:choose></td>
                    </tr>
                    <c:forEach items="${list}" var="instructor">
                        <tr class="item" data-id="${instructor.m_id}">
                            <td class="prefix">강사</td>
                            <td class="name">${instructor.m_name}</td>
                            <td class="department">${instructor.m_dept}</td>
                            <td class="email">${instructor.m_email}</td>
                            <td class="course">${instructor.courseName}</td>
                        </tr>
                    </c:forEach>
                </table>
                <ul class="pagination">
                    <c:if test="${page ne 1}">
                        <a href="/instructor/search?page=${page-1}&keyword=${keyword}">
                            <li class="page">이전</li>
                        </a>
                    </c:if>
                    <c:forEach var="i" begin="1" end="${size}">
                        <a href="/instructor/search?page=${i}&keyword=${keyword}">
                            <li class="page <c:if test='${i eq page}'>selected</c:if>'">${i}</li>
                        </a>
                    </c:forEach>
                    <c:if test="${page ne size}">
                        <a href="/instructor/search?page=${page+1}&keyword=${keyword}">
                            <li class="page">다음</li>
                        </a>
                    </c:if>
                </ul>
            </div>
        </main>
    </div>
</body>
</html>
