<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
   <script type="text/javascript" src="js/jquery.JNMagnifier.js"></script>
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
  	  body{
  	  	background:url(images/img3.jpg) no-repeat right top;
  	  
  	  }
  #user_center a:hover{
  	color:red;background-color:#97FD87;
  }
  	 #order_mess{
  	 
  	 	height:40px;
  	 	background-color:#E1DC8B;
  	 } 
  	  #order_mess span{
  	  float:left;
  	  
  	  height:30px;
  	  }
  	  #showBig{
		position:absolute;
		left:490px;
		top:100px;
		width:520px;
		height:500px;
		display:none;
		background-repeat:no-repeat;
		overflow:hidden;
	}
  </style>

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
  
  <body  class="container" onload="showTime()">

	<nav id="nav1" class="navbar navbar-default navbar-fixed-top" role="navigation" 
	style="filter:alpha(opacity=20);opacity:0.7!important;padding-left:80px;height:90px;padding-top:20px;
	background-color:#E8F1FB;">

	  <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	    <ul id ="top_menu"class="nav navbar-nav">
	     
	      <li><a href="#" id ="order_sys">点餐系统</a></li>
	      <li style = "padding-left:100px"><a href="home.jsp" >首页</a></li>
	      <li><a href="#">在线预订</a></li>
	       <li ><a href="#">人工服务</a></li>
	       <li><a href="reg.jsp">用户注册</a></li>
	       <li><a href="customer_mess.jsp">我的账户</a></li>
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
	<!-- 导航条结束 -->
	<div id="showp"style="height:300px;width:300px; position:absolute;left:150px;top:140px;">
		<img src="images/timg.jpg"width="300px" height="300px">
	</div>
	<div style="position:absolute;top:470px;left:200px;width:190px;height:100px;text-align:center;"  class="btn-group btn-group-justified">
			    <c:forEach items="${findOneFood}" var="fof">
			    <h3 class="media-heading">${fof.foodName}</h3>
			    </c:forEach>
</div>

	
	</div>
	<div class="jumbotron" style="position:absolute;top:100px;left:490px;width:500px;height:500px">
	  <h1></h1>
	  <p>...</p>
	  <!-- <input type="text" class="form-control" style="size:2" placeholder="Search"> -->
	  <p><a class="btn btn-primary btn-lg" role="button">加入购物车</a></p>
	</div>
	<div id="showBig"></div>
  </body>
  <script type="text/javascript">
	$(document).ready(
			function (){
				$("#showp").JNMagnifier({
					renderTo:"#showBig"
				});
			}
		);
  </script>
</html>
