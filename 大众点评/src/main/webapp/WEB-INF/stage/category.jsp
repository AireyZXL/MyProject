<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

		<title>搜索页面</title>

		<link href="${app }/stagestaticfile/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css" />
		<link href="${app }/stagestaticfile/AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css" />

		<link href="${app }/stagestaticfile/basic/css/demo.css" rel="stylesheet" type="text/css" />

		<link href="${app }/stagestaticfile/css/seastyle.css" rel="stylesheet" type="text/css" />

		<script type="text/javascript" src="${app }/stagestaticfile/basic/js/jquery-1.7.min.js"></script>
		<script type="text/javascript" src="${app }/stagestaticfile/js/script.js"></script>
	</head>

	<body>

		
			<%@include file="head.jsp" %>
					<div class="am-g am-g-fixed">
						<div class="am-u-sm-12 am-u-md-12">
	                  	<div class="theme-popover">														
							
                        </div>
							
								<div class="sort">
									<li class="first"><a title="综合" href="${app }/stage/category?category=${category}&rule=avg_score&city=${city}">综合排序</a></li>
									<li><a title="销量" href="${app }/stage/category?category=${category}&rule=sale_num&city=${city}">销量排序</a></li>
									<li><a title="价格" href="${app }/stage/category?category=${category}&rule=avg_enviroment_score&city=${city}">环境优先</a></li>
									<li><a title="价格" href="${app }/stage/category?category=${category}&rule=avg_service_score&city=${city}">服务优先</a></li>
									<li><a title="价格" href="${app }/stage/category?category=${category}&rule=avg_taste_score&city=${city}">口味优先</a></li>
								</div>
								<div class="clear"></div>

								<ul class="am-avg-sm-2 am-avg-md-3 am-avg-lg-4 boxes">
									<c:forEach items="${vList }" var="v">
									<li>
										<div class="i-pic limit">
											<img src="${app }/stage?imgurl=${v.url}" />											
											<p class="title fl">${v.vendorName }</p>
											<p class="price fl">
												<b>人均¥</b>
												<strong>${v.price }</strong>
											</p>
											<p class="number fl">
												销量:<span>${ v.saleNum}</span>
											</p>
										</div>
									</li>
									</c:forEach>
								
								</ul>
							
							<div class="search-side">

								

							</div>
							<div class="clear"></div>
							<!--分页 -->
							<ul class="am-pagination am-pagination-right">
								<li class="am-disabled"><a href="#">&laquo;</a></li>
								<li class="am-active"><a href="#">1</a></li>
								<li><a href="#">2</a></li>
								<li><a href="#">3</a></li>
								<li><a href="#">4</a></li>
								<li><a href="#">5</a></li>
								<li><a href="#">&raquo;</a></li>
							</ul>

						</div>
					</div>



		<script>
			window.jQuery || document.write('<script src="${app }/stagestaticfile/basic/js/jquery-1.9.min.js"><\/script>');
		</script>
		<script type="text/javascript" src="${app }/stagestaticfile/basic/js/quick_links.js"></script>

<div class="theme-popover-mask"></div>
<%@include file="foot.jsp" %>
	</body>

</html>