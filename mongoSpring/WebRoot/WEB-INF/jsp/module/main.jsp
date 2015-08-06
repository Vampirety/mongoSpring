<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
	<%@include file="/common/jsLib.jsp"%>
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
<body>
    <!-- navbar -->
    <div class="navbar navbar-inverse">
        <div class="navbar-inner">
            <button type="button" class="btn btn-navbar visible-phone" id="menu-toggler">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            
            <a class="brand" href="##"><img src="${ctx }/webResources/images/logo.png" /></a>

            <ul class="nav pull-right">                
                <li class="hidden-phone">
                    <input class="search" type="text" />
                </li>
                <li class="notification-dropdown hidden-phone">
                    <a href="#" class="trigger">
                        <i class="icon-warning-sign"></i>
                        <span class="count">8</span>
                    </a>
                    <div class="pop-dialog">
                        <div class="pointer right">
                            <div class="arrow"></div>
                            <div class="arrow_border"></div>
                        </div>
                        <div class="body">
                            <a href="#" class="close-icon"><i class="icon-remove-sign"></i></a>
                            <div class="notifications">
                                <h3>您有8条新消息</h3>
                                <a href="#" class="item">
                                    <i class="icon-signin"></i> 新消息1
                                    <span class="time"><i class="icon-time"></i> 13 min.</span>
                                </a>
                                <a href="#" class="item">
                                    <i class="icon-signin"></i> 新消息2
                                    <span class="time"><i class="icon-time"></i> 18 min.</span>
                                </a>
                                <a href="#" class="item">
                                    <i class="icon-envelope-alt"></i> 新消息3
                                    <span class="time"><i class="icon-time"></i> 28 min.</span>
                                </a>
                                <a href="#" class="item">
                                    <i class="icon-signin"></i> 新消息4
                                    <span class="time"><i class="icon-time"></i> 49 min.</span>
                                </a>
                                <a href="#" class="item">
                                    <i class="icon-download-alt"></i> 新消息5
                                    <span class="time"><i class="icon-time"></i> 1 day.</span>
                                </a>
                                <div class="footer">
                                    <a href="#" class="logout">查看所有通知</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </li>
                <li class="notification-dropdown hidden-phone">
                    <a href="#" class="trigger">
                        <i class="icon-envelope-alt"></i>
                    </a>
                    <div class="pop-dialog">
                        <div class="pointer right">
                            <div class="arrow"></div>
                            <div class="arrow_border"></div>
                        </div>
                        <div class="body">
                            <a href="#" class="close-icon"><i class="icon-remove-sign"></i></a>
                            <div class="messages">
                                <a href="#" class="item">
                                    <img src="${ctx }/webResources/images/contact-img.png" class="display" />
                                    <div class="name">Alejandra GalvÃ¡n</div>
                                    <div class="msg">
                                        There are many variations of available, but the majority have suffered alterations.
                                    </div>
                                    <span class="time"><i class="icon-time"></i> 13 min.</span>
                                </a>
                                <a href="#" class="item">
                                    <img src="${ctx }/webResources/images/contact-img2.png" class="display" />
                                    <div class="name">Alejandra GalvÃ¡n</div>
                                    <div class="msg">
                                        There are many variations of available, have suffered alterations.
                                    </div>
                                    <span class="time"><i class="icon-time"></i> 26 min.</span>
                                </a>
                                <a href="#" class="item last">
                                    <img src="${ctx }/webResources/images/contact-img.png" class="display" />
                                    <div class="name">Alejandra GalvÃ¡n</div>
                                    <div class="msg">
                                        There are many variations of available, but the majority have suffered alterations.
                                    </div>
                                    <span class="time"><i class="icon-time"></i> 48 min.</span>
                                </a>
                                <div class="footer">
                                    <a href="#" class="logout">查看所有消息</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle hidden-phone" data-toggle="dropdown"> 我的账户
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="personal-info.html">个人信息</a></li>
                        <li><a href="#">账户设置</a></li>
                        <li><a href="#">导出数据</a></li>
                        <li><a href="#">反馈意见</a></li>
                    </ul>
                </li>
                <li class="settings hidden-phone">
                    <a href="personal-info.html" role="button">
                        <i class="icon-cog"></i>
                    </a>
                </li>
                <li class="settings hidden-phone">
                    <a href="signin.html" role="button">
                        <i class="icon-share-alt"></i>
                    </a>
                </li>
            </ul>            
        </div>
    </div>
    <!-- end navbar -->

    <!-- sidebar -->
    <div id="sidebar-nav">
        <ul id="dashboard-menu">
        	<c:forEach var="module" items="${moduleList}" varStatus="status">
	            	<c:if test="${status.first}">
	            		<li class="active">
		            		<div class="pointer">
			                    <div class="arrow"></div>
			                    <div class="arrow_border"></div>
		                	</div>
		                	<a href="##" onclick="goPage('${module.moduleUrl}')">
			                    <i class="${module.iconUrl}"></i>
			                    <span>${module.moduleName}</span>
			                </a>
	                	</li>
	            	</c:if>
	            	<c:if test="${!status.first}">
	            		<li>
		                	<a href="##" onclick="goPage('${module.moduleUrl}')">
			                    <i class="${module.iconUrl}"></i>
			                    <span>${module.moduleName}</span>
			                </a>
		                </li>
	            	</c:if>
            </c:forEach>
            <!--           
            <li>
                <a href="chart-showcase.html">
                    <i class="icon-signal"></i>
                    <span>Charts</span>
                </a>
            </li>
            <li>
                <a class="dropdown-toggle" href="#">
                    <i class="icon-group"></i>
                    <span>Users</span>
                    <i class="icon-chevron-down"></i>
                </a>
                <ul class="submenu">
                    <li><a href="user-list.html">User list</a></li>
                    <li><a href="new-user.html">New user form</a></li>
                    <li><a href="user-profile.html">User profile</a></li>
                </ul>
            </li>
            <li>
                <a class="dropdown-toggle" href="#">
                    <i class="icon-edit"></i>
                    <span>Forms</span>
                    <i class="icon-chevron-down"></i>
                </a>
                <ul class="submenu">
                    <li><a href="form-showcase.html">Form showcase</a></li>
                    <li><a href="form-wizard.html">Form wizard</a></li>
                </ul>
            </li>
            <li>
                <a href="gallery.html">
                    <i class="icon-picture"></i>
                    <span>Gallery</span>
                </a>
            </li>
            <li>
                <a href="calendar.html">
                    <i class="icon-calendar-empty"></i>
                    <span>Calendar</span>
                </a>
            </li>
            <li>
                <a href="tables.html">
                    <i class="icon-th-large"></i>
                    <span>Tables</span>
                </a>
            </li>
            <li>
                <a class="dropdown-toggle ui-elements" href="#">
                    <i class="icon-code-fork"></i>
                    <span>UI Elements</span>
                    <i class="icon-chevron-down"></i>
                </a>
                <ul class="submenu">
                    <li><a href="ui-elements.html">UI Elements</a></li>
                    <li><a href="icons.html">Icons</a></li>
                </ul>
            </li>
            <li>
                <a href="personal-info.html">
                    <i class="icon-cog"></i>
                    <span>My Info</span>
                </a>
            </li>
            <li>
                <a class="dropdown-toggle" href="#">
                    <i class="icon-share-alt"></i>
                    <span>Extras</span>
                    <i class="icon-chevron-down"></i>
                </a>
                <ul class="submenu">
                    <li><a href="code-editor.html">Code editor</a></li>
                    <li><a href="grids.html">Grids</a></li>
                    <li><a href="signin.html">Sign in</a></li>
                    <li><a href="signup.html">Sign up</a></li>
                </ul>
            </li> -->
        </ul>
    </div>
    <!-- end sidebar -->
	<!-- main container -->
    <div id="content" class="content">
		<!-- <iframe id="myFrame" style="border:none;background:#fff" src="${ctx }/user/toIframe.action"></iframe> -->
		<iframe id="myFrame" style="border:none;background:#fff" src="${ctx }/user/toIframe.action"></iframe>
    </div>
	<!-- scripts -->
    <script type="text/javascript">
	    var height=$(window).height();
		var width=$(window).width();
    	var options = {
    		currentPage: 1,
    		totalPages: 10,
    		numberOfPages:10
    	};
    	$('#pagination').bootstrapPaginator(options);
    	function goPage(url){
    		$("#myFrame").attr("src","${ctx }/"+url);
    	}
        $(function () {
			//$(".content").css("min-height",(height-200)+"px");
			$("#row-fluid").css("min-height",(height-48)+"px");
			$("#myFrame").css("width",(width-180)+"px");
			$("#myFrame").css("height",(height-48)+"px");
            // jQuery Knobs
        });
    </script>
</body>
</html>