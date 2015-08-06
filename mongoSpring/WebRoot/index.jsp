<%@include file="/common/header.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Nova</title>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event){		
			event.preventDefault();
			$('html,body').animate({scrollTop:$(this.hash).offset().top},1200);
		});
	});
</script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript"> 
addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
</head>
<%@include file="/common/jsLib.jsp"%>
<body>
<div class="header">
  <div class="container">
    <div class="logo"> <a href="##"><img src="${ctx }/webResources/images/logo1.png" alt="Nova"></a> </div>
    <div class="menu"> <a class="toggleMenu" href="##"><img src="${ctx }/webResources/images/nav_icon1.png" alt="" /> </a>
      <ul class="nav" id="nav">
        <li class="current"><a href="##">Home</a></li>
        <li><a href="##">About</a></li>
        <li><a href="##">Services</a></li>
        <li><a href="##">Blog</a></li>
        <li><a href="##">Contact</a></li>
        <div class="clear"></div>
      </ul>
    </div>
    <div class="clearfix"> </div>
  </div>
</div>
<div class="banner text-center">
  <div class="container">
    <div class="banner-info">
      <h1>Lorem ipsum dolor sit amet</h1>
      <p>nteger nec odio praesent libero. Sed cursus ante dapibus diamsed nisi.<br>
        Nulla quis sem at nibh elementum imperdiet</p>
      	<label class="page-scroll"><a class="banner-btn class scroll" href="${ctx }/module/toMain.action"><i class="fa fa-angle-double-down fa-4x"><h2>click here</h2></i></a></label>
    </div>
  </div>
</div>
<div class="main">
<div class="content_white">
  <h2>Welcome to our website!</h2>
  <p>Quisque cursus metus vitae pharetra auctor, sem massa mattis semat interdum magna.</p>
</div>
</body>
</html>
