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
<bean:define id="thongtin" name="chiTietNhanVatSuKienForm" property="nhanVatSuKien"></bean:define>
<title><bean:write name="thongtin" property="tenNVSK"/></title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css" rel="stylesheet">
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/rating.css" />
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/rating.js"></script>
<link rel="stylesheet" type="text/css" href="css/jquery.jscrollpane.custom.css" />
<link rel="stylesheet" type="text/css" href="css/bookblock.css" />
<link rel="stylesheet" type="text/css" href="css/custom.css" />
<script src="js/moder.js"></script>

<style type="text/css">
#main:before {
		/*background: url(image/bg.png)
		left center no-repeat;
*/}


.c-quote-content {
    width: 653px;
    height: 84px;
    margin: 0;
    position: relative;
    background-image: url(css/divider-wing-long.png);
    background-repeat: no-repeat;
    background-size: contain;
        top: -50px;
}
.breadcrumb-content{
margin:0 15%;
    height: 80px;
    
}
</style>


</head>
<body id="main">
<%@ include file="header.jsp" %>




<style>
#breadcrumb {
    list-style: none;
    display: inline-block;
      margin: 0px;
      position: relative;
      z-index: 100;
}
#breadcrumb li{
float: left;

}
#breadcrumb img
   { margin-top: 6px;
    padding-left: 10px;
    }

#breadcrumb li:first-child a:before {
    border: none;
}
#breadcrumb li a {
    color: rgb(206, 185, 133);
    display: block;
    background: rgba(58, 46, 32, 0.6);
    text-decoration: none;
    position: relative;
    height: 40px;
    line-height: 40px;
    padding: 0 10px 0 5px;
    text-align: center;
    margin-right: 27px;
   
    font-size: 19px;
}
#breadcrumb li a:hover{
color:#e9ddb3;
	text-shadow: 0 0 9px #e7d4b5, 0 0 13px #ffd200, 0 0 1px #ffd200;
}
#breadcrumb li a:before, #breadcrumb li a:after {
    content: "";
    position: absolute;
    top: 0;
    border: 0 solid rgba(58, 46, 32, 0.6);
    border-width: 20px 10px;
    width: 0;
    height: 0;
}


#breadcrumb li a:before, #breadcrumb li a:after {
    content: "";
    position: absolute;
    top: 0;
    border: 0 solid rgba(58, 46, 32, 0.6);
    border-width: 20px 10px;
    width: 0;
    height: 0;
}

#breadcrumb li a:before {
    left: -20px;
    border-left-color: transparent;
}
#breadcrumb li a:after {
    left: 100%;
    border-color: transparent;
    border-left-color: rgba(58, 46, 32, 0.6);
}

</style>
<div class="breadcrumb-content">
<ul id="breadcrumb">
  <li><a href="index.html"><img src="css/home.svg"/></a></li>
    <li><a href="thoi-ky.html?id=<bean:write name="thongtin" property="maThoiKy"/>">
    <bean:write name="thongtin" property="tenThoiKy"/></a></li>
    
    
    <bean:define id="kieu" name="thongtin" property="type"></bean:define>
    
  <li><a href="nhan-vat-su-kien.html?id=<bean:write name="thongtin" property="maGiaiDoan"/>&type=${kieu}"><bean:write name="thongtin" property="tenGiaiDoan"/></a></li>
  <li><a href="#"><bean:write name="thongtin" property="tenType"/></a></li>
 
</ul>

<div class="c-quote-content"></div>
</div>
<div class="post-content">	
<table>
<tr class="content-header">
	<td style="width:1%">
		<div class="content-avatar"><img src="<bean:write name="thongtin" property="hinhAnh"/>"></div>
	</td>
	<td class="content-title" style="display: table-cell; width: 79%">
		<div class="c-novela-header">
			<h2 class="c-novela-header__title" title="
			<bean:write name="thongtin" property="tenNVSK"/>">
			<bean:write name="thongtin" property="tenNVSK"/>
			
			</h2>
		</div>
	</td>
	<td style="width:20%">
	<section class="rate">

	<html:radio name="chiTietNhanVatSuKienForm" property="danhGia" value="1"/>
	<html:radio name="chiTietNhanVatSuKienForm" property="danhGia" value="2"/>
	<html:radio name="chiTietNhanVatSuKienForm" property="danhGia" value="3"/>
	<html:radio name="chiTietNhanVatSuKienForm" property="danhGia" value="4"/>
	<html:radio name="chiTietNhanVatSuKienForm" property="danhGia" value="5"/>
	
	 </section>
	  <span class="danh-gia"></span>  

	</td>
</tr>
</table>
</div>

<div id="container" class="container">	

<div class="menu-panel">
			<span></span>
				<ul id="menu-toc" class="menu-toc">
				<logic:iterate name="chiTietNhanVatSuKienForm" property="noiDung" id="ndpage">
				<bean:define id="page1" name="ndpage" property="page"></bean:define>	
				<li><a href="#item${page1}">${page1}</a></li>
				</logic:iterate>
				</ul>
				<div>
				</div>
