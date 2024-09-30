<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="kr">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="../main/css/checkin.css">
    <link rel="stylesheet" href="../admin/css/admin-form.css">
    <link rel="stylesheet" href="css/dialog.css">
    <script src="js/attendanceCalender.js"></script>
    <link rel="stylesheet" as="style" crossorigin
        href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.9/dist/web/static/pretendard.min.css" />

    <style>
        .req {
            padding: 40px 30px;
        }

        .textarea {
            width: 100%;
            height: 150px;
            padding: 20px;
            resize: none;
            border: 1px solid gainsboro;
            border-radius: 5px;
            box-sizing: border-box;
        }

        .modal-bottom.req .message {
            font-size: 14px;
            color: darkred;
        }
    </style>
</head>

<body>
    <button class="dialogBtn">다이얼로그 버튼</button>
    <dialog open id="modal">
        <div class="modal-top flex cen">
            <span class="bold" id="reqType">출결 정정 요청</span>
            <span class="f24 exit">✕</span>
        </div>
        <div class="modal-bottom req">
            <form class="grid g10" action="">
                <input type="hidden" name="date" value="2024.03.21">
                <table>
                    <tr>
                        <td>일자:</td>
                        <td>2024.03.21</td>
                    </tr>
                    <tr>
                        <td>상태:</td>
                        <td>지각</td>
                    </tr>
                    <tr>
                        <td colspan="2">사유:</td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <textarea class="textarea" name="" id=""></textarea>
                        </td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                    </tr>
                    <tr>
                        <td>증명서류:</td>
                        <td><input type="file"></td>
                    </tr>
                    <tr>
                        <td colspan="2" class="message">
                            * 증명서류가 여러 개인 경우 하나의 파일(.zip)로 압축하여 제출하세요.
                        </td>
                    </tr>
                </table>
                <input class="btn f20" type="button" value="요청하기">
            </form>
        </div>
    </dialog>
</body>

</html>