<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Profile</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Bootstrap Core CSS -->
<link href="../../assets/css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<!-- Custom CSS -->
<link href="../../assets/css/style.css" rel='stylesheet' type='text/css' />
<link rel="stylesheet" href="../../assets/css/lightbox.css">
<!-- Graph CSS -->
<link href="../../assets/css/font-awesome.css" rel="stylesheet"> 
<!-- jQuery -->
<script src="../../assets/js/jquery-2.1.4.min.js"></script>
<!-- //jQuery -->

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
                <li class="breadcrumb-item"><a href="admin.jsp">Trang Chủ</a><i class="fa fa-angle-right"></i>Thông Tin Cá Nhân</li>
            </ol>
<div class="agile3-grids">
		<style>
				.user-row {
			margin-bottom: 14px;
		}

		.user-row:last-child {
			margin-bottom: 0;
		}

		.dropdown-user {
			margin: 13px 0;
			padding: 5px;
			height: 100%;
		}

		.dropdown-user:hover {
			cursor: pointer;
		}

		.table-user-information > tbody > tr {
			border-top: 1px solid rgb(221, 221, 221);
		}

		.table-user-information > tbody > tr:first-child {
			border-top: 0;
		}


		.table-user-information > tbody > tr > td {
			border-top: 0;
		}
		.toppad
		{margin-top:20px;
		}

		</style>
		
	<div class="container " >
      <div class="row ">
 
        <div class="col-xs-10 col-sm-10  col-xs-offset-0 col-sm-offset-0" >

          <div class="panel panel-info">
            <div class="panel-heading">
              <h3 class="panel-title" >Phan Thị Minh Tâm</h3>
            </div>
            <div class="panel-body" style="background-color:white">
              <div class="row">
                <div class="col-md-5 col-lg-4 " align="center"> 
					<img alt="User Pic" src="images/in4.jpg" class="img-circle img-responsive " style="width:200px"> </br>
					<a href="">Đổi Avatar</a>
				</div>

                <div class=" col-md-7 col-lg-8 "> 
                  <table class="table table-user-information">
                    <tbody>
                      <tr>
                        <td>Quyền Truy Cập:</td>
                        <td>Quản Trị Viên</td>
                      </tr>
                      <tr>
                        <td>Ngày Sinh:</td>
                        <td>01/01/1995</td>
                      </tr>
                   
                         <tr>
                             <tr>
                        <td>Giới Tính:</td>
                        <td>Nữ</td>
                      </tr>
                        <tr>
                        <td>Địa Chỉ:</td>
                        <td>Quảng Trị</td>
                      </tr>
                      <tr>
                        <td>Email:</td>
                        <td><a href="mailto:svtt0117TamPTM@svtt.fsdn">svtt0117TamPTM@svtt.fsdn</a></td>
                      </tr>
                        <td>Số Điện Thoại:</td>
                        <td>0123456789<br>
                        </td>
                           
                      </tr>
                     
                    </tbody>
                  </table>
                  
                </div>
              </div>
            </div>
                 <div class="panel-footer" style="background-color:#14C1d6">
                        <a data-original-title="" data-toggle="tooltip" type="button" class="btn btn-sm btn-primary"></a>
                        <span class="pull-right">
                            <a href="" data-original-title="Sửa" data-toggle="tooltip" type="button" class="btn btn-sm btn-warning"><i class="glyphicon glyphicon-edit"></i></a>
                            <a data-original-title="Quay Lại" data-toggle="tooltip" type="button" onclick="history.go(-1)" class="btn btn-sm btn-danger"><i class="glyphicon glyphicon-remove"></i></a>
                        </span>
                    </div>
            
          </div>
        </div>
      </div>
    </div>
		
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