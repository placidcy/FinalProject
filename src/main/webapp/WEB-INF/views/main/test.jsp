<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>AWS S3 버킷 테스트 페이지</h1>
	<hr>

	<form action="/upload" method="post" enctype="multipart/form-data">
		<input type="file" name="file" /> <input type="submit" value="upload" />
	</form>
</body>
</html>