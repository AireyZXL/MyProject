<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>

<html>

<head>


<!-- Meta -->
<meta charset="UTF-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE" />

    <!-- Bootstrap -->
	<link href="${app}/stagestaticfile/css/bootstrap.css" rel="stylesheet" />
	
	<!-- Main Theme Stylesheet :: CSS -->
	<link href="${app}/stagestaticfile/css/style-dark.css?1369414386" rel="stylesheet" />
	

    <link href="${app}/stagestaticfile/css/airey.css" rel="stylesheet" type="text/css">
</head>
<body >
	
   <%@include file="head.jsp" %>
    
  	 <div class="total">
                   订单管理
      </div> 
 
		
		<!-- Cart table -->
		
		<table class="table table-bordered table-primary table-striped table-vertical-center checkboxs js-table-sortable"> 
			<thead>
				<tr>
					<th style="text-align: center;width:250px;" class="center">订单号</th>
					<th style="text-align: center;">商铺信息</th>
					<th style="text-align: center;width: 100px;">支付金额</th>
					<th style="text-align:center;width:180px;">交易时间</th>
					<th style="text-align: center;width: 180px;">评价状态</th>
				</tr>
			</thead>
			<tbody>
			
		<!-- Cart item -->
		<c:forEach items="${orderAndVendorList}" var="o">
				<tr class="selectable">
					 <td class="center">${o.orderId}</td> 
					<td class="product">
						<div class="media">
						    <div style="width:60px;height:60px;float:left;">
							<img  src="${app}/stage?imgurl=${o.url}"  alt="">
							</div>
							<div class="media-body" float="right" style="padding-left: 15px">
							 <span>${o.vendorName}</span>
							</div>
							<div class="media-body" float="left" style=" padding-left: 15px">
							<span>${o.remark}</span>
							</div>
						</div>
					</td>
					<td class="center">￥${o.money }</td>
					<td class="center"><fmt:formatDate value="${o.payTime}" pattern="yyyy-MM-dd"/></td>
					<td class="center">
					<c:if test="${o.state==1}"><a href="#"><font color="green">已评价</font></a></c:if>
			        <c:if test="${o.state==0}"><a href="start?order=${o.orderId}"><font color="red">未评价</font></c:if></a>
			        </td>
				</tr>
					</c:forEach>
				
				
			</tbody>
		</table>
    <%@include file="foot.jsp"%>
</body>
</html>