
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<base href="<%=basePath%>">

<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<meta name="viewport" content="width=device-width,inital-scale=1">
<script type="text/javascript" src="js/jquery-2.1.3.min.js"
	charset="UTF-8"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"
	charset="UTF-8"></script>
<link href="bootstrap/css/bootstrap.min.css" type="text/css"
	rel="stylesheet" charset="UTF-8">

<style>
body {
	background: url("img/18c59e4816dec126e3878772882df352.jpg") no-repeat;
	background-color: #FAF9FE;
	background-size: auto 100%;
}

#Dlu {
	position: absolute;
	top: 0px;
	right: 5%;
	width: 30%;
	margin-top: 6%;
}

#mid {
	border: none;
	text-align: center;
	font-size: 20px;
	background: url("img/qweww.png");
	background-size: cover;
}

#pwd {
	width: 100%;
	border: none;
	text-align: center;
	font-size: 20px;
	border: none;
	background: url("img/qweww.png");
	background-size: cover;
}

#basic-addon1 {
	border: none;
	background-color: transparent;
}

.form-control {
	border: none;
}

#tab {
	background: url("img/8ef0398a36091f4e6665ac93a6707bea.png");
	/* background-size:cover;  */
	text-align: center;
}

select {
	width: 100%;
	text-align: center;
}

.btn {
	width: 100%;
	background: url("img/qweww.png");
	background-size: cover;
	color: black;
	font-weight: bold;
}

h4 {
	text-align: center;
	font-weight: bold;
}

#basic-addon1 {
	font-we	ight: bold;
	font-size: 20px;
}
select option{
	text-align: center;
}
</style>
</head>

<body>


	<div id="Dlu">
		<div id="zhong">
			<H2 id="tab">点餐登录</H2>
			<br />
			<form id="loginForm" action="login.action" method="post"
				class="form-horizontal">

				<input id="mid" name="mid" type="text" class="form-control"
					placeholder="请输入账号" aria-describedby="basic-addon1"> <br />
				<input id="pwd" type="password" class="form-control" name="pwd"
					placeholder="请输入密码" aria-describedby="basic-addon1"> <br />

				<div>
					<h4>选择桌台号：</h4>
				</div>
				<select id="zth" name="zth">
					
					
					 
				</select> <br /> <br />


				<button type="submit" id="subBut" class="btn">登录</button>
				<br /> <br />
				<button type="reset" id="resBut" class="btn">重置</button>
				<p>${error}</p>
		</div>
	</div>
	</form>
	</div>
</body>
</html>
