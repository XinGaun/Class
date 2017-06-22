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
  	  input[type="text"]{
		width:70px;
	}
  	  #showBig{
		position:absolute;
		left:450px;
		top:140px;
		width:520px;
		height:470px;
		display:none;
		background-repeat:no-repeat;
		overflow:hidden;
	}
	#beforetab div{
		float:left;
	}
	.leftmess{
		width:100px;
		height:40px;
		font-size:20px;
	}
	.rightmess{
		width:430px;
		height:40px;
		font-size:20px;
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
		var price = ${findOneFood[0].foodPrice};//菜品单价
		
		/* 加载总共价格 */
		fill();
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
	<div id="showp"style="border:1px solid gray;height:300px;width:300px; position:absolute;left:150px;top:140px;">
		<img src="images/timg.jpg"width="290px" height="290px">
	</div>
	<div style="position:absolute;top:470px;left:200px;width:190px;height:100px;text-align:center; "  class="btn-group btn-group-justified">
			    <h3 id="foodname" class="media-heading">${findOneFood[0].foodName}</h3>
	</div>

	
	</div>
	<!-- 菜品详情 -->
	<div style="border:1px solid gray;filter:alpha(opacity=20);opacity:0.7!important; position:absolute;top:140px;left:450px;width:700px;height:470px">
		<!-- 面包屑开始 -->
		<form action="food_addCar.action" method="post">
			<input type="hidden" name="foodName" value="${findOneFood[0].foodName}">
			<div class="jumbotron" style="height:0px;">
			  <h3 >
				  单价：<span  style="color:red"><input type="hidden" name="foodPrice" value="${findOneFood[0].foodPrice}">${findOneFood[0].foodPrice}￥元</span>
				  &nbsp;&nbsp;&nbsp;&nbsp;总价：<span  style="color:red"name="countPrice" id="count">25</span >
			  		<span style="color:red">￥元</span>
			  </h3>
			  <h3></h3>
			</div>
			<!-- 面包屑结束 -->
			<div id="beforetab" style="padding:0px 0px 0px 40px;height:180px;width:580px;">
				<div class="leftmess">配送方式:</div>
				<div class="rightmess">快递</div>
				
				<div class="leftmess">购买数量:</div>
				<div class="rightmess">
					
									<img src="images/minus.jpg"id="jian" width="15px;"></img>
									<input type="text"onblur="fill()" name="num"id="num"value="1">
									<img src="images/adding.jpg" id="jia" width="15px;"></img>
							
				</div>
				
			</div>
			<div id="btn_div" style="margin-left:40px">
				 <input type="button" class="btn btn-warning btn-lg" onClick="location.href='home.jsp'"id="backhome" value="&nbsp;再&nbsp;&nbsp;逛&nbsp;&nbsp;逛&nbsp;&nbsp;">
				 <input type="submit" id="add_car" class="btn btn-info btn-lg" value="加入购物车" >
			</div>
		</form>
	 </div>
	<div id="showBig"></div>
  </body>
  <script type="text/javascript">
 
  var price = ${findOneFood[0].foodPrice};//菜品单价
  //图片放大镜
	$(document).ready(
			function (){
				$("#showp").JNMagnifier({
					renderTo:"#showBig"
				});
			}
		); 
	//加
	$("#jia").click(function(){
		var num = $("#num").val();
		num++;//每次点击，文本框内的数据自加一次
		$("#num").val(num);
		
		var count = price*num;//总价
		$("#count").html(count);
	});
	//减减操作
	$("#jian").click(function(){
		var num = $("#num").val();
		if(num>1){
			num--;//每次点击，文本框内的数据自加一次
			$("#num").val(num);
			var count = price*num;//总价
			$("#count").html(count);
		}else{
			$("#num").val("1");
		}
		
	});
	//失焦
	function fill(){
		var num = $("#num").val();//获取文本档的内容
		var length = num.length;//获取文本框内容的长度
		for(var i = 0; i <length ; i++){//截取每个字符去和数字比较
			if(num.charAt(i)>"9" || num.charAt(i)<"0"){//判断是否为数字
				$("#count").html("25");//默认的总价
				$("#num").val("1");//默认数量为1
				return false;
			}else{
			var count = price * num;
				$("#count").html(count);
			}
		}if(num==""||num==null){
			$("#num").val("1");
		}
	}
	//键盘输入的值不能字母
	$("#num").keypress(function(event) { 
	            var keyCode = event.which;  
	            if (keyCode==8 ||keyCode==37 ||keyCode==39 || (keyCode >= 48 && keyCode <=57))  
	                return true;  
	            else {
	                return false;  
	            }
	        })
	 /* //添加购物车      bug未解决 
	   $("#add_car").click(function(){
	  
	   		var countprice = $("#count").html();//获取总价钱
	   		var nums = $("#num").val();//获取菜品数量
	   		var foodname = $("#foodname").html();//获取菜品名称
	   		var oneprice = ${findOneFood[0].foodPrice};//单件价格
	   		$.ajax({
	   			type:"post",
	   			url:"food_addCar.action",
	   			data:{countPrice:countprice,
	   				  foodPrice:oneprice,
					  num:nums,
					  foodName:foodname,},
	   			dataType:"json",
	   			success:function(data){
	   			}
	   		}) 
	   });  */
  </script>
</html>
