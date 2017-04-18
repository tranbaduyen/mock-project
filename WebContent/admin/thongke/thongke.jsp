<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Bootstrap Core CSS -->
<link href="../../assets/css/bootstrap.min.css" rel='stylesheet'
	type='text/css' />
<!-- Custom CSS -->
<link href="../../assets/css/style.css" rel='stylesheet' type='text/css' />
<link rel="stylesheet" href="../../assets/css/morris.css"
	type="text/css" />
<link href="../../assets/css/dataTables.bootstrap.css" rel="stylesheet">
<link href="../../assets/css/dataTables.bootstrap.min.css"
	rel="stylesheet">
<!-- Graph CSS -->
<link href="../../assets/css/font-awesome.css" rel="stylesheet">
<!-- Morris Css -->
<link href="../../assets/plugin/morrisjs/morris.css" rel="stylesheet" />

<!-- lined-icons -->
<link rel="stylesheet" href="../../assets/css/icon-font.min.css"
	type='text/css' />
<!-- jQuery -->
<script src="../../assets/js/jquery-2.1.4.min.js"></script>
<script src="../../assets/js/jquery.min.js"></script>
<script src="../../assets/js/jquery.dataTables.js"></script>
<script src="../../assets/js/dataTables.bootstrap.js"></script>
<!-- //jQuery -->
<!-- tables -->
<link rel="stylesheet" type="text/css"
	href="../../assets/css/table-style.css" />
<link rel="stylesheet" type="text/css"
	href="../../assets/css/basictable.css" />
<script type="text/javascript"
	src="../../assets/js/jquery.basictable.min.js"></script>
<script src="../../assets/js/jquery-datatable.js"></script>

<!-- //tables -->

<!-- lined-icons -->
<link rel="stylesheet" href="../../assets/css/icon-font.min.css"
	type='text/css' />
<!-- //lined-icons -->
</head>
<body>
<div class="page-container"><!--/content-inner-->
<div class="left-content">
<div class="mother-grid-inner"><!--header start here--> <jsp:include
	page="../header.html" flush="true" /> <!--heder end here-->
<ol class="breadcrumb">
	<li class="breadcrumb-item"><a
		href="/Mock_Project_DAV/admin/dashboard.html">Trang Chủ</a><i
		class="fa fa-angle-right"></i>Quản Lý Đóng Góp</li>
