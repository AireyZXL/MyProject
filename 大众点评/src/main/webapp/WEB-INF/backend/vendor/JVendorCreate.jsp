<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
   <form method="post" enctype="multipart/form-data"> 
		 <button class="green" onclick="formSubmit('save','_self');this.blur();">保存</button>
		 <button class="green" onclick="window.history.go(-1)">返回</button>

</section>
<section class="content">
	<section class="widget">
		<header>
			<span class="icon">&#128101;</span>
			<hgroup>
				<h1>新增商户</h1>
				<h2>Create new member accounts</h2>
			</hgroup>
		</header>
		<div class="content">
		   <table id="myTable" border="0" width="100">
		      <tr class="avatar">
		         <td>头像上传:</td>
		         <td colspan="5"><input type="file" name="photo" /></td>
		      </tr>
		       <tr class="avatar">
			    <td>商户名称:</td>
			    <td><input type="text" name="vendorName" /></td>
			    <td>所在城市:</td>
			    <td>
			    <select name="city" style="width:120px;height:30px;padding-left: 10px">
			      <option value="">---请选择----</option>
			      <c:forEach items="${cityList}" var="c">
			         <option value="${c.cityName }">${c.cityName}</option>
			      </c:forEach>
			    </select>
			    
			    </td>
			    <td>详细地址</td>
			    <td><input type="text" name="address" /></td>
			   </tr>
			   <tr class="avatar">
			    <td>电话号码:</td>
			    <td><input type="text" name="telephone" /></td>
			    <td>商家类别:</td>
			    <td>
			    	<select name="category">
			    		<option value="美食" selected="selected">美食</option>
			    		<option value="电影">电影</option>
			    		<option value="休闲娱乐">休闲娱乐</option>
			    		<option value="运动健身">运动健身</option>
			    		<option value="景点">景点</option>
			    		<option value="KTV">KTV</option>
			    	</select>
			  
			    
			    </td>
			    <td>人均价格:</td>
			    <td><input type="text" name="price" /></td>
			   </tr>
			   <tr class="avatar">
			    <td>备注:</td>
			    <td colspan="5"><textarea  name="remark" style="height:70px;width:100%"></textarea></td>
			   </tr>
			</table>
		</div>
	</section>
</section>
</form>
</body>
</html>
</html>