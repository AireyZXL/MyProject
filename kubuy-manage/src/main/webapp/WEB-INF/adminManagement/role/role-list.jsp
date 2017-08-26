<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
	<%@include file="../../common.jsp" %>
<title>角色管理</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 管理员管理 <span class="c-gray en">&gt;</span> 角色管理 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<div class="text-c"> 日期范围：
		<input type="text" onfocus="WdatePicker({ maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}' })" id="datemin" class="input-text Wdate" style="width:120px;">
		-
		<input type="text" onfocus="WdatePicker({ minDate:'#F{$dp.$D(\'datemin\')}',maxDate:'%y-%M-%d' })" id="datemax" class="input-text Wdate" style="width:120px;">
		<input type="text" class="input-text" style="width:250px" placeholder="输入角色名称" id="" name="">
		<button type="submit" class="btn btn-success radius" id="" name=""><i class="Hui-iconfont">&#xe665;</i> 搜角色</button>
	</div>
	<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a> <a href="javascript:;" onclick="item_add('添加商品','item-toAdd','800','610')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 添加管理员</a></span>  </div>
	<div class="mt-20">
	<table class="table table-border table-bordered table-hover table-bg table-sort">
		<thead>
			<tr class="text-c">
				<th width="25"><input type="checkbox" name="" value=""></th>
				<th width="80">角色ID</th>
				<th width="100">角色名称</th>
				<th width="40">模块描述</th>	
				<th width="80">创建日期</th>
				<th width="80">修改日期</th>
				<th width="50">操作</th>
			</tr>
		</thead>
		<tbody id="mybody">
		
		</tbody>
	</table>
	</div>
</div>

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${app }/staticfile/lib/My97DatePicker/4.8/WdatePicker.js"></script> 
<script type="text/javascript" src="${app }/staticfile/lib/datatables/1.10.0/jquery.dataTables.min.js"></script> 
<script type="text/javascript" src="${app }/staticfile/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
$(function(){
	/* datatable分页 */
	 $('.table-sort').dataTable(
            {
                "sPaginationType": "full_numbers", //分页风格，full_number会把所有页码显示出来（大概是，自己尝试）
                "iDisplayLength": 10,//每页显示10条数据
                "bAutoWidth": false,//宽度是否自动，感觉不好使的时候关掉试试
           		"bLengthChange": false, 
           		"bFilter": false,
           		"bStateSave": true,
           		"bPaginate": true,  //是否显示分页 
                "oLanguage": {//下面是一些汉语翻译
                    "sSearch": "搜索",
                    "sLengthMenu": "每页显示 _MENU_ 条记录",
                    "sZeroRecords": "没有检索到数据",
                    "sInfo": "显示 _START_ 至 _END_ 条 &nbsp;&nbsp;共 _TOTAL_ 条",
                    "sInfoFiltered": "(筛选自 _MAX_ 条数据)",
                    "sInfoEmtpy": "没有数据",
                    "sProcessing": "正在加载数据...",
                    "sProcessing": "<img src='{{rootUrl}}global/img/ajaxLoader/loader01.gif' />", //这里是给服务器发请求后到等待时间显示的 加载gif
                            "oPaginate":
                            {
                                "sFirst": "首页",
                                "sPrevious": "前一页",
                                "sNext": "后一页",
                                "sLast": "末页"
                            }
                },
                "autoWidth" : false,
               "bProcessing": true, //开启读取服务器数据时显示正在加载中……特别是大数据量的时候，开启此功能比较好
                "bServerSide": true, //开启服务器模式，使用服务器端处理配置datatable。注意：sAjaxSource参数也必须被给予为了给datatable源代码来获取所需的数据对于每个画。 这个翻译有点别扭。开启此模式后，你对datatables的每个操作 每页显示多少条记录、下一页、上一页、排序（表头）、搜索，这些都会传给服务器相应的值。 
                 "sAjaxSource": "query", //给服务器发请求的url
                 
                "columns": [ //这个属性下的设置会应用到所有列，按顺序没有是空
                   {"data":"roleId","render": function(data, type, full) { // 返回自定义内容
                	  return '<input type="checkbox" name="" value="'+data+'">';
           			}},
                    {"data": 'roleId'}, //mData 表示发请求时候本列的列名，返回的数据中相同下标名字的数据会填充到这一列
                    {"data":"roleName","render": function(data, type, full) { // 返回自定义内容
   						if(data==null){
   							return "";
   						}
                    	return '<u style="cursor:pointer" class="text-primary" onclick="member_show(\'张三\',\'member-show.html\',\'10001\',\'360\',\'400\')">'+data+'</u>'
                	}},
                	{"data": 'remark'},
               		{"data":"created","render": function(data, type, full) { // 返回自定义内容
               			var now = new Date(data);
               	    	return now.toLocaleDateString()
                	}},
                	{"data":"updated","render": function(data, type, full) { // 返回自定义内容
               			var now = new Date(data);
               	    	return now.toLocaleDateString()
                	}},
                    {"data":"id","sClass": "text-center","render": function(data, type, full) { // 返回自定义内容
                       var id=data;
                    
                    	return '<a style="text-decoration:none" onClick="item_stop(this,\'10001\')" href="javascript:;" title="下架"><i class="Hui-iconfont">&#xe6de;</i></a> <a style="text-decoration:none" class="ml-5" onClick="item_addSeckill(\'添加秒杀\',\'seckill-toAdd/'+id+'\')"'+' href="javascript:;" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a> <a style="text-decoration:none" class="ml-5" onClick="item_del(this,\'10001\')" href="javascript:;" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a>';
                     }}
                ]
          
            }
            
            
    );
	


});


/*管理员-添加*/
function item_add(title,url,w,h){
	layer_show(title,url,w,h);
}
/*管理员-查看*/
function item_show(title,url,id,w,h){
	layer_show(title,url,w,h);
}
/*管理员-停用*/
function item_stop(obj,id){
	layer.confirm('确认要停用吗？',function(index){
		$.ajax({
			type: 'POST',
			url: '',
			dataType: 'json',
			success: function(data){
				$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="member_start(this,id)" href="javascript:;" title="启用"><i class="Hui-iconfont">&#xe6e1;</i></a>');
				$(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">已停用</span>');
				$(obj).remove();
				layer.msg('已停用!',{icon: 5,time:1000});
			},
			error:function(data) {
				console.log(data.msg);
			},
		});		
	});
}

/*管理员-启用*/
function item_start(obj,id){
	layer.confirm('确认要启用吗？',function(index){
		$.ajax({
			type: 'POST',
			url: '',
			dataType: 'json',
			success: function(data){
				$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="member_stop(this,id)" href="javascript:;" title="停用"><i class="Hui-iconfont">&#xe631;</i></a>');
				$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已启用</span>');
				$(obj).remove();
				layer.msg('已启用!',{icon: 6,time:1000});
			},
			error:function(data) {
				console.log(data.msg);
			},
		});
	});
}
/*管理员-编辑*/
function item_addSeckill(title,url,id,w,h){
	layer_show(title,url,w,h);
}
/*密码-修改*/
function change_password(title,url,id,w,h){
	layer_show(title,url,w,h);	
}
/*管理员-删除*/
function item_del(obj,id){
	layer.confirm('确认要删除吗？',function(index){
		$.ajax({
			type: 'POST',
			url: '',
			dataType: 'json',
			success: function(data){
				$(obj).parents("tr").remove();
				layer.msg('已删除!',{icon:1,time:1000});
			},
			error:function(data) {
				console.log(data.msg);
			},
		});		
	});
}
</script> 
</body>
</html>