<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>user Info</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<%@include file="/common/jsLib.jsp"%>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script type="text/javascript">
		$(function(){
			//$("form").validation();
			$("input[type='submit']").on('click',function(event){
				if (!$("form").valid(this,"error!")){
					return false;
				}else{
					//$("form").submit();
					var btn = $(this).button('loading');
				    setTimeout(function () {
				        btn.button('reset');
				    }, 3000);
				}
			});
			$("form").validation(function(obj,params){
				if (obj.name=='email'&&'${type}'!='edit'){
					$.post("${ctx}/user/checkEmail.action?email="+$(obj).val(),{mail :$(obj).val()},function(data){
						if(!data.success){
							params.err = data.success;
							params.msg = data.msg;
						}else{
							return;
						}
					});
				}
			});
		});
	</script>
</head>
<body>
	<div class="content">
		<div class="container-fluid">
			<div id="pad-wrapper">
				<div class="row-fluid">
					<div class="row-fluid form-wrapper">
						<form method="post" action="${ctx}/user/saveUser.action" >
							<input type="hidden" name="id" value="${user.id }"/>
							<input type="hidden" name="delFlag" value="${user.delFlag }"/>
							<input type="hidden" name="type" value="${type }"/>
							<div class="field-box">
                                <label>姓<span id="autoreqmark" style="color:#FF9966"> *</span>:</label>
                                <input class="form-control" name="lastName" value="${user.lastName }" style="width:450px" check-type="required" type="text" />
                            </div>
                            <div class="field-box">
                                <label>名<span id="autoreqmark" style="color:#FF9966"> *</span>:</label>
                            	<input type="text" name="firstName" class="form-control" value="${user.firstName }" style="width:450px" check-type="required">
                            </div>
                            <div class="field-box">
                                <label>昵称<span id="autoreqmark" style="color:#FF9966"> *</span>:</label>
                                <input class="form-control" name="nickName" value="${user.nickName }" style="width:450px" check-type="required" type="text" />
                            </div>
                            <div class="field-box">
                                <label>手机号码<span id="autoreqmark" style="color:#FF9966"> *</span>:</label>
                                <input class="form-control" name="phone" value="${user.phone }" style="width:450px" check-type="mobile required" type="text" />
                            </div>
                            <div class="field-box">
                                <label>邮箱<span id="autoreqmark" style="color:#FF9966"> *</span>:</label>
                                <input class="form-control" name="email" value="${user.email }" style="width:450px" check-type="mail" type="text" />
                            </div>
                            <div class="field-box">
                                <label>公司名称<span id="autoreqmark" style="color:#FF9966"> *</span>:</label>
                                <input class="form-control" name="company" value="${user.company }" style="width:450px" type="text" />
                            </div>
                            <div class="buttonFloat">
	                            <div class="span6 field-box actions">
		                            <input type="submit" class="btn-glow primary" value="确定" />
		                            <input type="button" class="btn-glow primary" onclick="parent.close_win('edit');" value="取消"/>
		                        </div>
	                        </div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>