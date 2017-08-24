<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<form method="post">
		<shiro:hasPermission name="管理员--新增">
		 	<button class="green" onclick="formSubmit('toAdd','_self');this.blur();">新增</button>
		 </shiro:hasPermission>
		 <shiro:hasPermission name="管理员--修改">
		 	<button class="green" onclick="formSubmit('toUpdate','_self');this.blur();">修改</button>
		 </shiro:hasPermission>
		 <shiro:hasPermission name="管理员--查询">
		 	<button class="green" onclick="formSubmit('view','_self');this.blur();">查询</button>
		 </shiro:hasPermission>
		 <shiro:hasPermission name="管理员--删除">
			 <button class="green" onclick="formSubmit('delete','_self');this.blur();">删除</button>
		 </shiro:hasPermission>
		 <shiro:hasPermission name="管理员--停用">
		 	<button class="green" onclick="formSubmit('stop','_self');this.blur();">停用</button>
		 </shiro:hasPermission>
		 <shiro:hasPermission name="管理员--角色">
		  	<button class="green" onclick="formSubmit('toRole','_self');this.blur();">角色</button>
		  </shiro:hasPermission>
		</section>
		<section class="content">
			<section class="widget">
				<header>
					<span class="icon">&#128100;</span>
					<hgroup>
						<h1>用户</h1>
						<h2>当前管理员用户</h2>
					</hgroup>
				
				</header>
				<div class="content">
					<table id="myTable" border="0" width="100">
						<thead>
							<tr>
								<th>用户名</th>
								<th>姓名</th>
								<th>性别</th>
								<th>邮箱</th>
								<th>电话号码</th>
								<th>创建者</th>
								<th>创建日期</th>
								<th>状态</th>
							</tr>
						</thead>
							<tbody>
								<c:forEach items="${adminList }" var="admin">
									<tr>
										<td><input type="checkbox" name="adminId" value="${admin.adminId }">${admin.username }</td>
										<td>${admin.info.name }</td>
										<td>${admin.info.gender }</td>
										<td>${admin.info.email }</td>
										<td>${admin.info.telephone }</td>
										<td>${admin.createBy }</td>	
										<td><fmt:formatDate value="${admin.createTime }" pattern="yyyy-MM-dd"/></td>
										<td>
											<c:if test="${admin.state==0 }"><font color="blue">未激活</font></c:if>
											<c:if test="${admin.state==1 }"><font color="green">启用</font></c:if>
											<c:if test="${admin.state==2 }"><font color="red">停用</font></c:if>
										</td>
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