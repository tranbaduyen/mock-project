<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sidebar</title>
</head>
<body>
<div class="sidebar-menu"><header class="logo1"> <a
	href="#" class="sidebar-icon"> <span class="fa fa-bars"></span> </a> </header>
<div style="border-top: 1px ridge rgba(255, 255, 255, 0.15)"></div>
<div class="menu">
<ul id="menu">
	<li><a href="/Mock_Project_DAV/admin/dashboard.html"><i class="fa fa-tachometer"></i> <span>Dashboard</span>
	<div class="clearfix"></div>
	</a></li>
	<li id="menu-academico"><a href="${pageContext.request.contextPath}/admin/quanlydonggop/quan-ly-dong-gop.html"><i
		class="fa fa-envelope nav_icon"></i><span>Đóng Góp</span>
	<div class="clearfix"></div>
	</a></li>
	<li id="menu-academico"><a href="${pageContext.request.contextPath}/admin/quanlybinhluan/quan-ly-binh-luan.html"><i
		class="fa fa-comments-o nav_icon"></i><span>Bình Luận</span>
	<div class="clearfix"></div>
	</a></li>
	<li id="menu-academico"><a href="${pageContext.request.contextPath}/admin/thongke/thong-ke.html"><i
		class="fa fa-signal nav_icon"></i><span>Thống Kê</span>
	<div class="clearfix"></div>
	</a></li>
	<li><a href="${pageContext.request.contextPath}/admin/quanlytaikhoan/quan-ly-tai-khoan.html"><i class="fa fa-users"
		aria-hidden="true"></i><span>Tài Khoản</span>
	<div class="clearfix"></div>
	</a></li>
	<li id="menu-academico"><a href="#"><i class="fa fa-list-ul"
		aria-hidden="true"></i><span> Bài Viết</span> <span
		class="fa fa-angle-right" style="float: right"></span>
	<div class="clearfix"></div>
	</a>
	<ul id="menu-academico-sub">
		<li id="menu-academico-avaliacoes"><a href="${pageContext.request.contextPath}/admin/quanlybaiviet/danh-sach-thoi-ky.html">Thời Kỳ Lịch Sử</a></li>
		<li id="menu-academico-avaliacoes"><a href="${pageContext.request.contextPath}/admin/quanlybaiviet/danh-sach-giai-doan.html">Giai
		Đoạn Lịch Sử</a></li>
		<li id="menu-academico-avaliacoes"><a href="${pageContext.request.contextPath}/admin/quanlybaiviet/danh-sach-su-kien.html">Sự
		Kiện Lịch Sử</a></li>
		<li id="menu-academico-avaliacoes"><a href="${pageContext.request.contextPath}/admin/quanlybaiviet/danh-sach-nhan-vat.html">Nhân Vật
		Lịch Sử</a></li>
		<li id="menu-academico-avaliacoes"><a href="${pageContext.request.contextPath}/admin/quanlybaiviet/danh-sach-dia-danh.html">Địa
		Danh Lịch Sử</a></li>
	</ul>
	</li>

	<li><a href="${pageContext.request.contextPath}/ban-do.html"><i class="fa fa-map-marker"
		aria-hidden="true"></i> <span>Bản Đồ</span>
	<div class="clearfix"></div>
	</a></li>

</ul>
</div>
</div>
<div class="clearfix"></div>
</div>
<script>
							var toggle = true;
										
							$(".sidebar-icon").click(function() {                
							  if (toggle)
							  {
								$(".page-container").addClass("sidebar-collapsed").removeClass("sidebar-collapsed-back");
								$("#menu span").css({"position":"absolute"});
							  }
							  else
							  {
								$(".page-container").removeClass("sidebar-collapsed").addClass("sidebar-collapsed-back");
								setTimeout(function() {
								  $("#menu span").css({"position":"relative"});
								}, 400);
							  }
											
											toggle = !toggle;
										});
							</script>
</body>
</html>