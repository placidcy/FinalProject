<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<header>
    <div id="header1">
        <a href="<c:url value='/login' />">
            <h1>CHECK</h1>
        </a>
    </div>
    <div id="header2">
        <p>${param.pageTitle}</p>
        <hr>
        <div id="header2msg">
            <img class="lockImg" src="resources/img/lock.png" />
            <span>${param.pageContent}</span>
        </div>
    </div>
</header>