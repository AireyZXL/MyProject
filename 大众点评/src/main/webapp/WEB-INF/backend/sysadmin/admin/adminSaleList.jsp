<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
    	</form>
</section>
<section class="content">
	<section class="widget">
		<header>
			<span class="icon">&#128100;</span>
			<hgroup>
				<h1>平台经营数据</h1>
			</hgroup>
		</header>
		<div class="content">
			<table id="myTable" border="0" width="100">
				<thead>
					<tr>
						<th>商铺名</th>
						<th>订单总数</th>
						<th>成交金额</th>
						<th>单均消费额</th>
						<th>环境评分</th>
						<th>口味评分</th>
						<th>服务评分</th>
				</thead>
					<tbody>
					<c:forEach items="${poiList}" var="p">
						<tr>
							<td>${p.vendorName}</td>
							<td>${p.ordernum}</td>
							<td>${p.orderMoney}</td>
							<td>${p.avgprice}</td>
							<td>${p.environment}</td>
							<td>${p.taste}</td>
							<td>${p.service}</td>
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