<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Đăng nhập</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css" rel="stylesheet">
<link rel="stylesheet" href="css/style.css" />

<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>
<div id="main">


<%@ include file="header.jsp" %>
 
<div id="login">
<h3 style="text-align: center;">Đăng nhập</h3>
<html:form action="login" focus="userName">
<div class="row form-group">
	<label class="col-lg-2">User Name:</label>
	<div class="col-lg-3">
		<html:text property="userName" styleClass="form-control" style="width:100%"></html:text>
	</div>
</div>
<div class="row form-group">
	<label class="col-lg-2">Password:</label>
	<div class="col-lg-3">
		<html:password property="password" styleClass="form-control textpro" style="width:100%"></html:password>
	</div>
</div>
<div class="row form-group">
	<div class="col-lg-3 col-lg-offset-2">
		<p style="color: red;">
		<bean:write name="loginForm" property="loginError"/>
		</p>
	</div>
</div>
<div class="row form-group">
	<div class="col-lg-3 col-lg-offset-2">
		<html:submit value="Đăng nhập" property="getSubmit" styleClass="btn btn-info"/>
		<html:reset styleClass="btn btn-info" value="Nhập lại"></html:reset>
	</div>
</div>
<html:hidden property="url" value='<%=request.getHeader("referer")%>'></html:hidden>

</html:form>
</div>
</div>

</body>
</html:html>