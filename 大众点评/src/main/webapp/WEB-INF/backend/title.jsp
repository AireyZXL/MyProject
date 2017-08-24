<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<title></title>
	<link rel="stylesheet" href="${app }/backstaticfile/css/style.css" media="all" />
	<!--[if IE]><link rel="stylesheet" href="css/ie.css" media="all" /><![endif]-->
</head>

<script src="${app }/backstaticfile/js/jquery.wysiwyg.js"></script>
<script src="${app }/backstaticfile/js/custom.js"></script>
<script src="${app }/backstaticfile/js/cycle.js"></script>
<script src="${app }/backstaticfile/js/jquery.checkbox.min.js"></script>
<script src="${app }/backstaticfile/js/flot.js"></script>
<script src="${app }/backstaticfile/js/flot.resize.js"></script>
<script src="${app }/backstaticfile/js/flot-graphs.js"></script>
<script src="${app }/backstaticfile/js/flot-time.js"></script>
<script src="${app }/backstaticfile/js/cycle.js"></script>
<script src="${app }/backstaticfile/js/jquery.tablesorter.min.js"></script>

<body  id="demo">
	<div class="testing">
<header class="main">
	<h1><strong>大众点评</strong> 后台管理系统</h1>
	<input type="text" value="search" />
</header>
<section class="user">
	<div class="profile-img">
		<p><img src="${app }/sysadmin/admin?imgurl=${sessionadmin.info.imgurl}" alt="" height="40" width="40" /> 欢迎 ${sessionadmin.username}回来</p>
	</div>
	<div class="buttons">
		<button class="ico-font">&#9206;</button>
		
		
		<span class="button"><a href="${app }/sysadmin/admin/view?adminId=${sessionadmin.adminId}" target="main">我的信息</a></span>
		 <span class="button">帮助</span>
		 <span class="button blue"><a href="${app }/logout.action" target="_top">退出</a></span>
	</div>
</section>
</div>
</body>
</html>