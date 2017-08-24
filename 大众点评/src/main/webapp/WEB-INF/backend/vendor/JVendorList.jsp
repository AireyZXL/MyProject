<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    	 <shiro:hasPermission name="商户--新增">
			 <button class="green" onclick="formSubmit('toAdd','_self');this.blur();">新增</button>
		 </shiro:hasPermission>	 
		  <shiro:hasPermission name="商户--修改">
			 <button class="green" onclick="formSubmit('update','_self');this.blur();">修改</button>
			</shiro:hasPermission>	 
		 <shiro:hasPermission name="商户--删除">	 
			 <button class="green" onclick="formSubmit('delete','_self');this.blur();">删除</button>
		 </shiro:hasPermission>	 
		 <shiro:hasPermission name="商户--查询">	 
			 <button class="green" onclick="formSubmit('toview','_self');this.blur();">查看</button>
    	</shiro:hasPermission>	 
</section>
<section class="content">
	<section class="widget">
		<header>
			<span class="icon">&#128100;</span>
			<hgroup>
				<h1>商户管理</h1>
				<h2>Current member accounts</h2>
			</hgroup>
		</header>
		<div class="content">
			<table id="myTable" border="0" width="100">
				<thead>
					<tr>
						<th class="avatar">商户名称</th>
						<th>所在城市</th>
						<th>联系电话</th>
						<th>类别</th>
						<th>人均价格</th>
						<th>访问次数</th>
				</thead>
					<tbody>
					<c:forEach items="${vendorList}" var="v">
						<tr>
							<td class="avatar"><input type="checkbox" name="vendorId"
							value="${v.vendorId}"/>${v.vendorName}</td>
							<td>${v.city }</td>
							<td>${v.telephone}</td>
							<td>${v.category}</td>
							<td>${v.price}</td>
							<td>${v.viewTime}</td>
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