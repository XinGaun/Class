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
  </style>
  </head>
	<body class="container">  
    <table id="cartTable"  class="cart table table-condensed" >  
        <thead>  
            <tr>  
                <th style="width:60px;"><label><input class="check-all check" type="checkbox" /> 全选</label></th>  
                <th><label>产品型号</label></th>  
                <th style="width:100px;"><label>单价</label></th>  
                <th style="width:120px;"><label>数量</label></th>  
                <th style="width:100px;"><label>小计</label></th>  
                <th style="width:40px;"><label>操作</label></th>    
            </tr>  
        </thead>  
        <tbody>  
            <tr >  
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
            </tr>  
        </tbody>  
    </table>  
  
    <div class="row">  
        <div class="col-md-12 col-lg-12 col-sm-12">  
            <div style="border-top:1px solid gray;padding:4px 10px;">  
                <div style="margin-left:20px;" class="pull-right total">  
                    <label>金额合计:<span class="currency">￥</span><span id="priceTotal" class="large-bold-red">0.00</span></label>  
                </div>  
                <div class="pull-right">  
                    <label>您选择了<span id="itemCount" class="large-bold-red" style="margin:0 4px;"></span>种产品型号，共计<span id="qtyCount" class="large-bold-red" style="margin:0 4px;"></span>件</label>  
                </div>  
                <div class="pull-right selected" id="selected">  
                    <span id="selectedTotal"></span>  
                </div>  
            </div>  
        </div>  
    </div>  
</body>  
</html>  
  	
</html>
