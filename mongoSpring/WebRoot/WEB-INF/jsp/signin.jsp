<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/common/header.jsp"%>
<!DOCTYPE html>
<html class="login-bg">
<head>
	<title>Sign in</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	
    <!-- bootstrap -->
    <link href="${ctx }/webResources/css/bootstrap/bootstrap.css" rel="stylesheet" />
    <link href="${ctx }/webResources/css/bootstrap/bootstrap-responsive.css" rel="stylesheet" />
    <link href="${ctx }/webResources/css/bootstrap/bootstrap-overrides.css" type="text/css" rel="stylesheet" />

    <!-- global styles -->
    <link rel="stylesheet" type="text/css" href="${ctx }/webResources/css/layout.css" />
    <link rel="stylesheet" type="text/css" href="${ctx }/webResources/css/elements.css" />
    <link rel="stylesheet" type="text/css" href="${ctx }/webResources/css/icons.css" />

    <!-- libraries -->
    <link rel="stylesheet" type="text/css" href="${ctx }/webResources/css/lib/font-awesome.css" />
    
    <!-- this page specific styles -->
    <link rel="stylesheet" href="${ctx }/webResources/css/compiled/signin.css" type="text/css" media="screen" />

    <!-- open sans font -->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css' />
	<link rel="stylesheet" href="${ctx }/webResources/css/validate.css" type="text/css" media="screen" />
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
	<style>
    </style>
<body>
    <div class="row-fluid login-wrapper">
        <a href="index.html">
            <img class="logo" src="${ctx }/webResources/images/logo-white.png" />
        </a>
		<form id="myForm" class="main" onsubmit="return check()" action="${ctx }/user/login.action" method="post">
	        <div class="span4 box" id="box">
	            <div class="content-wrap">
	                <h6>Log in</h6>
	                <input class="span12 input-xlarge" id="account" name="account" type="text" placeholder="E-mail address" required 
	                pattern="^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$"/>
	                <input class="span12 input-xlarge" id="password" name="password" type="password" placeholder="Your password" required/>
	                <a href="#" class="forgot">Forgot password?</a>
	                <div class="remember">
	                    <input id="remember-me" type="checkbox" />
	                    <label for="remember-me">Remember me</label>
	                    <label id="msg" style="display:none;font-weight:bold;float:right">${TSR_MSG_LOGINFAIL}</label>
	                </div>
	                <!-- <a class="btn-glow primary login" type="submit">Log in</a> -->
	                <button class="btn-glow primary login" type="submit" id="ok">Log in</button>
	            </div>
	        </div>
	        <div class="span4 no-account">
	            <p>Don't have an account?</p>
	            <a href="${ctx }/user/signup.action" type="submit">Sign up</a>
	        </div>
        </form>
    </div>

	<!-- scripts -->
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script src="${ctx }/webResources/js/bootstrap.min.js"></script>
    <script>
    	if('${TSR_MSG_LOGINFAIL}'){
			$("#msg").show();
    	}else{
    		$("#msg").hide();
    	}
        function check() {
            document.getElementById('ok').disabled = 'disabled';
        }
    </script>
</body>
</html>