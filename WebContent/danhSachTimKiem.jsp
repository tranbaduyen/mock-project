<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dấu Ấn Việt</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css"
	rel="stylesheet">
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" type="text/css"
	href="css/jquery.jscrollpane.custom.css" />
<link rel="stylesheet" type="text/css" href="css/bookblock.css" />
<link rel="stylesheet" type="text/css" href="css/custom.css" />
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/moder.js"></script>
</head>
<body>
<div id="main">

<%@ include file="header.jsp" %>



<div id="new-post">
<div class="c-novela-header">
<h2 class="c-novela-header__title"
	style="text-transform: none; font-size: 25px" title="Danh sách tìm kiếm">
Danh sách tìm kiếm</h2>
</div>
<div class="new-boder">
<div class="new-content" style="position: absolute;left: 300px;">


	<ul>
		<logic:iterate name="timKiemThongTinForm" property="nhanVatSuKien"
			id="nhanVatSuKien">
			<bean:define id="id" name="nhanVatSuKien" property="maNVSK"></bean:define>
			<bean:define id="type" name="nhanVatSuKien" property="type"></bean:define>
			<li class="new-content-li">
			<div class="new-title"><img
				src="<bean:write name="nhanVatSuKien" property="hinhAnh"/>"
				class="new-image">
			<div class="meta"><a
				href="chi-tet-nhan-vat-su-kien.html?id=${id}&type=${type}"> <bean:write
				name="nhanVatSuKien" property="tenSuKien" /></a> <span class="new-desc"><bean:write
				name="nhanVatSuKien" property="noiDung" filter="false" /></span></div>
			</div>
			</li>
		</logic:iterate>
	</ul>
</div>
</div>
</div>
</div>
</body>
</html:html>