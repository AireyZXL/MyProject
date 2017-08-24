<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
 <%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
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
       <form  method="post">
       <shiro:hasPermission name="订单--删除">
		 <button class="green" onclick="formSubmit('delete','_self');this.blur();">删除</button>
		</shiro:hasPermission>
</section>
<section class="content">
	<section class="widget">
		<header>
			<span class="icon">&#10146;</span>
			<hgroup>
				<h1>订单管理</h1>
				<h2>所有订单条目</h2>
			</hgroup>
		</header>
		<div class="content">
			<table id="myTable" border="0" width="100">
				<thead>
					<tr>
						<th class="avatar">订单号</th>
						<th>商户名称</th>
						<th>消费者</th>
						<th>订单金额</th>
						<th>订单状态</th>
						<th>支付时间</th>
					
						
				</thead>
					<tbody>
					<c:forEach items="${orderList}" var="o">
					   <tr>
						<td class="avatar"><input type="checkbox" name="orderId" value="${o.orderId}"/>${o.orderId}</td>
						<td>${o.vendorName }</td>
						<td>${o.userName }</td>
					    <td>${o.money}</td>
						<td>
						<c:if test="${o.state==1}"><font color="green">已评论</font></c:if>
						<c:if test="${o.state==0}"><font color="red">未评论</font></c:if>
						</td>
						<td><fmt:formatDate value="${o.payTime}" pattern="yyyy-MM-dd"/></td>
					
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