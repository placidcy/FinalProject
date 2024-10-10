<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CHECK-비밀번호 재설정</title>
    <link rel="stylesheet" href="resources/css/header.css" />
    <link rel="stylesheet" href="resources/css/changepw.css" />
    <script src="/resources/js/find.js"></script>
</head>
<body>
    <div id="container">
<!--     
        <header>
            <div id="header1">
                <a href="#">
                    <h1>CHECK</h1>
                </a>
            </div>
            <div id="header2">
                <p>비밀번호 재설정</p>
                <hr>
                <div id="header2msg">
                    <img class="lockImg" src="resources/img/lock.png" />
                    <span>비밀번호를 변경할 수 있습니다.</span>
                </div>
            </div>
        </header>
 -->
 		<jsp:include page="common/find_header.jsp">
 			<jsp:param name="pageTitle" value="비밀번호 재설정"/>
        	<jsp:param name="pageContent" value="비밀번호를 변경할 수 있습니다."/>
 		</jsp:include>
        <main>
            <form id="findProcess" action="<c:url value='/changepwProcess' />" method="Post">
                <table>
                    <tr>
                        <th>
                            <label for="currentpw">현재 비밀번호</label>
                        </th>
                        <td>
                            <input type="password" name="currentpw" id="currentpw" required />
                            <p>현재 비밀번호를 입력하세요.</p>
                        </td>
                    </tr>
                    <tr>
                        <th>
                            <label for="changepw">새 비밀번호</label>
                        </th>
                        <td>
                            <input type="password" name="changepw" id="changepw" required />
                            <p>새 비밀번호를 영문(대/소문자)과 숫자, 특수문자 중 3가지의 조합 8~24자로 입력하세요.</p>
                        </td>
                    </tr>
                    <tr>
                        <th>
                            <label for="confirmpw">새 비밀번호 확인</label>
                        </th>
                        <td>
                            <input type="password" name="confirmpw" id="confirmpw" required />
                            <p>새 비밀번호를 다시 입력하세요.</p>
                        </td>
                    </tr>
                </table>
            </form>
            <hr />
            <div class="btn">
                <button id="cancelBtn">취소</button>
                <button type="submit" id="submitBtn">수정</button>
            </div>
        </main>
    </div>
</body>
</html>