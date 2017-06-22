<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/houtaistyles.css">
<style type="text/css">
	body{
		background: url("img/578d90a021687_1024.jpg")no-repeat;
		background-size: 100%;
	}
</style>
</head>

<body>
	<div class="htmleaf-container">
		<div class="wrapper">
			<div class="container">
				<h1>后台登录</h1>

				<form class="form" action = "Hlogin_loggingverify.action" method ="post">
					<input type="text" placeholder="请输入账号" name ="mobile"> 
					<input type="password" placeholder="请输入密码" name ="Userpwd">
					<button type="submit" id="login-button">登录</button>
				</form>
			</div>

			<ul class="bg-bubbles">
				<li>1</li>
				<li>2</li>
				<li>3</li>
				<li>4</li>
				<li>5</li>
				<li>6</li>
				<li>7</li>
				<li>8</li>
				<li>9</li>
				<li>10</li>
			</ul>
		</div>
	</div>

	<script src="js/jquery-2.2.3.min.js" type="text/javascript"></script>
	<script>
/**		$('#login-button').click(function(event) {
			event.preventDefault();
			$('form').fadeOut(500);
			$('.wrapper').addClass('form-success');
		});
		*/
	</script>
</body>
</html>
