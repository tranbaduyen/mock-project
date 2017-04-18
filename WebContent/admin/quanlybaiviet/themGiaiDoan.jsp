<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.bean.SuKien"%>
<%@page import="java.util.ArrayList"%>
    <%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Giai Đoạn</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Bootstrap Core CSS -->
<link href="../../assets/css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<link href="../../assets/css/bootstrap.css" rel="stylesheet">
<!-- Custom CSS -->
<link href="../../assets/css/style.css" rel='stylesheet' type='text/css' />
<link rel="stylesheet" href="../../assets/css/morris.css" type="text/css"/>
<!-- Graph CSS -->
<link href="../../assets/css/font-awesome.css" rel="stylesheet"> 
<!-- lined-icons -->
<link rel="stylesheet" href="../../assets/css/icon-font.min.css" type='text/css' />
<!-- jQuery -->
<script src="../../assets/js/jquery-2.1.4.min.js"></script>
<script src="../../assets/js/jquery.min.js"></script>
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
                <li class="breadcrumb-item"><a href="admin.jsp">Trang Chủ</a><i class="fa fa-angle-right"></i><a href="quanLyDongGop.jsp">Bài Viết</a><i class="fa fa-angle-right"></i>Giai Đoạn Lịch Sử</li>
            </ol>
<!--grid-->
 	<div class="validation-system">
 		
 		<div class="validation-form">
 	<!---->
  	    	
        <html:form action="/admin/quanlybaiviet/them-giai-doan" method="post">
        	
			<div class="col-md-12 form-group2 group-mail">
              <label class="control-label">Thời Kỳ</label>
				<html:select property="maThoiKi" styleClass="form-control">
					<html:option value="0">--Chọn Thời Kỳ--</html:option>
            		<html:option value="1">Cổ Đại</html:option>
            		<html:option value="2">Trung Đại</html:option>
            		<html:option value="3">Cận Đại</html:option>	
            		<html:option value="4">Hiện Đại</html:option>
            	</html:select>
            	<script type="text/javascript">
			        $("[name='maThoiKi']").val('<bean:write name="giaiDoanForm" property="maThoiKi"/>');
			    </script>
            </div>
			<div class="col-md-12 form-group1 group-mail">
              <label class="control-label">Tên Giai Đoạn</label>
              <html:text property="tenGiaiDoan" styleClass="form-control" ></html:text>
            </div>
         	<div class="vali-form">
				<div class="col-md-6 form-group1 group-mail">
				  <label class="control-label ">Năm Bắt Đầu</label>
				  <html:text property="ngayBatDau" styleClass="form-control"></html:text>
				</div>
				 <div class="col-md-6 form-group1 group-mail">
				  <label class="control-label ">Năm Kết Thúc</label>
				  <html:text property="ngayKetThuc" styleClass="form-control"></html:text>
				</div>
            </div>
            
             <div class="clearfix"> </div>
            <div class="col-md-12 form-group1 group-mail">
              <label class="control-label">Nội Dung</label>
            </div>
            <!-- CKEditor -->
            <div class="row clearfix ">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group1 group-mail">
                    <div class="card">
                        <div class="body" >
                        	<html:textarea styleId="ckeditor"  property="noiDung"></html:textarea>
                        </div>
                    </div>
                </div>
            </div>
            <!-- #END# CKEditor -->

             <div class="clearfix"> </div>

            <div class="col-md-12 form-group">
              <html:submit styleClass="btn btn-primary" property="submit" value="submit"></html:submit>
			  <button type="submit" class="btn btn-primary" onclick="history.go(-1);">Quay Lại</button>
            </div>
          <div class="clearfix"> </div>
        </html:form>
    
 	<!---->
 </div>

</div>
 	<!--//grid-->

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
<script src="../../assets/plugin/ckeditor/ckeditor.js"></script>
<script src="../../assets/js/editors.js"></script>
<!-- Bootstrap Core JavaScript -->
   <script src="../../assets/js/bootstrap.min.js"></script>
   <!-- /Bootstrap Core JavaScript -->	    

</body>
</html>