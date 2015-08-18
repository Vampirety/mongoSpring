<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/header.jsp"%>
<!DOCTYPE html>  
<html>  
    <head>  
        <meta http-equiv="Content-type" content="text/html; charset=utf-8">  
       <%@include file="/common/jsLib.jsp"%>
    </head>
    <script type="text/javascript">
    	$(function(){
    		var windowId='${windowId}';
    		$(parent.document.getElementById(windowId)).modal('hide');
    	});
    </script>
    <body>  
        <p>保存成功</p>
        <input type="button" value="确定"/>  
    </body>  
</html> 