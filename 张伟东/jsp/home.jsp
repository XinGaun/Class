<%@page import="com.biz.UserInfoBiz"%>
<%@page import="com.biz.imp.UserInfoBizImp"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
  #home_left{
  		width:306px;
  		height:500px;
  		margin:100px 0px 0px 10px;
 		float:left; 		
  	}
 
  	#home_right{
  		float:left;
  		margin-top:2px;
  		width:1030px;
  		height:100%;
  		
  		
  	}
  	#home_iframe{
  		width:1030px;
  		height:100%;
  		
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
  	  #top_menu li a {
  	  	color:#FFBF20;
  	  }
  	  #login_main{
  	  	margin-top:50px;
  	  }
  </style>

</head>


<%
	UserInfoBiz uib = new UserInfoBizImp();//实例化业务层
	List<Map<String, Object>> findAllFoods = uib.findAllFoods();
	List<Map<String, Object>> findFoodCategory =uib.findFoodCategory();
	request.setAttribute("findFoodCategory", findFoodCategory); 
	request.setAttribute("findAllFoods", findAllFoods);
 %>
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
	     
	      <li><a href="home.jsp" id ="order_sys">点餐系统</a></li>
	      <li style = "padding-left:100px"><a href="home.jsp" >首页</a></li>
	      <li><a href="#">在线预订</a></li>
	       <li ><a href="customer_login.jsp">用户登录</a></li>
	       <li><a href="reg.jsp">用户注册</a></li>
	       <li><a href="userInfoAction_findOrders.action?Mobile=${user[0].Mobile }">我的账户</a></li>
	      <li><a href="shoppingcar.jsp">购物车</a></li>
	    </ul>
	    <form action="food_findAllFoodsBySearch.action" method="post"class="navbar-form navbar-left" role="search">
	      <div class="form-group">
	        <input type="text" name="searchfood" id="searchfood" class="form-control" placeholder="Search">
	        <input  type="submit" class="btn btn-primary"/>
	      </div>
	    </form>	
	 	<div id="time"></div>
	  </div><!-- /.navbar-collapse -->
	</nav>
	<div id = "home_left">
		<div class = "mess1">
			<ul class="nav nav-pills nav-stacked">
			  <li class="active">
			    <a >
			      <span class="badge pull-right">1</span>
			      <span style="font-size:15px;">登录提示</span>
			    </a>
			  </li>
			</ul>
			<div id="login_win" >
			<!-- 用户登录之后 -->
			<c:if test="${Mobile!=null}">
				<c:forEach items="${user}" var="user">
					欢迎<a href="userInfoAction_findOrders.action?Mobile=${user.Mobile}" method="post">${user.UserName}</a>,您已登录成功。<br>
					<a href="userInfoAction_logout.action"style="margin-left:70px" type="button" id ="login_btn"class="btn btn-primary" >注销</a>
		        <input  type="reset"class="btn btn-warning"  id ="reset_mess"value="取消"></a>  
				</c:forEach>
			</c:if>
			<c:if test="${Mobile==null}">
				您还未登录，为了您的方便请登录。<br>
				<a href="customer_login.jsp"style="margin-left:70px" type="button" id ="login_btn"class="btn btn-primary" >登录</a>
		        <input  type="reset"class="btn btn-warning"  id ="reset_mess"value="取消"></a>  
			</c:if>
			<!-- <form class="navbar-form navbar-left" action="userInfoAction_userLogin.action" method="post"  role="search">
		      <div class="form-group">
		       手机号: <input type="text" name = "Mobile" id = "Mobile"  class="form-control" placeholder=""><br/>
		       <br/>
		       <div id ="notice" style="margin-top:-16px;height:20px; padding-left:90px;"></div>
		       密&nbsp;&nbsp;&nbsp;码: <input type="text" name ="Userpwd" id ="Userpwd" class="form-control" placeholder=""><br>
				<div id="checkboxusername">
					<input type="checkbox" name ="checkusername"> 是否保存密码
				</div>
		      </div>
		      	<input type="submit" style="margin-left:70px" id ="login_btn"class="btn btn-primary"  value="登录">
		      <input  type="reset"class="btn btn-warning"  id ="reset_mess"value="取消"> 
		    </form>	 -->
		
			</div>
			<div id = "login_mess1"></div>
			<div id = "login_mess2"></div>
			   	
		</div>
		<div class = "mess2">
			<ul class="nav nav-pills nav-stacked">
			  <li class="active">
			    <a>
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
			    <a >
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
				<li><a href="food_findAllFood.action" method="post">全部</a></li>
		  		 <c:forEach items="${findFoodCategory}" var="ffc">
		  			<li><a href="foodcategory_findOneFoodCategory.action?classid=${ffc.classid }" method="post">${ffc.classname}</a></li>
		  		</c:forEach> 
		  		
			</ul>	
		</div>	
	</div>
	
	<div id="home_right">
		<!-- 根据查询循环 -->
		<div id="searchFood">
			<c:if test="${findFoodBySearch!=null }">
				<c:forEach items="${findFoodBySearch}" var="ffbs">
					<div class="row" style="width:1000px; margin-left:0px;" >
						  <div class="col-sm-12 col-md-4">
						    <div class="thumbnail">
						      <img data-src="holder.js/300x200" alt="..."src="images/food1.jpg"style=" width:100%;">
						      <div class="caption">
						        <h3 style="text-align:center">${ffbs.foodName}</h3>
						         <p style="text-align:center">${ffbs.foodPrice }元</p>
						        <p style="text-align:center"> 
						         <a href=""class="btn btn-primary" role="button">加入购物车</a>
						         <a href="food_findOneFood.action?foodID=${ffbs.foodID}" method="post" class="btn btn-success" role="button">查看详情</a></p>
						      </div>
						    </div>
						  </div>
				</c:forEach>
			</c:if>
	</div>
	
	<div id="findAll">
	<c:if test="${findFoodBySearch==null }"><!-- 没有搜索 -->
		<c:if test="${findOndFoodCategory==null }"><!-- 无种类查询 -->
		<c:forEach items="${findAllFoods}" var="faf">
			<div class="row" style="width:1000px; margin-left:0px;" >
				  <div class="col-sm-12 col-md-4">
				    <div class="thumbnail">
				      <img data-src="holder.js/300x200" alt="..."src="images/food1.jpg"style=" width:100%;">
				      <div class="caption">
				        <h3 style="text-align:center">${faf.foodName}</h3>
				         <p style="text-align:center">${faf.foodPrice }元</p>
				        <p style="text-align:center"> 
				         <a href=""class="btn btn-primary" role="button">加入购物车</a>
				         <a href="food_findOneFood.action?foodID=${faf.foodID}" method="post" class="btn btn-success" role="button">查看详情</a></p>
				      </div>
				    </div>
				  </div>
			</c:forEach>
		</c:if>
	</c:if>
	</div>
	
	<div id="findOneType">
	<!-- 查询一种 -->
		<c:if test="${findOndFoodCategory!=null }">
			<c:forEach items="${findOndFoodCategory}" var="fofc">
				<div class="row" style="width:1000px; margin-left:0px;" >
					  <div class="col-sm-12 col-md-4">
					    <div class="thumbnail">
					      <img data-src="holder.js/300x200" alt="..."src="images/food1.jpg"style=" width:100%;">
					      <div class="caption">
					        <h3 style="text-align:center">${fofc.foodName}</h3>
					         <p style="text-align:center">${fofc.foodPrice }元</p>
					        <p style="text-align:center"> 
					         <a href=""class="btn btn-primary" role="button">加入购物车</a>
					         <a href="food_findOneFood.action?foodID=${fofc.foodID}" method="post" class="btn btn-success" role="button">查看详情</a></p>
					      </div>
					    </div>
					 </div>
			</c:forEach>			
		</c:if>
	</div>
	<!-- 	<div class="row" style="width:1000px; margin-left:0px;" >
		  <div class="col-sm-12 col-md-4">
		    <div class="thumbnail">
		      <img data-src="holder.js/300x200" alt="..."src="images/food1.jpg"style=" width:100%;">
		      <div class="caption">
		        <h3 style="text-align:center">菜品名称</h3>
		         <p style="text-align:center">菜品介绍</p>
		        <p style="text-align:center"> <a href="#" class="btn btn-primary" role="button">加入购物车</a>
		         <a href="#" class="btn btn-success" role="button">查看详情</a></p>
		      </div>
		    </div>
		  </div>
		  -->
		  <!-- 菜品结束循环 -->
  </div>
		<!-- 
		 <iframe name ="home_iframe" id ="home_iframe">

		</iframe> -->
	
  </body>
  <script type="text/javascript">
	  $("#search_btn").click(function(){
	  		var searchfood = $("#searchfood").val();
	  		$.ajax({
	  			type:"post",
	  			url:"food_findAllFoodsBySearch.action",
	  			data:{searchfood:searchfood},
	  			dataType:"json",
	  			success:function(data){
	  				
	  			}
	  		})		
	  });
  
  
  