</ol>

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
				<script>
					
					$(function () {
					    getMorris('donutNgay', 'donut_chart_ngay');
					    getMorris('donutTuan', 'donut_chart_tuan');
					    getMorris('donutThang', 'donut_chart_thang');
					    getMorris('donutNam', 'donut_chart_nam');
					    getMorris('donut', 'donut_chart');
					});
				</script>
				<script>
				function getMorris(type, element) {
				     if (type === 'donutNgay') {
				    	 var soLuongSKNgay = parseInt(document.getElementById("span_soLuongSKNgay").innerText);
				    	 console.log(soLuongSKNgay);
				    	 var soLuongNVNgay = parseInt(document.getElementById("span_soLuongNVNgay").innerText);
				    	 console.log(soLuongNVNgay);
				    	 var phanTramSK = Math.ceil(soLuongSKNgay*100/(soLuongSKNgay+soLuongNVNgay));
				    	 console.log(phanTramSK);
				        Morris.Donut({
				            element: element,
				            data: [{
				                label: 'Sự Kiện',
				                value: phanTramSK
				            }, {
				                    label: 'Nhân Vật',
				                    value: 100-phanTramSK
				                }],
				            colors: ['rgb(233, 30, 99)', 'rgb(0, 188, 212)', 'rgb(255, 152, 0)', 'rgb(0, 150, 136)'],
				            formatter: function (y) {
				                return y + '%'
				            }
				        });
				    }
				     if (type === 'donutTuan') {
				    	 var soLuongSKTuan = parseInt(document.getElementById("span_soLuongSKTuan").innerText);
				    	 console.log(soLuongSKTuan);
				    	 var soLuongNVTuan = parseInt(document.getElementById("span_soLuongNVTuan").innerText);
				    	 console.log(soLuongNVTuan);
				    	 var phanTramSK = Math.ceil(soLuongSKTuan*100/(soLuongSKTuan+soLuongNVTuan));
				    	 console.log(phanTramSK);
				        Morris.Donut({
				            element: element,
				            data: [{
				                label: 'Sự Kiện',
				                value: phanTramSK
				            }, {
				                    label: 'Nhân Vật',
				                    value: 100-phanTramSK
				                }],
				            colors: ['rgb(233, 30, 99)', 'rgb(0, 188, 212)', 'rgb(255, 152, 0)', 'rgb(0, 150, 136)'],
				            formatter: function (y) {
				                return y + '%'
				            }
				        });
				    }
				     if (type === 'donutThang') {
				    	 var soLuongSKThang = parseInt(document.getElementById("span_soLuongSKThang").innerText);
				    	 console.log(soLuongSKThang);
				    	 var soLuongNVThang = parseInt(document.getElementById("span_soLuongNVThang").innerText);
				    	 console.log(soLuongNVThang);
				    	 var phanTramSK = Math.ceil(soLuongSKThang*100/(soLuongSKThang+soLuongNVThang));
				    	 console.log(phanTramSK);
				        Morris.Donut({
				            element: element,
				            data: [{
				                label: 'Sự Kiện',
				                value: phanTramSK
				            }, {
				                    label: 'Nhân Vật',
				                    value: 100-phanTramSK
				                }],
				            colors: ['rgb(233, 30, 99)', 'rgb(0, 188, 212)', 'rgb(255, 152, 0)', 'rgb(0, 150, 136)'],
				            formatter: function (y) {
				                return y + '%'
				            }
				        });
				    }
				     if (type === 'donutNam') {
				    	 var soLuongSKNam = parseInt(document.getElementById("span_soLuongSKNam").innerText);
				    	 console.log(soLuongSKNam);
				    	 var soLuongNVNam = parseInt(document.getElementById("span_soLuongNVNam").innerText);
				    	 console.log(soLuongNVNam);
				    	 var phanTramSK = Math.ceil(soLuongSKNam*100/(soLuongSKNam+soLuongNVNam));
				    	 console.log(phanTramSK);
				        Morris.Donut({
				            element: element,
				            data: [{
				                label: 'Sự Kiện',
				                value: phanTramSK
				            }, {
				                    label: 'Nhân Vật',
				                    value: 100-phanTramSK
				                }],
				            colors: ['rgb(233, 30, 99)', 'rgb(0, 188, 212)', 'rgb(255, 152, 0)', 'rgb(0, 150, 136)'],
				            formatter: function (y) {
				                return y + '%'
				            }
				        });
				    }
				     if (type === 'donut') {
				    	 var soLuongSK = parseInt(document.getElementById("span_soLuongSK").innerText);
				    	 console.log(soLuongSK);
				    	 var soLuongNV = parseInt(document.getElementById("span_soLuongNV").innerText);
				    	 console.log(soLuongNV);
				    	 var phanTramSK = Math.ceil(soLuongSK*100/(soLuongSK+soLuongNV));
				    	 console.log(phanTramSK);
				        Morris.Donut({
				            element: element,
				            data: [{
				                label: 'Sự Kiện',
				                value: phanTramSK
				            }, {
				                    label: 'Nhân Vật',
				                    value: 100-phanTramSK
				                }],
				            colors: ['rgb(233, 30, 99)', 'rgb(0, 188, 212)', 'rgb(255, 152, 0)', 'rgb(0, 150, 136)'],
				            formatter: function (y) {
				                return y + '%'
				            }
				        });
				    }
				}
				</script> 
