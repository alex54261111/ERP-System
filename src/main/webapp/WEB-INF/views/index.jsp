 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<script src="./js/style.js"></script>
<%-- <link rel='stylesheet' href="<c:url value='/css/styles.css' /> "type="text/css" /> --%>
<link rel="stylesheet" href="./css/style.css">
    <link rel="stylesheet" href="./css/page.css">

<meta charset="UTF-8">
<title>ERP</title>
</head>
<body>
<div class="headerBackground">
    <div class="loginBox">
        <div class="header">
            <div class="logo">
                <h1><a href="./index">ERP-System</a></h1>
            </div>
        </div>
        <div class="loginContainer wrapper">
            <h2>使用者登入</h2>
            <form action="" method="POST" target="_self">
                <p>帳號：</p>
                <input type="text" name="account" value="" placeholder="">
                <p>密碼：</p>
                <input type="password" name="password" value="" placeholder="">
                <input class="loginButton" type="submit" name="" >
                <a href="/register">還沒有帳號嗎?</a>
            </form>
        </div>
    </div>
</div>
</body>
</html>