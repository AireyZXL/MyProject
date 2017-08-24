<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

		<title>商户页面</title>

		<link href="${app }/stagestaticfile/AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css" />
		<link href="${app }/stagestaticfile/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css" />
		<link href="${app }/stagestaticfile/basic/css/demo.css" rel="stylesheet" type="text/css" />
		<link type="text/css" href="${app }/stagestaticfile/css/optstyle.css" rel="stylesheet" />
		<link type="text/css" href="${app }/stagestaticfile/css/style.css" rel="stylesheet" />

		<script type="text/javascript" src="${app }/stagestaticfile/basic/js/jquery-1.7.min.js"></script>
		<script type="text/javascript" src="${app }/stagestaticfile/basic/js/quick_links.js"></script>

		<script type="text/javascript" src="${app }/stagestaticfile/AmazeUI-2.4.2/assets/js/amazeui.js"></script>
		<script type="text/javascript" src="${app }/stagestaticfile/js/jquery.imagezoom.min.js"></script>
		<script type="text/javascript" src="${app }/stagestaticfile/js/jquery.flexslider.js"></script>
		<script type="text/javascript" src="${app }/stagestaticfile/js/list.js"></script>

	</head>

	<body>
		<%@include file="../head.jsp" %>


				<!--放大镜-->

				<div class="item-inform">
					<div class="clearfixLeft" id="clearcontent">

						<div class="box">
							<script type="text/javascript">
								$(document).ready(function() {
									$(".jqzoom").imagezoom();
									$("#thumblist li a").click(function() {
										$(this).parents("li").addClass("tb-selected").siblings().removeClass("tb-selected");
										$(".jqzoom").attr('src', $(this).find("img").attr("mid"));
										$(".jqzoom").attr('rel', $(this).find("img").attr("big"));
									});
								});
							</script>

							<div class="tb-booth tb-pic tb-s310">
								<img src="${app }/stage?imgurl=${vendorInfo.vendor.url}" alt="细节展示放大镜特效"  class="jqzoom" /></a>
							</div>
							<ul class="tb-thumb" id="thumblist">								
								<li>
									
								</li>
								<li>
									
								</li>
							</ul>
						</div>

						<div class="clear"></div>
					</div>

					<div class="clearfixRight">

						<!--规格属性-->
						<!--名称-->
						<div class="tb-detail-hd">
							<h1>	
				 			${vendorInfo.vendor.vendorName }
	         				 </h1>
	         				 <h3>
	         				 ${vendorInfo.vendor.remark }
	         				 </h3>
						</div>
						<div class="tb-detail-list">
							<!--价格-->
							<div class="tb-detail-price">
								<li class="price iteminfo_price">
									<dt>人均价格：</dt>
									<dd><em>¥</em><b class="sys_item_price">${vendorInfo.vendor.price }</b>  </dd>                                 
								</li>								
								<!--<li class="price iteminfo_mktprice">
									<dt>人均价格</dt>
									<dd><em>¥</em><b class="sys_item_mktprice">98.00</b></dd>									
								</li>-->
								<div class="clear"></div>
							</div>

							<!--销量-->
							<ul class="tm-ind-panel">								
								<li class="tm-ind-item tm-ind-reviewCount canClick tm-line3">
									<div class="tm-indcon"><span class="tm-label">访问量</span><span class="tm-count">${vendorInfo.vendor.viewTime }</span></div>
								</li>
							</ul>
							<div class="clear"></div>

							<!--各种规格-->
							<dl class="iteminfo_parameter sys_item_specpara">
								<dt class="theme-login"><div class="cart-title">可选规格<span class="am-icon-angle-right"></span></div></dt>
								<dd>
									<!--操作页面-->

									<div class="theme-popover-mask"></div>

									<div class="theme-popover">
										<div class="theme-span"></div>
										<div class="theme-poptit">
											<a href="javascript:;" title="关闭" class="close">×</a>
										</div>
										<div class="theme-popbod dform">
											<form class="theme-signin" name="loginform" action="" method="post">

												<div class="theme-signin-left">

													<div class="theme-options">
														<div class="cart-title">口味分：</div>
														<ul>
															<li class="sku-line selected">${vendorInfo.avgTasteScore }<i></i></li>															
														</ul>
													</div>
													<div class="theme-options">
														<div class="cart-title">环境分：</div>
														<ul>
															<li class="sku-line selected">${vendorInfo.avgEnviromentScore}<i></i></li>
															
														</ul>
													</div>
													<div class="theme-options">
														<div class="cart-title">服务分：</div>
														<ul>
															<li class="sku-line selected">${vendorInfo.avgServiceScore }<i></i></li>
															
														</ul>
													</div>
													
													<div class="clear"></div>

													<div class="btn-op">
														<div class="btn am-btn am-btn-warning">确认</div>
														<div class="btn close am-btn am-btn-warning">取消</div>
													</div>
												</div>
												<div class="theme-signin-right">
													<div class="img-info">
														<img src="../images/songzi.jpg" />
													</div>
													<div class="text-info">
														<span class="J_Price price-now">¥39.00</span>
														<span id="Stock" class="tb-hidden">库存<span class="stock">1000</span>件</span>
													</div>
												</div>

											</form>
										</div>
									</div>

								</dd>
							</dl>
							<div class="clear"></div>
							<!--活动	-->
							<div class="shopPromotion gold">
								<div class="hot">
									<dt class="tb-metatit">店铺优惠</dt>
									<div class="gold-list">
										<p>购物满500打8折，购物满800打7折</p>
									</div>
								</div>
								<div class="clear"></div>
								
							</div>
						</div>

						<div class="pay">
							<div class="pay-opt">
							<a href="home.html"><span class="am-icon-home am-icon-fw">首页</span></a>
							<a><span class="am-icon-heart am-icon-fw">收藏</span></a>
							
							</div>
							<li>
								<div class="clearfix tb-btn tb-btn-buy theme-login">
									<a id="LikBuy" title="点此按钮到下一步确认购买信息" href="#">买单</a>
									<a id="LikBuy" title="点此按钮到下一步确认购买信息" href="${app }/stage/addCollect?vendorId=${vendorInfo.vendor.vendorId}">添加到收藏夹</a>
								</div>
								
							</li>							
						</div>

					</div>

					<div class="clear"></div>

				</div>

				<!--优惠套装-->
				
				<div class="clear"></div>
				
							
				<!-- introduce-->

				<div class="introduce">
					<div class="browse">
					  				    
						     
					</div>
					<div class="introduceMain">
						<div class="am-tabs" data-am-tabs>
							<ul class="am-avg-sm-3 am-tabs-nav am-nav am-nav-tabs">
								<li class="am-active">
									<a href="#">
										<span class="index-needs-dt-txt">全部评价</span></a>

								</li>

							
							
							</ul>

							<div class="am-tabs-bd">

									<ul class="am-comments-list am-comments-list-flip">
										<c:forEach items="${vendorInfo.commentList }" var="c">
										<li class="am-comment">
											<!-- 评论容器 -->
											<a href="">
												<img class="am-comment-avatar" src="${app }/stagestaticfile/images/hwbn40x40.jpg" />
												<!-- 评论者头像 -->
											</a>

											<div class="am-comment-main">
												<!-- 评论内容容器 -->
												<header class="am-comment-hd">
													<!--<h3 class="am-comment-title">评论标题</h3>-->
													<div class="am-comment-meta">
														<!-- 评论元数据 -->
														<a href="#link-to-user" class="am-comment-author">${c.username}</a>
														<!-- 评论者 -->
														评论于
														<time datetime=""><fmt:formatDate value="${c.commentTime }" pattern="yyyy-MM-dd"/></time>
													</div>
												</header>

												<div class="am-comment-bd">
													<div class="tb-rev-item " data-id="255776406962">
														<div class="J_TbcRate_ReviewContent tb-tbcr-content ">
															${c.commentMessage }
														</div>
														<!-- <div class="tb-r-act-bar">
															颜色分类：柠檬黄&nbsp;&nbsp;尺码：S
														</div> -->
													</div>

												</div>
												<!-- 评论内容 -->
											</div>
										</li>
										
										
									</c:forEach>
									</ul>

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
									<div class="clear"></div>

									
								</div>

								<div class="am-tab-panel am-fade">
									
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
									<div class="clear"></div>

								</div>

							</div>

						</div>

						<div class="clear"></div>

						<%@include file="../foot.jsp" %>
					</div>

				</div>
				
			</div>
			<!--菜单 -->
		



		
	</body>

</html>