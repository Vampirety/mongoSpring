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
                    <form>
                        <div class="field-box">
                            <label>姓:</label>
                            <input class="span5 inline-input" type="text" value="Alejandra" />
                        </div>
                        <div class="field-box">
                            <label>名:</label>
                            <input class="span5 inline-input" type="text" value="Galvan" />
                        </div>
                        <div class="field-box">
                            <label>公司:</label>
                            <input class="span5 inline-input" type="text" value="Design Co." />
                        </div>
                        <div class="field-box">
                            <label>邮箱:</label>
                            <input class="span5 inline-input" type="text" value="alejandra@design.com" />
                        </div>
                        <div class="field-box">
                            <label>用户名:</label>
                            <input class="span5 inline-input" type="text" value="alegalvan" />
                        </div>
                        <div class="field-box">
                            <label>密码:</label>
                            <input class="span5 inline-input" type="password" value="blablablabla" />
                        </div>
                        <div class="field-box">
                            <label>确认密码:</label>
                            <input class="span5 inline-input" type="password" value="blablablabla" />
                        </div>
                        <div class="span6 field-box actions">
                        	<div class="pull-right">
	                            <input type="button" class="btn-glow primary" value="保存"/>
	                            <input type="button" class="btn-glow primary" value="取消" onclick="parent.close_win('edit');"/>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>