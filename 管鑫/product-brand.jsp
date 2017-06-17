<%@page import="guanxin.Dao.realizeDao.ClassifyDao"%>
<%@page import="guanxin.Dao.protDao.daoProt"%>
<%@page import="com.zjc.entity.Classify"%>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="Bookmark" href="favicon.ico" >
<link rel="Shortcut Icon" href="favicon.ico" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/style.css" />
<script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
<!--[if IE 6]>
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script><![endif]-->
<!--/meta 作为公共模版分离出去-->
<style type="text/css">
	#dd{
		position: absolute;
		TOP:0px;
	}
	#error{
		position:absolute;
		width:480;
		text-align: center;
	}
</style>
<title>菜类管理</title>
</head>
<body>
<section class="Hui-article-box" id="dd">
	<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 菜品管理 <span class="c-gray en">&gt;</span>菜类管理 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
		
	<div class="Hui-article">
		<article class="cl pd-20">
			<div class="text-c">
				<form class="Huiform" method="post" action="classify_updeteClassify.action" target="_self" onsubmit="return show()">
					<input type="text" placeholder="菜类名称"  id="classify"  name="classname" class="input-text" style="width:120px">
					
					<span class="btn-upload form-group">
					
					<!-- <a href="javascript:void();" class="btn btn-primary upload-btn"><i class="Hui-iconfont">&#xe642;</i> 添加图片</a> -->
					<input type="file" multiple name="file-2" class="input-file">
					</span> <!--<span class="select-box" style="width:150px">
					 <select class="select" name="brandclass" size="1">
						<option value="1" selected>国内品牌</option>
						<option value="0">国外品牌</option>
					</select> -->
					</span><button type="submit" class="btn btn-success" id="addClassify" name="addClassify" ><i class="Hui-iconfont">&#xe600;</i>添加菜类</a></button><span id="error" style="width:200px">&nbsp;</span>
				</form>
			</div>
			<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"></span> <span class="r">共有数据：<strong>${ClassifyList.size()}</strong> 条</span> </div>
			<div class="mt-10">
				<table class="table table-border table-bordered table-bg table-sort">
					<thead>
						<tr class="text-c">
							<!-- <th width="25"><input type="checkbox" name="" value=""></th> -->
							<th width="70">菜类ID</th>
							<!-- <th width="80">排序</th> -->
							<th width="200">菜类名称</th>
					<!-- 		<th width="120">具体描述</th> -->
							<th>菜类状态</th>
							<th width="100">操作</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${ClassifyList}" var="p">
					
						<tr class="text-c">
							<!-- <td><input name="" type="checkbox" value="" ></td> -->
							<!-- 	<td>1</td> -->
							<td><input type="text" class="input-text text-c" value="${p.classid}"  disabled="disabled">
							</td>
							<td class="ere">${p.classname}</td>
						<!-- 	<td class="text-l" id="de">这是热菜</td> -->
							<td class="text-l" style="text-align:center;">
								<c:if test="${p.stutu==1}">未禁用<input type="text" name="stutu" value="${p.stutu}" style="display: none"/></c:if>
								<c:if test="${p.stutu!=1}">已禁用<input type="text" name="stutu" value="${p.stutu}" style="display: none"/></c:if>
							</td>
							<td class="f-14 product-brand-manage"><a class="submitee" href="classify_alterClassify.action?classid=${p.classid}&stutu=${p.stutu}&classname=${p.classname}">
								<c:if test="${p.stutu==1}">禁用</c:if>
								<c:if test="${p.stutu!=1}">启用</c:if>
							<i class="Hui-iconfont">&#xe6df;</i></a></td>
						</tr>
					
					</c:forEach>
					</tbody>
				</table>
			</div>
		</article>
	</div>
</section>
<script type="text/javascript">
	
	var a = 1;
	/**
	*添加菜类时验证是否输入框是否为空
	*
	*/
	$("#classify").blur(
		function(){
			if($(this).val()==""){
				$("#error").html("<p style='color:red'>新增菜类名不能为空!</p>");
			}else{
				$.ajax({
					type:"post",
					url:"classify_soleClassify.action",
					data:{"classname":$("#classify").val()},
					dataType:"text",
					success:function(data){						
						if(data!=0){
							$("#error").html("菜类名可用");
							a =0;
						}else{
							$("#error").html("<p style='color:red'>菜类名重复用</p>");
							a=1;
						}
					}	
				});
			}
		}
	);
	/**
	*添加菜品
	*/
	 $("#addClassify").click(
		function(){
		
			if($("#classify").val()!=null && a==0){
				alert("添加成功!");
			}else{
				return false;
			}
		}
	); 
	/**
	* 表单提交验证
	*/
	function show(){
		if(a==0){
			return true;
		}else{
			return false;
		}
	}
	var b =0;
	$(".submitee").click(
		function(){
			var ee = confirm("是否修改状态");
			if(ee==true){	
				b =1;
				return true;
			}else{
				b=0;
				return false;
			}
		}
	);
</script>
<!--_footer 作为公共模版分离出去--> 
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.js"></script> 
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.page.js"></script> 
<!--/_footer /作为公共模版分离出去--> 

<!--请在下方写此页面业务相关的脚本--> 
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script>  
<script type="text/javascript" src="lib/datatables/1.10.0/jquery.dataTables.min.js"></script> 
<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script>
<!-- <script type="text/javascript">
/* $('.table-sort').dataTable({
	"aaSorting": [[ 1, "desc" ]],//默认第几个排序
	"bStateSave": true,//状态保存
	"aoColumnDefs": [
	  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
	  {"orderable":false,"aTargets":[0,6]}// 制定列不参与排序
	]
}); */
</script> -->
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>