<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지-공지사항: ${notice.noticeTitle }</title>
<link rel="stylesheet" href="/resources/css/common.css">
<link rel="stylesheet" href="/resources/css/admin/notice.css">
<link rel="stylesheet" as="style" crossorigin
	href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.9/dist/web/static/pretendard.min.css" />
<script src="/resources/js/admin/notice.js"></script>

</head>
<body>
	<div class="container flex">
		<!-- 관리자 사이드바 -->
		<jsp:include page="../common/admin_sidebar.jsp"></jsp:include>
		<!-- 본문 -->
		<main class="contents bgf2f2f2">
			<div class="grid g20">
				<h3 class="f24">공지사항: 게시글 상세 조회</h3>
				<table class="post details">
					<tr>
						<th>제목</th>
						<td>${notice.noticeTitle }</td>
					</tr>
					<tr>
						<th>작성일</th>
						<td>${notice.regdate }</td>
					</tr>
					<c:if test="${not empty attms }">
						<tr>
							<th>첨부파일</th>
							<td>
								<ul class="attms">
									<c:forEach items="${attms }" var="attm">
										<li><a class="attm" href="${attm.url }">${attm.fileName }</a></li>
									</c:forEach>
								</ul>
							</td>
						</tr>
					</c:if>
					<tr>
						<th>내용</th>
						<td><pre>${notice.noticeContents }</pre></td>
					</tr>
				</table>
				<div class="buttons">
					<button class="btn" id="list" data-page="${page }">목록</button>
					<button class="btn" id="delete" data-id="${notice.noticeId }">삭제</button>
				</div>
			</div>
		</main>
	</div>
</body>
</html>