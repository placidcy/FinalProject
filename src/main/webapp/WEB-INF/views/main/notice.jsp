<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>CHECK-공지사항</title>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="/css/main/notice.css">
<link rel="stylesheet" as="style" crossorigin
	href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.9/dist/web/static/pretendard.min.css" />
<script src="/js/main/mobile.js"></script>
</head>

<body>
	<div class="container flex">
		<!-- 메인 사이드바 -->
		<jsp:include page="../common/side_main.jsp"></jsp:include>
		<!-- 본문 -->
		<main class="contents bgf2f2f2">
			<div class="grid g20">
				<h3 class="f24">공지사항</h3>
				<!-- 서치바 -->
				<jsp:include page="./notice_searchbar.jsp"></jsp:include>
				<table class="tab notice mbe30">
					<c:forEach items="${list }" var="item">
						<tr class="item" data-id="${item.noticeId }">
							<td class="prefix">공지</td>
							<td class="title">${item.noticeTitle }</td>
							<td class="date">등록일: ${item.regdate }</td>
						</tr>
					</c:forEach>
				</table>
				<ul class="pagination">
					<c:if test="${page ne 1 }">
						<a href="/notice?page=${page-1 }">
							<li class="page">이전</li>
						</a>
					</c:if>
					<c:forEach var="i" begin="1" end="${size }">
						<a href="/notice?page=${i}">
							<li class="page <c:if test="${i eq page }">selected</c:if>">${i}</li>
						</a>
					</c:forEach>
					<c:if test="${page ne size}">
						<a href="/notice?page=${page+1 }">
							<li class="page">다음</li>
						</a>
					</c:if>
				</ul>
			</div>
		</main>
	</div>
</body>

</html>