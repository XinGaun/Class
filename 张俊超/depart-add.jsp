<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="Bookmark" href="favicon.ico">
<link rel="Shortcut Icon" href="favicon.ico" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css"
	href="static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css"
	href="static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css"
	href="lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css"
	href="static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css"
	href="static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script><![endif]-->
<!--/meta 作为公共模版分离出去-->

<title>添加用户 - H-ui.admin 3.0</title>
<meta name="keywords"
	content="H-ui.admin 3.0,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
<meta name="description"
	content="H-ui.admin 3.0，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>
	<article class="cl pd-20">
	<form action="depart_departadd.action" method="post"
		class="form form-horizontal" id="form-member-add">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>部门名称：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" id="dename" class="input-text" value="" placeholder="部门名称"
					name="departname">
				<span id="span"></span>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>默认状态：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<select name="departstatus">
					<option value ="1">已启用</option>
					<option value ="2">禁用</option>
				</select>
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<input class="btn btn-primary radius" type="submit"
					value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
			</div>
		</div>
	</form>
	</article>

	<!--_footer 作为公共模版分离出去-->
	<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
	<script type="text/javascript" src="static/h-ui/js/H-ui.js"></script>
	<script type="text/javascript"
		src="static/h-ui.admin/js/H-ui.admin.page.js"></script>
	<!--/_footer /作为公共模版分离出去-->

	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript"
		src="lib/My97DatePicker/4.8/WdatePicker.js"></script>
	<script type="text/javascript"
		src="lib/jquery.validation/1.14.0/jquery.validate.js"></script>
	<script type="text/javascript"
		src="lib/jquery.validation/1.14.0/validate-methods.js"></script>
	<script type="text/javascript"
		src="lib/jquery.validation/1.14.0/messages_zh.js"></script>
	<script type="text/javascript">
		var a=1;
		/**
		*添加部门时验证是否输入框是否为空，是否重复
		*
		*/
		$("#dename").blur(
			function (){
				if ($(this).val()=="") {
					$("#span").html("<p style='color:red'>新增部门名不能为空!</p>");
				} else {
					$.ajax({
						type:"post",
						url:"depart_soledepart.action",
						data:{"departname":$("#dename").val()},
						dataType:"text",
						success:function(data){						
							if(data!=0){
								$("#span").html("部门名称可用");
								a =0;
							}else{
								$("#span").html("<p style='color:red'>部门名称不可重复</p>");
								a=1;
							}
						}	
					});
				}
			}
		);
		
		/*
		 $(function(){
		 $('.skin-minimal input').iCheck({
		 checkboxClass: 'icheckbox-blue',
		 radioClass: 'iradio-blue',
		 increaseArea: '20%'
		 });
		
		 $("#form-member-add").validate({
		 rules:{
		 username:{
		 required:true,
		 minlength:2,
		 maxlength:16
		 },
		 sex:{
		 required:true,
		 },
		 mobile:{
		 required:true,
		 isMobile:true,
		 },
		 email:{
		 required:true,
		 email:true,
		 },
		 uploadfile:{
		 required:true,
		 },
		
		 },
		 onkeyup:false,
		 focusCleanup:true,
		 success:"valid",
		 submitHandler:function(form){
		
		 $(form).ajaxSubmit();
		 var index = parent.layer.getFrameIndex(window.name);
		 parent.$('.btn-refresh').click();
		 parent.layer.close(index);
		 }
		 });
		 });
		 */
	</script>
	<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>
