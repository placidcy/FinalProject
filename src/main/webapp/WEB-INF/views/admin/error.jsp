<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="write" value="write"></c:set>
	<script>
		alert("${msg}");
		<c:if test="${redirect eq write}">
		window.location.href = "/admin/notice/write";
		</c:if>
	</script>
</body>
</html>