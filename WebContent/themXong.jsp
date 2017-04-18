<%@ page import="model.bean.GiaiDoan"%>
<%@ page import="model.bean.ThoiKy"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css" />
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
}
</style>

</head>
<body id="main">
<div id="header">
<h1 class="header-title" title="Dau An Viet">Dấu Ấn Việt</h1>
<div class="right-search">

<form class="navbar-form" role="search"><input type="text"
	placeholder="Tìm Kiếm" name="keyword" id="keyword">
<button class="none-button" type="submit"><i
	class="glyphicon glyphicon-search"
	style="color: #e9ddb3; position: absolute; top: 17px; right: 40px"></i></button>
</form>
</div>
<span class="login"> <a href="/login.html">Username</a> | <a
	href="/register.html">Đăng xuất</a> </span></div>
<div class="dong-gop">
<h2 class="content-title">Cảm ơn</h2>
<center>
	<p>Cảm ơn bạn đã đóng góp bài viết của mình để website của chúng tôi thêm hoàn hảo</p>
	<strong><p>Chúng tôi sẽ xác nhận lại bài đóng góp của bạn để xem có phù hợp hay không. Bạn Vui lòng kiểm tra mail của mình nhé.</p></strong>
</center>
</div>

</body>
</html>