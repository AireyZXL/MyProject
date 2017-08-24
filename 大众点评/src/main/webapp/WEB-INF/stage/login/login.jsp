<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

	<head lang="en">
		<meta charset="UTF-8">
		<title>登录</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<meta name="format-detection" content="telephone=no">
		<meta name="renderer" content="webkit">
		<meta http-equiv="Cache-Control" content="no-siteapp" />
		<!-- 引入jQuery类库 -->
		<script type="text/javascript" src="${app}/stagestaticfile/js/jquery-1.4.2.js"></script>
		<link rel="stylesheet" href="${app}/stagestaticfile/AmazeUI-2.4.2/assets/css/amazeui.css" />
		<link href="${app}/stagestaticfile/css/dlstyle.css" rel="stylesheet" type="text/css">
		<script type="text/javascript">
			$(function(){
				//点击图片换一张
				$(".valistr").click(function(){
					var timeStr = new Date().getTime();
					$(this).attr("src", "/stage/stageValiImage.action?time="+timeStr);
				});
			});
		</script>
	
	</head>

	<body>

		<div class="login-boxtitle">
			<a href="home.html"><img alt="logo" src="${app}/stagestaticfile/images/logobig.png" /></a>
		</div>

		<div class="login-banner">
			<div class="login-main">
				<div class="login-banner-bg"><span></span><img src="${app}/stagestaticfile/images/big.jpg" /></div>
				<div class="login-box">

							<h3 class="title">登录商城</h3>

							<div class="clear"></div>
						
						<div class="login-form">
						  <form action="/stage/Login.action" method="post">
							   <div class="user-name">
								    <label for="user"><i class="am-icon-user"></i></label>
								    <input type="text" name="username" id="user" placeholder="请输入用户名">
                 </div>
                 <div class="user-pass">
								    <label for="password"><i class="am-icon-lock"></i></label>
								    <input type="password" name="password" id="password" placeholder="请输入密码">
                 </div>
                 <div >
								    <label for="valistr"><i class="am-icon-lock"></i></label>
								    <input type="text" name="valistr"  placeholder="验证码" style="width: 150px;">
								    <img class="valistr" src="/stage/stageValiImage.action" alt="验证吗" style="width: 150px;height: 42px;vertical-align: middle;"/>
                 </div>
           </div>
            
            <div class="login-links">
                <label for="remember-me"><input id="remember-me" type="checkbox">记住密码</label>
								<a href="#" class="am-fr">忘记密码</a>
								<a href="/stage/stageregister/list.action" class="zcnext am-fr am-btn-default">注册</a>
								<br />
            </div>
            					<div align="center" style="color: red;padding-bottom: 10px;" >
										<c:if test="${!empty errorInfo}">
											${errorInfo}
										</c:if>
								</div>
								<div class="am-cf">
									<input type="submit" name="" value="登 录" class="am-btn am-btn-primary am-btn-sm">
								</div>
              </form>
						<div class="partner">		
								<h3>合作账号</h3>
							<div class="am-btn-group">
								<li><a href="#"><i class="am-icon-qq am-icon-sm"></i><span>QQ登录</span></a></li>
								<li><a href="#"><i class="am-icon-weibo am-icon-sm"></i><span>微博登录</span> </a></li>
								<li><a href="#"><i class="am-icon-weixin am-icon-sm"></i><span>微信登录</span> </a></li>
							</div>
						</div>	

				</div>
			</div>
		</div>


					<div class="footer ">
						<div class="footer-hd ">
							<p>
								<a href="# ">恒望科技</a>
								<b>|</b>
								<a href="# ">商城首页</a>
								<b>|</b>
								<a href="# ">支付宝</a>
								<b>|</b>
								<a href="# ">物流</a>
							</p>
						</div>
						<div class="footer-bd ">
							<p>
								<a href="/stage/stageValiImage.action">关于恒望</a>
								<a href="# ">合作伙伴</a>
								<a href="# ">联系我们</a>
								<a href="# ">网站地图</a>
								<em>© 2015-2025 Hengwang.com 版权所有. 更多模板 <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></em>
							</p>
						</div>
					</div>
	</body>

</html>