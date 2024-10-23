<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지-공지사항: 게시글 작성</title>
<link rel="stylesheet" href="/resources/css/common.css">
<link rel="stylesheet" href="/resources/css/admin-form.css">
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
				<h3 class="f24">공지사항: 게시글 작성</h3>
				<form class="courseForm grid g20" action="/admin/notice/addPost"
					method="POST" enctype="multipart/form-data">
					<div class="flex">
						<label class="f20 bold w120" for="title">공지 제목</label> <input
							class="w800 border" type="text" id="title" name="title" required>
					</div>
					<div class="flex">
						<label class="f20 bold w120" for="content">공지 내용</label>
						<textarea class="w800 h400 border" name="content" id="content"
							required></textarea>
					</div>
					<div class="flex">
						<label class="f20 bold w120" for="target">분류</label> <select
							class="w360 border" name="target" id="target">
							<option value="0">전체</option>
							<option value="1">강사</option>
						</select>
					</div>
					<div class="flex ac">
						<label class="f20 bold w120" for="files">첨부파일</label> <input
							class="w360 border" type="file" name="files" value="이미지/문서 첨부"
							id="files" multiple>
					</div>
					<div class="flex g20 je mb20">
						<input class="impleBtn" type="submit" value="등록"> <input
							class="cancelBtn" type="button" id="cancel" value="취소">
					</div>
				</form>
			</div>
		</main>
	</div>
</body>
</html>