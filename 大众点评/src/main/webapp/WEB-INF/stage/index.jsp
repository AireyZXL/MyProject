<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

		<title>首页</title>

		<link href="${app }/stagestaticfile/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css" />
		<link href="${app }/stagestaticfile/AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css" />

		<link href="${app }/stagestaticfile/basic/css/demo.css" rel="stylesheet" type="text/css" />

		<link href="${app }/stagestaticfile/css/hmstyle.css" rel="stylesheet" type="text/css"/>
		<link href="${app }/stagestaticfile/css/skin.css" rel="stylesheet" type="text/css" />
		<script src="${app }/stagestaticfile/AmazeUI-2.4.2/assets/js/jquery.min.js"></script>
		<script src="${app }/stagestaticfile/AmazeUI-2.4.2/assets/js/amazeui.min.js"></script>

	</head>

	<body>
		
		<div class="hmtop">
			

			

				<div class="clear"></div>
			</div>
			<div class="banner">
                      <!--轮播 -->
						<div class="am-slider am-slider-default scoll" data-am-flexslider id="demo-slider-0">
							<ul class="am-slides">

							

								<c:forEach items="${ adList}" var="ad" varStatus="status">
									<li class="banner${status.index+1}"><a href="adIntroduce?imgurl=${ad.url}"><img src="${app }/stage?imgurl=${ad.url}" /></a></li>

								</c:forEach>	
							</ul>
						</div>
						<div class="clear"></div>	
			</div>
			
			<%@include file="head.jsp" %>			
						
						
						
					



					<!--小导航 -->
					<div class="am-g am-g-fixed smallnav">
						<div class="am-u-sm-3">
							<a href="sort.html"><img src="${app }/stagestaticfile/images/navsmall.jpg" />
								<div class="title">商品分类</div>
							</a>
						</div>
						<div class="am-u-sm-3">
							<a href="#"><img src="${app }/stagestaticfile/images/huismall.jpg" />
								<div class="title">大聚惠</div>
							</a>
						</div>
						<div class="am-u-sm-3">
							<a href="#"><img src="${app }/stagestaticfile/images/mansmall.jpg" />
								<div class="title">个人中心</div>
							</a>
						</div>
						<div class="am-u-sm-3">
							<a href="#"><img src="${app }/stagestaticfile/images/moneysmall.jpg" />
								<div class="title">投资理财</div>
							</a>
						</div>
					</div>

				
				<script type="text/javascript">
					if ($(window).width() < 640) {
						function autoScroll(obj) {
							$(obj).find("ul").animate({
								marginTop: "-39px"
							}, 500, function() {
								$(this).css({
									marginTop: "0px"
								}).find("li:first").appendTo(this);
							})
						}
						$(function() {
							setInterval('autoScroll(".demo")', 3000);
						})
					}
				</script>
			</div>
			<div class="shopMainbg">
				<div class="shopMain" id="shopmain">

				
					<!--热门活动 -->
						<!-- 一栏活动 -->
						<c:if test="${!(empty foodList) }">
						
					<div class="am-container activity ">
					
						<div class="shopTitle ">
							<h4>美食推荐</h4>
							<h3>高评价商户 值得信赖 </h3>
						
						</div>
					
						  <div class="am-g am-g-fixed ">
						  <c:forEach items="${foodList }" var="f" varStatus="status">
							<div class="am-u-sm-3 ">
								
								
								<div class="icon-sale one "></div>
									<h4>推荐</h4>							
								<div class="activityMain ">
									<a href="/stage/toVonder?vendorId=${f.vendorId}"><img src="${app }/stage?imgurl=${f.url } "></img></a>
								</div>
								
								<div class="info ">
									<a href="/stage/toVonder?vendorId=${f.vendorId}"><h3>${f.vendorName }</h3></a>
								</div>	
																					
							</div>
							
							
							
						 </c:forEach>		
						  </div>
					 
                   </div>
					<div class="clear "></div>
					</c:if>
					<!-- 一栏活动 -->
					
					<c:if test="${!(empty mList) }">
						<div class="am-container activity ">
						<div class="shopTitle ">
							<h4>电影推荐</h4>
							<h3>高评价商户 值得信赖 </h3>
						
						</div>
					
						  <div class="am-g am-g-fixed ">
						  <c:forEach items="${mList }" var="m">
							<div class="am-u-sm-3 ">
								<div class="icon-sale one "></div>	
									<h4>推荐</h4>							
								<div class="activityMain ">
									<a href="/stage/toVonder?vendorId=${m.vendorId}"><img src="${app }/stage?imgurl=${m.url } "></img></a>
								</div>
								<div class="info ">
									<a href="/stage/toVonder?vendorId=${m.vendorId}"><h3>${m.vendorName }</h3></a>
								</div>		
																				
						</c:forEach>	
							</div>
							
						  </div>
					  
                   </div>
					<div class="clear "></div>
				</c:if>
				
				
				
									<!-- 一栏活动 -->
					
					<c:if test="${!(empty eList) }">
						<div class="am-container activity ">
						<div class="shopTitle ">
							<h4>休闲娱乐推荐</h4>
							<h3>高评价商户 值得信赖 </h3>
						
						</div>
					<c:forEach items="${eList }" var="e">
						  <div class="am-g am-g-fixed ">
							<div class="am-u-sm-3 ">
								<div class="icon-sale one "></div>	
									<h4>推荐</h4>							
								<div class="activityMain ">
									<a href="/stage/toVonder?vendorId=${e.vendorId}"><img src="${app }/stage?imgurl=${e.url } "></img></a>
								</div>
								<div class="info ">
									<a href="/stage/toVonder?vendorId=${e.vendorId}"><h3>${e.vendorName }</h3></a>
								</div>														
							</div>
							
						  </div>
					  </c:forEach>	
                   </div>
					<div class="clear "></div>
				</c:if>
				
				
									<!-- 一栏活动 -->
					
					<c:if test="${!(empty sList) }">
						<div class="am-container activity ">
						<div class="shopTitle ">
							<h4>运动健身推荐</h4>
							<h3>高评价商户 值得信赖 </h3>
						
						</div>
					<c:forEach items="${sList }" var="s">
						  <div class="am-g am-g-fixed ">
							<div class="am-u-sm-3 ">
								<div class="icon-sale one "></div>	
									<h4>推荐</h4>							
								<div class="activityMain ">
									<a href="/stage/toVonder?vendorId=${s.vendorId}"><img src="${app }/stage?imgurl=${s.url } "></img></a>
								</div>
								<div class="info ">
									<a href="/stage/toVonder?vendorId=${s.vendorId}"><h3>${s.vendorName }</h3></a>
								</div>														
							</div>
							
						  </div>
					  </c:forEach>	
                   </div>
					<div class="clear "></div>
				</c:if>
				
				
				
									<!-- 一栏活动 -->
					
					<c:if test="${!(empty tList) }">
						<div class="am-container activity ">
						<div class="shopTitle ">
							<h4>景点推荐</h4>
							<h3>高评价商户 值得信赖 </h3>
						
						</div>
					<c:forEach items="${tList }" var="t">
						  <div class="am-g am-g-fixed ">
							<div class="am-u-sm-3 ">
								<div class="icon-sale one "></div>	
									<h4>推荐</h4>							
								<div class="activityMain ">
									<a href="/stage/toVonder?vendorId=${t.vendorId}"><img src="${app }/stage?imgurl=${t.url } "></img></a>
								</div>
								<div class="info ">
									<a href="/stage/toVonder?vendorId=${t.vendorId}"><h3>${t.vendorName }</h3></a>
								</div>														
							</div>
							
						  </div>
					  </c:forEach>	
                   </div>
					<div class="clear "></div>
				</c:if>
				
				
									<!-- 一栏活动 -->
					
					<c:if test="${!(empty kList) }">
						<div class="am-container activity ">
						<div class="shopTitle ">
							<h4>KTV推荐</h4>
							<h3>高评价商户 值得信赖 </h3>
						
						</div>
					<c:forEach items="${kList }" var="k">
						  <div class="am-g am-g-fixed ">
							<div class="am-u-sm-3 ">
								<div class="icon-sale one "></div>	
									<h4>推荐</h4>							
								<div class="activityMain ">
									<a href="/stage/toVonder?vendorId=${k.vendorId}"><img src="${app }/stage?imgurl=${k.url } "></img></a>
								</div>
								<div class="info ">
									<a href="/stage/toVonder?vendorId=${k.vendorId}"><h3>${k.vendorName }</h3></a>
								</div>														
							</div>
							
						  </div>
					  </c:forEach>	
                   </div>
					<div class="clear "></div>
				</c:if>
				
				
		</div>
	
		<script>
			window.jQuery || document.write('<script src="${app }/stagestaticfile/basic/js/jquery.min.js "><\/script>');
		</script>
		<script type="text/javascript " src="${app }/stagestaticfile/basic/js/quick_links.js "></script>
	<%@include file="foot.jsp" %>
	</body>

</html>