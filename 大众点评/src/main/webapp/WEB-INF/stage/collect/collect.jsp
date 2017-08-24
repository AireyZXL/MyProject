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
	
   <%@include file="../head.jsp" %>
    
  	 <div class="total">
                  我的收藏夹
      </div> 
 
		
		<!-- Cart table -->
		
		<table class="table table-bordered table-primary table-striped table-vertical-center checkboxs js-table-sortable"> 
			<thead>
				<tr>
					<th style="text-align: center;width: 160px">商铺信息</th>
					<th style="text-align: center;width: 100px;">人均</th>
					<th style="text-align:center;width:180px;">收藏时间</th>
					<th style="text-align: center;width: 180px;">操作</th>
				</tr>
			</thead>
			<tbody>
			
		<!-- Cart item -->
		<c:forEach items="${cList}" var="c">
				<tr class="selectable">
					<td class="product">
						<div class="media">
						    <div style="width:100px;height:60px;float:left;">
							<img  src="${app}/stage?imgurl=${c.vendor.url}"  alt="">
							</div>
							<div class="media-body" float="right" style="padding-left: 15px">
							 <span>${c.vendor.vendorName}</span>
							</div>
							<div class="media-body" float="left" style=" padding-left: 15px">
							<span>${c.vendor.address}</span>
							</div>
						</div>
					</td>
					<td class="center">￥${c.vendor.price}</td>
					<td class="center"><fmt:formatDate value="${c.collectTime}" pattern="yyyy-MM-dd"/></td>
					<td class="center">
						<a style="color: blue" href="${app }/stage/delete?collectId=${c.collectId}">移出收藏夹</a>
			        </td>
				</tr>
					</c:forEach>
				
				
			</tbody>
		</table>
		<div style="color: red;text-align: center">${msg }</div>
    <%@include file="../foot.jsp"%>
</body>
</html>