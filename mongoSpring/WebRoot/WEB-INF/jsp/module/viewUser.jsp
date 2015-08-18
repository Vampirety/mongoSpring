<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>user Info</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<%@include file="/common/jsLib.jsp"%>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
	<div class="content">
		<div class="container-fluid">
			<div id="pad-wrapper">
				<div class="row-fluid">
					<div class="row-fluid form-wrapper">
						<div class="field-box">
                               <label>姓:</label>
                               <div class="alert alert-info">${user.lastName }</div>
                           </div>
                           <div class="field-box">
                               <label>名:</label>
                               <div class="alert alert-info">${user.firstName }</div>
                           </div>
                           <div class="field-box">
                               <label>昵称:</label>
                               <div class="alert alert-info">${user.nickName }</div>
                           </div>
                           <div class="field-box">
                               <label>手机号码:</label>
                               <div class="alert alert-info">${user.phone }</div>
                           </div>
                           <div class="field-box">
                               <label>邮箱:</label>
                               <div class="alert alert-info">${user.email }</div>
                           </div>
                           <div class="field-box">
                               <label>公司名称:</label>
                               <div class="alert alert-info">${user.company }</div>
                           </div>
                           <div class="buttonFloat">
                            <div class="span6 field-box actions">
	                            <input type="button" class="btn-glow primary" onclick="parent.close_win('view');" value="确定" />
	                        </div>
                        </div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>