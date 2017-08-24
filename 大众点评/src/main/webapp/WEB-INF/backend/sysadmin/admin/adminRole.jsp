<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>用户角色分配</title>
	<link rel="stylesheet" href="${app }/backstaticfile/css/style.css" media="all" />
	<link rel="stylesheet" href="${app}/backstaticfile/components/zTree/css/zTreeStyle/zTreeStyle.css" type="text/css">
	<script type="text/javascript" src="${app}/backstaticfile/components/zTree/js/jquery-1.4.4.min.js"></script>
	<script type="text/javascript" src="${app}/backstaticfile/components/zTree/js/jquery.ztree.core-3.5.min.js"></script>.
	<script type="text/javascript" src="${app}/backstaticfile/components/zTree/js/jquery.ztree.excheck-3.5.min.js"></script>
	<script language="javascript" src="${app}/backstaticfile/js/common.js"></script>
	<SCRIPT type="text/javascript">	
		var setting = {
			check: {
				enable: true
			},
			data: {
				simpleData: {
					enable: true
				}
			}
		};		
		//这里相当于在拿后来传来的数据，后台在传数据的时候，属性名要对应上
		var zNodes =${zTreeJson}
		
		$(document).ready(function(){
			$.fn.zTree.init($("#htZtree"), setting, zNodes);

			var zTreeObj = $.fn.zTree.getZTreeObj("htZtree");
			zTreeObj.expandAll(true);		//展开所有树节点
		});
				
		//获取到所以用户选中的节点id值
		//获取所有选择的节点，提交时调用下面函数
		function submitCheckedNodes(treeNode) {
			var nodes = new Array();
			var zTreeObj = $.fn.zTree.getZTreeObj("htZtree");
			nodes = zTreeObj.getCheckedNodes(true);		//取得选中的结点
			var str = "";
			for (i = 0; i < nodes.length; i++) {
				if (str != "") {
					str += ",";
				}
				str += nodes[i].id;
			}
			$("#roleIds").val(str);		//将拼接完成的字符串放入隐藏域，这样就可以通过post提交
		}
	</SCRIPT>
</head>

<body>
<section class="alert">
	<form method="post">		 
		  <button class="green" onclick="window.history.go(-1)">返回</button>
		  <button class="green" onclick="submitCheckedNodes();formSubmit('role','_self');this.blur();">保存</button>
		</section>
		   <br/>
		   <br/>
		   <br/>
		   <br/>
		   <br/>
		   <br/>		   
		   <section class="widget">
			<header>
					<span class="icon">&#128100;</span>
					<hgroup>
						<h1>用户</h1>
						<h2>当前管理员角色分配</h2>
					</hgroup>
				
				</header>
		<div>
			<div class="eXtremeTable" >
				<table id="ec_table" class="tableRegion" width="98%" >
					<!--隐藏域用来传递数据  -->
					<input type="hidden" id="adminId" name="adminId" value="${adminId}"/>
					<input type="hidden" id="roleIds" name="roleIds"/>
					<ul id="htZtree" class="ztree"></ul>
				</table>
			</div>
		</div>
		</section>		 
		</form>
	</body>
	

	
</html>


