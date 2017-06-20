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
    <c:forEach items="${findShoppingCar}" var= "product">
        	<tr>
        		<td><input class="check-one check" type="checkbox" /></td>
        		<td class="goods" style="width:200px">
        			 <label>${product.foodName}</label>  
        		</td>
        		
        	<%-- 	<td class="sl">
					<div class="Numbers">
						<a href="javascript:void(0);" onclick="updatenum('del');"
							class="jian">-</a> <input id="number" name="number"
							type="text" readonly="readonly" value="${cart.cart_buycount}" class="number_text"/> <a
							href="javascript:void(0);" onclick="updatenum('del');"
							class="jia">+</a>
					</div>
				</td> --%>
        		
        		
        		<td class="number small-bold-red"><span>${product.foodPrice}</span></td> 
        		 <td class="input-group" style="margin-left:-42px" width="150px" >  
                    <span class="input-group-addon minus" id="">-</span>  
                    <input type="text" class="number form-control input-sm"  value="10" />  
                    <span class="input-group-addon plus">+</span>  
                </td> 
                <td style="color:#FE7C00;" id="singleSum">0</td> 
                 <td class="operation"><span class="delete btn btn-xs btn-primary">删除</span></td>  
        	</tr>
        </c:forEach>  
          <!--    <tr >  
                <td ><input class="check-one check" type="checkbox" /> </td>  
                <td class="goods">  
                    <label>Item 1</label>  
                </td>  
                <td class="number small-bold-red"><span>76.55</span></td>  
                <td class="input-group">  
                    <span class="input-group-addon minus">-</span>  
                    <input type="text" class="number form-control input-sm" value="10" />  
                    <span class="input-group-addon plus">+</span>  
                </td>  
                <td class="subtotal number small-bold-red">101</td>  
                <td class="operation"><span class="delete btn btn-xs btn-primary">删除</span></td>  
            </tr>  
            <tr>  
                <td ><input class="check-one check" type="checkbox" /></td>  
                <td class="goods">  
                    <label>Item 2</label>  
                </td>  
                <td class="number small-bold-red"><span>1100</span></td>  
                <td class="input-group">  
                    <span class="input-group-addon minus">-</span>  
                    <input type="text" class="number form-control input-sm" value="1" />  
                    <span class="input-group-addon plus">+</span>  
                </td>  
                <td class="subtotal number small-bold-red">352</td>  
                <td class="operation"><span class="delete btn btn-xs btn-primary">删除</span></td>  
            </tr>  
            <tr>  
                <td ><input class="check-one check" type="checkbox" /></td>  
                <td class="goods">  
                    <label>Item 3</label>  
                </td>  
                <td class="number small-bold-red"><span>1200</span></td>  
                <td class="input-group">  
                    <span class="input-group-addon minus">-</span>  
                    <input type="text" class="number form-control input-sm" value="1" />  
                    <span class="input-group-addon plus">+</span>  
                </td>  
                <td class="subtotal number small-bold-red">9876.55</td>  
                <td class="operation"><span class="delete btn btn-xs btn-primary">删除</span></td>  
            </tr>  
            <tr>  
                <td ><input class="check-one check" type="checkbox" /></td>  
                <td class="goods">  
                    <label>Item 4</label>  
                </td>  
                <td class="number small-bold-red"><span>1400</span></td>  
                <td class="input-group">  
                    <span class="input-group-addon minus">-</span>  
                    <input type="text" class="number form-control input-sm" value="1" />  
                    <span class="input-group-addon plus">+</span>  
                </td>  
                <td class="subtotal number small-bold-red">9876.55</td>  
                <td class="operation"><span class="delete btn btn-xs btn-primary">删除</span></td>  
            </tr>   --> 
        </tbody>  
    </table>  

    <div class="row"> 
     <a href="">首页</a><a href="">尾页</a><a href="">上一页</a><a href="">下一页</a>
        <div class="col-md-12 col-lg-12 col-sm-12">  
            <div style="border-top:1px solid gray;padding:4px 10px;">  
           <!--  <a  type="button" id ="del"class="btn btn-danger" value="删除所选">
             <span id="del"><img id="delSelect"src="photos/del_checked.jpg"></img></span> --> 
           <input type="button" id="delSelect"class="btn btn-danger" value="删除所选">
                <div style="margin-left:20px;" class="pull-right total">  
                    <label>金额合计:<span class="currency">￥</span><span id="priceTotal" class="large-bold-red">0.00</span></label>  
                </div>  
                <div class="pull-right">  
                    <label>您选择了<span id="itemCount" class="large-bold-red" style="margin:0 4px;"></span>种菜，共计<span id="qtyCount" class="large-bold-red" style="margin:0 4px;"></span>个</label>  
                </div>  
                <div class="pull-right selected" id="selected">  
                    <span id="selectedTotal"></span>  
                </div>  
            </div>  
        </div>  
    </div>  
	</div>
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
  </script>
</html>
