<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="">
<head>
	<meta charset="utf-8">
	<title>Retina Dashboard</title>
	<meta name="description" content="" />
	<meta name="keywords" content="" />
	<meta name="robots" content="" />
	<meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0">
	<link rel="stylesheet" href="${app }/backstaticfile/css/style.css" media="all" />
	<!--[if IE]><link rel="stylesheet" href="css/ie.css" media="all" /><![endif]-->
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
	<button class="green" onclick="formSubmit('update','_self');this.blur();">更新</button>
	<button class="green" onclick=" window.history.go(-1);">返回</button>	
	<form method="post" enctype="multipart/form-data">
</section>
<section id="section-content" class="content">
	<section class="widget">
		<header>
			<span class="icon">&#128100;</span>
			<hgroup>
				<h1>广告修改</h1>
				<h2>Update a advertisement</h2>
			</hgroup>			
		</header>
		<div class="content">
			<table id="myTable" border="0" width="100">		
				<tbody>	
				<tr class="odd" hidden="hidden">
					<td><input type="text" name="adId" value="${advert.adId}" /></td>
				</tr>
				<tr>									
					<td>标题：</td>
					<td><input type="text" name="adName" value="${advert.adName}"/></td>														
					
				</tr>
				<tr>
					<td>上传图片:</td>
					<td> <input name="photo" type="file"></td>
				</tr>											
				<tr>
					<td>权重：</td>
					<td><input type="text" name="level" value="${advert.level}"/></td>
				<tr/>																						
					<td>描述信息：</td>
					<td>
						<textarea name="remark" style="width:100%;height:80px">${advert.remark}</textarea>
					</td>
				</tbody>
				</table>
		</div>
	</section>
</section>
</form>
</body>
</html>
</html>