<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
<script type="text/javascript" src="${app}/backstaticfile/js/WdatePicker.js"></script>
<body>
<section class="alert">
	<form method="post" enctype="multipart/form-data">
		<button class="green" onclick="window.history.go(-1)">返回</button>	
		 <button class="green" onclick="formSubmit('active.action','_self');this.blur();">激活</button>	 
		</section>
		<section class="content">
			<section class="widget">
				<header>
					<span class="icon">&#128100;</span>
					<hgroup>
						<h1>激活页面</h1>
						<h2>管理员第一次登陆后台必须修改密码及个人信息</h2>
					</hgroup>
				
				</header>
				<div class="content">
					<table id="myTable" border="0" width="100">
						<input type="hidden" name="adminId" value="${sessionadmin.adminId }"/>
						<input type="hidden" name="state" value="${sessionadmin.state }"/>
						<tr>
							<td>用户名:</td>
							<td><input type="text" name="username" value="${sessionadmin.username }" readonly="readonly"/></td>
							<td>头像:</td>
							<td>
								<input type="file" name="photo"/>
							</td>
						</tr>
						
						<tr>
							<td>密码:</td>
							<td><input type="password" name="password"/></td>
							<td>确认密码:</td>
							<td>
								<input type="password" name="password2" />
							</td>
						</tr>
						
						<tr>
							<td>真实姓名:</td>
							<td><input type="text" name="info.name" value=""/></td>
							<td>身份证号码:</td>
							<td><input type="text" name="info.cardNo" value=""/></td>
						</tr>
	
						<tr>
							<td>性别:</td>
							<td>
								<input type="radio" name="info.gender" value="男">男</input>
								<input type="radio" name="info.gender" value="女">女</input>
							</td>
							<td>生日日期:</td>
							<td><input type="date" style="width:120px;" name="info.birthday"/></td>
						</tr>
	
						<tr>
							<td>电话号码:</td>
							<td><input type="text" name="info.telephone"/></td>
							<td>邮箱:</td>
							<td><input type="text" name="info.email"/></td>
						</tr>
						
						<tr>
							<td>备注信息:</td>
							<td colspan="3">
								<textarea name="info.remark" style="height:80px;width:100%"></textarea>
							</td>
						</tr>
						
						<tr>
				
					</table>
				</div>
				<div align="center" style="color: red;padding-bottom: 10px;" >
					<c:if test="${!empty errorInfo}">
						${errorInfo}
					</c:if>
				</div>
			</section>
		</section>
</form>
</body>
</html>