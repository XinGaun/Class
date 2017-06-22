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
  	 #top_menu li a {
  	  	color:#FFBF20;
  	  }
  	  #bottomdiv div{
  	  	float:left;
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
		
		init();
	}
		</script>
  
  <body  class="container" onload="showTime()">

	<nav id="nav1" class="navbar navbar-default navbar-fixed-top" role="navigation" 
	style="filter:alpha(opacity=20);opacity:0.7!important;padding-left:80px;height:90px;padding-top:20px;
	background-color:#E8F1FB;">

	  <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	    <ul id ="top_menu"class="nav navbar-nav">
	     
	      <li><a href="home.jsp" id ="order_sys">点餐系统</a></li>
	      <li style = "padding-left:100px"><a href="home.jsp" >首页</a></li>
	      <li><a href="#">在线预订</a></li>
	       <li ><a href="customer_login.jsp">用户登录</a></li>
	       <li><a href="reg.jsp">用户注册</a></li>
	       <li><a href="userInfoAction_findOrders.action?Mobile=${user[0].Mobile }">我的账户</a></li>
	      <li><a href="#shoppingcar.jsp">购物车</a></li>
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
 	<div class="login-page about" style="margin-top:20px;">
 	<h1 align="center">购物车</h1>
 	<form action="order_makeOrder.action" method="post">
    <table id="cartTable"  class="cart table table-condensed" >  
        <thead>  
            <tr>  
                <th style="width:60px;"><label><input class="check-all check" type="checkbox" id="all" onclick="checkAll()"/> 全选</label></th>  
                <th><label>菜品名称</label></th>  
                <th style="width:100px;"><label>单价</label></th>  
                <th style="width:120px;"><label>数量</label></th>  
                <th style="width:100px;"><label>小计</label></th>  
                <th style="width:40px;"><label>操作</label></th>    
            </tr>  
        </thead>  
        <tbody>  
    <c:forEach items="${cart}" var= "product">
        	<tr class="tr">
        		<td>
        			<input class="check-one check" type="checkbox" />
        		</td>
        		<td class="goods" style="width:200px">
        			 <label>${product.foodName}</label>  
        		</td>
          		<td class="number small-bold-red" class="shoujia">${product.foodPrice}</td>
        	
          		
        		 <td class="input-group" style="margin-left:-42px" width="150px" >  
                    <div class="input-group-addon minus" onclick="jian()">-</div>  
                    <input type="text" readonly="readonly" class="number form-control input-sm"  value="${product.num}" />  
                    <div class="input-group-addon plus">+</div>  
                </td> 
           
                 <td style="color:#FE7C00;" class="xiaoji" id="singleSum">${product.countPrice}</td> 
                 <td class="operation">
                 	<div onclick="delTr()" class="delete btn btn-xs btn-primary">删除</div>
                 	<div >1</div>
                 </td>  
        	</tr>
        </c:forEach>  
        </tbody>  
    </table>  

    <div class="row"> 
     <a href="">首页</a><a href="">尾页</a><a href="">上一页</a><a href="">下一页</a>
        <div class="col-md-12 col-lg-12 col-sm-12">  
            <div id="bottomdiv" style="border-top:1px solid gray;padding:4px 10px;"> 
           		<div>
          			<input type="button" id="delSelect" class="btn btn-danger" value="删除所选">
          		</div>
            	<div style="margin:6px 0px 0px 200px; font-size:15px">
                	<label>金额合计:&nbsp;&nbsp;
                   	<input type="text" size="4"style="border:0px white;color:red" readonly="readonly" name="countMoney" id="countMoney" ><span class="currency">￥</span><span style="color:red" class="large-bold-red"></span><span>元</span></label>  
                    <label style="margin-left:30px;">您选择了&nbsp;&nbsp;<span id="itemCount" class="large-bold-red" style="color:red;margin:0 4px;"></span>&nbsp;&nbsp;种菜品&nbsp;&nbsp;&nbsp;&nbsp;共计&nbsp;&nbsp;<span id="qtyCount" style="color:red"class="large-bold-red" style="margin:0 4px;"></span>&nbsp;&nbsp;份</label>
            	</div> 
            	<div style="margin-left:150px">
          			<input type="submit" id="addOrder" class="btn btn-info" value="确认订单">
                </div>
            </div>  
        </div>  
    </div> 
	</div>
    </form> 

  </body>
  <script type="text/javascript">
	//选中全部的复选框
 	function checkAll(){
	var flag=$("#all")[0].checked;
		$(":checkbox").each(
			function(){
				$(this)[0].checked=flag;
			}
		);
	}
	//删除已选中的复选框
		$("#delSelect").click(
		function (){
			$(":checkbox").each(
				function(){
				if($(this)[0].checked==true)
					{
					var par=($(this).parent().parent());
					par.remove();}
				}
			);
		}
	);
	//总价
	function init(){
		var countPrice = 0.00;//总价
		var foodcount = 0 ;//获取菜品总个数
		var foodtype= document.getElementsByTagName("tr").length-1;	
		$(".tr").each(function(){
			//获取单品菜品的小计
			 countPrice = countPrice+parseFloat($(this).find(".xiaoji").text());
			//获取菜品总份数
			 foodcount = foodcount + parseInt($(this).find(".input-sm").val());
		});
		var countPrice = countPrice;
		$("#countMoney").val(countPrice);
		$("#itemCount").text(foodtype);
		$("#qtyCount").text(foodcount);
	}
		//自加
		$(".plus").click(function() { //加
			var input = $(this).parent().find("input").val();//获取input内的值
			var b = parseInt(input) +1;//自加
			$(this).parent().find("input").val(b);//将自加的值放入input框内
			var foodPrice=parseFloat($(this).parent().parent().children().first().next().next().text());//获取售价
			$(this).parent().parent().find(".xiaoji").text(parseFloat(b*foodPrice));//小计计算结果
		});
		//进行自减操作
		$(".minus").click(function() { //减
			var input = $(this).parent().find("input").val();//获取input内的值
			var b = parseInt(input) -1;//自减
			if(b==0){//判断是否为0，当为0时，设置为1
				b=1;
			}
			$(this).parent().find("input").val(b);//将自加的值放入input框内
			var foodPrice=parseFloat($(this).parent().parent().children().first().next().next().text());//获取售价
			$(this).parent().parent().find(".xiaoji").text(b*foodPrice);//小计计算结果
		});
		/* //删除一行
		function delTr(){
			$(this).each(function(){
				var b = $(this).parent().children().first().next().html();
				alert(b);
			});
		} */
  </script>
</html>
