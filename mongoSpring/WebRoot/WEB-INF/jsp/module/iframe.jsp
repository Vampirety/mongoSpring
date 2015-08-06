<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/header.jsp"%>
<!DOCTYPE html>
<html>
  <head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<%@include file="/common/jsLib.jsp"%>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
  </head>
  <body class="whiteBg">
  	<div class="container-fluid">
    <div id="pad-wrapper">
         <div class="table-products section">
             <div class="row-fluid filter-block">
             	 <a class="btn-flat danger"><i class="icon-remove"></i>批量删除</a>
             	 <a class="btn-flat "><i class="icon-plus"></i>新增用户</a>
                 <div class="pull-right">
                     <div class="ui-select">
                         <select>
                           <option>用户姓名</option>
                           <option>手机号码</option>
                         </select>
                     </div>
                     <input type="text" class="search" />
                     <a class="btn-flat primary"><i class="icon-search"></i>搜索</a>
                 </div>
             </div>
             <div class="pagination" id="pagination">
             </div>
         </div>
     </div>
     </div>
     <script type="text/javascript">
     	var options = {
     		/*currentPage: 1,
     		totalPages: 10,
     		numberOfPages:10,*/
     		url:'${ctx}/user/getUserPage.action',
     		//queryParams:{"nickName":"白"},
     		title:'用户列表',
     		columns:[
				{field:'id',checkbox:true},
				{field:'headPic',title:'用户头像',width:0.1,formatter:function(rec){
					if(rec.headPic){
						return '<img src="'+rec.headPic+'" />';
					}else{
						return '<img src="${ctx }/webResources/images/table-img.png" />';
					}
				}},
				{field:'name',title:'用户姓名',width:0.1,formatter:function(rec){
					return rec.lastName+" "+rec.firstName;
				}},
				{field:'phone',title:'手机号码',width:0.1},
				{field:'op',title:'操作',width:0.2,formatter:function(rec){
					return "<ul class='actions'><li><i class='icon-pencil' onclick='edit(\""+rec.id+"\");'></i></li>"//编辑
                        +'<li><i class="icon-eye-open"></i></li>'//设置
                        +'<li class="last"><i class="icon-remove" onclick="del();"></i></li></ul>';//删除					
				}}
     		]
     	};
     	$('#pagination').bootstrapPaginator(options);
     	function edit(id){
     		createSimpleWindow("edit","新增用户","${ctx}/user/toEdit.action?userId="+id, 600, 500);
     	}
     	function del(){
     		bootbox.confirm({ 
     		    size: 'small',
     		    message: "Your message here…", 
     		    callback: function(result){
     		    	
     		    }
     		});
     	}
     </script>
  </body>
</html>
