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
<script src="../../assets/js/jquery.dataTables.js"></script>
<script src="../../assets/js/dataTables.bootstrap.js"></script>
<!-- //jQuery -->
<!-- tables -->
<link rel="stylesheet" type="text/css" href="../../assets/css/table-style.css" />
<link rel="stylesheet" type="text/css" href="../../assets/css/basictable.css" />
<script type="text/javascript" src="../../assets/js/jquery.basictable.min.js"></script>
<script src="../../assets/js/jquery-datatable.js"></script>

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
                <li class="breadcrumb-item"><a href="/Mock_Project_DAV/admin/admin.jsp">Trang Chủ</a><i class="fa fa-angle-right"></i>Quản Lý Đóng Góp</li>
            </ol>
<div class="inbox-mail">
	<div class="col-md-3 compose w3layouts">
		
            <h2>Đóng Góp</h2>
    <nav class="nav-sidebar">
		<ul class="nav tabs">
		<bean:define id="soLuongSK" name="quanLyDongGopForm" property="soLuongSuKienChoDuyet"></bean:define>
		<bean:define id="soLuongNV" name="quanLyDongGopForm" property="soLuongNhanVatChoDuyet"></bean:define>
          <li class="active"><a href="#tab2" data-toggle="tab" aria-expanded="true"><i class="fa fa-bookmark"></i>Sự Kiện Lịch Sử<span><bean:write name="soLuongSK" /></span><div class="clearfix"></div></a></li>
          <li class=""><a href="#tab3" data-toggle="tab" aria-expanded="false"><i class="fa fa-user"></i>Nhân Vật Lịch Sử<span><bean:write name="soLuongNV" /></span><div class="clearfix"></div></a></li> 
          <li class=""><a href="#tab4" data-toggle="tab" aria-expanded="false"><i class="fa fa-map-marker"></i>Địa Danh Lịch Sử <span>2</span><div class="clearfix"></div></a></li>                              
		</ul>
	</nav>
		
</div>
<!-- tab content -->
<div class="col-md-9 tab-content tab-content-in w3">

