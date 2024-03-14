<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://cdn.lordicon.com/bhenfmcm.js"></script>
<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
	<script src="./js/style.js"></script>

<link rel='stylesheet'
	href="<c:url value='/bootstrap-3.4.1-dist/css/bootstrap.min.css' /> "
	type="text/css" />
<link rel='stylesheet'
	  href="<c:url value='/css/page.css' /> "
	type="text/css" />
<link rel='stylesheet'
	  href="<c:url value='/css/style.css' /> "
	type="text/css" />

<meta charset="UTF-8">
<title>帳號註冊</title>
</head>
<style>
body {
	overflow-x: hidden;
	overflow-y: hidden;
}

.loginBox {
	width: 100%;
	height: 100%;
	background-color: rgba(0, 0, 0, 0.6);
}

.loginContainer h2 {
	text-align: center;
	color: aliceblue;
	margin-top: 50px;
}

.loginContainer p {
	color: white;
	margin: 0 0 5px 0;
}

.loginContainer input {
	width: 100%;
	height: 50px;
	border-radius: 5px;
	display: block;
	font-size: 20px;
	text-indent: 10px;
	color: aliceblue;
	background-color: rgba(240, 248, 255, 0.2);
	border: 0;
	margin-bottom: 20px;
}

.loginContainer .loginButton {
	margin-top: 40px;
}
</style>

<body>
	<div class="headerBackground">
		<div class="loginBox">
			<div class="header">
				<div class="menuButton"></div>
				<div class="menuBox">
					<ul>
						<h1>
							<a href="./index.html">marlinLogo</a>
						</h1>
						<div class="user">
							<div class="menuButtonClose"></div>
						</div>
						<li><a class="click1" href="#">服務介紹
								<div class="downIcon"></div>
						</a>
							<ul>
								<li><a href="./OderSystem.html">接單系統</a></li>
								<li><a href="./Report.html">報表分析</a></li>
							</ul>
						<li><a href="./plan.html">價格方案</a></li>
						<li><a class="click2" href="/contact">立刻諮詢</a></li>
					</ul>
				</div>
				<div class="logo">
					<h1>
						<a href="./index.html">MarlinLogo</a>
					</h1>
				</div>
				<div class="nav">
					<ul>
						<li><a href="#">服務介紹</a>
							<ul>
								<li><a href="./OderSystem.html">接單系統</a></li>
								<li><a href="./Report.html">報表分析</a></li>
							</ul></li>
						<li><a href="./plan.html">價格方案</a></li>
						<li><a href="./contact">立刻諮詢</a></li>
					</ul>
				</div>
			</div>
			<div class="loginContainer pageWrapper">
				<h2>帳號註冊</h2>
				<form id="registrationForm">
<%--				    <p>輸入註冊碼</p>--%>
<%--					<input type="text" name="invitationCode" id="invitationCode">--%>
					<p>輸入帳號：</p>
					<input type="text" name="username" id="username">
					<p>輸入密碼：</p>
					<input type="password" name="password" id="password">
					<p>再次輸入密碼：</p>
					<input type="password" name="password" id="password2"> <input
						class="loginButton" type="submit" value="註冊"> <a href="#"></a>
				</form>
				<p id="errorMessage"></p>
				<p id="passwordErrorMessage"></p>
			</div>
		</div>
	</div>
</body>
<script>	
$(document).ready(function() {
	 $("#registrationForm").submit(function(event) {
		    event.preventDefault(); // 阻止表单的默认提交行为
		    // 获取表单数据
		    var formData = {
		      invitationCode: $("#invitationCode").val(),
		      username: $("#username").val(),
		      password: $("#password").val(),
		      password2: $("#password2").val()
		    };
		 var passwordPattern = /./;
		    // var passwordPattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$/;
		 var $errorMessage = $("#errorMessage");
			if (formData.password===formData.password2) {
				if (passwordPattern.test(formData.password)) {
					// 发送AJAX请求
					$.ajax({
						type: "POST",
						url: "/registerUser",
						data: JSON.stringify(formData), // 将数据转换为JSON字符串
						contentType: "application/json", // 设置请求的内容类型为JSON
						success: function(response) {
							if (response.exists) {
								// $("form").unbind("submit").submit();
								// 用户名註冊成功处理逻辑
								console.log("註冊成功" + formData.username);
								$("#errorMessage").text(response.message);
								window.location.href = response.redirect; // 跳轉到指定的頁面
							} else {
								// 用户名註冊失敗处理逻辑
								console.log("註冊失敗" + formData.username);
							}
						},
						error: function() {
							console.log("執行錯誤");
						}
					});
				} else {
					$errorMessage.text("密碼需有一個小寫及大寫，一個數字且長度必須大於8個字符");
					return; // 停止继续执行表单提交
				}
			}else {
				$errorMessage.text("密碼不一致");
				return; // 停止继续执行表单提交}
			}
		});
});
</script>

</html>