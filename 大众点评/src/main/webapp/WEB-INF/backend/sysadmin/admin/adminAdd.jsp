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
<script src="${app }/backstaticfile/js/jquery-1.6.2.js"></script>
<script language="javascript" src="${app}/backstaticfile/js/common.js"></script>
<script type="text/javascript">
	$(function(){
		$("#username").blur(function(){		
			var username=$(this).val();
			if(username!=""){
				$("#msg").load("${app}/sysadmin/admin/ajax",{"username":username});
			}			
		});		
		
	});

</script>
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
						<h1>用户</h1>
						<h2>用户的新增</h2>
					</hgroup>
				
				</header>
				<div class="content">
					<table id="myTable" border="0" width="80">
						<tr>
							<td>用户名:</td>
							<td><input id="username" type="text" name="username"/></td>
							
						</tr>
						<tr>
							<td>密码:</td>
							<td><input type="password" name="password"/></td>
						</tr>	
						<tr>
							<td colspan="2" style="text-align: center"><span id="msg" style="color:red">${msg }<span></span></td>
						</tr>		
					</table>
				</div>
			</section>
		</section>
</form>
</body>
</html>