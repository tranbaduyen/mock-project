<%@ page import="model.bean.GiaiDoan"%>
<%@ page import="model.bean.ThoiKy"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css" rel="stylesheet">

<link rel="stylesheet" href="css/style.css" />
<script src="js/jquery-1.11.2.min.js"></script>





<style>
.text {
	border: 1px solid rgb(173, 204, 204);
	height: 40px;
	width: 223px;
	box-shadow: 0px 0px 27px rgb(204, 204, 204) inset;
	transition: 500ms all ease;
	padding: 3px 3px 3px 3px;
	margin: 3px;
	font-family: Comic Sans MS;
}

.dong-gop {
	margin: 30px 10%;
	webkit-box-shadow: 0 0 3px #AAAAAA;
	box-shadow: 0 0 3px #AAAAAA;
	padding: 10px;
	background: rgba(0, 0, 0, .5);
	position: relative;
	z-index: 100;
}

.nicEdit-panelContain{
background: transparent;
}
</style>

</head>
<body id="main">
<%@ include file="header.jsp" %>

<div class="dong-gop">
<h2 class="content-title">Đóng góp bài viết</h2>
<p>Chào mừng bạn đã đến với trang đóng góp bài viết <strong>Dấu
Ấn Việt</strong>. Bây giờ bạn có thể đóng góp các nội dung liên quan</p>

<html:form action="/bai-dang" method="post" acceptCharset="UTF-8">
	<table>
		<tr>
			<td>Thời kì</td>
			<td><html:select property="maThoiKy" styleClass="textpro text"
				onchange="this.form.submit()">
				<html:option value="0">Chọn Thời Kỳ</html:option>
				<html:optionsCollection name="baiDangForm" property="thoiKy"
					label="tenThoiKy" value="maThoiKy" />
			</html:select></td>
		</tr>
		<tr>
			<td>Giai Đoạn</td>
			<td><html:select property="maGiaiDoan" styleClass="textpro text">
				<html:option value="0">Chọn Giai Đoạn</html:option>
				<html:optionsCollection name="baiDangForm" property="giaiDoan"
					label="tenGiaiDoan" value="maGiaiDoan" />
			</html:select></td>
		</tr>
		<tr>
			<td>Mục đóng góp</td>
			<td><html:select property="mucDongGopTen"
				styleClass="textpro text">
				<html:option value="0">Chon Muc Dong Gop</html:option>
				<html:optionsCollection name="baiDangForm" property="mucDongGopList"
					label="mucDongGopTen" value="mucDongGopID" />
			</html:select></td>
		</tr>
		
		<tr>
			<td>Tên</td>
			<td><html:text property="tieuDe" styleClass="text"
				style="width: 98.8%;" ></html:text></td>
			
		</tr>
		<tr><td></td><td><span style="color: red;"><bean:write name="baiDangForm" property="tieuDeErros"/></span></td></tr>
		<tr>
			<td>Từ Ngày:</td>
				<td><html:text property="ngayBatDau" styleClass="text" style="width: 50%"></html:text>
			</td>
				<td colspan="2">Đến Ngày: <html:text property="ngayKetThuc"
				styleClass="text" style="width: 50%"></html:text></td>
			
		</tr>
		<tr>
			<td></td>
			<td><span style="color: red;"><bean:write name="baiDangForm" property="ngayBatDauErrors"/></span></td>
			<td><span style="color: red;"><bean:write name="baiDangForm" property="ngayKetThucErros"/></span></td>
		</tr>
		<tr>
			<td>Năm sinh:</td>
			<td><html:text property="namSinh" styleClass="text" style="width: 50%"></html:text>
			</td>
			<td colspan="2">Năm mất : <html:text property="namMat"
				styleClass="text" style="width: 50%"></html:text></td>
		</tr>
		<tr>
			<td></td>
			<td><span style="color: red;"><bean:write name="baiDangForm" property="namSinhErros"/></span></td>
			<td><span style="color: red;"><bean:write name="baiDangForm" property="namMatErros"/></span></td>
		</tr>
		<tr>
			<td>Nội dung</td>
			<td>
			<div id="sample" style="background-color: transparent;  margin: 8px 3px;"><script
				type="text/javascript" src="js/nicEdit.js"></script> <script
				type="text/javascript">
							bkLib.onDomLoaded(function() { nicEditors.allTextAreas() });
						</script> <html:textarea property="noiDung" cols="50"></html:textarea></div>
			</td>
			
		</tr>
		<tr>
			<td></td>
			<td><span style="color: red;"><bean:write name="baiDangForm" property="noiDungErros"/></span></td>
		</tr>
		<tr>
			<td>Nguồn</td>
			<td><html:text property="nguon" styleClass="text"
				style="width: 98.8%;"></html:text></td>
			
		</tr>
		<tr>
			<td></td>
			<td><span style="color: red;"><bean:write name="baiDangForm" property="nguonErros"/></span></td>
		</tr>

		<tr>
			<td></td>
			<td colspan="2"><html:submit styleClass="btn btn-default"
				property="gui" value="gui">
			</html:submit></td>
		</tr>
	</table>

</html:form></div>


<script>
  
  		$("select[name='mucDongGopTen']").change(function() {
  			var select=$(this).val();
  			if(select==1){
				$("input[name='ngayBatDau']").attr("disabled", "disabled"); 
				$("input[name='ngayKetThuc']").attr("disabled", "disabled"); 
				$("input[name='namSinh']").removeAttr("disabled");				
	  			$("input[name='namMat']").removeAttr("disabled");
	  			$("input[name='ngayBatDau']").val("");
	  			$("input[name='ngayKetThuc']").val("");
	  			
  			}
  	  		if(select==2){
  	  			$("input[name='namSinh']").attr("disabled", "disabled"); 
				$("input[name='namMat']").attr("disabled", "disabled"); 
				$("input[name='ngayBatDau']").removeAttr("disabled");
	  			$("input[name='ngayKetThuc']").removeAttr("disabled");
	  			$("input[name='namSinh']").val("");
	  			$("input[name='namMat']").val("");
  	  		}
  	  		if(select==3){
  	  			$("input[name='ngayBatDau']").attr("disabled", "disabled"); 
				$("input[name='ngayKetThuc']").attr("disabled", "disabled"); 
				$("input[name='namSinh']").attr("disabled", "disabled"); 
				$("input[name='namMat']").attr("disabled", "disabled"); 
  	  		}
		});
  
  
  </script>
  
<%@ include file="footer.jsp" %>

</body>
</html>