<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<!DOCTYPE html>
<html>
<head>
	<title></title>
	
</head>
<link rel="stylesheet" href="${app }/backstaticfile/css/style.css" media="all" />


<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js"></script>

<script src="${app }/backstaticfile/js/jquery.wysiwyg.js"></script>
<script src="${app }/backstaticfile/js/custom.js"></script>
<script src="${app }/backstaticfile/js/cycle.js"></script>
<script src="${app }/backstaticfile/js/jquery.checkbox.min.js"></script>
<script src="${app }/backstaticfile/js/jquery.tablesorter.min.js"></script>
<body>
	<nav>
	<ul>

		<shiro:hasPermission name="基础信息">
			<li><a href="dashboard.html"><span class="icon">&#128711;</span> 基础信息</a></li>
		</shiro:hasPermission>
		<shiro:hasPermission name="内容管理">
			<li class="section">
				<a href="javascript:void(0)"><span class="icon">&#128196;</span> 内容管理</a>
				<ul class="submenu">
					<shiro:hasPermission name="广告管理">
						<li><a href="${app }/backend/Advertisment/list.action" target="main">广告管理</a></li>
					</shiro:hasPermission>
					<shiro:hasPermission name="商户管理">
						<li><a href="${app}/backend/vendor/list" onclick="linkHighlighted(this)" target="main">商户管理</a></li>
					</shiro:hasPermission>
					<shiro:hasPermission name="评论查询">
						<li><a href="${app}/backend/comment/list" onclick="linkHighlighted(this)" target="main">评论查询</a></li>
					</shiro:hasPermission>
					<shiro:hasPermission name="订单查询">
						<li><a href="${app}/backend/order/list" onclick="linkHighlighted(this)" target="main"">订单查询</a></li>
					</shiro:hasPermission>
				</ul>	
			</li>
		</shiro:hasPermission>
		<shiro:hasPermission name="用户管理">
			<li><a href="${app}/sysadmin/user/list" target="main"><span class="icon">&#128101;</span> 用户管理</a><li>
		</shiro:hasPermission>
		<shiro:hasPermission name="报表统计">
			<li>
				<a href="javascript:void(0)"><span class="icon">&#127748;</span> 报表统计</a>
				<ul class="submenu">
					<shiro:hasPermission name="管理员数据表">
						<li><a href="${app}/sysadmin/admin/adsaletablelist"  target="main">管理员数据表</a></li>
					</shiro:hasPermission>
					<shiro:hasPermission name="商户数据表">
						<li><a href="${app}/vendor/vdsaletablelist"  target="main">商户数据表</a></li>
					</shiro:hasPermission>
					<shiro:hasPermission name="图表">
						<li><a href="files.html">图表</a></li>
					</shiro:hasPermission>
				</ul>
			</li>
		</shiro:hasPermission>
		<shiro:hasPermission name="系统管理">
			<li>
				<a href="javascript:void(0)"><span class="icon">&#59160;</span> 系统管理</a>
				<ul class="submenu">
					<shiro:hasPermission name="管理员管理">
						<li><a href="${app}/sysadmin/admin/list" target="main">管理员管理</a></li>
					</shiro:hasPermission>	
					<shiro:hasPermission name="角色管理">	
						<li><a href="${app}/sysadmin/role/list" target="main">角色管理</a></li>
					</shiro:hasPermission>
					<shiro:hasPermission name="模块管理">			
						<li><a href="${app}/moduleMain" target="main";">模块管理</a></li>
					</shiro:hasPermission>
				</ul>
			</li>
		</shiro:hasPermission>

	</ul>
</nav>
</body>
</html>