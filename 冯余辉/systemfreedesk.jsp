<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="x" %>
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
<!--[if IE 6]>
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script><![endif]-->
<!--/meta 作为公共模版分离出去-->
<style type="text/css">
	#homedesk{
		display:none;
	}
	#dd{
		position: absolute;
		top:0px;
	}
	.col-md-1{
		height:80px;
		margin:10px;
		width: 100px;	
		
	}
	#div-li ul li{
		color:black;
	}
	#div-li ul li a{
		color:blue;
	}
	.div{
		height:50px;
	}
	.img{
		width:80px;
		height:80px;
		margin-top:-50px;
	}
	
</style>
<script>
	function changedesk(){
		document.getElementById("homedesk").style.display="none";
		document.getElementById("desk").style.display="block";
	}
	function changehome(){
		document.getElementById("homedesk").style.display="block";
		document.getElementById("desk").style.display="none";
	}
</script>
<title>图片列表</title>
<script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script></head>
<body>
<!--_header 作为公共模版分离出去-->

<!--_menu 作为公共模版分离出去-->


<section class="Hui-article-box" id="dd">
	<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 开台 <span class="c-gray en">&gt;</span>  <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
	<div class="Hui-article">
		<article class="cl pd-20">
			<!-- <div class="text-c"> 日期范围：
				<input type="text" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'logmax\')||\'%y-%M-%d\'}'})" id="logmin" class="input-text Wdate" style="width:120px;">
				-
				<input type="text" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'logmin\')}',maxDate:'%y-%M-%d'})" id="logmax" class="input-text Wdate" style="width:120px;">
				<input type="text" name="" id="" placeholder=" 图片名称" style="width:250px" class="input-text">
				 <button name="" id="" class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i> 搜图片</button> 
			</div>-->
			<!--  <div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a> <a class="btn btn-primary radius" onclick="picture_add('添加图片','picture-add.jsp')" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 添加图片</a></span> <span class="r">共有数据：<strong>54</strong> 条</span> </div>-->
			<a onclick="location.href='systemopendesk.jsp'"class="btn btn-default">返回</a>
			<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="glyphicon glyphicon-plus"><i class="glyphicon glyphicon-plus">&#xe6e2;</i> <button type="button" class="btn btn-primary" onclick="changedesk()">可用的大厅</button><button type="button" class="btn btn-primary" onclick="changehome()">可用的包厢</button> </span> <span class="r"><strong></strong> </span> </div>
			<div class="div"></div>
			<div  id="desk" class="col-md-10">
				<c:forEach items="${list}" var="li">
					<div class="col-md-1 " id="div-li"> 
						<ul >
							<img class="img" src="../img/1aaa.jpg">
							<li>桌号:${li.deskID }</li>
							<li>人数:${li.deskSize }</li>
							<li><a  href="login_opendesk.action?opendeskid=${li.deskID }">开台</a></li>
						</ul>
					</div>
				</c:forEach>
			</div>
			<div id="homedesk" class="col-md-10">
				<c:forEach items="${homelist}" var="li">
					<div class="col-md-1  " id="div-li">
						<ul >
							<img class="img" src="../img/1aaa.jpg">
							<li>桌号:${li.deskID }</li>
							<li>人数:${li.deskSize }</li>
						<li><a href="login_opendesk.action?opendeskid=${li.deskID }">开台</a></li>
						</ul>
					</div>
				</c:forEach>
			</div>
			
			</div>
		</article>
	</div>
</section>

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
<script type="text/javascript">

$('.table-sort').dataTable({
	//"aaSorting": [[ 1, "desc" ]],//默认第几个排序
	//"bStateSave": true,//状态保存
	//"aoColumnDefs": [
	  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
	 // {"orderable":false,"aTargets":[0,8]}// 制定列不参与排序
	//]
});
/*图片-添加*/
/*
function picture_add(title,url){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}*/
/*图片-查看*/
/*
function picture_show(title,url,id){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}*/
/*图片-审核*/
/*
function picture_shenhe(obj,id){
	layer.confirm('审核文章？', {
		btn: ['通过','不通过'], 
		shade: false
	},
	function(){
		$(obj).parents("tr").find(".td-manage").prepend('<a class="c-primary" onClick="picture_start(this,id)" href="javascript:;" title="申请上线">申请上线</a>');
		$(obj).parents("tr").find(".td-status").jsp('<span class="label label-success radius">已发布</span>');
		$(obj).remove();
		layer.msg('已发布', {icon:6,time:1000});
	},
	function(){
		$(obj).parents("tr").find(".td-manage").prepend('<a class="c-primary" onClick="picture_shenqing(this,id)" href="javascript:;" title="申请上线">申请上线</a>');
		$(obj).parents("tr").find(".td-status").jsp('<span class="label label-danger radius">未通过</span>');
		$(obj).remove();
    	layer.msg('未通过', {icon:5,time:1000});
	});	
}*/
/*图片-下架*/
/*
function picture_stop(obj,id){
	layer.confirm('确认要下架吗？',function(index){
		$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="picture_start(this,id)" href="javascript:;" title="发布"><i class="Hui-iconfont">&#xe603;</i></a>');
		$(obj).parents("tr").find(".td-status").jsp('<span class="label label-defaunt radius">已下架</span>');
		$(obj).remove();
		layer.msg('已下架!',{icon: 5,time:1000});
	});
}
*/

/*图片-发布*/
/*
function picture_start(obj,id){
	layer.confirm('确认要发布吗？',function(index){
		$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="picture_stop(this,id)" href="javascript:;" title="下架"><i class="Hui-iconfont">&#xe6de;</i></a>');
		$(obj).parents("tr").find(".td-status").jsp('<span class="label label-success radius">已发布</span>');
		$(obj).remove();
		layer.msg('已发布!',{icon: 6,time:1000});
	});
}*/
/*图片-申请上线*/
/*
function picture_shenqing(obj,id){
	$(obj).parents("tr").find(".td-status").jsp('<span class="label label-default radius">待审核</span>');
	$(obj).parents("tr").find(".td-manage").jsp("");
	layer.msg('已提交申请，耐心等待审核!', {icon: 1,time:2000});
}*/
/*图片-编辑*/
/*
function picture_edit(title,url,id){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
*/
/*图片-删除*/
/*
function picture_del(obj,id){
	layer.confirm('确认要删除吗？',function(index){
		$(obj).parents("tr").remove();
		layer.msg('已删除!',{icon:1,time:1000});
	});
}*/
</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>
