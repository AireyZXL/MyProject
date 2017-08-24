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
								$("#citys").click(function(){
									 $.post("/stage/toFindCity.action",{}, function(result){
										 $("#nav").html(result);
										});
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
		<input type="hidden" id="myHidden" value=""/>
		<!--顶部导航条 -->
			<div class="am-container header">
				<ul class="message-l">
					<div class="topMessage">
						<div class="menu-hd">
							<!-- 如果用户没有登陆, 提示登陆或注册 -->
							<c:if test="${ (empty sessionScope) || empty sessionScope.user }">
								<a href="/stage/toLogin.action" target="_top" class="h">亲，请登录</a>&nbsp;&nbsp;|&nbsp;&nbsp;
								<a href="/stage/stageregister/list.action" target="_top">免费注册</a>
							</c:if>
							
							<!-- 如果用户已经登陆, 提示欢迎xxx回来 -->
							<c:if test="${ !((empty sessionScope) || empty sessionScope.user)}">
								欢迎 ${ sessionScope.user.username } 回来	&nbsp;&nbsp;|&nbsp;&nbsp; 
								<a href="/stage/logout.action">退出</a>&nbsp;&nbsp;|&nbsp;&nbsp;
							</c:if>
						</div>
					</div>
				</ul>
				<ul class="message-r">
					<div class="topMessage home">
						<div class="menu-hd"><a href="#" target="_top" class="h">我的评论</a></div>
					</div>
					<div class="topMessage home">
						<div class="menu-hd"><a href="/stage/order/choose" target="_top" class="h">我的订单</a></div>
					</div>
					<div class="topMessage my-shangcheng">
						<div class="menu-hd MyShangcheng"><a href="#" target="_top"><i class="am-icon-user am-icon-fw"></i>个人中心</a></div>
					</div>
					<div class="topMessage favorite">
						<div class="menu-hd"><a href="/stage/collect" target="_top"><i class="am-icon-heart am-icon-fw"></i><span>收藏夹</span></a></div>
				</ul>
			</div>



	<!--悬浮搜索框-->

				<div class="nav white">
					<div class="logo"><img src="${app }/stagestaticfile/images/logo.png" /></div>
					<div class="logoBig">
						<li><img src="${app }/stagestaticfile/images/logobig.png" /></li>
					</div>

					<div class="search-bar pr">
						<a name="index_none_header_sysc" href="#"></a>
						<form>
							<input id="searchInput" name="index_none_header_sysc" type="text" placeholder="搜索" autocomplete="off">
							<input id="ai-topsearch" class="submit am-btn" value="搜索" index="1" type="submit">
						</form>
					</div>
				</div>




<div class="shopNav">
				<div class="slideall">
					
					   <div class="long-title"><span id="citys" class="all-goods">选择城市</span></div>
					   <div class="nav-cont">
							<ul>
								<li class="index"><a href="${app }/stage/home.action">首页</a></li>
                                <li class="qc"><a class="cvendor" href="#">美食</a></li>
                                <li class="qc"><a class="cvendor" href="#">电影</a></li>
                                <li class="qc"><a class="cvendor" href="#">休闲娱乐</a></li>
                                <li class="qc last"><a class="cvendor" href="#">运动健身</a></li>
                                 <li class="qc last"><a class="cvendor" href="#">景点</a></li>
                                  <li class="qc last"><a class="cvendor" href="#">KTV</a></li>
							</ul>
						    
						</div>					
		        				
						<!--侧边导航 -->
						<div id="nav" class="navfull">
							
						</div>


				
	</body>

</html>