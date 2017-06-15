<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

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

<title>H-ui.admin 3.0</title>
<style type="text/css">
	iframe {
	width:100%;
	height:100%;
	border:none;
}
</style>
<meta name="keywords"
	content="H-ui.admin 3.0,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
<meta name="description"
	content="H-ui.admin 3.0，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>

<body>
	<!--_header 作为公共模版分离出去-->
	<header class="navbar-wrapper">
	<div class="navbar navbar-fixed-top">
		<div class="container-fluid cl">
			<a class="logo navbar-logo f-l mr-10 hidden-xs"
				href="/aboutHui.shtml">H-ui.admin</a> <a
				class="logo navbar-logo-m f-l mr-10 visible-xs"
				href="/aboutHui.shtml">H-ui</a> <span
				class="logo navbar-slogan f-l mr-10 hidden-xs">3.0</span> <a
				aria-hidden="false" class="nav-toggle Hui-iconfont visible-xs"
				href="javascript:;">&#xe667;</a>
			<nav class="nav navbar-nav">
			<ul class="cl">
				<li class="dropDown dropDown_hover"><a href="javascript:;"
					class="dropDown_A"><i class="Hui-iconfont">&#xe600;</i> 新增 <i
						class="Hui-iconfont">&#xe6d5;</i>
				</a>
					<ul class="dropDown-menu menu radius box-shadow">
						<li><a href="javascript:;"
							onclick="article_add('添加资讯','article-add.jsp')"><i
								class="Hui-iconfont">&#xe616;</i> 资讯</a>
						</li>
						<li><a href="javascript:;"
							onclick="picture_add('添加资讯','picture-add.jsp')"><i
								class="Hui-iconfont">&#xe613;</i> 图片</a>
						</li>
						<li><a href="javascript:;"
							onclick="product_add('添加资讯','product-add.jsp')"><i
								class="Hui-iconfont">&#xe620;</i> 产品</a>
						</li>
						<li><a href="javascript:;"
							onclick="member_add('添加用户','member-add.jsp','','510')"><i
								class="Hui-iconfont">&#xe60d;</i> 用户</a>
						</li>
					</ul></li>
			</ul>
			</nav>
			<nav id="Hui-userbar" class="nav navbar-nav navbar-userbar hidden-xs">
			<ul class="cl">
				<li>超级管理员</li>
				<li class="dropDown dropDown_hover"><a href="#"
					class="dropDown_A">admin <i class="Hui-iconfont">&#xe6d5;</i>
				</a>
					<ul class="dropDown-menu menu radius box-shadow">
						<li><a href="javascript:;" onClick="myselfinfo()">个人信息</a>
						</li>
						<li><a href="#">切换账户</a>
						</li>
						<li><a href="#">退出</a>
						</li>
					</ul></li>
				<li id="Hui-msg"><a href="#" title="消息"><span
						class="badge badge-danger">1</span><i class="Hui-iconfont"
						style="font-size:18px">&#xe68a;</i>
				</a></li>
				<li id="Hui-skin" class="dropDown right dropDown_hover"><a
					href="javascript:;" class="dropDown_A" title="换肤"><i
						class="Hui-iconfont" style="font-size:18px">&#xe62a;</i>
				</a>
					<ul class="dropDown-menu menu radius box-shadow">
						<li><a href="javascript:;" data-val="default" title="默认（黑色）">默认（黑色）</a>
						</li>
						<li><a href="javascript:;" data-val="blue" title="蓝色">蓝色</a>
						</li>
						<li><a href="javascript:;" data-val="green" title="绿色">绿色</a>
						</li>
						<li><a href="javascript:;" data-val="red" title="红色">红色</a>
						</li>
						<li><a href="javascript:;" data-val="yellow" title="黄色">黄色</a>
						</li>
						<li><a href="javascript:;" data-val="orange" title="橙色">橙色</a>
						</li>
					</ul></li>
			</ul>
			</nav>
		</div>
	</div>
	</header>
	<!--/_header 作为公共模版分离出去-->

	<!--_menu 作为公共模版分离出去-->
	<aside class="Hui-aside">

	<div class="menu_dropdown bk_2">
		<dl id="menu-article">
			<dt>
				<i class="Hui-iconfont">&#xe616;</i> 订单管理<i
					class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a href="article-list.jsp" title="资讯管理" target="home_iframe">资讯管理</a>
					</li>
				</ul>
			</dd>
		</dl>
		<dl id="menu-picture">
			<dt>
				<i class="Hui-iconfont">&#xe613;</i> 桌台管理<i
					class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a href="picture-list.jsp" title="图片管理" target="home_iframe">图片管理</a>
					</li>
				</ul>
			</dd>
		</dl>
		<dl id="menu-product">
			<dt>
				<i class="Hui-iconfont">&#xe620;</i> 菜品管理<i
					class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a href="product-brand.jsp" title="品牌管理" target="home_iframe">品牌管理</a>
					</li>
					<li><a href="product-category.jsp" title="分类管理" target="home_iframe">分类管理</a>
					</li>
					<li><a href="product-list.jsp" title="产品管理" target="home_iframe">产品管理</a>
					</li>
				</ul>
			</dd>
		</dl>
		<dl id="menu-comments">
			<dt>
				<i class="Hui-iconfont">&#xe622;</i> 部门管理<i
					class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a href="http://h-ui.duoshuo.com/admin/" title="评论列表" target="home_iframe">评论列表</a>
					</li>
					<li><a href="feedback-list.jsp" title="意见反馈" target="home_iframe">意见反馈</a>
					</li>
				</ul>
			</dd>
		</dl>
		<dl id="menu-member">
			<dt>
				<i class="Hui-iconfont">&#xe60d;</i> 用户管理<i
					class="Hui-iconfont menu_dropdown-arrow" >&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a href="member-list.jsp" title="会员列表" target="home_iframe">会员列表</a>
					</li>
					<li><a href="member-del.jsp" title="删除的会员" target="home_iframe">删除的会员</a>
					</li>
		<!-- 			<li><a href="member-level.jsp" title="等级管理" target="home_iframe">等级管理</a>
					</li>
					<li><a href="member-scoreoperation.jsp" title="积分管理" target="home_iframe">积分管理</a>
					</li> -->
					<li><a href="member-record-browse.jsp" title="浏览记录" target="home_iframe">浏览记录</a>
					</li>
					<li><a href="member-record-download.jsp" title="下载记录" target="home_iframe">下载记录</a>
					</li>
					<li><a href="member-record-share.jsp" title="分享记录" target="home_iframe">分享记录</a>
					</li>
				</ul>
			</dd>
		</dl>
		<dl id="menu-admin">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i> 管理员管理<i
					class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a href="admin-role.jsp" title="角色管理" target="home_iframe">角色管理</a>
					</li>
					<li><a href="admin-users.jsp" title="用户管理" target="home_iframe">用户管理</a>
					</li>
					<li><a href="admin-list.jsp" title="管理员列表" target="home_iframe">管理员列表</a>
					</li>
				</ul>
			</dd>
		</dl>
		<dl id="menu-tongji">
			<dt>
				<i class="Hui-iconfont">&#xe61a;</i> 财务管理<i
					class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a href="charts-1.jsp" title="折线图" target="home_iframe">折线图</a>
					</li>
					<li><a href="charts-2.jsp" title="时间轴折线图" target="home_iframe">时间轴折线图</a>
					</li>
					<li><a href="charts-3.jsp" title="区域图" target="home_iframe">区域图</a>
					</li>
					<li><a href="charts-4.jsp" title="柱状图" target="home_iframe">柱状图</a>
					</li>
					<li><a href="charts-5.jsp" title="饼状图" target="home_iframe">饼状图</a>
					</li>
					<li><a href="charts-6.jsp" title="3D柱状图" target="home_iframe">3D柱状图</a>
					</li>
					<li><a href="charts-7.jsp" title="3D饼状图" target="home_iframe">3D饼状图</a>
					</li>
				</ul>
			</dd>
		</dl>
		<dl id="menu-system">
			<dt>
				<i class="Hui-iconfont">&#xe62e;</i> 系统管理<i
					class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a href="system-base.jsp" title="系统设置" target="home_iframe">系统设置</a>
					</li>
					<li><a href="system-category.jsp" title="栏目管理" target="home_iframe">栏目管理</a>
					</li>
					<li><a href="system-data.jsp" title="数据字典" target="home_iframe">数据字典</a>
					</li>
					<li><a href="system-shielding.jsp" title="屏蔽词" target="home_iframe">屏蔽词</a>
					</li>
					<li><a href="system-log.jsp" title="系统日志" target="home_iframe">系统日志</a>
					</li>
				</ul>
			</dd>
		</dl>
	</div>
	</aside>
	<div class="dislpayArrow hidden-xs">
		<!-- <a class="pngfix" href="javascript:void(0);"
			onClick="displaynavbar(this)"></a> -->
	</div>
	<!--/_menu 作为公共模版分离出去-->

	
	
	
		<iframe name="home_iframe" id="home_iframe">
			
		</iframe>
	
	</section>

	<!--_footer 作为公共模版分离出去-->
	<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>

	<script type="text/javascript"
		src="lib/jquery.validation/1.14.0/jquery.validate.js"></script>
	<script type="text/javascript"
		src="lib/jquery.validation/1.14.0/validate-methods.js"></script>
	<script type="text/javascript"
		src="lib/jquery.validation/1.14.0/messages_zh.js"></script>
	<script type="text/javascript" src="static/h-ui/js/H-ui.js"></script>
	<script type="text/javascript"
		src="static/h-ui.admin/js/H-ui.admin.page.js"></script>

	<!--/_footer /作为公共模版分离出去-->

	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript">

</script>
	<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>