<div class="w3-agile-chat">
<div class="charts">
<div class="col-md-3 w3layouts-char">
	<form>
		<div class="">
			<div class=" form-group2 group-mail">
			<select disabled="disabled">
				<option value="0">Lượt Xem</option>
				<option value="1">Lượt Bình Luận</option>
			</select> 
			<select disabled="disabled">
				<option value="0">Sự Kiện</option>
				<option value="1">Nhân Vật</option>
			</select>
		
			</div>
		</div>
	</form>
		<div class="compose w3layouts">
			<nav class="nav-sidebar">
				<ul class="nav tabs">
					<bean:define id="soLuongSKNgay" name="thongKeForm"
						property="tongSoLuotXemSuKienTrongNgay"></bean:define>
					<bean:define id="soLuongSKTuan" name="thongKeForm"
						property="tongSoLuotXemSuKienTrongTuan"></bean:define>
					<bean:define id="soLuongSKThang" name="thongKeForm"
						property="tongSoLuotXemSuKienTrongThang"></bean:define>
					<bean:define id="soLuongSKNam" name="thongKeForm"
						property="tongSoLuotXemSuKienTrongNam"></bean:define>
					<bean:define id="soLuongSK" name="thongKeForm"
						property="tongSoLuotXemSuKien"></bean:define>
					<li id ="liclick1" class="active"><a href="#tab1" data-toggle="tab"
						aria-expanded="true"><i class="fa fa-history"></i>Thống Kê Theo
					Ngày <span id="span_soLuongSKNgay"><bean:write name="soLuongSKNgay" /></span>
					<div class="clearfix"></div>
					</a></li>
					<li id ="liclick2" class=""><a href="#tab2" data-toggle="tab"
						aria-expanded="false"><i class="fa fa-bookmark"></i>Thống Kê Theo
					Tuần<span id="span_soLuongSKTuan"><bean:write name="soLuongSKTuan" /></span>
					<div class="clearfix"></div>
					</a></li>
					<li id ="liclick3" class=""><a href="#tab3" data-toggle="tab"
						aria-expanded="false"><i class="fa fa-user"></i>Thống Kê Theo
					Tháng<span id="span_soLuongSKThang"><bean:write name="soLuongSKThang" /></span>
					<div class="clearfix"></div>
					</a></li>
					<li id ="liclick4" class=""><a href="#tab4" data-toggle="tab"
						aria-expanded="false"><i class="fa fa-map-marker"></i>Thống Kê
					Theo Năm <span id="span_soLuongSKNam"><bean:write name="soLuongSKNam" /></span>
					<div class="clearfix"></div>
					</a></li>
					<li id ="liclick5" class=""><a href="#tab5" data-toggle="tab"
						aria-expanded="false"><i class="fa fa-pencil-square-o"></i>Thống
					Kê Tất Cả<span id="span_soLuongSK"><bean:write name="soLuongSK" /></span>
					<div class="clearfix"></div>
					</a></li>
				</ul>
			</nav>
		</div>
		
		
		<script type="text/javascript">
		
		
		$("#liclick2").click(function(){
			$(this).parents().find("#thongke1").css({'display':'none'});
			$(this).parents().find("#thongke3").css({'display':'none'});
			$(this).parents().find("#thongke4").css({'display':'none'});
			$(this).parents().find("#thongke5").css({'display':'none'});
			$(this).parents().find("#thongke2").css({'display':'block'});	
		});

		$("#liclick1").click(function(){
			$(this).parents().find("#thongke2").css({'display':'none'});
			$(this).parents().find("#thongke3").css({'display':'none'});
			$(this).parents().find("#thongke4").css({'display':'none'});
			$(this).parents().find("#thongke5").css({'display':'none'});
			$(this).parents().find("#thongke1").css({'display':'block'});	
		});
		$("#liclick3").click(function(){
			$(this).parents().find("#thongke2").css({'display':'none'});
			$(this).parents().find("#thongke1").css({'display':'none'});
			$(this).parents().find("#thongke4").css({'display':'none'});
			$(this).parents().find("#thongke5").css({'display':'none'});
			$(this).parents().find("#thongke3").css({'display':'block'});	
		});
		$("#liclick4").click(function(){
			$(this).parents().find("#thongke2").css({'display':'none'});
			$(this).parents().find("#thongke3").css({'display':'none'});
			$(this).parents().find("#thongke1").css({'display':'none'});
			$(this).parents().find("#thongke5").css({'display':'none'});
			$(this).parents().find("#thongke4").css({'display':'block'});	
		});

		
		$("#liclick5").click(function(){
			$(this).parents().find("#thongke2").css({'display':'none'});
			$(this).parents().find("#thongke3").css({'display':'none'});
			$(this).parents().find("#thongke4").css({'display':'none'});
			$(this).parents().find("#thongke1").css({'display':'none'});
			$(this).parents().find("#thongke5").css({'display':'block'});	
		});

		
		
		
		</script>
		
		
		
		
					<bean:define id="soLuongNVNgay" name="thongKeForm"
						property="tongSoLuotXemNhanVatTrongNgay"></bean:define>
					<bean:define id="soLuongNVTuan" name="thongKeForm"
						property="tongSoLuotXemNhanVatTrongTuan"></bean:define>
					<bean:define id="soLuongNVThang" name="thongKeForm"
						property="tongSoLuotXemNhanVatTrongThang"></bean:define>
					<bean:define id="soLuongNVNam" name="thongKeForm"
						property="tongSoLuotXemNhanVatTrongNam"></bean:define>
					<bean:define id="soLuongNV" name="thongKeForm"
						property="tongSoLuotXemNhanVat"></bean:define>
				
					<span id="span_soLuongNVNgay" style="display:none"><bean:write name="soLuongNVNgay" /></span>

					<span id="span_soLuongNVTuan" style="display:none"><bean:write name="soLuongNVTuan" /></span>

					<span id="span_soLuongNVThang" style="display:none"><bean:write name="soLuongNVThang" /></span>
				
					<span id="span_soLuongNVNam" style="display:none"><bean:write name="soLuongNVNam" /></span>
				
					<span id="span_soLuongNV" style="display:none"><bean:write name="soLuongNV" /></span>
					
		
