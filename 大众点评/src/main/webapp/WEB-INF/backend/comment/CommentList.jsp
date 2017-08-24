<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
 <%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<!DOCTYPE html>
<html lang="">
<head>
	<link rel="stylesheet" href="${app }/backstaticfile/css/style.css" media="all" />
	<title></title>
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
       <form  method="post">
       <shiro:hasPermission name="评论--查询">
		 <button class="green" onclick="formSubmit('toview','_self');this.blur();">查看评论</button>
		</shiro:hasPermission>
		<shiro:hasPermission name="评论--删除">
		  <button class="green" onclick="formSubmit('delete','_self');this.blur();">删除评论</button>
		 </shiro:hasPermission>
</section>
<section class="content">
	<section class="widget">
		<header>
			<span class="icon">&#10146;</span>
			<hgroup>
				<h1>评论管理</h1>
				<h2>所有评论条目</h2>
			</hgroup>
		</header>
		<div class="content">
			<table id="myTable" border="0" width="100">
				<thead>
					<tr>
						<th class="avatar">商户名称</th>
						<th>总分</th>
						<th>环境分</th>
						<th>口味分</th>
						<th>服务分</th>
						<th>评论者</th>
						<th>评论时间</th>
					
						
				</thead>
					<tbody>
					<c:forEach items="${cList}" var="c">
					   <tr>
						<td class="avatar"><input type="checkbox" name=commentId value="${c.commentId}"/>${c.vendorName}</td>
						<td>${c.score }</td>
						<td>${c.enviromentScore }</td>
					    <td>${c.tasteScore}</td>
						<td>${c.serviceScore}</td>
						<td>${c.username}</td>
						<td><fmt:formatDate value="${c.commentTime}" pattern="yyyy-MM-dd"/></td>
					
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