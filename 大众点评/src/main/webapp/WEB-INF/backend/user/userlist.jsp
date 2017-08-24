<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
	<form method="link" action="page-new.html">
		<shiro:hasPermission name="用户--停用">
		 <button class="green" onclick="formSubmit('stop','_self');this.blur();">停用</button>
		 </shiro:hasPermission>
		 <shiro:hasPermission name="用户--启用">
		<button class="green" onclick="formSubmit('start','_self');this.blur();">启用</button>
		</shiro:hasPermission>
</section>
<section class="content">
	<section class="widget">
		<header>
			<span class="icon">&#128100;</span>
			<hgroup>
				<h1>用户</h1>
				<h2>当前所有用户</h2>
			</hgroup>
			
		</header>
		<div class="content">
			<table id="myTable" border="0" width="100">
				<thead>
					<tr>
						<th>序号</th>
						<th >用户名</th>
						<th>状态</th>
						<th>注册时间</th>
					</tr>
				</thead>
					<c:forEach items="${userList}" var="u" varStatus="status">
					<tbody>
						<tr>
							<td><input type="checkbox" name="userId" value="${u.userId}"/>
							${status.index+1}</td>
							<td class="avatar">${u.username}</td>
							<td>
								<c:if test="${u.state==1}"><font color="green">启用</font></a></c:if>
								<c:if test="${u.state==0}"><font color="red">停用</font></a></c:if>
							</td>
							
							<td><fmt:formatDate value="${u.registTime }" pattern="yyyy-MM-dd"/></td>
						</tr>
					</tbody>
					</c:forEach>	
				</table>
		</div>
	</section>
	</form>
</section>

</body>
</html>
</html>