</div>
<div class="col-md-9 w3-char">
	<div class="charts-grids widget tab-content tab-content-in w3">
			<div class="tab-pane text-style active" id="tab1">
				<div id="donut_chart_ngay" class="graph"></div>
			</div>
			<div class="tab-pane text-style active" id="tab2">
				<div id="donut_chart_tuan" class="graph"></div>
			</div>
			<div class="tab-pane text-style active" id="tab3">
				<div id="donut_chart_thang" class="graph"></div>
			</div>
			<div class="tab-pane text-style active" id="tab4">
				<div id="donut_chart_nam" class="graph"></div>
			</div>
			<div class="tab-pane text-style active" id="tab5">
				<div id="donut_chart" class="graph"></div>
			</div>
	</div>
</div>



<div class="clearfix"></div>

<div class="hight-chat"><!-- tab content -->
<div class="col-md-12 tab-content tab-content-in w3">
<div class="tab-pane text-style active" id="thongke1">
<div class="mailbox-content">
<table class="table table-bordered table-striped table-hover ">
	<thead>
		<tr class="">
			<th>Mã</th>
			<th>Tên</th>
			<th>Số Lượng</th>
		</tr>
	</thead>
	<tbody>
		<logic:iterate name="thongKeForm" property="listSuKienTKNgay"
			id="skThongKe">
			<tr class="table-row ">
				<td scope="row" class="table-text">
				<h6><bean:write name="skThongKe" property="maSuKien" /></h6>
				</td>
				<td class="table-text">
				<h6><bean:write name="skThongKe" property="tenSuKien" /></h6>
				</td>
				<td class="table-text">
				<h6><bean:write name="skThongKe" property="soLuongLuotXemNgay" /></h6>
				</td>
			</tr>
		</logic:iterate>

	</tbody>
</table>
</div>
</div>
<div class="tab-pane text-style" id="thongke2">
<div class="mailbox-content">
<table class="table table-bordered table-striped table-hover ">
	<thead>
		<tr>
			<th>Mã</th>
			<th>Tên</th>
			<th>Số Lượng</th>
		</tr>
	</thead>
	<tbody>
		<logic:iterate name="thongKeForm" property="listSuKienTKTuan"
			id="skThongKe">
			<tr class="table-row">
				<td scope="row" class="table-text">
				<h6><bean:write name="skThongKe" property="maSuKien" /></h6>
				</td>
				<td class="table-text">
				<h6><bean:write name="skThongKe" property="tenSuKien" /></h6>
				</td>
				<td class="table-text">
				<h6><bean:write name="skThongKe" property="soLuongLuotXemTuan" /></h6>
				</td>
			</tr>
		</logic:iterate>

	</tbody>
