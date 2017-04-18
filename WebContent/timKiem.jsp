<%@page import="model.bean.GiaiDoan" %>
<%@page import="model.bean.ThoiKy" %>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script language='javascript'>
 		<!--
		 function isNumberKey(evt){
			 var charCode = (evt.which) ? evt.which : event.keyCode
 				if (charCode > 31 && (charCode < 48 || charCode > 57))
 					return false;
 				return true;
 				}
 //-->
 </script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tim kiem</title>

</head>
<body>
<div class="right-search">
<div id="search">
	
		
		

</div>
</div>
	<div class="search-adv">
	
			<div class="col-md-12 form-group1 group-mail">
				<table class="col-md-12">
				</table>
            </div>
            <html:form action="/timKiemThongTin" method="post" acceptCharset="UTF-8">
            
            <html:text property="keyWord" ></html:text>
           
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
					<div class="radio-inline col-sm-3"><label>
						<html:radio property="rdSearch" value="3" >Thời gian</html:radio></label>
					</div>
				</div>
			</div>
			
			
			<div class="col-md-12 form-group2 group-mail" style="margin:5px auto;">
              <label class="control-label">Thời Kỳ</label>
				<html:select property="maThoiKy" styleClass="textpro text" onchange="this.form.submit()">
					<html:option value="0">-- Chọn Thời Kỳ --</html:option>
					<html:optionsCollection name="timKiemThongTinForm" property="thoiKy" label="tenThoiKy" value="maThoiKy" />
				</html:select>
            </div>
			<div class="col-md-12 form-group2 group-mail" style="margin:5px auto;">
              <label class="control-label">Giai Đoạn</label>
				<html:select property="maGiaiDoan" styleClass = "textpro text"> 
					<html:option value="0">-- Chọn Giai đoạn --</html:option>
					<html:optionsCollection name="timKiemThongTinForm" property="giaiDoan" label="tenGiaiDoan" value="maGiaiDoan"/>
				</html:select>
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
							<td class="form-group1 col-md-2"><input type="text" style="width:100%"></td>
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
             
     
	     <html:submit styleClass="none-button" value="Tìm" property="timKiem"></html:submit>    
             
     </html:form>
</div>
</body>
</html>