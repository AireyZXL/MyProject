<%@ page contentType="text/html; charset=utf-8"%>
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
			<div class="clear"></div>
            <b class="line"></b>
			<%@include file="../head.jsp" %>	
			<div class="listMain">

				<ol class="am-breadcrumb am-breadcrumb-slash">
					<li><a href="#">首页</a></li>
					<li><a href="#">分类</a></li>
					<li class="am-active">内容</li>
				</ol>
				<script type="text/javascript">
					$(function() {});
					$(window).load(function() {
						$('.flexslider').flexslider({
							animation: "slide",
							start: function(slider) {
								$('body').removeClass('loading');
							}
						});
					});
				</script>
				

				<!--放大镜-->

				<div class="item-inform">
					<div class="clearfixLeft" id="clearcontent">

						<div class="box">
							

							<div class="tb-booth tb-pic tb-s310">
								<img src="${app }/stage?imgurl=${advert.url}" alt="细节展示放大镜特效"  class="jqzoom" />
							</div>
							
						</div>

					<div class="clear"></div>
				</div>


					<div class="clearfixRight">

						<!--规格属性-->
						<!--名称-->
						<div class="tb-detail-hd">
							<h1>${advert.adName }</h1>
						</div>
						<div class="tb-detail-hd">
							<span>访问次数:</span>
							<span>${advert.viewTimes }</span>
						</div>
						<br /><br /><br /><br /><br />
						<div class="tb-detail-hd">
							<span>广告详情</span>
							<br />
							<br />
							<textarea style="border-color:red " rows="10" cols="80" readonly="readonly">${advert.remark }</textarea>
						</div>
					</div>
					<div class="clear"></div>
				</div>
			</div>
			
						<input type="hidden" name="url" value="${advert.url}"/>
						<input type="hidden" name="adName" value="${advert.adName }"/>
						<input type="hidden" name="viewTimes" value="${advert.viewTimes }"/>
						<input type="hidden" name="adName" value="${advert.remark }"/>
					

	<%@include file="../foot.jsp" %>
	</body>

</html>