<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>大众点评后台管理系统</title>
</head>
	<frameset rows="125,*" name="topFrameset" border="1" >
		<frame name="top_frame" scrolling="no"  target="middleFrameSet" src="title.action">	
	<frameset cols="202,*" height="100%" name="middle">
		<frame name="leftFrame" class="leftFrame" target="main" scrolling="no" src="left.action" />
		<frame name="main"  src="main.action" />
	</frameset>
</frameset>
</html>