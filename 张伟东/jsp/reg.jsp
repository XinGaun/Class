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

</head>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=	qiF0y9uvwUfl4T2Z9ZC3b68OcLvIG3y9"></script> 
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
			<h3 class="w3ls-title w3ls-title1">注册</h3>  
			<div class="login-agileinfo"> 
				<form action="userInfoAction_uersReg.action" onsubmit="return showAll()	" method ="post"> 
				<!-- 用户名 -->
					<input oncontextmenu="return false"onpaste="return false" onblur="checkName()" onfocus="checkName2()"class="agile-ltext" type="text" name="UserName" id="UserName"  placeholder="姓名" required="">
					<div id="UserNamecare" style="border: margin-top:2px;height:20px; text-align:center;"></div>
				<!-- 手机号 -->
					<input  oncontextmenu="return false"onpaste="return false"onblur="checkPhone()" maxlength="11"onfocus="pe()" class="agile-ltext" style="margin-top:4px;"type="text" name="Mobile" id="Mobile" placeholder="手机号" required="">
					<div id="mobilecare" style="border: margin-top:2px;height:20px; text-align:center;"></div>
				<!-- 密码 -->
					<input oncontextmenu="return false"onpaste="return false" onblur="passA()" onfocus="passB()" style="margin-top:12px;" class="agile-ltext" type="password" name="Userpwd" id="Userpwd" placeholder="密码" required="">
						<div id="passwordcare" style="border: margin-top:2px;height:20px; text-align:center;"></div>
			
				<!-- 重复密码 -->
					<input oncontextmenu="return false"onpaste="return false" onblur="passC()" onfocus="passD()"class="agile-ltext" style="margin-top:12px;"  type="password" name="repassword" id="repassword"placeholder="重复密码" required="">
							<div id="repasswordcare" style="border: margin-top:2px;height:20px; text-align:center;"></div>
			
				<!-- 地址-->
					<input  readonly="readonly"  onblur="checkAddress()" onfocus="checkAddress2()" class="agile-ltext" style="margin-top:12px;"  type="text" name="UserAddress" id="UserAddress" placeholder="地址" required="">
								<div id="Addresscare" style="margin-top:2px;height:20px; text-align:center;"></div>
				<!-- 地图 -->
					<div id="onlinemap" style="display:none;margin-top:-20px">
							  <input id="where" style="width:200px; height:35px;font-size:12px;" name="where" placeholder="位置搜索" type="text" >   
							 <a style="margin:-35px 0px 0px 210px"type="button" id ="login_btn"class="btn btn-primary"  value="地图上找" onClick="sear(document.getElementById('where').value);"> 地图上找</a>

							  <a style="margin:-35px 0px 0px 368px" type="button" id ="hideMap" onclick="checkMap()"class="btn btn-primary" >隐&nbsp;&nbsp;藏</a>
							  <br />  
							  <div style="width:430px;height:340px;border:1px solid gray" id="container"></div>  
							  <br />  
					
					</div>
					
					<div class="wthreelogin-text" style="margin-top:0px;"> 
						<ul> 
							<li>
								<label class="checkbox"><input type="checkbox" id="agree" name="agree"><i></i> 
									<span > 我同意服务条款</span> 
								</label> 
							</li> 
						</ul>
					</div>   
					<input type="submit" id="reg_btn" value="注 &nbsp;册">
				</form>
				<p>是否已有账号?  <a href="customer_login.jsp">现在登录!</a></p> 
			</div>	 
			
		</div>
	</div>
  </body>
  <script type="text/javascript">
  
  
  	//显示地图
  	function checkAddress2(){
  		$("#onlinemap").css({color:"blue",display:"block"});
  		$("#Addresscare").html("本店外卖只送河南省郑州市中原区地区");
  		$("#Addresscare").css({color:"blue",display:"block"});
  	}
   	//隐藏按钮方法
  
var a;
var map = new BMap.Map("container");//在指定的容器内创建地图实例  
	map.setDefaultCursor("crosshair");//设置地图默认的鼠标指针样式  
	map.enableScrollWheelZoom();//启用滚轮放大缩小，默认禁用。
	
	map.addControl(new BMap.NavigationControl()); 
	var geoc = new BMap.Geocoder();
	map.addEventListener("click", function(e){//地图单击事件  
		var pt = e.point;
		geoc.getLocation(pt, function(rs){
			var addComp = rs.addressComponents;
			document.getElementById("UserAddress").value=addComp.province + ", " + addComp.city + ", " + addComp.district + ", " + addComp.street + ", " + addComp.streetNumber;
			
		});
		//document.getElementById("lonlat").value = e.point.lng + ", " + e.point.lat;  
	});  
	function iploac(result){//根据IP设置地图中心  
		var point = new BMap.Point(113.628283,34.762);
		map.centerAndZoom(point,18);
	}  
	var myCity = new BMap.LocalCity();  
	myCity.get(iploac);  
	function sear(result){//地图搜索  
		var local = new BMap.LocalSearch(map, {  
		    renderOptions:{map: map}  
	  });  
	 local.search(result);  
	}  
