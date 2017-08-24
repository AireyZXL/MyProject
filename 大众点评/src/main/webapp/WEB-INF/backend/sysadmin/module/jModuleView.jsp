<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		 <button class="green" onclick="window.history.go(-1);">返回</button>
		 
	
</section>
<section class="content">
	<section class="widget">
		<header>
			<span class="icon">&#128100;</span>
			<hgroup>
				<h1>模块查询</h1>
			</hgroup>
			
		</header>
		<div class="content">
			<table id="myTable" border="0" width="100" >
						<tr >
							<td>模块名称:</td>
							<td>${module.name}</td>
							<td>上级模块:</td>
							<td>
								${module.parentModule.name}
							</td>
						</tr>
						<tr >
							<<td>模块类型:</td>
							<td>
									<c:if test="${module.type ==0}">一级菜单</c:if>
									<c:if test="${module.type ==1}">二级菜单</c:if>
									<c:if test="${module.type ==2}">我的按钮</c:if>
							</td> 
							<td>排序号:</td>
							<td>${module.orderNo}</td>
						</tr>
						<tr >
							<td>状态:</td>
							<td>
								<c:if test="${module.state==0}">停用</c:if>
								<c:if test="${module.state==1}">启用</c:if>
							</td>
						</tr>
						<tr >
							<td>备注信息:</td>
							<td colspan="3">
								<textarea type="text" name="remark" style="width: 100%" >${module.remark}</textarea>
							</td>
						</tr>
				</table>
		</div>
	</section>
</section>
</form> 
</body>
</html>
</html>