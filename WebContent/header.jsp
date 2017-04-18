<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="header">
<a href="${pageContext.request.contextPath}/index.html"><h1 class="header-title" title="Dấu Ấn Việt">Dấu Ấn Việt</h1></a>




<div class="right-search">
<div id="search" style="  margin-right: 15px;">

			<div class="col-md-12 form-group1 group-mail">
				<table class="col-md-12">
				</table>
</div>
            <html:form action="/timKiemThongTin" method="post" acceptCharset="UTF-8">
            
            <html:text property="keyWord" ></html:text>
            
            <html:submit styleClass="none-button" value=" " property="timKiem"></html:submit>
         </div>
         
         	<div class="search-adv">               
           
            <span style="color: red;"><bean:write name="timKiemThongTinForm" property="keyWordErros"/></span>
            
			<div class="form-group1 group-mail col-md-12">
				<div style="margin: 10px 0">
					<div class="radio-inline col-sm-3"><label>
						<html:radio property="rdSearch" value="0" >Sự Kiện</html:radio></label>
					</div>
					<div class="radio-inline col-sm-3"><label>
						<html:radio property="rdSearch" value="1" >Nhân Vật</html:radio></label>
					</div>
					<div class="radio-inline col-sm-3"><label>
						<html:radio  property="rdSearch" value="2" >Địa Danh</html:radio></label>
					</div>
					
				</div>
			</div>
			
			
			
         	<div class="vali-form">
				<div class="col-md-6  group-mail">
					<label class="control-label ">Từ</label>
					<table >
						<tr>
							<td class="form-group2 col-md-2">
								<html:select property="ngayBD" styleClass="textpro" style="width:100%">
									<html:option value="0">Ngày</html:option>
									<c:forEach var="i" begin="1" end="30">
										<html:option value="${i}"><c:out value="${i}"/></html:option>
									</c:forEach>
								</html:select>
							</td>
							<td class="form-group2 col-md-2">
								<html:select property="thangBD" styleClass="textpro" style="width:100%">
									<html:option value="0">Tháng</html:option>
									<c:forEach var="i" begin="1" end="12">
										<html:option value="${i}"><c:out value="${i}"/></html:option>
									</c:forEach>
								</html:select>
							</td>
							<td class="form-group1 col-md-2"><html:text property="namBD" style="width:100%" maxlength="4" onkeypress="return isNumberKey(event)"></html:text></td>
						</tr>
					</table>
				</div>
				 <div class="col-md-6 group-mail">
				  <label class="control-label">Đến</label>
				  <table class="col-md-12">
						<tr>
							<td class="form-group2 col-md-2">
								<html:select property="ngayKT" styleClass="textpro" style="width:100%">
									<html:option value="0">Ngày</html:option>
									<c:forEach var="i" begin="1" end="30">
										<html:option value="${i}"><c:out value="${i}"/></html:option>
									</c:forEach>
								</html:select>
							</td>
							<td class="form-group2 col-md-2">
								<html:select property="thangKT" styleClass="textpro" style="width:100%">
									<html:option value="0">Tháng</html:option>
									<c:forEach var="i" begin="1" end="12">
										<html:option value="${i}"><c:out value="${i}"/></html:option>
									</c:forEach>
								</html:select>
							</td>
							<td class="form-group1 col-md-2"><html:text property="namKT" style="width:100%" onkeypress="return isNumberKey(event)" maxlength="4"></html:text></td>
						</tr>
					</table>
				</div>
				<span style="color: red;"><bean:write name="timKiemThongTinForm" property="namBDErros"/></span>
            </div>
            <div class="vali-form">
				<div class="col-md-6  group-mail">
					<label class="control-label">Từ Năm</label>
					<table >
						<tr>
							<td class="form-group1 col-md-2"><input type="text" placeholder="Năm" style="width:100%"></td>
							<td class="form-group2 col-md-2">
								<select  class="textpro" style="width:100%">
									<option value="">TCN</option>
									<option value="">SCN</option>
								</select>
							</td>
						</tr>
					</table>
				</div>
				 <div class="col-md-6 group-mail">
				  <label class="control-label">Đến Năm</label>
				  <table class="col-md-12">
						<tr>
							<td class="form-group1 col-md-2"><input type="text" placeholder="Năm" style="width:100%"></td>
							<td class="form-group2 col-md-2">
								<select class="textpro" style="width:100%">
									<option value="">TCN</option>
									<option value="">SCN</option>
								</select>
							</td>
						</tr>
					</table>
				</div>
            </div>
             <div class="clearfix"> </div>
             
     
	         
       
     </html:form>

</div>


	
<span id="hide-adv" class="glyphicon glyphicon-minus-sign" style="position: absolute;top: 10px;display:none"></span>	
<span id="expand" class="glyphicon glyphicon-plus-sign" style="position: absolute;top: 10px;"></span>



<script type="text/javascript">
$(document).ready(function(){
	$("#expand").click(function(){
	    $(this).css({'display':'none'});
	    $(this).parent().find("#hide-adv").css({'display':'inline-block'});
	    $(this).parent().find(".search-adv").show("slow");
	  //  $(this).parent().find("#search").hide(1000);
	});

	$("#hide-adv").click(function(){
	    $(this).css({'display':'none'});
	    $(this).parent().find("#expand").css({'display':'inline-block'});
	    $(this).parent().find(".search-adv").hide(1000);
	   // $(this).parent().find("#search").show("slow");
	});
});



 function isNumberKey(evt){
	 var charCode = (evt.which) ? evt.which : event.keyCode
			if (charCode > 31 && (charCode < 48 || charCode > 57))
				return false;
			return true;
			}


</script>


</div>


<% HttpSession ss = request.getSession();
if(request.getSession(false).getAttribute("userName")==null){%>

	<span class="login"> <a href="${pageContext.request.contextPath}/login.html">Đăng nhập</a> | <a
	href="${pageContext.request.contextPath}/register.html">Đăng ký</a> </span>
<%}
else{
if(request.getSession(false).getAttribute("level")==null){
%>
	<span class="login"><a href="bai-dang.html"><img src="${pageContext.request.contextPath}/css/dong-gop.svg"/></a> | <%=ss.getAttribute("userName").toString()%> | <a
	href="${pageContext.request.contextPath}/logout.html"><img src="${pageContext.request.contextPath}/css/logout.svg"/></a> </span>		
<%}
else{%>
	<span class="login"><a href="${pageContext.request.contextPath}/admin/dashboard.html">Dashboard</a> <%=ss.getAttribute("userName").toString()%> | <a
	href="${pageContext.request.contextPath}/logout.html"><img src="${pageContext.request.contextPath}/css/logout.svg"/></a>
	 </span>	
<%}}%>


</div>

<div style="clear: both;"></div>

<div class="starWrapper" id="quizStarWrap">
                        <img src="${pageContext.request.contextPath}/css/intro_stars.png" alt="" class="homeStars quizStarAnimation">
                        <img src="${pageContext.request.contextPath}/css/intro_stars.png" alt="" class="homeStars quizStarAnimation-two">
                        <img src="${pageContext.request.contextPath}/css/intro_stars.png" alt="" class="homeStars quizStarAnimation-three">
                    </div>
