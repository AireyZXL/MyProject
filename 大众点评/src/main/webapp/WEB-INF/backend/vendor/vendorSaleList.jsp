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
       		<span>查询时间段:
       			<input type="hidden" name="vendorId" value="${vendorId}"/>
			    <input style="width: 90px" type="date" name="startdate"/>-
			    <input style="width: 90px" type="date" name="enddate" />
        		<button class="green" onclick="formSubmit('vendorloadtable','_self');this.blur();">生成报表</button>
        		
			</span>
    	</form>
</section>
<section class="content">
	<section class="widget">
		<header>
			<span class="icon">&#128100;</span>
			<hgroup>
				<h1>商户经营数据</h1>
			</hgroup>
		</header>
		<div class="content">
			<table id="myTable" border="0" width="100">
				<thead>
					<tr>
						<th>订单号</th>
						<th>订单金额</th>
						<th>订单状态</th>
						<th>付款时间</th>
						<th>环境评分</th>
						<th>口味评分</th>
						<th>服务评分</th>
						<th>评价</th>
						<th>评价时间</th>
				</thead>
					<tbody>
					<c:forEach items="${orderList}" var="o">
						<tr>
							<td>${o.orderId}</td>
							<td>${o.money }</td>
							<td>${o.state}</td>
							<td><fmt:formatDate value="${o.payTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							<td>${o.enviromentScore}</td>
							<td>${o.tasteScore}</td>
							<td>${o.serviceScore}</td>
							<td>${o.commentMessage}</td>
							<td><fmt:formatDate value="${o.commentTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
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