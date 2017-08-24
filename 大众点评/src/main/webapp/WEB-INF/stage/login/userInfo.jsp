<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">

		<title>模板</title>

		<link href="${app }/stagestaticfile/AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css">
		<link href="${app }/stagestaticfile/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css">

		<link href="${app }/stagestaticfile/css/personal.css" rel="stylesheet" type="text/css">
		<link href="${app }/stagestaticfile/css/stepstyle.css" rel="stylesheet" type="text/css">

		<script src="${app }/stagestaticfile/AmazeUI-2.4.2/assets/js/jquery.min.js" type="text/javascript"></script>
		<script src="${app }/stagestaticfile/AmazeUI-2.4.2/assets/js/amazeui.js" type="text/javascript"></script>
		
		<style type="text/css">
	        input,a{
	            width:120px;
	            height:30px;
	            font-size:20px;
	            padding:0; 
	            margin:0;
	        }
        </style>
	</head>

	<body>
		<%@include file="head.jsp" %>
		
		<div class="center">
			<div class="col-main">
				<div class="main-wrap">
					<hr/>
					<!--进度条-->
					<div class="m-progress">
						<div class="m-progress-list">
							<span class="step-1 step">
                                <em class="u-progress-stage-bg"></em>
                                <i class="u-stage-icon-inner">1<em class="bg"></em></i>
                                <p class="stage-name">完善个人信息</p>
                            </span>
							<span class="step-2 step">
                                <em class="u-progress-stage-bg"></em>
                                <i class="u-stage-icon-inner">2<em class="bg"></em></i>
                                <p class="stage-name">完成</p>
                            </span>
							<span class="u-progress-placeholder"></span>
						</div>
						<div class="u-progress-bar total-steps-2">
							<div class="u-progress-bar-inner"></div>
						</div>
					</div>
					<form action="${app}/stage/stageregister/userinforegist" class="am-form am-form-horizontal" method="POST" >
						<input type="hidden" name="userInfoId" value="${user.userId}"/>
						<div>
							<label for="name" class="am-form-label">姓名:</label>
							<div class="am-form-content">
								<input type="text" name="name" id="name"/>
							</div>
						</div>
						<div class="am-form-group">
							<label for="gender" class="am-form-label">性别:</label>
							<div class="am-form-content">
								<input type="radio" name="gender" id="gender" value="男"/>男
								<input type="radio" name="gender" id="gender" value="女"/>女
							</div>
						</div>
						<div class="am-form-group">
							<label for="telephone" class="am-form-label">手机号:</label>
							<div class="am-form-content">
								<input type="text" name="telephone" id="telephone">
							</div>
						</div>
						<div class="am-form-group">
							<label for="email" class="am-form-label">邮箱:</label>
							<div class="am-form-content">
								<input type="text" name="email" id="email">
							</div>
						</div>
						<div class="am-form-group">
							<label for="birthday" class="am-form-label">生日:</label>
							<div class="am-form-content">
								<input type="date" name="birthday" id="birthday"/>
							</div>
						</div>
						<div class="am-form-group">
							<label for="cardNo" class="am-form-label">身份证:</label>
							<div class="am-form-content">
								<input type="text" name="cardNo" id="cardNo">
							</div>
						</div>
						<div class="am-form-group">
							<label for="remark" class="am-form-label">备注:</label>
							<div class="am-form-content">
								<textarea rows="2" cols="2" name="remark"></textarea>
							</div>
						</div>
						<div class="info-btn">
							<a href="${app}/stage/home"  class="am-btn am-btn-danger">暂不填写</a>
							<input type="submit" class="am-btn am-btn-danger" value="保存"/>
						</div>
	
					</form>

				</div>
			</div>
			
		</div>
		
		<%@include file="foot.jsp" %>
	</body>

</html>