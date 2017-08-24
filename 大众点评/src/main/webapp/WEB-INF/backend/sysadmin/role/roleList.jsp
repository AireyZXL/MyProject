<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		<shiro:hasPermission name="角色--新增">
		 	<button class="green" onclick="formSubmit('toAdd','_self');this.blur();">新增</button>
		</shiro:hasPermission> 
		<shiro:hasPermission name="角色--修改">
		 	<button class="green" onclick="formSubmit('toupdate','_self');this.blur();">修改</button>
		</shiro:hasPermission> 
		<shiro:hasPermission name="角色--查询">
			 <button class="green" onclick="formSubmit('view','_self');this.blur();">查询</button>
		</shiro:hasPermission>
		<shiro:hasPermission name="角色--删除">
		 	<button class="green" onclick="formSubmit('delete','_self');this.blur();">删除</button>
		</shiro:hasPermission>
		<shiro:hasPermission name="角色--模块">
			<button class="green" onclick="formSubmit('toModule','_self');this.blur();">模块</button>
		</shiro:hasPermission>
		</section>
		<section class="content">
			<section class="widget">
				<header>
					<span class="icon">&#128100;</span>
					<hgroup>
						<h1>角色列表</h1>
					</hgroup>
				
				</header>
				<div class="content">
					<table id="myTable" border="0" width="100">
						<thead>
							<tr>
								<th>选项</th>
								<th>序号</th>
								<th>角色名称</th>
								<th>排序号</th>
								<th>备注信息</th>
							</tr>
						</thead>
							<tbody>
								<c:forEach items="${roleList }" var="role" varStatus="status">
									<tr>
										<td><input type="checkbox" name="roleId" value="${role.roleId }"></td>
										<td>${status.index+1}</td>
										<td>${role.roleName }</td>
										<td>${role.orderNo }</td>
										<td>${role.remark }</td>
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