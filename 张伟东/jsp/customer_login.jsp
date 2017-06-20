<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	 <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Custom Theme files -->
<link href="zwdcss/bootstrap.css" type="text/css" rel="stylesheet" media="all">
<link href="zwdcss/style.css" type="text/css" rel="stylesheet" media="all">  
<link href="zwdcss/font-awesome.css" rel="stylesheet"> <!-- font-awesome icons --> 
<!-- //Custom Theme files --> 
<!-- js -->
<script src="js/jquery-2.2.3.min.js"></script>  
<!-- //js -->
<!-- web-fonts -->   
<link href="http://fonts.googleapis.com/css?family=Berkshire+Swash" rel="stylesheet"> 
<link href="http://fonts.googleapis.com/css?family=Yantramanav:100,300,400,500,700,900" rel="stylesheet">
<!-- //web-fonts -->
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  <link rel="stylesheet" href="js/bootstrap.min.css" type="text/css"></link>
  <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
  
  <script type="text/javascript" src="js/bootstrap.min.js"></script>
  <style type="text/css">
  	#order_sys{
  		font-size:40;
  		margin:0px 0px 0px 8px;	
  	}
  	.mess1{
  		
  		width:300px;
  		height:220px;
  	
  	}
  	.mess2{
  		width:300px;
  		height:150px;
  	
  	}
  	
  	#time{
  		margin-top:15px;
  	}
  	#home_menu{
  		margin-top:80px;
  		float:left;
  		width:1025px;
  		height:70px;
  	}
  	#top_menu{
  		margin-top:10px;
  		padding-left:-5px;
  	}
  #top_menu li{
  	font-size:12px;
  	margin-left:-2px;
  	letter-spacing:10px;
  	  }
  	  #login_main{
  	  	margin-top:50px;
  	  }
  	   #top_menu li a {
  	  	color:#FFBF20;
  	  }
  </style>
<%--   <%
  		Cookie [] cookies =	request.getCookies();
	  		if(cookies!=null){
	  		for(Cookie coo:cookies){
	  			if(coo.getName().equals("Mobile")){
	  				response.sendRedirect("home.jsp");
	  			}
	  		}
  		}
   %> --%>
</head>
 <script type="text/javascript">
	var xxx;
	function zwd(zwd){
	return document.getElementById(zwd);
	}	
	function showTime(){//显示时间的方法
		var now;
		var now1;
		var temptime=new Date();//实例化新的对象
		var years=temptime.getFullYear();
		var months=temptime.getMonth()+1;
		var days=temptime.getDate();
		var hours=temptime.getHours();
		var minu=temptime.getMinutes();
		var seconds=temptime.getSeconds();
		now=years+"年"+months+"月"+days+"日"+hours+"小时"
		+minu+"分钟"+seconds+"秒";//获取当前的时间
		zwd("time").innerHTML=now;//在id为time的div内显示
		xxx=setTimeout("showTime()",1000);//1000毫秒更新一次
	}
		</script>
  
  <body onload="showTime()">
	<nav id="nav1" class="navbar navbar-default navbar-fixed-top" role="navigation" 
	style="filter:alpha(opacity=20);opacity:0.7!important;padding-left:80px;height:90px;padding-top:20px;
	background-color:#DBEAF9;">

	  <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	    <ul id ="top_menu"class="nav navbar-nav">
	     
	      <li><a href="food_findAllFood.action" method="post" id ="order_sys">点餐系统</a></li>
	      <li style = "padding-left:100px"><a href="home.jsp" >首页</a></li>
	      <li><a href="#">在线预订</a></li>
	       <li ><a href="customer_login.jsp">用户登录</a></li>
	       <li><a href="reg.jsp">用户注册</a></li>
	       <li><a href="userInfoAction_findOrders.action?Mobile=${user[0].Mobile }">我的账户</a></li>
	      <li><a href="shoppingcar.jsp">购物车</a></li>
	    </ul>
	    <form class="navbar-form navbar-left" role="search">
	      <div class="form-group">
	        <input type="text" class="form-control" placeholder="Search">
	        <a  type="button"class="btn btn-primary">查询</a>
	      </div>
	    </form>	
	 	<div id="time"></div>
	  </div><!-- /.navbar-collapse -->
	</nav>
	
 </form>
 	<div class="login-page about">
		<img class="login-w3img" src="images/img3.jpg" alt="">
		<div class="container" id="login_main"> 
			<h3 class="w3ls-title w3ls-title1">登录</h3>  
			<div class="login-agileinfo"> 
				<form action="userInfoAction_userLogin.action" method ="post"> 
					<input class="agile-ltext" type="text" name="Mobile" id="Mobile" placeholder="手机号" required="">
					<input class="agile-ltext" type="password" name="Userpwd" id="Userpwd" placeholder="密码" required="">
					<!-- <div id ="care" style="border:1px solid red;width:300px;height:40px;text-align:center;margin:10px 0px 0px 50px;"></div> -->
					<div class="wthreelogin-text" style="margin-top:20px;"> 
						<ul> 
							<li>
								<input type="checkbox" id="agree" name="agree"><i></i> 
								<span >是否保存密码</span> 
								
							</li> 
						</ul>
						<div class="clearfix"> </div>
					</div>   
					<input type="submit" id="reg_btn" value="登 &nbsp;录">
				</form>
				<p>忘记密码  <a href="findpwd.jsp">密码找回!</a></p> 
			</div>	 
		</div>
	</div>
  </body>
  <script type="text/javascript">
  
  </script>
</html>
