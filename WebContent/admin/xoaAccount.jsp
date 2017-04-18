<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.bean.Account"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Xóa Tài Khoản</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Bootstrap Core CSS -->
<link href="../assets/css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<!-- Custom CSS -->
<link href="../assets/css/style.css" rel='stylesheet' type='text/css' />
<link rel="stylesheet" href="../assets/css/morris.css" type="text/css"/>
<link href="../assets/css/dataTables.bootstrap.css" rel="stylesheet">
<link href="../assets/css/dataTables.bootstrap.min.css" rel="stylesheet">
<link href="../assets/css/sweetalert.css" rel="stylesheet">
<!-- Waves Effect Css -->
<link href="../assets/plugin/node-waves/waves.css" rel="stylesheet" />
<!-- Graph CSS -->
<link href="../assets/css/font-awesome.css" rel="stylesheet">
<!-- lined-icons -->
<link rel="stylesheet" href="../assets/css/icon-font.min.css" type='text/css' />

<!-- jQuery -->
<script src="../assets/js/jquery-2.1.4.min.js"></script>
<script src="../assets/js/jquery.min.js"></script>
<!-- //jQuery -->
<script src="../assets/js/jquery.dataTables.js"></script>
<script src="../assets/js/dataTables.bootstrap.js"></script>
<script src="../assets/js/sweetalert.min.js"></script>
<!-- tables -->
<link rel="stylesheet" type="text/css" href="../assets/css/table-style.css" />
<link rel="stylesheet" type="text/css" href="../assets/css/basictable.css" />
<script type="text/javascript" src="../assets/js/jquery.basictable.min.js"></script>
<script src="../assets/js/jquery-datatable.js"></script>

<!-- //tables -->

<!-- lined-icons -->
<link rel="stylesheet" href="../assets/css/icon-font.min.css" type='text/css' />
<!-- //lined-icons -->
</head> 
<body>
   <div class="page-container">
   <!--/content-inner-->
<div class="left-content">
	   <div class="mother-grid-inner">
            <!--header start here-->
			<jsp:include page="header.html" flush="true"/>
			<!--heder end here-->
<ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="admin.jsp">Trang Chủ</a><i class="fa fa-angle-right"></i>Tài Khoản</li>
            </ol>
<div class="agile-grids">	
				<!-- tables -->
				
				<div class="row clearfix">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <h3>Xóa Tài Khoản: 
						<bean:write name="accountForm" property="ten"/>
					</h3>
				    <br>
					<html:form styleId="deleteForm"  action="/admin/xoaTK" method="post" >
				        <div class="row form-group">
				            <label class="col-lg-2">User Name</label>
				            <div class="col-lg-3">
				                <html:text property="userName" styleClass="form-control" readonly="true"></html:text>
				            </div>
				        </div>
				        <div class="row form-group">
				            <label class="col-lg-2">Họ Tên</label>
				            <div class="col-lg-3">
				                <html:text property="ten" styleClass="form-control" readonly="true"></html:text>
				            </div>
				        </div>
				        <div class="row form-group">
				            <label class="col-lg-2">Email</label>
				            <div class="col-lg-3">
				                <html:text property="email" styleClass="form-control" readonly="true"></html:text>
				            </div>
				        </div>
				        <div class="row form-group">
				            <label class="col-lg-2">Địa Chỉ</label>
				            <div class="col-lg-3">
				                <html:text property="diaChi" styleClass="form-control" readonly="true"></html:text>
				            </div>
				        </div>
				        
				        <div class="row form-group">
				            <div class="col-lg-3 col-lg-offset-2">
				                <html:submit styleClass="btn btn-primary waves-effect" styleId="submitDelete"  property="submit" value="submit" onclick="myAlertFunction(event);"></html:submit>
				                <button class="btn btn-primary" onclick="history.go(-1);">Quay lại</button>
				            </div>
				        </div>
				    </html:form>
                </div>
            </div>
				<!-- //tables -->
			</div>
<script>

</script>
			
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
		function myAlertFunction(event) {
			  event.preventDefault();
			  swal({
			      title: "Bạn có chắc muốn xóa ?",
			      text: "Tài khoản",
			      type: "warning",
			      showCancelButton: true,
			      confirmButtonColor: "#DD6B55",
			      confirmButtonText: "OK",
			      cancelButtonText: "Hủy",
			      closeOnConfirm: true,
			      closeOnCancel: false,
			      html: false
			    },
			    function(isConfirm) {
			      if (isConfirm) {
			        swal({
			          title: "Đã xóa",
			          text: "Thành công",
			          type: "success"
			        });
			        
			        //$(event.currentTarget).trigger(event.type, {'send': true});
			        console.log('done');
			        return true;
			      } else {
			        swal("Đã hủy", "Không thành công", "error");
			        return false;
			      }
			    });
			}
		</script>
		<script>
		
		</script>
<!--inner block start here-->
<div class="inner-block">

</div>
<!--inner block end here-->
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
<!-- Waves Effect Plugin Js -->
    <script src="../assets/plugin/node-waves/waves.js"></script>
	<script src="../assets/js/dialogs.js"></script>
<!-- Bootstrap Core JavaScript -->
   <script src="../assets/js/bootstrap.min.js"></script>
   <!-- /Bootstrap Core JavaScript -->	   

</body>
</html>