<div class="tab-pane text-style active" id="tab2">
	<div class="inbox-right">
         	
            <div class="mailbox-content">
			
               <div class="mail-toolbar clearfix">
               </div>
			   
                <table class="table table-bordered table-striped table-hover js-basic-example dataTable">
                    <thead>
						<tr>
							<th>Avatar</th>
							<th>Tên</th>
							<th>Trạng Thái</th>
							<th>Thời Gian</th>
							<th>Thao Tác</th>
						</tr>
					</thead>
					<tbody>
                        <logic:iterate name="quanLyDongGopForm" property="listSuKienDongGop" id="skDongGop">
						            	<tr class="table-row">
							                <td scope="row">
							                	<bean:write name="skDongGop" property="maBDSK"/>
											</td>
							                 <td class="table-text">
							                	<h6><bean:write name="skDongGop" property="ten"/></h6>
                                				<p>Đã đóng góp 1 bài viết</p>
							                </td>
							               <td>
							                	<logic:equal name="skDongGop" property="pheDuyet" value="1">
													<span class="fam">Đã duyệt</span>
												</logic:equal>
												<logic:notEqual name="skDongGop" property="pheDuyet" value="1">
													<span class="ur">Đang chờ</span>
												</logic:notEqual>
											</td>
											<td class="march">
							                	<bean:write name="skDongGop" property="ngayDang"/>
							                </td>
							                <td>
							                	<bean:define id="maBDSK" name="skDongGop" property="maBDSK"></bean:define>
							                	<html:link action="/admin/quanlydonggop/duyetSK?maBDSK=${maBDSK}">
							                		<span class="glyphicon glyphicon-edit"> Xem</span>
							                	</html:link>
							                </td>
						           		 </tr>
						</logic:iterate> 
                    </tbody>
                </table>
               </div>
            </div>
 </div>
 <div class="tab-pane text-style" id="tab3">
  <div class="inbox-right">
         	
            <div class="mailbox-content">
               <div class="mail-toolbar clearfix">
			   
               </div>
			   <div class="body">
                <table class="table  table-bordered table-striped table-hover js-basic-example dataTable">
                    <thead>
						<tr>
							<th>Avatar</th>
							<th>Tên</th>
							<th>Trạng Thái</th>
							<th>Thời Gian</th>
							<th>Thao Tác</th>
						</tr>
					</thead>
					<tbody>
                        
                        <logic:iterate name="quanLyDongGopForm" property="listNhanVatDongGop" id="nvDongGop">
						            	<tr class="table-row">
							                <td scope="row">
							                	<bean:write name="nvDongGop" property="maBDNV"/>
											</td>
							                 <td class="table-text">
							                	<h6><bean:write name="nvDongGop" property="ten"/></h6>
                                				<p>Đã đóng góp 1 bài viết</p>
							                </td>
							               <td>
							                	<logic:equal name="nvDongGop" property="pheDuyet" value="1">
													<span class="fam">Đã duyệt</span>
												</logic:equal>
												<logic:notEqual name="nvDongGop" property="pheDuyet" value="1">
													<span class="ur">Đang chờ</span>
												</logic:notEqual>
											</td>
											<td class="march">
							                	<bean:write name="nvDongGop" property="ngayDang"/>
							                </td>
							                <td>
							                	<bean:define id="maBDNV" name="nvDongGop" property="maBDNV"></bean:define>
							                	<html:link action="/admin/quanlydonggop/duyetNV?maBDNV=${maBDNV}">
							                		<span class="glyphicon glyphicon-edit"> Xem</span>
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
  <div class="tab-pane text-style" id="tab4">
  <div class="inbox-right">
         	
            <div class="mailbox-content">
               <div class="mail-toolbar clearfix">
			     
			    
               </div>
                <table class="table table-bordered table-striped table-hover js-basic-example dataTable">
                    <thead>
						<tr>
							<th>Avatar</th>
							<th>Tên</th>
							<th>Trạng Thái</th>
							<th>Thời Gian</th>
							<th>Thao Tác</th>
						</tr>
					</thead>
					<tbody>
                        <tr class="table-row">
                            <td class="table-img">
                               <img src="../../assets/images/in.jpg" alt="">
                            </td>
                            <td class="table-text">
                            	<h6> Lê Văn Thọ</h6>
                                <p>Đã đóng góp 1 bài viết</p>
                            </td>
                            <td>
                            	<span class="ur">Đang chờ</span>
                            </td>
                            <td class="march">
                               5 giờ trước
                            </td>
                          
                             <td>
								<a  href="chitiet_diadanh.jsp">
									<i class="glyphicon glyphicon-search"></i>Xem  
								</a>
                            </td>
                        </tr>
                       
                        <tr class="table-row">
                            <td class="table-img">
                               <img src="../../assets/images/in4.jpg" alt="">
                            </td>
                            <td class="table-text">
                            	<h6> Nguyễn Thị Minh Trang</h6>
                                <p>Đã đóng góp 1 bài viết</p>
                            </td>
                            <td>
                            	<span class="ur">Đang chờ</span>
                            </td>
                            <td class="march">
                                1 ngày trước
                            </td>
                          
                             <td>
                               <a  href="chitiet_diadanh.jsp">
									<i class="glyphicon glyphicon-search"></i>Xem  
								</a>
                            </td>
                        </tr>
                        
                        
                        <tr class="table-row">
                            <td class="table-img">
                               <img src="../../assets/images/in.jpg" alt="">
                            </td>
                            <td class="table-text">
                            	<h6> Trần Bá Duyên</h6>
                                <p>Đã đóng góp 1 bài viết</p>
                            </td>
                            <td>
                            	<span class="fam">Đã duyệt</span>
                            </td>
                            <td class="march">
                               3 ngày trước
                            </td>
                          
                             <td>
								<a  href="chitiet_diadanh.jsp">
									<i class="glyphicon glyphicon-search"></i>Xem  
								</a>
                            </td>
                        </tr>
						
                    </tbody>
                </table>
               </div>
            </div>
  </div>
  
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