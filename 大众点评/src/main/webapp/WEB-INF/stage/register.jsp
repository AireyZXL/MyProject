<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

	<head lang="en">
		<meta charset="UTF-8">
		<title>注册</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<meta name="format-detection" content="telephone=no">
		<meta name="renderer" content="webkit">
		<meta http-equiv="Cache-Control" content="no-siteapp" />
		<link rel="stylesheet" href="${app}/stagestaticfile/AmazeUI-2.4.2/assets/css/amazeui.min.css" />
		<link href="${app}/stagestaticfile/css/dlstyle.css" rel="stylesheet" type="text/css">
		<script src="${app}/stagestaticfile/AmazeUI-2.4.2/assets/js/jquery.min.js"></script>
		<script src="${app}/stagestaticfile/AmazeUI-2.4.2/assets/js/amazeui.min.js"></script>
        <script language="javascript" src="${app}/backstaticfile/js/common.js"></script>
        <script type="text/javascript">
          /*   function fun() {
				alert(111);
			} */
		 var formObj={
			   "checkForm":function(){
				   var flag=true;
				   //1.非空校验
				   flag=this.checkNull("username","用户名不能为空")&&flag;
				   flag=this.checkNull("password","密码不能为空")&&flag;
				   flag=this.checkNull("password2","确认密码不能为空")&&flag;
				   //2.两次密码是否一致
				   flag = this.checkPassword("password", "两次密码不一致") && flag;
				   //3.邮箱格式是否正确
				   //flag = this.checkEmail("email", "邮箱格式不正确") && flag;
				   return flag;
			   },
			   
			   "checkPassword" : function(name, msg) {
					var pwd1 = $("input[name='" + name + "']").val();
					//alert(pwd1);
					var pwd2 = $("input[name='" + name + "2']").val();
					//alert(pwd2);
					//清空上次提示消息
					this.setMsg(name + "2", "");
					this.checkNull(name + "2", "确认密码不能为空");
					if ($.trim(pwd1) != "" && $.trim(pwd2) != "") {
						if (pwd1 != pwd2) {
							this.setMsg(name + "2", msg);
							return false;
						}
					}
					return true;
				},
				
				"checkNull" : function(name, msg) {
					var $inp = $("input[name='" + name + "']");
					var $value = $inp.val();
					//清空上次提示消息
					//this.setMsg(name, "");
					if ($.trim($value) == "") {
						//设置提示消息
					    this.setMsg(name, msg);
						return false;
					}
					return true;
				},
				"setMsg" : function(name, msg) {
					
					$("input[name='" + name + "']").attr("placeholder",msg);
					
					
				}
			}
			
			//文档就绪事件
			$(function() {
				$("input[name='username']").blur(function() {
					formObj.checkNull("username", "用户名不能为空");
				});
				$("input[name='password']").blur(function() {
					formObj.checkNull("password", "密码不能为空");
				});
				$("input[name='password2']").blur(function() {
					formObj.checkNull("password2", "确认密码不能为空");
					formObj.checkPassword("password", "两次密码不一致~");
				});
				
				//使用jQuery实现ajax校验用户名是否存在
				 $("input[name='username']").blur(function(){
				    var username=$(this).val();
				    //1,检查输入框是否为空
				    if($.trim(username)==""){
				       formObj.setMsg(username, "用户名不能为空");
				       return;
				    }
				    //2.ajax检查用户是否存在
				    $.post("/stage/stageregister/ajax.action", {"username" : username}, function(result){
									$("#username_msg").html(result);
								});
				 });
				
			});
				
        
        </script>
	</head>

	<body >
       
		<div class="login-boxtitle">
			<a href="home/demo.html"><img alt="" src="${app}/stagestaticfile/images/logobig.png" /></a>
		</div>

		<div class="res-banner">
			<div class="res-main">
				<div class="login-banner-bg"><span></span><img src="${app}/stagestaticfile/images/big.jpg" /></div>
				<div class="login-box">
						<div class="am-tabs" id="doc-my-tabs">
							<ul class="am-tabs-nav am-nav am-nav-tabs am-nav-justify">
								<li class="am-active"><a href="">注册</a></li>
								
							</ul>

							<div class="am-tabs-bd">
								<div class="am-tab-panel am-active">
				<form method="post" onsubmit="return formObj.checkForm()">
										
							   <div class="user-email">
										<label for="email"><i class="am-icon-envelope-o"></i></label>
										<input type="email" name="username" id="email" placeholder="请输入邮箱账号/手机号"/>
                 </div>										
                 <div class="user-pass">
								    <label for="password"><i class="am-icon-lock"></i></label>
								    <input type="password" name="password" id="password" placeholder="设置密码"/>
                 </div>										
                 <div class="user-pass">
								    <label for="passwordRepeat"><i class="am-icon-lock"></i></label>
								    <input type="password" name="password2" id="passwordRepeat" placeholder="确认密码">
                 </div>	
                 
                 </form>
                 
					
								   <div class="am-cf">
											<input onclick="formSubmit('save','_self');this.blur();"  type="submit" name="" value="注册" class="am-btn am-btn-primary am-btn-sm am-fl">
									</div>
								    <div class="am-air-zxl" id="username_msg" >
						                    ${msg}
									</div>	 
								
								</div>


								<script>
									$(function() {
									    $('#doc-my-tabs').tabs();
									  })
								</script>

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
								<a href="#">关于恒望</a>
								<a href="# ">合作伙伴</a>
								<a href="# ">联系我们</a>
								<a href="# ">网站地图</a>
								<em>© 2015-2025 Hengwang.com 版权所有. 更多模板 <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></em>
							</p>
						</div>
					</div>

	</body>

</html>