</script>  
  
  <script type="text/javascript">

  	function showAll(){
  			
			if(checkName()&&passA()&&checkPhone()&&passC()&&checkAgree()&&checkMap()){
				return true;
			}
			else{
				return false;
			}
		}
 	//检查非空
 	/* function checkNull(){
			var st=true;
			$("input").each(
				function(){
					if($(this).val()==""){
					checkName();checkPhone();passA();passC();
						st=false;
					}
				}
			);
			return st;
		}
  */
  	//验证地图
  	function checkMap(){
  		var mapStr=$("#UserAddress").val();
  		var mapSub = mapStr.substring(0,3);//获得省份
  		var mapSub2 = mapStr.substring(5,8);//获得市级
  		var mapSub3 = mapStr.substring(10,13)//获得区
  		if(mapSub=="河南省"){
  			if(mapSub2=="郑州市"){
  				if(mapSub3=="中原区"){
  					$("#onlinemap").css({color:"blue",display:"none"});//隐藏地图
	  				$("#Addresscare").css({color:"blue",display:"none"});//隐藏提示语
	  				return true;
  				}else{
  					$("#Addresscare").html("请核对您填写的市区是否为中原区");
  					return false;
  				}
  				$("#Addresscare").html("请核对您填写的市区是否为中原区");
  				return false;
  			}
  				
	  		$("#Addresscare").html("请核对您填写的市区是否为郑州市");
	  		return false;
  		}else{
  			$("#Addresscare").html("请核对您填写的市区是否为河南省");
  			return false;
  		}
  	}
  
  
		//验证用户名
		function checkName(){
			if($("#UserName").val()==""){
				$("#UserNamecare").html("用户名不能为空!");
				$("#UserNamecare").css({color:"blue",fontSize:"14px"});
				
				return false;
			}
			var reg=/^[\u4e00-\u9fa5]{2,6}$/;
			if(reg.test($("#UserName").val())){
			 	$("#UserNamecare").html("");
				/* $("#UserNamecare").html("用户名正确");
				$("#UserNamecare").css({color:"blue",fontSize:"14px"}); */
				return true;
			}else{
				return false;
			}
		}
		function checkName2(){
			$("#UserNamecare").html("用户名：中文2-6位");
			$("#UserNamecare").css({color:"blue",fontSize:"14px"});
		}
		//手机号
			function checkPhone(){
			if($("#Mobile").val()==""){
				$("#mobilecare").html("手机号码不能为空！");
				$("#mobilecare").css({color:"blue",fontSize:"14px"});
				return false;
			}
			else{
				var reg=/^(18|13|15|16)\d{9}$/;
				if(reg.test($("#Mobile").val())){
					$.ajax({
						type:"post",
						data:{"Mobile":$("#Mobile").val()},
						url:"userInfoAction_findOnlyMobile.action",
						dataType:"text",
						success:function(data){
							if(data==1){
								$("#mobilecare").html("手机号码已被使用！");
								$("#mobilecare").css({color:"blue",fontSize:"14px"});
								return false;
							}else{
								$("#mobilecare").html("手机号码可以使用！");
								return true;
							}
						}
					});
					
					return true;
				}
				else{
					$("#mobilecare").html("手机号码格式错误！");
					$("#mobilecare").css({color:"blue",fontSize:"14px"});
					return false;
				}
			}
		}
		function pe(){
			$("#mobilecare").html("手机号码以13,15,16,18开头;手机号码由11位数字组成");
			$("#mobilecare").css({color:"blue",fontSize:"14px"});
		}
		
		//验证密码
		function passA(){
			if($("#Userpwd").val()==""){
				$("#passwordcare").html("密码不能为空!");
				$("#passwordcare").css({color:"blue",fontSize:"14px"});
				return false;
			}
			else{
				var reg=/^\w{6,16}$/;
				if(reg.test($("#Userpwd").val())){
					$("#passwordcare").html("");
					$("#passwordcare").css({color:"blue",fontSize:"14px"});
					return true;
				}
				else{
					$("#passwordcare").html("密码格式错误！");
					$("#passwordcare").css({color:"blue",fontSize:"14px"});
					return false;
				}
			}
		}
		function passB(){
			$("#passwordcare").html("密码长度为6-16");
			$("#passwordcare").css({color:"blue",fontSize:"14px"});
		}
		function passD(){
			$("#repasswordcare").html("密码长度为6-16，两次密码必须一致");
			$("#repasswordcare").css({color:"blue",fontSize:"14px"});
		}
		
		function passC(){
			if($("#repassword").val()!=""||$("#Userpwd").val()!=""){
				if($("#repassword").val()==$("#Userpwd").val()){
					$("#repasswordcare").html("");
					$("#repasswordcare").css({color:"blue",fontSize:"14px"});
					return true;
					}
				else{
					$("#repasswordcare").html("密码不一致！");
					$("#repasswordcare").css({color:"blue",fontSize:"14px"});
					return false;
				}
			}
			else{
				$("#repasswordcare").html("确认密码不能为空！");
				$("#repasswordcare").css({color:"blue",fontSize:"14px"});
					return false;
			}
		}

		//复选框的验证
	function checkAgree(){
	
		if($(":checkbox")[0].checked==true) {
			return true;
		}else{
			return false;
		}
	}

  </script>
</html>