</div>
			
			
			<div class="bb-custom-wrapper">
				<div id="bb-bookblock" class="bb-bookblock">
<logic:iterate name="chiTietNhanVatSuKienForm" property="noiDung" id="nd">
					<div class="bb-item" id="item1">
						<div class="content">
							<div class="scroller">
								<p>
								<bean:write name="nd" property="noiDung" filter="false"/>
								</p>
							</div>
						</div>
					</div>
</logic:iterate>
				</div>
				
				<nav>
					<span id="bb-nav-prev">&larr;</span>
					<span id="bb-nav-next">&rarr;</span>
				</nav>

				<span id="tblcontents" class="menu-button"></span>

			</div>
				
		</div>


	<script src="js/jquery.mousewheel.js"></script>
		<script src="js/jquery.jscrollpane.min.js"></script>
		<script src="js/jquerypp.custom.js"></script>
		<script src="js/jquery.bookblock.js"></script>
		<script src="js/page.js"></script>


<div class="connect">
<div class="c-divider" style="margin:0px 20px"></div>
</div>

					
<div id="comment">
<h3>Bình luận</h3>
<div class="comment-post">
<div id="noi-dung" class="textpro" contenteditable="true" style="height: 2.2em; width: 100%;border: 1px solid #555;">

</div>
<span class="close"><span class="left"></span><span class="right"></span></span>
<div class="control-row" style="display: block;">
<bean:define id="id" name="chiTietNhanVatSuKienForm" property="id"></bean:define>	
<bean:define id="type" name="chiTietNhanVatSuKienForm" property="type"></bean:define>
<span id="ket-qua"></span>
<span class="send" onclick="guiBinhLuan(${id},${type});">Gửi</span>
</div>


<ul id="list-comment">
<logic:iterate name="chiTietNhanVatSuKienForm" property="binhLuan" id="bl">

<li>
<img src="<bean:write name="bl" property="hinhDaiDien"/>" class="cmt-img">
<span class="cmt-time"><bean:write name="bl" property="ngayDang"/></span>
<div class="cmt-name" title="<bean:write name="bl" property="userName"/>"><bean:write name="bl" property="userName"/></div>
<div class="cmt-content"><bean:write name="bl" property="noiDung"/></div>
</li>

</logic:iterate>

<bean:define id="showmore" name="chiTietNhanVatSuKienForm" property="xemThem"></bean:define>	
<span class="show-binh-luan" onclick="showBinhLuan(${id},${type},20);">${showmore}</span>
</ul>

</div>
</div>				
	
<%@ include file="footer.jsp" %>

				
<script type="text/javascript">


$('.textpro').focus(function(e) {
	$(this).css({'height':'3.65em', 'overflow-y':'hidden'});
	$(this).parent().find('.close').css({'display':'block'});
	$(this).parent().find('.send').css({'display':'block','max-width': '50px'});
});
$('.close').click(function(e) {	
	$(this).css({'display':'none'});
	$(this).parent().find('.textpro').css({'height':'2.22em','outline':'none'});
	$(this).parent().find('.textpro').text('');
	$(this).parent().find('.send').removeClass('enabled');
	$(this).parent().find('.send').css({'display':'none'});
	$(this).parent().find('#ket-qua').text("");
});
$('.textpro').keypress(function(e) {
	$(this).parent().find('.send').addClass('enabled');
});

$('#noi-dung').text()="";
function guiBinhLuan(id,type) {
	var noidung = $('#noi-dung').text();
	  $.ajax({  
	    type: "POST",  
	    url: "gui-binh-luan.html",  
	    data: {id: id, type: type, noiDung: noidung},
	    success: function(response){  
	        $('#ket-qua').hide().html(response).fadeIn('slow'); 
	    },  
	    error: function(e){  
	      alert('Error: ' + e);  
	    }  
	  });  
	}  

function showBinhLuan(id,type, num) {
	  $.ajax({  
	    type: "POST",  
	    url: "show-binh-luan.html",  
	    data: {id: id, type: type, numComment: num},
	    success: function(response){  
	        $('#list-comment').hide().html(response).fadeIn('slow'); 
	    },  
	    error: function(e){  
	      alert('Error: ' + e);  
	    }  
	  });  
	}  


function danhGia(id,type, rating) {
	  $.ajax({  
	    type: "POST",  
	    url: "danh-gia.html",  
	    data: {id: id, type: type, rating: rating},
	    success: function(response){  
	        $('.danh-gia').hide().html(response).fadeIn('slow'); 
	    },  
	    error: function(e){  
	      alert('Error: ' + e);  
	    }  
	  });  
	}  

</script>			

<script type="text/javascript">


$('.rate').click(function(e) {	
	var diem= $('input[name=danhGia]:checked').val();
	danhGia(${id}, ${type}, diem);
});

$(function(){
	
	 $('.rate').rating();
 
});
        
    	$(function() {
			Page.init();
		});
</script>	
</body>
</html:html>