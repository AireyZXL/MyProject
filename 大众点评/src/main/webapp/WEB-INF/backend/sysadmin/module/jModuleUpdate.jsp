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
		 <button class="green" onclick="formSubmit('update','_self');this.blur();">保存</button>
		 <button class="green" onclick="window.history.go(-1);">返回</button>
		 
	
</section>
<section class="content">
	<section class="widget">
		<header>
			<span class="icon">&#128100;</span>
			<hgroup>
				<h1>模块修改</h1>
			</hgroup>
			
		</header>
		<div class="content">
			<table id="myTable" border="0" width="100" >
			
						<tr >
							<td>模块名称:</td>
							<td ><input type="text" name="name" value="${module.name}"></input></td>
							<td>上级模块:</td>
							<td >
							
								<select style="width: 120px" name="parentModule.moduleId">
									<option value="">---无上级---</option>
									<c:forEach items="${parentList}" var="p">
										<c:if test="${p.moduleId != module.moduleId}">
											<option value="${p.moduleId}"
											<c:if test="${p.moduleId==module.parentModule.moduleId}">selected="selected"</c:if>
											>${p.name}</option>
										</c:if>
									</c:forEach>
								</select>
							
							</td>
						</tr>
						<tr >
							<<td>模块类型:</td>
							<td>
								<select name="type">
									
									<option value="0" <c:if test="${module.type==0 }">selected="selected"</c:if>>一级菜单</option>
									<option value="1" <c:if test="${module.type==1 }">selected="selected"</c:if>>二级菜单</option>
									<option value="2" <c:if test="${module.type==2 }">selected="selected"</c:if>>我的按钮</option>
								</select>
							</td> 
							
							<td>排序号:</td>
							<td ><input type="text" name="orderNo" value="${module.orderNo}"></input></td>
						</tr>
						<tr >
							<td>状态:</td>
							<td >
								<input type="radio" name="state" value="1" <c:if test="${module.state ==1}">checked="checked"</c:if>/>启用
								<input type="radio" name="state" value="0" <c:if test="${module.state ==0}">checked="checked"</c:if>/>停用
								
							</td>
						</tr>
						<tr >
							<td>备注信息:</td>
							<td colspan="3">
								<textarea  name="remark" style="width: 100%" >${module.remark}</textarea>
							</td>
						</tr>
						<tr hidden="hidden">
							<td><input type="text" name="moduleId" value="${module.moduleId}"></input></td>
						</tr>
				</table>
		</div>
	</section>
</section>
</form> 
</body>
</html>
</html>