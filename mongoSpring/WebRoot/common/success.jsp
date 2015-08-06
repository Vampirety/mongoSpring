<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/header.jsp"%>
<!DOCTYPE html>  
<html>  
    <head>  
        <meta http-equiv="Content-type" content="text/html; charset=utf-8">  
       <%@include file="/common/jsLib.jsp"%>
    </head>  
    <body>  
        <a href="#myModal" role="button" class="btn" data-toggle="modal">Launch demo modal</a>  
        <!-- Modal -->  
        <div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">  
            <div class="modal-header">  
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>  
                <h3 id="myModalLabel">Modal header</h3>
            </div>  
            <div class="modal-body">  
                <p>弹出层…</p>  
            </div>  
            <div class="modal-footer">  
                <button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>  
                <button class="btn btn-primary">Save changes</button>  
            </div>  
        </div>  
    </body>  
</html> 