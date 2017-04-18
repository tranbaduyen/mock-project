<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
<bean:define id="giaidoan" name="nhanVatSuKienForm" property="giaiDoan"></bean:define>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><bean:write name="giaidoan" property="tenGiaiDoan"/></title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css" rel="stylesheet">
<link rel="stylesheet" href="css/style2.css" />
<link rel="stylesheet" href="css/style.css" />

<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>
<div id="main">
<%@ include file="header.jsp" %>



<div class="intro-content">

<bean:define id="type" name="nhanVatSuKienForm" property="type"></bean:define>
<bean:define id="typename" name="nhanVatSuKienForm" property="typeName"></bean:define>

<h2 class="content-title"><bean:write name="giaidoan" property="tenGiaiDoan"/>
<br/>
(<bean:write name="giaidoan" property="ngayBatDau"/>
-
<bean:write name="giaidoan" property="ngayKetThuc"/>)
</h2>
<div class="intro-detail-content">
<bean:write name="giaidoan" property="noiDung"/>
</div>


<div class="change"><img id="list" src="css/config.svg"/>
<img id="full" src="css/ifttt.svg"/> 
</div>
<div id="timeline" class="timeline-container">
<br class="clear">
<div class="timeline-wrapper">


<logic:iterate name="nhanVatSuKienForm" property="namChiaNho" id="nam">

<div class="timeline-year">

<bean:define id="nam" name="nam"></bean:define>

<h2 class="timeline-time"><span class="click-nam" onclick="showListSuKien(${nam},${type})">${nam}</span></h2>

<span class="tick tick-before"></span>
<div id="list-item${nam}" class="list-item-effect">

</div>

</div>
<br class="clear">
</logic:iterate>


</div>
<br class="clear">

</div>




<div id="nv-timeline" class="nv-container">
<logic:iterate name="nhanVatSuKienForm" property="nhanVatSK" id="listNVSK">
<bean:define id="id" name="listNVSK" property="maNVSK"></bean:define>
<bean:define id="title" name="listNVSK" property="tenNVSK"></bean:define>
<div class="nv-timeline-block">
<div class="nv-timeline-img nv-picture">
<div class="img-border"></div>
<a title="${title}" href="chi-tet-nhan-vat-su-kien.html?id=${id}&type=${type}">
<img class="nv-season_img" src="<bean:write name="listNVSK" property="hinhAnh"/>"></a>
<div class="img-border-bottom"></div>
</div>
<div class="nv-timeline-content">
<div class="date"><bean:write name="listNVSK" property="ngayDau"/> - <bean:write name="listNVSK" property="ngayCuoi"/></div>
<div style="clear: both;"></div>
<p class="nv-detail">
<bean:write name="listNVSK" property="noiDung" filter="false"/>
</p>
<h2 class="nv-title"><a title="${title}" href="chi-tet-nhan-vat-su-kien.html?id=${id}&type=${type}">${title}</a></h2>
</div>
</div>
</logic:iterate>


<bean:define id="id" name="nhanVatSuKienForm" property="id"></bean:define>

<span class="show-post" onclick="showNVSK(${id},${type},14);">
<bean:write name="nhanVatSuKienForm" property="xemThem"/>
</span>
<span class="show-post" onclick="showNVSK(${id},${type},10000);">
<bean:write name="nhanVatSuKienForm" property="tatCa"/>
</span>
</div>
</div>


<%@ include file="footer.jsp" %>
</div>



<script type="text/javascript">


$(document).ready(function(){
	$(".click-nam").click(function(){
		$(this).addClass('active');
	
	});

	$("#list").click(function(){
		$(this).parents().find("#nv-timeline").css({'display':'none'});
		$(this).parents().find("#timeline").css({'display':'block'});
	});

	$("#full").click(function(){
		$(this).parents().find("#timeline").css({'display':'none'});
		$(this).parents().find("#nv-timeline").css({'display':'block'});
	
	});
	
	$(document).on('click', '.click-sukien', function(){


		if($(this).parent().parent().find(".timeline-detail").css('display') == 'none')
		{
			$(this).parent().parent().find(".timeline-detail").show('slow');
		}else
			$(this).parent().parent().find(".timeline-detail").hide(1000);

		
		
		$(this).toggleClass('active');
	});

});

function showListSuKien(id,type) {
	  $.ajax({  
	    type: "POST",  
	    url: "show-list-nv-sk.html",  
	    data: {id: id, type: type},
	    success: function(response){  
	        $('#list-item'+id).hide().html(response).fadeIn('slow'); 
	    },  
	    error: function(e){  
	      alert('Error: ' + e);  
	    }  
	  });  
	}  


function showNVSK(id,type, num) {
	  $.ajax({  
	    type: "POST",  
	    url: "show-nvsk.html",  
	    data: {id: id, type: type, numPost: num},
	    success: function(response){  
	        $('#nv-timeline').hide().html(response).fadeIn('slow'); 
	    },  
	    error: function(e){  
	      alert('Error: ' + e);  
	    }  
	  });  
	}  



</script>























</body>
</html:html>