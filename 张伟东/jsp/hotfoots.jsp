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
	<style type="text/css">
		#hot_main{
			width:100%;
			height:100%;
			border:1px solid red;
		}
	</style>
  </head>
  
  <body>
    <div id ="hot_main">
    	<c:forEach items="${hotfoots.rowList}" var = "foot">
  			<div class="hot_most">${foot.img}</div>
  			<div class="hot_text">${foot.price}</div>
  			<div class="hot_text">${foot.mess}</div>
  		</c:forEach>
    </div>
  </body>
</html>
