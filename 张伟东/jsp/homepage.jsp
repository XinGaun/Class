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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  <link rel="stylesheet" href="js/bootstrap.min.css" type="text/css"></link>
  <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
  
  <script type="text/javascript" src="js/bootstrap.min.js"></script>
  <style type="text/css">
  	#order_sys{
  		font-size:40;
  		
  	}
  	.mess1{
  		
  		width:300px;
  		height:220px;
  	
  	}
  	.mess2{
  		width:300px;
  		height:150px;
  	
  	}
  	#home_left{
  		width:306px;
  		height:500px;
  		margin:100px 0px 0px 10px;
 		float:left; 		
  	}
 
  	#home_right{
  		float:left;
  		margin-top:2px;
  		width:76%;
  		height:600px;
  		border:1px solid red;
  		
  	}
  	#home_iframe{
  		width:100%;
  		height:100%;
  		border:1px solid black;
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
  	#checkboxusername{
  		width:200px;
  		height:30px;
  		
  		margin:8px 0px 0px 80px;
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
  
  <body onload="showTime()">
	<nav id="nav1" class="navbar navbar-default navbar-fixed-top" role="navigation" 
	style="filter:alpha(opacity=20);opacity:0.7!important;padding-left:80px;height:90px;padding-top:20px;
	background-color:#E8F1FB;">

	  <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	    <ul class="nav navbar-nav">
	     
	      <li><a href="#" id ="order_sys">点餐系统</a></li>
	      <li style = "padding-left:100px"><a href="homepage.jsp" >首页</a></li>
	      <li><a href="#">在线预订</a></li>
	       <li ><a href="#">人工服务</a></li>
	       <li><a href="reg.jsp">用户注册</a></li>
	       <li><a href="about.html">订单详情</a></li>
	      <li><a href="shoppingCarAction.action">购物车</a></li>
	    </ul>
	    <form class="navbar-form navbar-left" role="search">
	      <div class="form-group">
	        <input type="text" class="form-control" placeholder="Search">
	        <a  type="button"class="btn btn-primary">查询</a>
	      </div>
	    </form>	
	   
	 	<div id="time">1</div>
	  </div><!-- /.navbar-collapse -->
	</nav>
	<div id = "home_left">
		<div class = "mess1">
			<ul class="nav nav-pills nav-stacked">
			  <li class="active">
			    <a href="#">
			      <span class="badge pull-right">1</span>
			      <span style="font-size:15px;">用户登录</span>
			    </a>
			  </li>
			 
			</ul>
			<div id="login_win" >
			<form class="navbar-form navbar-left" action="userInfoAction_userLogin.action" role="search">
		      <div class="form-group">
		       手机号: <input type="text" name = "telephone" id = "telephone" class="form-control" placeholder=""><br/>
		       <br/>
		       密&nbsp;&nbsp;&nbsp;码: <input type="text" name ="password" id ="password" class="form-control" placeholder=""><br>
				<div id="checkboxusername">
					<input type="checkbox" name ="checkusername"> 是否保存密码
				</div>
		      </div>
		      
				<a style="margin-left:70px" type="button" id ="login_btn"class="btn btn-primary" >登录</a>
		        <input  type="reset"class="btn btn-warning"  id ="reset_mess"value="取消"></a>  
		    </form>	
			</div>
			<div id = "login_mess1"></div>
			<div id = "login_mess2"></div>
		</div>
		<div class = "mess2">
			<ul class="nav nav-pills nav-stacked">
			  <li class="active">
			    <a href="#">
			      <span class="badge pull-right">2</span>
			      营业时间
			    </a>
			  </li>
			</ul>
			<div style="font-size:20px;color:green;margin:10px 0px 0px 35px;">
				<span >早餐时间：05:30-09:30</span><br>
				<span>午餐时间：10:30-14:30</span><br>
				<span>晚餐时间：16:30-20:30</span>
			</div>
		</div>
		<div class = "mess2">
			<ul class="nav nav-pills nav-stacked">
			  <li class="active">
			    <a href="#">
			      <span class="badge pull-right">3</span>
			      餐馆公告
			    </a>
			  </li>
			</ul>
			<div style="font-size:20px;color:green;margin:10px 0px 0px 35px;">	
			</div>
		</div>
	</div>
	
	<div id ="home_menu">
		<div class="alert alert-success" style="height:50px; width:100%;margin-top:20px;" >
			<ul class="pager" style="margin-top:-5px">
		  		<li><a href="reg.jsp" target="home_iframe">特色菜</a></li>
		  		<li><a href="#">特色菜</a></li>
		  		<li><a href="#">特色菜</a></li>
		  		<li><a href="#">特色菜</a></li>
		  		<li><a href="#">特色菜</a></li>
		  		<li><a href="#">特色菜</a></li>
		  		<li><a href="#">特色菜</a></li>
		  		<li><a href="#">特色菜</a></li>
			</ul>	
		</div>
		
			
	</div>
	
	<div id="home_right">
		
		<iframe name ="home_iframe" id ="home_iframe">

		</iframe>
  	</div>
	</div>
  </body>
  <script type="text/javascript">
  //用户登录验证
  $("#login_btn").click(function(){
  	if($("#telephone").val()==""||$("#password").val()==""){
  		alert("请填写手机号和密码正确登录");
  	}else{
  		$.ajax({
  			type:"post",
			url:"loginCustomerAction.action",
			data:{telephone:$("#telephone").val(),
			password:$("#password").val()},
			dataType:"json",
			success:function(data){	
				alert("1");
			}
			
  		});
  	}
  	
  });
  
  	/* $("#login_btn").click(function(){
  		if($("#username").val()==""||$("#password").val==""){
  			alert("请输入用户名和密码");
  		}
  		else{
		$.ajax({
			type:"post",
			url:"loginServlet",
			data:{username:$("#username").val(),
			password:$("#password").val()},
			dataType:"json",
			success:function(data){
				//登录成功
				if(data!=1){
				$("#login_win").css("display","none");
				$("#login_mess1").html("欢迎"+data.username+"，您已登录成功");
				$("#login_mess2").css("display","block");
				$("#login_mess2").html("<button type='button' class='btn btn-danger'>注销</button>");
				}
				//登录失败
				else{
					$("#login_win").html("请核对您的用户名和密码是否正确");	
				}
			}
		});}
  	});*/
  	//注销账户
  	$("#login_mess2").click(function(){
  		$("#login_win").css("display","block");
  		$("#login_mess2").css("display","none");
  	}); 
  </script>
</html>
