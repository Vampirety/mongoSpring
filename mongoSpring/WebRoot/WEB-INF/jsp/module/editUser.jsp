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
    <div class="content wide-content">
        <div class="container-fluid">
            <div class="settings-wrapper" id="pad-wrapper">
                <div class="span7 personal-info">
                	<div class="form-group has-success has-feedback"> 
					  <label class="control-label" for="inputSuccess2">Input with success</label> 
					  <input type="text" class="form-control" id="inputSuccess2"> 
					  <span class="glyphicon glyphicon-ok form-control-feedback"></span> 
					</div> 
					<div class="form-group has-warning has-feedback"> 
					  <label class="control-label" for="inputWarning2">Input with warning</label> 
					  <input type="text" class="form-control" id="inputWarning2"> 
					  <span class="glyphicon glyphicon-warning-sign form-control-feedback"></span> 
					</div> 
					<div class="form-group has-error has-feedback"> 
					  <label class="control-label" for="inputError2">Input with error</label> 
					  <input type="text" class="form-control" id="inputError2"> 
					  <span class="glyphicon glyphicon-remove form-control-feedback"></span> 
					</div> 
                	<!-- <form id="myForm" action="${ctx}/user/saveUser.action">
                        <div class="field-box">
                            <label>姓:</label>
                            <input class="span5 inline-input" type="text" value="${user.lastName }"/>
                        </div>
                        <div class="field-box">
                            <label>名:</label>
                            <input class="span5 inline-input tooltip-show" data-toggle="tooltip" title="show" type="text" value="${user.firstName }" />
                        </div>
                        <div class="field-box">
                            <label>公司:</label>
                            <input class="span5 inline-input" type="text" value="${user.company }" />
                        </div>
                        <div class="field-box">
                            <label>邮箱:</label>
                            <input class="span5 inline-input" type="text" value="${user.email }"/>
                        </div>
                        <div class="field-box">
                            <label>用户名:</label>
                            <input class="span5 inline-input" type="text" value="${user.account }" />
                        </div>
                        <div class="field-box">
                            <label>手机号码:</label>
                            <input class="span5 inline-input" type="text" value="${user.phone }" />
                        </div>
                        <div class="field-box">
                            <label>通讯地址:</label>
                            <input class="span5 inline-input" type="text" value="${user.address }" />
                        </div>
                        <div class="span6 field-box actions">
                        	<div class="pull-right">
	                            <input type="submit" class="btn-glow primary" value="保存"/>
	                            <input type="button" class="btn-glow primary" value="取消" onclick="parent.close_win('edit');"/>
                            </div>
                        </div>
                    </form> -->
                </div>
            </div>
        </div>
    </div>
</body>
</html>