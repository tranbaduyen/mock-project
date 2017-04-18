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
<bean:define id="thoiky" name="hienThiGiaiDoanForm" property="thoiKy"></bean:define>
<title><bean:write name="thoiky" property="tenThoiKy"/></title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css"
	rel="stylesheet">
<link rel="stylesheet" href="css/style.css" />
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>
<div id="main">
<%@ include file="header.jsp" %>



<div id="gallery">

<div id="slides">
<logic:iterate name="hienThiGiaiDoanForm" property="listGiaiDoan" id="gd">

<div class="slide"><div style="width:920px; height: 400px">
<table class="thoi-ky"><tr><td>
<div class="left-content">

<bean:define id="hinhanh" name="gd" property="hinhAnh"></bean:define>
	<div class="left-img"><img src="<bean:write name="gd" property="hinhAnh"/>" />
	<span class="right-title" style="font-size: 22px;"><bean:write name="gd" property="ngayBatDau"/>
	- 
	<bean:write name="gd" property="ngayKetThuc"/>
	</span>
	</div>
</div></td>
<td width="30%"><span class="content-title"  style="font-size: 27px;">
<bean:write name="gd" property="tenGiaiDoan"/>
</span>
<p style="text-align: justify;">
<bean:write name="gd" property="noiDung"/>
</p>
</td>
<td width="40%">
<bean:define id="magiaidoan" name="gd" property="maGiaiDoan"></bean:define>
<div class="right-content"><a href="nhan-vat-su-kien.html?id=${magiaidoan}" class="tag">Nhân Vật
</a></div>
<div class="right-content"><a href="nhan-vat-su-kien.html?id=${magiaidoan}&type=1" class="tag">Sự Kiện</a></div>
<div class="right-content"><a href="giai-doan-dia-danh.html?id=${magiaidoan}" class="tag">Địa Danh</a></div>
</td></tr></table>
</div>
</div>

</logic:iterate>



</div>
<div id="menu"><div class="tl-wrap"><div class="tl-bar"><div class="tl-bar-meter"></div>
<ul id="mylist">

<logic:iterate name="hienThiGiaiDoanForm" property="giaiDoan" id="gdpage">
	
	<li class="menuItem"><a href="#" class="tl-icon"><bean:write name="gdpage"/></a></li>

</logic:iterate>
</ul></div></div></div>


</div>




<%@ include file="footer.jsp" %>




</div>






<script type="text/javascript">
$(document).ready(function(){
	var totWidth=0;
	var positions = new Array();
	$('#slides .slide').each(function(i){	
		positions[i]= totWidth;
		totWidth += $(this).width();
			if(!$(this).width())
		{
			return false;
		}	
	});


	var lengthBar = $(".tl-wrap").width();
	var numLi= $("#mylist li").length;
	var widthBar=lengthBar/numLi +15;
	$('.tl-bar-meter').stop().animate({width:widthBar+'px'},450);

	$('ul li:first-child').find('.tl-icon').addClass('is-active');
	
	
	$('#slides').width(totWidth);
	 $('.tl-bar').click(function(e) {
        var posX = $(this).offset().left;
        var dodai =(e.pageX - posX);
        $('.tl-bar-meter').stop().animate({width:dodai+'px'},450);
    });
	$('.tl-icon').click(function(e,keepScroll){
			$(this).parent().prevAll().find('a').addClass('is-active');
			$(this).addClass('is-active');
			$(this).parent().nextAll().find('a').removeClass('is-active');
			var pos = $(this).parent().prevAll('.menuItem').length;
			$('#slides').stop().animate({marginLeft:-positions[pos]+'px'},450);	
			e.preventDefault();
			if(!keepScroll) clearInterval(itvl);
	});
	var current=1;
	function autoAdvance()
	{
		if(current==-1) return false;
		$('#menu ul li a').eq(current%$('#menu ul li a').length).trigger('click',[true]);	
		current++;
	}
	var changeEvery = 1000;
	var itvl = setInterval(function(){autoAdvance()},changeEvery*1000);
});
</script>
</body>
</html:html>