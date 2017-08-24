<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<!DOCTYPE html>
<html lang="">
<head>
	<link rel="stylesheet" href="${app }/backstaticfile/css/style.css" media="all" />
	<title></title>
	<style type='text/css'>
		#fy_div{
			text-align: center;
		}
		
		#fy_div input{
			width:20px;
			border:solid 1px #CCCCCC;
		}
		
		#fy_div a{
			text-decoration: none;
			border: solid 1px #CCCCCC;
			padding: 5px;
			margin: 3px;
			color:#333
		}
		
		#fy_div a:hover{
			color:white;
			background-color: red;
		}
	</style>
	<script type="text/javascript">
		function plusPage(pluspage){
			location.href="moduleMain?page="+pluspage+"&&plus=1";
			pluspage=pluspage+1;
			}
	</script>
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
		<shiro:hasPermission name="模块--查询">
		 	<button class="green" onclick="formSubmit('toview','_self');this.blur();">查询</button>
		</shiro:hasPermission>
		<shiro:hasPermission name="模块--新增">
			 <button class="green" onclick="formSubmit('tocreate','_self');this.blur();">新增</button>
		</shiro:hasPermission>
		 <shiro:hasPermission name="模块--修改">	
		 	<button class="green" onclick="formSubmit('toupdate','_self');this.blur();">修改</button>
		 </shiro:hasPermission>
		 <shiro:hasPermission name="模块--删除">	
		 	<button class="green" onclick="formSubmit('delete','_self');this.blur();">删除</button>
		 </shiro:hasPermission>
		 <shiro:hasPermission name="模块--停用">	
		 	<button class="green" onclick="formSubmit('stop','_self');this.blur();">停用</button>
		</shiro:hasPermission>
		 <shiro:hasPermission name="模块--启用">	
		 	<button class="green" onclick="formSubmit('start','_self');this.blur();">启用</button>
		</shiro:hasPermission>
</section>
<section class="content">
	<section class="widget">
		<header>
			<span class="icon">&#128100;</span>
			<hgroup>
				<h1>模块信息</h1>
			</hgroup>
			
		</header>
		<div class="content">
			<table id="myTable" border="0" width="100">
				<thead>
					<tr>
						<th>序号</th>
						<th>模块名</th>
						<th>上级模块</th>
						<th>模块类型</th>
						<th>状态</th>
						<th>排序号</th>
						<th>备注信息</th>
					</tr>
				</thead>
					<c:forEach items="${moduleList}" var="m" varStatus="status">
					<tbody>
						<tr>
							<td><input type="checkbox" name="moduleId" value="${m.moduleId}"/>
							${status.index+1}</td>
							<td >${m.name}</td>
							<td>${m.parentModule.name}</td>
							<td>
								<c:if test="${m.type==0 }">一级菜单</c:if>
								<c:if test="${m.type==1 }">二级菜单</c:if>
								<c:if test="${m.type==2 }">我的按钮</c:if>
							</td>
							<td>
								<c:if test="${m.state==1}"><a href="stop?moduleId=${m.moduleId}"><font color="green">启用</font></a></c:if>
								<c:if test="${m.state==0}"><a href="start?moduleId=${m.moduleId}"><font color="red">停用</font></a></c:if>
							</td>
							<td>${m.orderNo}</td>
							<td>${m.remark }</td>
						</tr>
					</tbody>
					</c:forEach>	
				</table>
		</div>
				<div id="fy_div">
					<a href="moduleMain?page=1">首页</a>
					<a href="moduleMain?page=${page}&&del=1">上一页</a>
					<a href="moduleMain?page=1">1</a>
					<a href="moduleMain?page=2">2</a>
					<a href="moduleMain?page=3">3</a>
					<a href="moduleMain?page=4">4</a>
			
					<%-- 分页逻辑开始 --%>
					<%-- 分页逻辑结束 --%>
					<a onclick="plusPage(${page});">下一页</a> 
					跳转到<span>${page}</span>页
				</div>
	</section>
</section>
</form> 
</body>
</html>
</html>