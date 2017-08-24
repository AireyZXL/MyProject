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
   <form method="post"> 
		 <button class="green" onclick="formSubmit('save','_self');this.blur();">保存</button>
		 <button class="green" onclick="window.history.go(-1)">返回</button>

</section>
<section class="content">
	<section class="widget">
		<header>
			<span class="icon">&#128101;</span>
			<hgroup>
				<h1>商户查看</h1>
				<h2>View  member accounts</h2>
			</hgroup>
		</header>
		<div class="content">
		   <table id="myTable" border="0" width="100">
		      <tr class="avatar">
		         <td>商户头像</td>
		         <td colspan="3">
		         <img style="padding-left: 30px" height="100px" width="100px" src="${app }/backend/vendor?imgurl=${vendor.url}" alt=""></img>
		         </td>
		         <td>访问次数:</td>
			    <td>${vendor.viewTime}</td>
		     </tr>
		     <tr class="avatar">
			     <td>商户名称:</td>
			     <td>${vendor.vendorName}</td>
			     <td>所在城市:</td>
			     <td>${vendor.city }</td>
			     <td>详细地址</td>
			    <td>${vendor.address}</td>
			    </tr>
			   <tr class="avatar">
			    <td>电话号码:</td>
			    <td>${vendor.telephone}</td>
			    <td>商家类别:</td>
			    <td>${vendor.category}</td>
			    <td>人均价格:</td>
			    <td>${vendor.price}</td>
			   </tr>
			  
			   <tr class="avatar">
			    
			    <td>备注:</td>
			    <td colspan="5">
			   	 <textarea name="remark" style="width:100%;height:80px">${vendor.remark}</textarea>
			    
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