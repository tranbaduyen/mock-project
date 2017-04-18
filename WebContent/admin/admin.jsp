<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE HTML>
<html>
	<head>
		<title>Admin Dashboard</title>
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
				<li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/admin/dashboard.html">Trang Chủ</a> <i
					class="fa fa-angle-right"></i></li>
			</ol>
			<!--four-grids here-->
			<div class="four-grids">
			<div class="col-md-3 four-grid">
			<div class="four-agileits">
			<div class="icon"><i class="glyphicon glyphicon-user"
				aria-hidden="true"></i></div>
			<div class="four-text">
			<bean:define id="soLuongND" name="quanLyDashboardForm" property="soLuongNguoiDung"></bean:define>
			<h3>Người Dùng</h3>
			<h4><bean:write name="soLuongND" /></h4>
			</div>
			
			</div>
			</div>
			<div class="col-md-3 four-grid">
			<div class="four-agileinfo">
			<div class="icon"><i class="glyphicon glyphicon-eye-open"
				aria-hidden="true"></i></div>
			<div class="four-text">
			<bean:define id="soLuongLX" name="quanLyDashboardForm" property="soLuongLuotXem"></bean:define>
			<h3>Lượt Xem</h3>
			<h4><bean:write name="soLuongLX" /></h4>
			
			</div>
			
			</div>
			</div>
			<div class="col-md-3 four-grid">
			<div class="four-w3ls">
			<div class="icon"><i class="glyphicon glyphicon-edit"
				aria-hidden="true"></i></div>
			<div class="four-text">
				<bean:define id="soLuongBVM" name="quanLyDashboardForm" property="soLuongBaiVietMoi"></bean:define>
				<h3>Bài Viết Mới</h3>
				<h4><bean:write name="soLuongBVM" /></h4>
			</div>
			
			</div>
			</div>
			<div class="col-md-3 four-grid">
			<div class="four-wthree">
			<div class="icon"><i class="glyphicon glyphicon-pencil"
				aria-hidden="true"></i></div>
			<div class="four-text">
				<bean:define id="soLuongBV" name="quanLyDashboardForm" property="soLuongBaiViet"></bean:define>
				<h3>Bài Viết</h3>
				<h4><bean:write name="soLuongBV" /></h4>	
			</div>
			
			</div>
			</div>
			<div class="clearfix"></div>
			</div>
			<!--//four-grids here--> <!--agileinfo-grap-->
			<div class="agileinfo-grap">
			<div class="agileits-box"><header
				class="agileits-box-header clearfix">
			<h3>Thống Kê</h3>
			<div class="toolbar">
			<div class="pull-left">
			<div class="btn-group"><a href="#" class="btn btn-default btn-xs">Ngày</a>
			<a href="#" class="btn btn-default btn-xs active">Tháng</a> <a href="#"
				class="btn btn-default btn-xs">Năm</a></div>
			</div>
			<div class="pull-right">
			<div class="btn-group"><a aria-expanded="false"
				class="btn btn-default btn-xs dropdown-toggle" data-toggle="dropdown">
			Xuất <i class="fa fa-angle-down"></i> </a>
			<ul class="dropdown-menu pull-right" role="menu">
				<li><a href="#">Xuất ra PDF</a></li>
				<li><a href="#">Xuất ra CSV</a></li>
				<li><a href="#">Xuất ra PNG</a></li>
				<li class="divider"></li>
				<li><a href="#"></a></li>
			</ul>
			</div>
			<a href="#" class="btn btn-primary btn-xs"><i class="fa fa-cog"></i></a>
			</div>
			</div>
			</header>
			<div class="agileits-box-body clearfix">
			<div id="hero-area"></div>
			</div>
			</div>
			</div>
			<!--//agileinfo-grap--> <!--photoday-section-->

			
			<div class="clearfix"></div>
			
				<!--//photoday-section--> <!--w3-agileits-pane-->
				
			<!--//w3-agileits-pane--> <!--inner block start here-->
			<div class="inner-block"></div>
			<!--inner block end here--> <!--copy rights start here--> <jsp:include
				page="footer.jsp" /> <!--COPY rights end here--></div>
			</div>
		<!--//content-inner--> <!--/sidebar-menu--> <jsp:include
			page="sidebar.jsp" /> <!-- end sidebar-menu --> <!--js --> <script
			src="../assets/js/jquery.nicescroll.js"></script> <script
			src="../assets/js/scripts.js"></script> <!-- Bootstrap Core JavaScript -->
		<script src="../assets/js/bootstrap.min.js"></script> <!-- /Bootstrap Core JavaScript -->
		<!-- morris JavaScript --> <script src="../assets/js/raphael-min.js"></script>
		<script src="../assets/plugin/morrisjs/morris.js"></script> 
		<script>
			$(document).ready(
					function() {
						//BOX BUTTON SHOW AND CLOSE
						jQuery('.small-graph-box').hover(function() {
							jQuery(this).find('.box-button').fadeIn('fast');
						}, function() {
							jQuery(this).find('.box-button').fadeOut('fast');
						});
						jQuery('.small-graph-box .box-close').click(function() {
							jQuery(this).closest('.small-graph-box').fadeOut(200);
							return false;
						});
		
						//CHARTS
						function gd(year, day, month) {
							return new Date(year, month - 1, day).getTime();
						}
						var data = [ {
							period : '2016 Q3',
							sukien : 4830,
							nhanvat : 3805,
							diadanh : 1598
						}, {
							period : '2016 Q4',
							sukien : 15083,
							nhanvat : 8977,
							diadanh : 5185
						}, {
							period : '2017 Q1',
							sukien : 10697,
							nhanvat : 4470,
							diadanh : 2038
						}, {
							period : '2017 Q2',
							sukien : 8442,
							nhanvat : 5723,
							diadanh : 1801
						} ];
						graphArea2 = Morris.Area( {
							element : 'hero-area',
							padding : 10,
							behaveLikeLine : true,
							gridEnabled : false,
							gridLineColor : '#dddddd',
							axes : true,
							resize : true,
							smooth : true,
							pointSize : 0,
							lineWidth : 0,
							fillOpacity : 0.85,
							data : data,
							lineColors : [ '#ff4a43', '#a2d200', '#22beef' ],
							xkey : 'period',
							redraw : true,
							ykeys : [ 'sukien', 'nhanvat', 'diadanh' ],
							labels : [ 'Sự Kiện', 'Nhân Vật','Địa Danh' ],
							pointSize : 2,
							hideHover : 'auto',
							resize : true
						});
		
					});
		</script>
	</body>
</html>