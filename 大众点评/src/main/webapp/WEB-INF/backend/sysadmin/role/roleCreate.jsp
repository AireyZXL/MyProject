<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		<button class="green" onclick="window.history.go(-1)">返回</button>	
		 <button class="green" onclick="formSubmit('add','_self');this.blur();">保存</button>	 
		</section>
		<section class="content">
			<section class="widget">
				<header>
					<span class="icon">&#128100;</span>
					<hgroup>
						<h1>角色</h1>
						<h2>角色的新增</h2>
					</hgroup>
				
				</header>
				<div class="content">
					<table id="myTable" border="0" width="80">
						<tr>
							<td>角色名称:</td>
							<td><input type="text" name="roleName"/></td>
							
						</tr>
						<tr>
							<td>排序号:</td>
							<td><input type="text" name="orderNo"/></td>
						</tr>
						<tr>
							<td>备注信息:</td>
							<td>
								<textarea type="text" name="remark" style="height: 100px;width: 100%"></textarea>
							</td>
						</tr>			
					</table>
				</div>
			</section>
		</section>
</form>
</body>
</html>