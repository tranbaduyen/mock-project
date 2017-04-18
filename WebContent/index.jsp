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
<title>Dấu Ấn Việt</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css" rel="stylesheet">
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/jquery.jscrollpane.custom.css" />
<link rel="stylesheet" type="text/css" href="css/bookblock.css" />
<link rel="stylesheet" type="text/css" href="css/custom.css" />
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/moder.js"></script>

</head>
<body>
<div id ="main">
<%@ include file="header.jsp" %>


<div id="main-content">

<div id="new-post" style="display: none">
<div class="c-novela-header">
<h2 class="c-novela-header__title" style="text-transform: none; font-size:25px" title="Cập Nhật Mới">
Cập Nhật Mới</h2></div>

<div class="new-boder">
<div class="new-content"><h3 class="cmt-name" title="Nhân vật">Nhân vật</h3>

<ul>
<logic:iterate name="indexForm" property="nhanVatMoi" id="nvMoi">
<bean:define id="id" name="nvMoi" property="maNhanVat"></bean:define>
<li class="new-content-li">
<div class="new-title">
<img src="<bean:write name="nvMoi" property="hinhAnh"/>" class="new-image">
<div class="meta">
<a href="chi-tet-nhan-vat-su-kien.html?id=${id}">
<bean:write name="nvMoi" property="tenNhanVat"/></a>
<span class="new-desc"><bean:write name="nvMoi" property="noiDung" filter="false"/></span>
</div>
</div></li>
</logic:iterate>
</ul>


</div>
<div class="new-content"><h3 class="cmt-name" title="Sự kiện">Sự kiện</h3>
<ul>
<logic:iterate name="indexForm" property="suKienMoi" id="skMoi">
<bean:define id="id" name="skMoi" property="maSuKien"></bean:define>
<li class="new-content-li">
<div class="new-title">
<img src="<bean:write name="skMoi" property="hinhAnh"/>" class="new-image">
<div class="meta">
<a href="chi-tet-nhan-vat-su-kien.html?id=${id}&type=1">
<bean:write name="skMoi" property="tenSuKien"/></a>
<span class="new-desc"><bean:write name="skMoi" property="noiDung" filter="false"/></span>
</div>
</div></li>
</logic:iterate>
</ul>
</div>

</div>

</div>


<div class="c-novela-header">
<h2 class="c-novela-header__title" style="text-transform: none; font-size:25px; text-align: center;" title="Các Thời Kỳ Lịch Sử Việt Nam">
Các Thời Kỳ Lịch Sử Việt Nam</h2>
<img id="open-new" style="float: right;top: -30px;position: relative;" src="css/delicious.svg"/>
</div>

<div id="cd-timeline" class="cd-container">
<logic:iterate name="indexForm" property="thoiKy" id="tk">
<bean:define id="tenthoiky" name="tk" property="tenThoiKy"></bean:define>
<bean:define id="hinhanh" name="tk" property="hinhAnh"></bean:define>
<bean:define id="id" name="tk" property="maThoiKy"></bean:define>
<div class="cd-timeline-block">
<div class="cd-timeline-img cd-picture">
<a href="thoi-ky.html?id=${id}" title="${tenthoiky}">
<img class="season_img" src="${hinhanh}" alt="${tenthoiky}"></a>
</div>
<div class="cd-timeline-content">
<div class="content-title" style="text-align:center;"><h2><a href="thoi-ky.html?id=${id}">${tenthoiky}</a></h2></div>
<p class="detail">
<bean:write name="tk" property="noiDung"/>
</p><span class="cd-read-more">Mở rộng</span>
<span class="cd-close">Thu nhỏ</span>
<span class="cd-date"><bean:write name="tk" property="thoiGian"/></span>
</div>
</div>
</logic:iterate>

</div>
</div>





<div id="right-content">

<div class="c-novela-header">
<h2 class="c-novela-header__title" style="text-transform: none; font-size:25px" title="Ngày Lịch Sử">
Ngày Lịch Sử</h2></div>
<div class="top-right-content">
<ul>
<logic:iterate name="indexForm" property="suKienSapDienRa" id="sdr">
<bean:define id="id" name="sdr" property="maSuKien"></bean:define>
<li class="top-right-content-li">
<a href="chi-tet-nhan-vat-su-kien.html?id=${id}&type=1">
<img src="css/wunderlist.svg"/>
<bean:write name="sdr" property="tenSuKien"/>
</a></li>
</logic:iterate>
</ul>
</div>



<div class="c-novela-header">
<h2 class="c-novela-header__title" style="text-transform: none; font-size:25px" title="Top Sự Kiện">
Top Sự Kiện</h2></div>
<div class="top-right-content">
<ul>

<logic:iterate name="indexForm" property="suKien" id="topsk">
<bean:define id="id" name="topsk" property="maSuKien"></bean:define>
<li class="top-right-content-li">
<a href="chi-tet-nhan-vat-su-kien.html?id=${id}&type=1">
<img src="css/favorite.svg"/>
<bean:write name="topsk" property="tenSuKien"/>
</a></li>
</logic:iterate>

</ul>
</div>
<div class="c-novela-header">
<h2 class="c-novela-header__title" style="text-transform: none; font-size:25px" title="Top Nhân Vật">
Top Nhân Vật</h2></div>
<div class="top-right-content">
<ul>
<logic:iterate name="indexForm" property="nhanVat" id="nv">
<bean:define id="id" name="nv" property="maNhanVat"></bean:define>
<li class="top-right-content-li">
<a href="chi-tet-nhan-vat-su-kien.html?id=${id}">
<img src="css/favorite.svg"/>
<bean:write name="nv" property="tenNhanVat"/>
</a></li>
</logic:iterate>
</ul>
</div>


<div class="c-novela-header">
<h2 class="c-novela-header__title" style="text-transform: none; font-size:25px" title="Giải Trí">
Giải Trí
</h2>
</div>

<div class="top-right-content">
<ul>
<li class="top-right-content-li"><a href="game/ban-la-ai"><img src ="css/gandi.svg">Bạn là ai?</a></li>

<li class="top-right-content-li"><a href="game/ai-la-su-gia"><img src ="css/compass.svg">Ai là sử gia</a></li>
</ul>
</div>



</div>






<%@ include file="footer.jsp" %>

</div>
<script type="text/javascript">
$(document).ready(function(){
	$(".cd-read-more").click(function(){
	    $(this).prev('.detail').css({'max-height': '1024px'});
	    $(this).prev('.detail').hide().show( "slow" );
	    $(this).css({'display': 'none'});
	    $(this).next('.cd-close').css({'display': 'block'});
	});
	$(".cd-close").click(function(){
	    $(this).prev().prev('.detail').css({'max-height': '124px'});
	    $(this).prev().prev('.detail').hide().show( "slow" );
	    $(this).css({'display': 'none'});
	    $(this).prev('.cd-read-more').css({'display': 'block'});
	});



	$("#open-new").click(function(){
		$(this).parents().find("#new-post").css({'display':'block'});
		$(this).hide(1000);
	});
	
});


</script>
</body>
</html:html>