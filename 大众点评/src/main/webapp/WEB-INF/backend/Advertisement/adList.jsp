<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<!DOCTYPE html>
<html lang="">
<head>
	<link rel="stylesheet" href="${app }/backstaticfile/css/style.css" media="all" />
	<!--[if IE]><link rel="stylesheet" href="css/ie.css" media="all" /><![endif]-->
</head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js"></script>
<script src="${app }/backstaticfile/js/jquery.wysiwyg.js"></script>
<script src="${app }/backstaticfile/js/custom.js"></script>
<script src="${app }/backstaticfile/js/cycle.js"></script>
<script src="${app }/backstaticfile/js/jquery.checkbox.min.js"></script>
<script src="${app }/backstaticfile/js/flot.js"></script>
<script src="${app }/backstaticfile/js/flot.resize.js"></script>
<script src="${app }/backstaticfile/js/flot-graphs.js"></script>
<script src="${app }/backstaticfile/js/flot-time.js"></script>
<script src="${app }/backstaticfile/js/cycle.js"></script>.
<script src="${app }/backstaticfile/js/jquery.tablesorter.min.js"></script>
<script language="javascript" src="${app}/backstaticfile/js/common.js"></script>
<body>
<section class="alert">	
<form method="post">
	<shiro:hasPermission name="广告--新增">
	 	<button class="green" onclick="formSubmit('toAdd','_self');this.blur();">广告新增</button>
	</shiro:hasPermission>
	<shiro:hasPermission name="广告--删除">
		<button class="green" onclick="formSubmit('delete','_self');this.blur();">广告删除</button>
	</shiro:hasPermission>
	<shiro:hasPermission name="广告--修改">
		<button class="green" onclick="formSubmit('toupdate','_self');this.blur();">广告修改</button>
	</shiro:hasPermission>
	<shiro:hasPermission name="广告--查询">
		<button class="green" onclick="formSubmit('toview','_self');this.blur();">广告查看</button>
	</shiro:hasPermission>
</section>
<section id="section-content" class="content">
	<section class="widget">
		<header>
			<span class="icon">&#128100;</span>
			<hgroup>
				<h1>广告管理</h1>
				<h2>Current member accounts</h2>
			</hgroup>			
		</header>
		<div class="content">
			<table id="myTable" border="0" width="100">
				<thead>
					<tr>
					 <th class="tableHeader"></th>  
						<th>广告图片</th>
						<th class="avatar">广告标题</th>
						<th>权重级别</th>
						<th>访问次数</th>
					</tr>
				</thead>
					<tbody>				
						<c:forEach items="${adList}" var="ad">
						<tr class="odd">
																									
							<td><input type="checkbox" name="adId" value="${ad.adId}"/></td>
							<td class="avatar"><img src="${app}/backend/Advertisement/?url=${ad.url}" alt="" height="100px" width="100px" /></td>							
							<td>${ad.adName}</td>
							<td>${ad.level }</td>
							<td>${ad.viewTimes }</td>							
						</tr>
						</c:forEach>
					</tbody>
				</table>
		</div>
	</section>
</section>
</form>
</body>
</html>
</html>