/*   $("#login_btn").click(function(){
		var Mobile=$("#Mobile").val();
		var password=$("#Userpwd").val();
		if(Mobile==""){
			$("#notice").html("用户名不能为空！");
			$("#notice").css({color:"red",fontSize:"14px"});
				return false;
		}else if(password==""){
			$("#notice").html("密码不能为空！");
			$("#notice").css({color:"red",fontSize:"14px"});
				return false;
		}
		if (password!=null&&Mobile!=null){
				 $.ajax({
				alert("1");
					type:"post",
					url:"userInfoAction_userLogin.action",
					data:{Mobile:$("#Mobile").val(), 
					password:$("#Userpwd").val()},
					datatype:"json",
					success:function(data){
					alert("1222");
						}
				}); 
		} 
		
		
	});
				$("#Mobile").blur(function(){
				
					if($("#Mobile").val()!=""){
					
						$("#notice").html("");
					}
				});
				$("#Userpwd").blur(function(){
					if($("#Userpwd").val()!=""){
						$("#notice").html("");
					}
				}); */
			
  
  /*  //用户登录验证
  $("#login_btn").click(function(){
  	if($("#Mobile").val()==""||$("#Userpwd").val()==""){
  		alert("请填写手机号和密码正确登录");
  	}else{
  
  		$.ajax({
  			type:"post",
			url:"userInfoAction_userLogin.action",
			data:{telephone:$("#Mobile").val(),
			password:$("#Userpwd").val()},
			dataType:"json",
			success:function(data){	
				alert("1");
			}
			
  		});
  	}
  	
  }); */
  	
  	/*  $("#login_btn").click(function(){
  		if($("#Mobile").val()==""||$("#Userpwd").val==""){
  			alert("请输入用户名和密码");
  		}
  		else{
		$.ajax({
  		alert("1");
			type:"post",
			url:"userInfoAction_userLogin.action",
			data:{Mobile:$("#Mobile").val(),
			Userpwd:$("#Userpwd").val()},
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
  	});
  	//注销账户
  	$("#login_mess2").click(function(){
  		$("#login_win").css("display","block");
  		$("#login_mess2").css("display","none");
  	});  */
  </script>
</html>
