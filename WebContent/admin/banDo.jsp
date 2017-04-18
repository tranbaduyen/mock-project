<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE HTML>
<html>
	<head>
		<title>Bản Đồ</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="keywords" content="" />
		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
		</script>
		<!-- Bootstrap Core CSS -->
		<link href="../assets/css/bootstrap.min.css" rel='stylesheet'
			type='text/css' />
		<!-- Custom CSS -->
		<link href="../assets/css/style.css" rel='stylesheet' type='text/css' />
		<link rel="stylesheet" href="../assets/css/morris.css" type="text/css" />
		<!-- Graph CSS -->
		<link href="../assets/css/font-awesome.css" rel="stylesheet">
		<!-- lined-icons -->
		<link rel="stylesheet" href="../assets/css/icon-font.min.css" type='text/css' />
		<!-- jQuery -->
		<script src="../assets/js/jquery-2.1.4.min.js"></script>
		<!-- //jQuery -->
		
		<!-- lined-icons -->
		<link rel="stylesheet" href="../assets/css/icon-font.min.css"
			type='text/css' />
		<!-- //lined-icons -->
	</head>
	<body>
		<div class="page-container"><!--/content-inner-->
			<div class="left-content">
			<div class="mother-grid-inner">
			<!--header start here--> 
			<jsp:include page="header.html" flush="true"/> <!--heder end here-->
			
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="Mock_Project_DAV/admin/dashboard.do">Trang Chủ</a> <i
					class="fa fa-angle-right"></i>Bản Đồ</li>
			</ol>
			<div class="map">
				<div class="col-md-6 w3layouts-map">
					<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3320.183033874468!2d150.8649541095356!3d-33.678324494541656!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x6b129838f39a743f%3A0x3017d681632a850!2sSydney+NSW%2C+Australia!5e0!3m2!1sen!2sin!4v1476529656354"  frameborder="0" style="border:0" allowfullscreen></iframe>
				</div>
				<div class="col-md-6 agileits-map">
					<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d106224.83240082047!2d150.87676655803944!3d-33.6953354022623!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x6b129838f39a743f%3A0x3017d681632a850!2sSydney+NSW%2C+Australia!5e0!3m2!1sen!2sin!4v1476529926928" frameborder="0" style="border:0" allowfullscreen></iframe>
				</div>
				<div class="col-md-6 agileinfo-map">
					<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d424521.98724489537!2d150.6419337943232!3d-33.77156856642666!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x6b129838f39a743f%3A0x3017d681632a850!2sSydney+NSW%2C+Australia!5e0!3m2!1sen!2sin!4v1476529981265" frameborder="0" style="border:0" allowfullscreen></iframe>
				</div>
				<div class="col-md-6 w3-agileits-map">
					<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d6697825.113257229!2d144.173733109507!3d-34.946019835412905!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x6b129838f39a743f%3A0x3017d681632a850!2sSydney+NSW%2C+Australia!5e0!3m2!1sen!2sin!4v1476530044829" frameborder="0" style="border:0" allowfullscreen></iframe>
				</div>
				<div class="clearfix"> </div>
			</div>
			<!-- script-for sticky-nav -->
				<script>
				$(document).ready(function() {
					 var navoffeset=$(".header-main").offset().top;
					 $(window).scroll(function(){
						var scrollpos=$(window).scrollTop(); 
						if(scrollpos >=navoffeset){
							$(".header-main").addClass("fixed");
						}else{
							$(".header-main").removeClass("fixed");
						}
					 });
					 
				});
				</script>
			<!-- /script-for sticky-nav -->
<!--inner block start here-->
<div class="inner-block">

</div>
			<!--copy rights start here-->
			<jsp:include
				page="footer.jsp" />
			<!--COPY rights end here-->
			</div>
			</div>
			  <!--//content-inner-->
					<!--/sidebar-menu-->
							<jsp:include page="sidebar.jsp" />
			<!--js -->
			<script src="../assets/js/jquery.nicescroll.js"></script>
			<script src="../assets/js/scripts.js"></script>
			<!-- Bootstrap Core JavaScript -->
			   <script src="../assets/js/bootstrap.min.js"></script>
			   <!-- /Bootstrap Core JavaScript -->	   
	</body>
</html>