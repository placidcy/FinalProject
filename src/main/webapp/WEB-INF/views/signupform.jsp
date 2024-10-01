<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CHECK-회원 가입</title>
    <link rel="stylesheet" href="resources/css/header.css" />
    <link rel="stylesheet" href="resources/css/signupform.css" />
</head>
<body>
    <div id="container">
        <header>
            <div id="header1">
                <a href="#">
                    <h1>CHECK</h1>
                </a>
            </div>
            <div id="header3">
                <p>회원 정보 입력 <span>(필수 입력은 *로 표시됩니다.)</span></p>
                <hr>
            </div>
        </header>

        <main>
            <form action="<c:url value='/signupProcess' />" method="Post">
                <table>
                    <tr>
                        <th>
                            <label for="inputid">아이디 <span>*</span></label>
                        </th>
                        <td>
                            <input type="text" name="inputId" id="inputId" required />
                            <p>영문 또는 숫자 조합 5~15자로 입력하세요.</p>
                        </td>
                    </tr>
                    <tr>
                        <th>
                            <label for="inputpw">비밀번호 <span>*</span></label>
                        </th>
                        <td>
                            <input type="password" name="inputpw" id="inputpw" required />
                            <p>영문 대/소문자와 숫자, 특수문자 중 3가지의 조합 8~24자로 입력하세요.</p>
                        </td>
                    </tr>
                    <tr>
                        <th>
                            <label for="confirmpw">비밀번호 확인 <span>*</span></label>
                        </th>
                        <td>
                            <input type="password" name="confirmpw" id="confirmpw" required />
                            <p>위의 비밀번호를 다시 입력하세요.</p>
                        </td>
                    </tr>
                    <tr>
                        <th>
                            <label for="inputname">성명 <span>*</span></label>
                        </th>
                        <td>
                            <input type="password" name="inputname" id="inputname" required />
                            <p>이름을 입력하세요.</p>
                        </td>
                    </tr>
                    <tr>
                        <th>
                            <label for="inputmail">이메일 <span>*</span></label>
                        </th>
                        <td>
                            <input type="email" name="inputmail" id="inputmail" required />
                            <p>example@example.com 형식으로 입력하세요.</p>
                        </td>
                    </tr>
                    <tr>
                        <th>
                            <label for="inputtel">전화번호</label>
                        </th>
                        <td>
                            <input type="tel" name="inputtel" id="inputtel" />
                            <p>010-1234-5678 형식으로 입력하세요.</p>
                        </td>
                    </tr>
                    <tr>
                        <th>
                            <label for="inputgroup">소속 / 조직</label>
                        </th>
                        <td>
                            <input type="password" name="inputgroup" id="inputgroup" />
                            <p>현재 소속을 입력하세요.</p>
                        </td>
                    </tr>
                </table>
                <hr />
                <button type="submit" id="signupBtn">가입</button>
            </form>
        </main>
    </div>
</body>
</html>