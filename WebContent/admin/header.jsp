<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="header-main">
					<div class="logo-w3-agile ">
								<h1><a href="${pageContext.request.contextPath}/admin/dashboard.html">500 Error</a></h1>
							</div>
					<div class="w3layouts-left">
							
							<!--search-box-->
								<div class="w3-search-box">
									<form action="#" method="post">
										<input type="text" placeholder="Tìm Kiếm..." required="">	
										<input type="submit" value="">					
									</form>
								</div><!--//end-search-box-->
							<div class="clearfix"> </div>
						 </div>
						 <div class="w3layouts-right">
							<div class="profile_details_left"><!--notifications of menu start -->
								<ul class="nofitications-dropdown">
									<li class="dropdown head-dpdn">
										<bean:define id="soLuongBL" name="headerForm" property="soLuongBinhLuanMoi"></bean:define>
										<a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="fa fa-envelope"></i><span class="badge"><bean:write name="soLuongBL"/></span></a>
										<ul class="dropdown-menu">
											<li>
												<div class="notification_header">
													<h3>Bạn có <bean:write name="soLuongBL"/> bình luận mới</h3>
												</div>
											</li>
											<logic:iterate name="headerForm" property="listBinhLuanMoi" id="blMoi">
											   	<li><html:link href="${pageContext.request.contextPath}/admin/quanlybinhluan/quan-ly-binh-luan.html">
												   		<div class="user_img"><img src="<bean:write name="blMoi" property="hinhDaiDien"/>" alt=""></div>
												   		<div class="notification_desc">
															<p><bean:write name="blMoi" property="noiDung"/></p>
															<p><span><bean:write name="blMoi" property="ngayBinhLuan"/></span></p>
														</div>
														<div class="clearfix"></div>
												</html:link></li>		  
											</logic:iterate> 
											<li>
												<div class="notification_bottom">
													<html:link href="${pageContext.request.contextPath}/admin/quanlybinhluan/quan-ly-binh-luan.html">Xem tất cả bình luận</html:link>
												</div> 
											</li>
										</ul>
									</li>
									<li class="dropdown head-dpdn">
										<bean:define id="soLuongDG" name="headerForm" property="soLuongDongGopMoi"></bean:define>
										<a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="fa fa-bell"></i><span class="badge blue"><bean:write name="soLuongDG"/></span></a>
										<ul class="dropdown-menu">
											<li>
												<div class="notification_header">
													<h3>Bạn có <bean:write name="soLuongDG"/> đóng góp mới</h3>
												</div>
											</li>
											<logic:iterate name="headerForm" property="listDongGopMoi" id="dgMoi">
											   	<li><html:link href="${pageContext.request.contextPath}/admin/quanlydonggop/quan-ly-dong-gop.html">
												   		<div class="user_img"><img src="<bean:write name="dgMoi" property="hinhDaiDien"/>" alt=""></div>
												   		<div class="notification_desc">
															<p>Thêm 1 đóng góp mới</p>
															<p><span><bean:write name="dgMoi" property="ngayDang"/></span></p>
														</div>
														<div class="clearfix"></div>
												</html:link></li>		  
											</logic:iterate> 
											 <li>
												<div class="notification_bottom">
													<html:link href="${pageContext.request.contextPath}/admin/quanlydonggop/quan-ly-dong-gop.html">Xem tất cả đóng góp</html:link>
												</div>  
											</li>
										</ul>
									</li>	
									
									<div class="clearfix"> </div>
								</ul>
								<div class="clearfix"> </div>
							</div>
							<!--notification menu end -->
							
							<div class="clearfix"> </div>				
						</div>
						<div class="profile_details w3l">		
								<ul>
									<li class="dropdown profile_details_drop">
										<bean:define id="acc" name="headerForm" property="account"></bean:define>
										<a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
											<div class="profile_img">	
												<span class="prfil-img"><img src="<bean:write name="acc" property="hinhDaiDien"/>" alt=""> </span> 
												<div class="user-name">
													<p><bean:write name="acc" property="ten"/></p>
													<span>Quản Trị Viên</span>
												</div>
												<i class="fa fa-angle-down"></i>
												<i class="fa fa-angle-up"></i>
												<div class="clearfix"></div>	
											</div>	
										</a>
										<ul class="dropdown-menu drp-mnu">
											<li> <a href="#"><i class="fa fa-cog"></i> Cài đặt</a> </li> 
											<li> <html:link action="/admin/suaTK?userName=${userName}">
													<i class="fa fa-user"></i> Thông tin cá nhân</a>
							                	</html:link></li> 
											<li> <a href="${pageContext.request.contextPath}/logout.html"><i class="fa fa-sign-out"></i> Thoát</a> </li>
										</ul>
									</li>
								</ul>
						</div>
							
				     <div class="clearfix"> </div>	
				</div>
</body>
