<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.bean.Account"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Danh Sách Sự Kiện</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Bootstrap Core CSS -->
<link href="../../assets/css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<!-- Custom CSS -->
<link href="../../assets/css/style.css" rel='stylesheet' type='text/css' />
<link rel="stylesheet" href="../../assets/css/morris.css" type="text/css"/>
<link href="../../assets/css/dataTables.bootstrap.css" rel="stylesheet">
<link href="../../assets/css/dataTables.bootstrap.min.css" rel="stylesheet">
<!-- Graph CSS -->
<link href="../../assets/css/font-awesome.css" rel="stylesheet">
<!-- lined-icons -->
<link rel="stylesheet" href="../../assets/css/icon-font.min.css" type='text/css' /> 
<!-- jQuery -->
<script src="../../assets/js/jquery-2.1.4.min.js"></script>
<script src="../../assets/js/jquery.min.js"></script>
<!-- //jQuery -->
<script src="../../assets/js/jquery.dataTables.js"></script>
<script src="../../assets/js/dataTables.bootstrap.js"></script>
<!-- tables -->
<link rel="stylesheet" type="text/css" href="../../assets/css/table-style.css" />
<link rel="stylesheet" type="text/css" href="../../assets/css/basictable.css" />
<script type="text/javascript" src="../../assets/js/jquery.basictable.min.js"></script>
<script src="../../assets/js/jquery-datatable.js"></script>
<style type="text/css">
.img-list img{
width: 50px;
height: 50px;
} 
</style>
<!-- //tables -->

<!-- lined-icons -->
<link rel="stylesheet" href="../../assets/css/icon-font.min.css" type='text/css' />
<!-- //lined-icons -->
</head> 
<body>
   <div class="page-container">
   <!--/content-inner-->
<div class="left-content">
	   <div class="mother-grid-inner">
            <!--header start here-->
			<jsp:include page="../header.html" flush="true"/>
			<!--heder end here-->
<ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="admin.jsp">Trang Chủ</a><i class="fa fa-angle-right"></i>Sự Kiện Lịch Sử</li>
            </ol>
<div class="agile-grids">	
				<!-- tables -->
				
				<div class="row clearfix">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="card">
                        <div class="header w3l-table-info">
                            <h2>
                                Danh Sách Sự Kiện
                            </h2>
                            
                        </div>
                        <div class="">
					        <html:form action="/admin/quanlybaiviet/danh-sach-su-kien" method="get">
					            <div class="col-lg-4">
					                <html:select property="maGiaiDoan" styleClass="form-control">
										<option value="0">-- Chọn khoa --</option>
										<html:optionsCollection name="danhSachSuKienForm" property="listGiaiDoan" 
											label="tenGiaiDoan" value="maGiaiDoan" />
									</html:select>
					            </div>
					            <script type="text/javascript">
					            	$("[name='maGiaiDoan']").val('<bean:write name="danhSachSuKienForm" property="maGiaiDoan"/>');
					            </script>
					            <html:submit styleClass="btn btn-primary">Xem</html:submit>
					            <div class="col-lg-2 pull-right">
					            	<html:link styleClass="btn btn-primary" action="/bai-dang">Thêm mới</html:link>
					            </div>
					        </html:form>
					    </div>
                        <div class="">
                            <table class="table table-bordered table-striped table-hover js-basic-example dataTable">
                                 <thead class="thead">
									  <tr>
										<th>Mã Sự Kiện</th>
										<th>Tên Sự Kiện</th>
										<th>Tên Giai Đoạn</th>
										<th>Hình Ảnh</th>
										<th>Thao Tác</th>
									  </tr>
								</thead>

								<tbody>
						  
                                	<logic:iterate name="danhSachSuKienForm" property="listSuKien" id="sk">
						            	<tr>
							                <td scope="row">
							                	<bean:write name="sk" property="maSuKien"/>
											</td>
							                <td>
							                	<bean:write name="sk" property="tenSuKien"/>
							                </td>
							           		<td>
							                	<bean:write name="sk" property="tenGiaiDoan"/>
							                </td>
							                <td>
							                	<div class="img-list"><img src = "../../<bean:write name="sk" property="hinhAnh"/>" alt = "hinhAnh"/>
							                	</div>
							                </td>
							                <td>
							                	<bean:define id="maSuKien" name="sk" property="maSuKien"></bean:define>
							                	<html:link action="/admin/quanlybaiviet/suaSK?maSuKien=${maSuKien}">
							                		<span class="glyphicon glyphicon-edit"> Sửa</span>
							                	</html:link>
							                	<html:link action="/admin/quanlybaiviet/xoaSK?maSuKien=${maSuKien}">
							                		<span class="glyphicon glyphicon-trash"> Xóa</span>
							                	</html:link>
							                </td>
						           		</tr>
						            </logic:iterate>    
                                    
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
				<!-- //tables -->
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
<!--inner block end here-->
<!--copy rights start here-->
<jsp:include
	page="/admin/footer.jsp" />
<!--COPY rights end here-->
</div>
</div>
  <!--//content-inner-->
		<!--/sidebar-menu-->
				<jsp:include page="/admin/sidebar.jsp" />
<!--js -->
<script src="../../assets/js/jquery.nicescroll.js"></script>
<script src="../../assets/js/scripts.js"></script>
<!-- Bootstrap Core JavaScript -->
   <script src="../../assets/js/bootstrap.min.js"></script>
   <!-- /Bootstrap Core JavaScript -->	   

</body>
</html>