</table>
</div>
</div>
<div class="tab-pane text-style" id="thongke3">
<div class="mailbox-content">
<table class="table table-bordered table-striped table-hover ">
	<thead>
		<tr>
			<th>Mã</th>
			<th>Tên</th>
			<th>Số Lượng</th>
		</tr>
	</thead>
	<tbody>
		<logic:iterate name="thongKeForm" property="listSuKienTKThang"
			id="skThongKe">
			<tr class="table-row">
				<td scope="row" class="table-text">
				<h6><bean:write name="skThongKe" property="maSuKien" /></h6>
				</td>
				<td class="table-text">
				<h6><bean:write name="skThongKe" property="tenSuKien" /></h6>
				</td>
				<td class="table-text">
				<h6><bean:write name="skThongKe" property="soLuongLuotXemThang" /></h6>
				</td>
			</tr>
		</logic:iterate>

	</tbody>
</table>
</div>
</div>
<div class="tab-pane text-style" id="thongke4">
<div class="mailbox-content">
<table class="table table-bordered table-striped table-hover ">
	<thead>
		<tr>
			<th>Mã</th>
			<th>Tên</th>
			<th>Số Lượng</th>
		</tr>
	</thead>
	<tbody>
		<logic:iterate name="thongKeForm" property="listSuKienTKNam"
			id="skThongKe">
			<tr class="table-row" class="table-text">
				<td scope="row" class="table-text">
				<h6><bean:write name="skThongKe" property="maSuKien" /></h6>
				</td>
				<td class="table-text">
				<h6><bean:write name="skThongKe" property="tenSuKien" /></h6>
				</td>
				<td class="table-text">
				<h6><bean:write name="skThongKe" property="soLuongLuotXemNam" /></h6>
				</td>
			</tr>
		</logic:iterate>

	</tbody>
</table>
</div>
</div>
<div class="tab-pane text-style" id="thongke5">
<div class="mailbox-content">
<table class="table table-bordered table-striped table-hover ">
	<thead>
		<tr>
			<th>Mã</th>
			<th>Tên</th>
			<th>Số Lượng</th>
		</tr>
	</thead>
	<tbody>
		<logic:iterate name="thongKeForm" property="listSuKienTK"
			id="skThongKe">
			<tr class="table-row" class="table-text">
				<td scope="row" class="table-text">
				<h6><bean:write name="skThongKe" property="maSuKien" /></h6>
				</td>
				<td class="table-text">
				<h6><bean:write name="skThongKe" property="tenSuKien" /></h6>
				</td>
				<td class="table-text">
				<h6><bean:write name="skThongKe" property="soLuongLuotXem" /></h6>
				</td>
			</tr>
		</logic:iterate>

	</tbody>
</table>
</div>
</div>
</div>

<div class="clearfix"></div>
</div>
</div>

</div>
<!--inner block start here-->
<div class="inner-block"></div>
<!--inner block end here--> <!--copy rights start here--> <jsp:include
	page="/admin/footer.jsp" /> <!--COPY rights end here--></div>
</div>
<!--//content-inner--> <!--/sidebar-menu--> <jsp:include
	page="/admin/sidebar.jsp" /> <!--js --> <script
	src="../../assets/js/jquery.nicescroll.js"></script> <script
	src="../../assets/js/scripts.js"></script> <!-- Bootstrap Core JavaScript -->
<script src="../../assets/js/bootstrap.min.js"></script> <!-- /Bootstrap Core JavaScript -->
<!-- Morris Plugin Js --> <script
	src="../../assets/plugin/morrisjs/morris.js"></script> <script
	src="../../assets/plugin/raphael/raphael.min.js"></script>
</body>
</html>