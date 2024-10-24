<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CHECK-이메일 변경</title>
    <link rel="stylesheet" href="resources/css/header.css" />
    <link rel="stylesheet" href="resources/css/changepwd.css" />
    <script src="/resources/js/changemailVaild.js"></script>
</head>
<body>
    <div id="container">
 		<jsp:include page="common/find_header.jsp">
 			<jsp:param name="headerType" value="content" />
 			<jsp:param name="pageTitle" value="이메일 변경"/>
        	<jsp:param name="pageContent" value="이메일을 변경할 수 있습니다."/>
 		</jsp:include>
        <main>
            <form id="findProcess" action="/changeEmailProcess" method="POST">
            	<input type="hidden" name="member_id" value="${param.member_id}" required />
                <table>
                    <tr>
                        <th>
                            <label for="newM_email">새 이메일</label>
                        </th>
                        <td>
                            <input type="email" name="newM_email" id="newM_email" required />
                            <p>example@example.com 형식으로 입력하세요.</p>
                            <p id="emailmsg"></p>
                        </td>
                    </tr>
                </table>
	            <hr />
	            <div class="btn">
	                <a href="/mypage" class="cancel">취소</a>
	                <button type="submit" id="submitBtn">변경</button>
	            </div>
            </form>
        </main>
    </div>
</body>
</html>