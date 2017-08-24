<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

		<title>main</title>

		<link href="${app }/stagestaticfile/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css" />
		<link href="${app }/stagestaticfile/AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css" />

		<link href="${app }/stagestaticfile/basic/css/demo.css" rel="stylesheet" type="text/css" />

		<link href="${app }/stagestaticfile/css/hmstyle.css" rel="stylesheet" type="text/css"/>
		<link href="${app }/stagestaticfile/css/skin.css" rel="stylesheet" type="text/css" />
		<script src="${app }/stagestaticfile/AmazeUI-2.4.2/assets/js/jquery.min.js"></script>
		<script src="${app }/stagestaticfile/AmazeUI-2.4.2/assets/js/amazeui.min.js"></script>
		<script type="text/javascript">	
		(function() {
				$('.am-slider').flexslider();
			});
			$(document).ready(function() {
				$("li").hover(function() {
					$(".category-content .category-list li.first .menu-in").css("display", "none");
					$(".category-content .category-list li.first").removeClass("hover");
					$(this).addClass("hover");
					$(this).children("div.menu-in").css("display", "block")
				}, function() {
					$(this).removeClass("hover")
					$(this).children("div.menu-in").css("display", "none")
				});
			})
			
			$(function(){
				
				$("#nav").css("display","none");
				$("#citys").mouseover(function(){
					$("#nav").css("display","inline-block");
				});
				
				$("a[title]").click(function(){
					
					$("#nav").css("display","none");
					/* alert($(this).find("span").text()); */
					$("#myHidden").val($(this).find("span").text());
					
				});
				
				$(".cvendor").click(function(){
					var category=$(this).text();
					var city=$("#myHidden").val();
					window.location.href="${app }/stage/category?category="+category+"&city="+city;
				});
					
				
				
			});
			
			
		</script> 
</head>
<body>
	<div class="area clearfix">
		<div class="category-content" id="guide_2">
			<div class="category">
				<ul class="category-list" id="js_climit_li">
					<!-- 一条栏目 -->
					<c:forEach items="${cityMap}" var="mymap"> 
						<li class="appliance js_toggle relative first">
							<div class="category-info">
								<h3 class="category-name b-category-name"><i><img src="${app }/stagestaticfile/images/cake.png"></i><a class="ml-22" title="点心">${mymap.key}</a></h3>
								<em>&gt;</em></div>
							<div class="menu-item menu-in top">
								<div class="area-in">
									<div class="area-bg">
										<div class="menu-srot">
											<div class="sort-side">
												<dl class="dl-sort">
													<dt><span title="蛋糕">城市</span></dt>
														<c:forEach items="${mymap.value}" var="city">
															<dd><a title="蒸蛋糕" href="#"><span class="city">${city.cityName }</span></a></dd>
														</c:forEach>	
												</dl>
											</div>
										</div>
									</div>
								</div>
							</div>
						<b class="arrow"></b>	
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>